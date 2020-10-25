package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class klinikVokasiMetodePembayaran extends AppCompatActivity {
    RadioGroup radioMetodePembayaran;
    RadioButton radioMetodeSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_metode_pembayaran);

        radioMetodePembayaran = (RadioGroup) findViewById(R.id.radioJenisKelamin);
        Button btnLanjutKonfirmasiUser = (Button) findViewById(R.id.btnKonfirmasiTidak);

        btnLanjutKonfirmasiUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutKonfirmasiUser();
            }
        });
    }

    private void lanjutKonfirmasiUser(){
        ApplicationData data = (ApplicationData) getApplicationContext();

        EditText editNoAsuransi = (EditText) findViewById(R.id.editNoAsuransi);
        int radioIdPembayaran = radioMetodePembayaran.getCheckedRadioButtonId();
        radioMetodeSelect = findViewById(radioIdPembayaran);

        if(radioIdPembayaran != (-1))
            data.setMetodePembayaran(radioMetodeSelect.getText().toString());
        data.setNoAsuransi(editNoAsuransi.getText().toString());

        Intent intent = new Intent(this, klinikVokasiUserConfirmation.class);
        startActivity(intent);
    }
}