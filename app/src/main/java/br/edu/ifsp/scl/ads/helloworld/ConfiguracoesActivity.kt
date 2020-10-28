package br.edu.ifsp.scl.ads.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConfiguracoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        supportActionBar?.subtitle = "Tela de configurações"
    }
}