package com.example.softpillartest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.softpillartest.fragments.BlankFragment;
import com.example.softpillartest.fragments.ConnectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {
    BottomNavigationViewEx bnve;
    int position = 0;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">"+getString(R.string.app_name)+"</font>"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    private void initialization() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ConnectFragment()).commit();
        bnve = (BottomNavigationViewEx) findViewById(R.id.navigation);
        //viewPager = findViewById(R.id.view_pager);
        floatingActionButton = findViewById(R.id.fab);
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);


        floatingActionButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Click of center button", Toast.LENGTH_SHORT).show();
        });

        bnve.setCurrentItem(R.id.connects);
        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.update:
                        callFragment(new BlankFragment());
                        break;

                    case R.id.connects:
                        callFragment(new ConnectFragment());
                        break;

                    case R.id.people:
                        callFragment(new BlankFragment());
                        break;

                    case R.id.dashboard:
                        callFragment(new BlankFragment());
                        break;
                }
                return false;
            }
        });

    }

    private void callFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}