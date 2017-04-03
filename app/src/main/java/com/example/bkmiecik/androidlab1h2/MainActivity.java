package com.example.bkmiecik.androidlab1h2;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean flaga = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flaga = true;

        Button b_1 = (Button) findViewById(R.id.b_1);
        b_1.setText("Uruchom moją aplikację");
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("com.example.bkmiecik.androidlab1h","com.example.bkmiecik.androidlab1h.MainActivity"));
                startActivity(intent);
            }
        });

        Button b_2 = (Button) findViewById(R.id.b_2);
        b_2.setText("Wybierz numer");
        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(intent);
            }
        });

        Button b_3 = (Button) findViewById(R.id.b_3);
        b_3.setText("Zużycie baterii");
        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_POWER_USAGE_SUMMARY);
                startActivity(intent);
            }
        });

        Button b_4 = (Button) findViewById(R.id.b_4);
        b_4.setText("Ustawienia Wi-Fi");
        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        Toast.makeText(MainActivity.this,"Jeszcze tu wrócę!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(MainActivity.this,"To znowu ja!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"Jestem zniszczony!",Toast.LENGTH_SHORT).show();
    }
}
