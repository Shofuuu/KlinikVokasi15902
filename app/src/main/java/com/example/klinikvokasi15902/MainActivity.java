package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSelectedKaliurang = (Button) findViewById(R.id.btnSelectKaliurang);
        Button btnSelectedParangtritis = (Button) findViewById(R.id.btnSelesai);
        Button btnSelectedMagelang = (Button) findViewById(R.id.btnSelectMagelang);

        btnSelectedKaliurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kaliurangOnClick();
            }
        });

        btnSelectedParangtritis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parangtritisOnClick();
            }
        });

        btnSelectedMagelang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                magelangOnClick();
            }
        });
    }

    private void kaliurangOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        data.setSelectedLocation("Jalan Kaliurang");
        data.setLocationAddress("Jl. Kaliurang Km. 7.5 Sleman");

        Intent intent = new Intent(this, klinikVokasiPilihDokter.class);
        startActivity(intent);
    }

    private void parangtritisOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        data.setSelectedLocation("Jalan Parangtritis");
        data.setLocationAddress("Jl. Parangtritis Km. 10 Sewon");

        Intent intent = new Intent(this, klinikVokasiPilihDokter.class);
        startActivity(intent);
    }

    private void magelangOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        data.setSelectedLocation("Jalan Magelang");
        data.setLocationAddress("Jl. Magelang Km. 5 Sleman");

        Intent intent = new Intent(this, klinikVokasiPilihDokter.class);
        startActivity(intent);
    }
}