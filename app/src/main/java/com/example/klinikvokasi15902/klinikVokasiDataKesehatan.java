package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class klinikVokasiDataKesehatan extends AppCompatActivity {
    RadioGroup radioAlergiObat;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_data_kesehatan);

        Button btnLanjutMetodePembayaran = (Button) findViewById(R.id.btnKonfirmasiTidak);
        radioAlergiObat = (RadioGroup) findViewById(R.id.radioJenisKelamin);

        btnLanjutMetodePembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutMetodePembayaran();
            }
        });
    }

    private void lanjutMetodePembayaran(){
        ApplicationData data = (ApplicationData) getApplicationContext();

        EditText editBeratBadan = (EditText) findViewById(R.id.editBeratBadan);
        EditText editTinggiBadan = (EditText) findViewById(R.id.editTinggiBadan);
        EditText editTekananDarah = (EditText) findViewById(R.id.editTekananDarah);
        EditText editKeluhan = (EditText) findViewById(R.id.editTekananDarah);

        int radioIdAlergi = radioAlergiObat.getCheckedRadioButtonId();
        radioButton = findViewById(radioIdAlergi);

        if(radioIdAlergi != (-1))
            data.setAlergiObat(radioButton.getText().toString());

        data.setBeratBadan(editBeratBadan.getText().toString());
        data.setTinggiBadan(editTinggiBadan.getText().toString());
        data.setTekananDarah(editTekananDarah.getText().toString());
        data.setKeluhan(editKeluhan.getText().toString());

        Intent intent = new Intent(this, klinikVokasiMetodePembayaran.class);
        startActivity(intent);
    }
}