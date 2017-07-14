package com.amelia.pert4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {
    TextView judul, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        judul = (TextView)findViewById(R.id.txt_Judul);
        harga = (TextView)findViewById(R.id.txt_Harga);
        Intent intent = getIntent();
        judul.setText(intent.getStringExtra("Judul"));
    }
}
