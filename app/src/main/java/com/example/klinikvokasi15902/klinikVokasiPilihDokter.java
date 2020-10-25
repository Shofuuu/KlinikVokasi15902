package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class klinikVokasiPilihDokter extends AppCompatActivity {
    RadioButton radioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_pilih_dokter);

        ApplicationData data = (ApplicationData) getApplicationContext();

        TextView txtPilihDokter = (TextView) findViewById(R.id.txtPilihJam);
        radioGroup = (RadioGroup) findViewById(R.id.radioJam);
        Button btnLanjut = (Button) findViewById(R.id.btnLanjutDataDiri);

        RadioButton drA = (RadioButton) findViewById(R.id.radioWaktuA);
        RadioButton drB = (RadioButton) findViewById(R.id.radioWaktuB);
        RadioButton drC = (RadioButton) findViewById(R.id.radioWaktuC);

        List<String> strNamaDokter = new ArrayList<String>(3);
        if(data.getSelectedLocation().equals("Jalan Kaliurang"))
            strNamaDokter = Arrays.asList(getResources().getStringArray(R.array.dokterKaliurang));
        else if(data.getSelectedLocation().equals("Jalan Parangtritis"))
            strNamaDokter = Arrays.asList(getResources().getStringArray(R.array.dokterParangtritis));
        else if(data.getSelectedLocation().equals("Jalan Magelang"))
            strNamaDokter = Arrays.asList(getResources().getStringArray(R.array.dokterMagelang));

        drA.setText(strNamaDokter.get(0));
        drB.setText(strNamaDokter.get(1));
        if(strNamaDokter.size() < 3)
            drC.setVisibility(View.INVISIBLE);
        else
            drC.setText(strNamaDokter.get(2));

        txtPilihDokter.setText(
                "Pilih Dokter\n" +
                data.getSelectedLocation()
        );

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutWaktuKunjungan();
            }
        });
    }

    private void lanjutWaktuKunjungan(){
        ApplicationData data = (ApplicationData) getApplicationContext();
        int radioIdDokter = radioGroup.getCheckedRadioButtonId();

        if(radioIdDokter != (-1)){
            radioButton = findViewById(radioIdDokter);
            data.setDokterName(radioButton.getText().toString());
        }

        Intent intent = new Intent(this, klinikVokasiWaktuKunjungan.class);
        startActivity(intent);
    }
}