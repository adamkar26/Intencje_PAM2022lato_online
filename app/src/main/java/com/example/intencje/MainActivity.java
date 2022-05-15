package com.example.intencje;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getBaseContext(), Druga.class));
                Intent intent = new Intent(getBaseContext(), Druga.class);
                intent.putExtra("Imie", "Zenek");
                intent.putExtra("Wiek", 99);
                startActivity(intent);
            }
        });

    }

    public void log(View view){
        Intent intent = new Intent(this, Logowanie.class);
        getResult.launch(intent);
    }

    ActivityResultLauncher<Intent> getResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //pobranie danych
                    Intent intent = result.getData();
                    if(intent != null){
                        String imie = intent.getStringExtra("Imie");
                        Toast.makeText(MainActivity.this, "Witaj  "+ imie,
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
    );
}