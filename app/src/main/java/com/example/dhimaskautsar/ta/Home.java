package com.example.dhimaskautsar.ta;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;


public class Home extends AppCompatActivity {

    private FirebaseAuth auth;

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new com.example.dhimaskautsar.ta.BottomNavigationBehavior());

        toolbar.setTitle("Beranda");
        loadFragment(new com.example.dhimaskautsar.ta.HomeFragment());

    }
//    @Override
//    public boolean onOptionItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//            case R.id.acc:
//                FirebaseAuth fAuth = FirebaseAuth.getInstance();
//            fAuth.signOut();
//            Intent loginscreen = new Intent(Home.this, Login.class);
//            (Home.this).finish();
//            loginscreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY );
//            startActivity(loginscreen);
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.home:
                    toolbar.setTitle("BERANDA");
//                    toolbar.
                    com.example.dhimaskautsar.ta.HomeFragment f = new com.example.dhimaskautsar.ta.HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, f).commit();
                    return true;

                case R.id.find:
                    toolbar.setTitle("CARI");
                    com.example.dhimaskautsar.ta.FindFragment c = new com.example.dhimaskautsar.ta.FindFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, c).commit();
                    return true;
                case R.id.list:
                    toolbar.setTitle("DAFTAR SAPI");
                    com.example.dhimaskautsar.ta.ListFragment e = new com.example.dhimaskautsar.ta.ListFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, e).commit();
                    return true;

            }
            return false;
        }
    };

    private void loadFragment(android.support.v4.app.Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }






}
