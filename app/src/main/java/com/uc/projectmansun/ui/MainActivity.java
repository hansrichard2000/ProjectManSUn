package com.uc.projectmansun.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uc.projectmansun.R;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.nav_view);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.berandaFragment, R.id.jadwalFragment, R.id.notifikasiFragment, R.id.profilFragment).build();
        navController = Navigation.findNavController(this, R.id.fragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.berandaFragment || destination.getId() == R.id.jadwalFragment || destination.getId() == R.id.notifikasiFragment || destination.getId() == R.id.profilFragment){
                navigationView.setVisibility(View.VISIBLE);
                getSupportActionBar().hide();
            }else {
                navigationView.setVisibility(View.GONE);
            }
        });
        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (Openable) null);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

}