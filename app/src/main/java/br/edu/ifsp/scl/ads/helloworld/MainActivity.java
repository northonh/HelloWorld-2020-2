package br.edu.ifsp.scl.ads.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    // referência para o objeto Button definido no leiaute
    private Button cliqueAquiBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recuperando e atribuindo referência para objeto Button inflado a partir do leiaute
        cliqueAquiBt = findViewById(R.id.clique_aqui_bt);

        // setando listener de tratamento de eventos de clique no botão
        cliqueAquiBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // tratando evento de clique no botão mostrando uma mensagem curta para o usuário
        Toast.makeText(this, "Você clicou aqui", Toast.LENGTH_SHORT).show();
    }
}