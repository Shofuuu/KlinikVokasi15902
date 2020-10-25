package com.example.klinikvokasi15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class klinikVokasiSelesai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klinik_vokasi_selesai);

        ApplicationData data = (ApplicationData) getApplicationContext();

        TextView txtSelesai = (TextView) findViewById(R.id.txtSelesai);
        Button btnSelesai = (Button) findViewById(R.id.btnSelesai);

        txtSelesai.setText(
                "Terimakasih telah\n" +
                "mendaftar di Klinik\n" +
                "Vokasi. Konfirmasi\n" +
                "pendaftaran anda akan\n" +
                "segera dikirimkan\n" +
                "melalui sms ke nomer\n" +
                data.getTeleponPengunjung()
        );

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selesaiKembaliKeAwal();
            }
        });
    }

    private void selesaiKembaliKeAwal(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}