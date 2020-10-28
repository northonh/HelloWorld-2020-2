package br.edu.ifsp.scl.ads.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(getString(R.string.app_name), "onCreate executado - iniciado ciclo completo");
        setContentView(R.layout.activity_main);

        visorTv = findViewById(R.id.visorTv);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(getString(R.string.app_name), "onStart executado - iniciado ciclo visível");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getString(R.string.app_name), "onResume executado - iniciado ciclo em primeiro plano");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getString(R.string.app_name), "onPause executado - finalizado ciclo em primeiro plano");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(getString(R.string.app_name), "onStop executado - finalizado ciclo visível");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(getString(R.string.app_name), "onDestroy executado - finalizado ciclo completo");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zeroBt:
                visorTv.setText(getString(R.string.zero));
                Log.v(getString(R.string.app_name), getString(R.string.zero));
                break;
            case R.id.umBt:
                visorTv.setText(getString(R.string.um));
                break;
            case R.id.doisBt:
                visorTv.setText(getString(R.string.dois));
                break;
            case R.id.tresBt:
                visorTv.setText(getString(R.string.tres));
                break;
            case R.id.quatroBt:
                visorTv.setText(getString(R.string.quatro));
                break;
            case R.id.cincoBt:
                visorTv.setText(getString(R.string.cinco));
                break;
            case R.id.seisBt:
                visorTv.setText(getString(R.string.seis));
                break;
            case R.id.seteBt:
                visorTv.setText(getString(R.string.sete));
                break;
            case R.id.oitoBt:
                visorTv.setText(getString(R.string.oito));
                break;
            case R.id.noveBt:
                visorTv.setText(getString(R.string.nove));
                break;
        }
    }
}