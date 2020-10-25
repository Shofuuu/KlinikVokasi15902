package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class klinikVokasiDataDiri extends AppCompatActivity {
    RadioGroup radioJenisKelamin;
    RadioButton radioButton;
    String selectedProvinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_data_diri);

        Button btnLanjutDataKesehatan = (Button) findViewById(R.id.btnKonfirmasiTidak);
        Spinner spinnerProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        radioJenisKelamin = (RadioGroup) findViewById(R.id.radioJenisKelamin);

        List<String> strProvinsi = new ArrayList<String>(5);
        strProvinsi = Arrays.asList(getResources().getStringArray(R.array.provinsi));
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strProvinsi);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerProvinsi.setAdapter(adapter);
        spinnerProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedProvinsi = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedProvinsi = parent.getItemAtPosition(0).toString();
            }
        });

        btnLanjutDataKesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutOnClick();
            }
        });
    }

    private void lanjutOnClick(){
        ApplicationData data = (ApplicationData) getApplicationContext();

        EditText editNama = (EditText) findViewById(R.id.editBeratBadan);
        EditText editNIK = (EditText) findViewById(R.id.editNoAsuransi);
        EditText editTelp = (EditText) findViewById(R.id.editTelp);

        int radioIdKelamin = radioJenisKelamin.getCheckedRadioButtonId();
        radioButton = findViewById(radioIdKelamin);

        if(radioIdKelamin != (-1))
            data.setKelamin(radioButton.getText().toString());

        data.setNamaPengunjung(editNama.getText().toString());
        data.setNIKPengunjung(editNIK.getText().toString());
        data.setTeleponPengunjung(editTelp.getText().toString());
        data.setProvinsiPengunjung(selectedProvinsi);

        Intent intent = new Intent(this, klinikVokasiDataKesehatan.class);
        startActivity(intent);
    }
}