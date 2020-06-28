package fonseca.emmanuel.tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fonseca.emmanuel.tabs.fragments.HomeFragment;
import fonseca.emmanuel.tabs.fragments.NotificationFragment;
import fonseca.emmanuel.tabs.fragments.SmsFragment;

public class MainActivity extends AppCompatActivity {

    // Creamos el bottomNavigation
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // lo inicializamos con con el bottomNavigation del activity_main.xml
        bottomNavigation = findViewById(R.id.navigationView);
        // inicializamos el Listener del botomNavigation
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
    }

    // Hacemos un Fragment container, donde se mostrara la información de cada fragment que creemos
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // Definiremos en el Listener del botomNavigation el fragmente que se cargará en cada caso.
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(HomeFragment.newInstance("", ""));
                        return true;
                    case R.id.navigation_sms:
                        openFragment(SmsFragment.newInstance("", ""));
                        return true;
                    case R.id.navigation_notifications:
                        openFragment(NotificationFragment.newInstance("", ""));
                        return true;
                    }
                    return false;
                }
            };

}