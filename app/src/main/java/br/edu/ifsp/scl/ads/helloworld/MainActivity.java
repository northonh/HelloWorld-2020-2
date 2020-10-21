package br.edu.ifsp.scl.ads.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visorTv = findViewById(R.id.visorTv);
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
            case R.id.limparBt:
                visorTv.setText("");
                break;
        }
    }
}