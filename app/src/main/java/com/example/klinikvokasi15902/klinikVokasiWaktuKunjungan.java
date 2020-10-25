package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class klinikVokasiWaktuKunjungan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_waktu_kunjungan);

        Button btnPagi = (Button) findViewById(R.id.btnSelectKaliurang);
        Button btnSiang = (Button) findViewById(R.id.btnSelesai);
        Button btnMalam = (Button) findViewById(R.id.btnSelectMagelang);

        btnPagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPagiOnClick();
            }
        });

        btnSiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedSiangOnClick();
            }
        });

        btnMalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedMalamOnClick();
            }
        });
    }

    private void selectedPagiOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        data.setWaktuKunjungan("Pagi");

        Intent intent = new Intent(this, klinikVokasiJamKunjungan.class);
        startActivity(intent);
    }

    private void selectedSiangOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        data.setWaktuKunjungan("Siang");

        Intent intent = new Intent(this, klinikVokasiJamKunjungan.class);
        startActivity(intent);
    }

    private void selectedMalamOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        data.setWaktuKunjungan("Malam");

        Intent intent = new Intent(this, klinikVokasiJamKunjungan.class);
        startActivity(intent);
    }
}