package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class klinikVokasiUserConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_user_confirmation);

        ApplicationData data = (ApplicationData) getApplicationContext();

        Button btnKonfirmasiTidak = (Button) findViewById(R.id.btnKonfirmasiTidak);
        Button btnKonfirmasiYa = (Button) findViewById(R.id.btnKonfirmasiya);
        TextView txtDataUser = (TextView) findViewById(R.id.txtDataUser);

        txtDataUser.setText(
                "Alamat Klinik : " + data.getLocationAddress() + "\n" +
                "Nama Dokter : " + data.getDokterName() + "\n" +
                "Waktu Kunjungan : " + data.getWaktuKunjungan() + ". " + data.getJamKunjungan() + "\n" +
                "Nama : " + data.getNamaPengunjung() + "\n" +
                "Jenis Kelamin : " + data.getKelamin() + "\n" +
                "NIK : " + data.getNIKPengunjung() + "\n" +
                "Provinsi : " + data.getProvinsiPengunjung() + "\n" +
                "No. Telp. : " + data.getTeleponPengunjung() + "\n" +
                "Berat Badan : " + data.getBeratBadan() + "\n" +
                "Tinggi Badan : " + data.getTinggiBadan() + "\n" +
                "Tekanan Darah : " + data.getTekananDarah() + "\n" +
                "Alergi Obat : " + data.getAlergiObat() + "\n" +
                "Keluhan : " + data.getKeluhan() + "\n" +
                "Pembayaran : " + data.getMetodePembayaran() + "\n" +

                ((data.getNoAsuransi().isEmpty()) ? "" : ("No. Asuransi : " + data.getNoAsuransi()))
        );

        btnKonfirmasiYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutSelesai();
            }
        });

        btnKonfirmasiTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembaliKeAwal();
            }
        });
    }

    private void kembaliKeAwal(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void lanjutSelesai(){
        Intent intent = new Intent(this, klinikVokasiSelesai.class);
        startActivity(intent);
    }
}