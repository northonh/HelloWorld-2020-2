package br.edu.ifsp.scl.ads.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // referência para o objeto Button definido no leiaute
    private Button cliqueAquiBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recuperando e atribuindo referência para objeto Button inflado a partir do leiaute
        cliqueAquiBt = findViewById(R.id.clique_aqui_bt);

        /* setando listener de tratamento de eventos de clique no botão como um objeto único de
        uma classe anônima */
        cliqueAquiBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Você clicou aqui (anônimo)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}