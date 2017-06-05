package com.luccas.imobiliaria;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cadastro);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.open_navigation_drawer,
                R.string.close_navigation_drawer);

        // Above is deprecated, use addDrawerListener
        //drawerLayout.setDrawerListener(toggle);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =
                (NavigationView) findViewById(R.id.navigation_drawer_view);
        navigationView.setNavigationItemSelectedListener(new NavigationItemListener());

        /* Show cadastrar fragment */
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        CadastrarFragment cadastrarFragment = new CadastrarFragment();
        transaction.add(R.id.fragment_container, cadastrarFragment);
        transaction.commit();

    }

    private class NavigationItemListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectItem(item.getItemId());
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }
    }

    private void selectItem(int id) {
        switch (id) {
            case R.id.buscar_menu_item:
                //Buscar
                Snackbar.make(findViewById(R.id.main_drawer_layout), "Buscar Selected", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.cadastrar_menu_item:
                //cadastrar
                //Snackbar.make(findViewById(R.id.main_drawer_layout), "Cadastrar Selected", Snackbar.LENGTH_SHORT).show();
                /* Show cadastrar fragment */
                break;
        }
    }
}