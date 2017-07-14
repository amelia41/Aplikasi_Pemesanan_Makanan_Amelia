package com.amelia.pert4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        getSupportActionBar().setTitle("Pengaturan"); //setting menu tampilan

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // untuk menampilkan tombol back atas

    }
}
