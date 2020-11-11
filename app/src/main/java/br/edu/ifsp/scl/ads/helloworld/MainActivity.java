package br.edu.ifsp.scl.ads.helloworld;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Constante para salvamento/restauração de variáveis de instância
    private final String VALOR_VISOR_TV = "VALOR_VISOR_TV";

    // Constantes para solicitação de permissões
    private final int CALL_PHONE_PERMISSION_REQUEST_CODE = 0;
    private final int CONFIGURACOES_REQUEST_CODE = 1;

    // Constante para o envio de parâmetros para a ConfiguracoesActivity
    public static final String EXTRA_CONFIGURACOES = "EXTRA_CONFIGURACOES";

    // referência para os objetos Button definidos no leiaute
    private TextView visorTv;

    // Referência para objeto que armazena as configurações
    private Configuracoes configuracoes = new Configuracoes(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(getString(R.string.app_name), "onCreate executado - iniciado ciclo completo");
        setContentView(R.layout.activity_main);

        visorTv = findViewById(R.id.visorTv);
        if (savedInstanceState != null) {
            visorTv.setText(savedInstanceState.getString(VALOR_VISOR_TV, ""));
        }

        getSupportActionBar().setSubtitle("Tela principal");
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(getString(R.string.app_name), "onSaveInstanceState executado - salvando dados de instância");
        outState.putString(VALOR_VISOR_TV, visorTv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(getString(R.string.app_name), "onRestoreInstanceState executado - restaurando dados de instância");
        //visorTv.setText(savedInstanceState.getString(VALOR_VISOR_TV, ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.configuracoesMi:
//                Intent configuracoesIntent = new Intent(this, ConfiguracoesActivity.class);
//                startActivity(configuracoesIntent);

                // Definindo uma ação (Action) particular do nosso aplicativo
                Intent configuracoesIntent = new Intent("CONFIGURACOES");
                configuracoesIntent.putExtra(EXTRA_CONFIGURACOES, configuracoes);

                startActivityForResult(configuracoesIntent, CONFIGURACOES_REQUEST_CODE);
                return true;
            case R.id.siteIfspMi:
                // Definir a URL
                Uri siteIfspUri = Uri.parse("https://www.ifsp.edu.br");
                Intent siteIfspIntent = new Intent(Intent.ACTION_VIEW, siteIfspUri);
                startActivity(siteIfspIntent);
                return true;
            case R.id.chamarIfspMi:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSION_REQUEST_CODE);
                    }
                }
                chamarIfsp();
                return true;
            case R.id.sairMi:
                finish();
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PHONE_PERMISSION_REQUEST_CODE) {
           for (int resultado: grantResults) {
               if (resultado != PackageManager.PERMISSION_GRANTED) {
                   Toast.makeText(this, "Permissão necessária não concedida", Toast.LENGTH_SHORT).show();
                   finish();
               }
           }
           chamarIfsp();
        }
    }

    private void chamarIfsp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Uri chamarIfspUri = Uri.parse("tel:1137754501");
                Intent chamarIfspIntent = new Intent(Intent.ACTION_CALL, chamarIfspUri);
                startActivity(chamarIfspIntent);
            }
        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONFIGURACOES_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            configuracoes = data.getParcelableExtra(EXTRA_CONFIGURACOES);
            if (configuracoes != null && configuracoes.getAvancada()) {
                findViewById(R.id.raizQuadradaBt).setVisibility(View.VISIBLE);
            }
            else {
                findViewById(R.id.raizQuadradaBt).setVisibility(View.GONE);
            }
        }
    }
}