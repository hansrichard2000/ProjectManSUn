package com.uc.projectmansun.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uc.projectmansun.R;
import com.uc.projectmansun.ui.main.beranda.BerandaFragment;
import com.uc.projectmansun.ui.main.jadwal.JadwalFragment;
import com.uc.projectmansun.ui.main.notifikasi.NotifikasiFragment;
import com.uc.projectmansun.ui.main.profil.ProfilFragment;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BottomNavigationView navigationView = findViewById(R.id.nav_view);
//
//        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.berandaFragment, R.id.jadwalFragment, R.id.notifikasiFragment, R.id.profilFragment).build();
//        navController = Navigation.findNavController(this, R.id.fragment);
//        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
//            if (destination.getId() == R.id.berandaFragment || destination.getId() == R.id.jadwalFragment || destination.getId() == R.id.notifikasiFragment || destination.getId() == R.id.profilFragment){
//                navigationView.setVisibility(View.VISIBLE);
//            }else {
//                navigationView.setVisibility(View.GONE);
//            }
//        });
//        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        return NavigationUI.navigateUp(navController, (Openable) null);

        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new BerandaFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.beranda:
                    fragment = new BerandaFragment();
                    break;
                case R.id.jadwal:
                    fragment = new JadwalFragment();
                    break;
                case R.id.notifikasi:
                    fragment = new NotifikasiFragment();
                    break;
                case R.id.profil:
                    fragment = new ProfilFragment();
                    break;
//                case R.id.login:
//                    fragment = new BerandaFragment();
//                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();

            return true;
        }
    };
}