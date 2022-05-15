package com.example.intencje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Druga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String napis = bundle.getString("Imie");
            int liczba = bundle.getInt("Wiek");

            Toast.makeText(this, napis +" mam " + liczba+ "lat", Toast.LENGTH_SHORT).show();
        }

    }
}