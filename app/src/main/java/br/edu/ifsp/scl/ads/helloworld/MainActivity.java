package br.edu.ifsp.scl.ads.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // referência para os objetos Button definidos no leiaute
    private Button zeroBt, umBt, doisBt, limparBt;
    private TextView visorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getString(R.string.zero);

        // recuperando e atribuindo referência para objeto Button inflado a partir do leiaute
        visorTv = findViewById(R.id.visorTv);
        zeroBt = findViewById(R.id.zeroBt);
        umBt = findViewById(R.id.umBt);
        limparBt = findViewById(R.id.limparBt);

        /* setando listener de tratamento de eventos de clique no botão como uma função lambda */
        zeroBt.setOnClickListener(this);
        umBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                visorTv.setText(getString(R.string.um));
            }
        });
        limparBt.setOnClickListener(
                v -> visorTv.setText("")
        );
    }

    @Override
    public void onClick(View v) {
        visorTv.setText(getString(R.string.zero));
    }

    public void onClickDois(View view) {
        visorTv.setText(getString(R.string.dois));
    }
}