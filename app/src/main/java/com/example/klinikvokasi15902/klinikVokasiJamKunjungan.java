package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class klinikVokasiJamKunjungan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_jam_kunjungan);

        ApplicationData data = (ApplicationData) getApplicationContext();

        TextView txtPilihJam = (TextView) findViewById(R.id.txtPilihJam);
        Button btnLanjut = (Button) findViewById(R.id.btnLanjutDataDiri);

        CheckBox cbA = (CheckBox) findViewById(R.id.cbWaktuA);
        CheckBox cbB = (CheckBox) findViewById(R.id.cbWaktuB);
        CheckBox cbC = (CheckBox) findViewById(R.id.cbWaktuC);

        List<String> strJamKunjungan = new ArrayList<String>(3);
        if(data.getWaktuKunjungan().equals("Pagi"))
            strJamKunjungan = Arrays.asList(getResources().getStringArray(R.array.jamPagi));
        else if(data.getWaktuKunjungan().equals("Siang"))
            strJamKunjungan = Arrays.asList(getResources().getStringArray(R.array.jamSiang));
        else if(data.getWaktuKunjungan().equals("Malam"))
            strJamKunjungan = Arrays.asList(getResources().getStringArray(R.array.jamMalam));

        cbA.setText(strJamKunjungan.get(0));
        cbB.setText(strJamKunjungan.get(1));
        cbC.setText(strJamKunjungan.get(2));

        txtPilihJam.setText(
                "Pilih Waktu\n"+
                "Kunjungan "+
                data.getWaktuKunjungan()
        );

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutOnClick();
            }
        });
    }

    private void lanjutOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        String allTime = "";

        CheckBox cbA = (CheckBox) findViewById(R.id.cbWaktuA);
        CheckBox cbB = (CheckBox) findViewById(R.id.cbWaktuB);
        CheckBox cbC = (CheckBox) findViewById(R.id.cbWaktuC);

        if(cbA.isChecked())
            allTime += cbA.getText().toString() + ", ";
        if(cbB.isChecked())
            allTime += cbB.getText().toString() + ", ";
        if(cbC.isChecked())
            allTime += cbC.getText().toString() + ", ";
        else
            allTime += cbA.getText().toString() + ", ";

        StringBuilder sbTime = new StringBuilder(allTime);
        sbTime.setCharAt(allTime.indexOf(',', allTime.length()-3), '\0');
        allTime = sbTime.toString();

        data.setJamKunjungan(allTime);

        Intent intent = new Intent(this, klinikVokasiDataDiri.class);
        startActivity(intent);
    }
}