package br.com.test.myloginapplication.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.*;
import android.content.Intent;
import br.com.test.myloginapplication.util.SessionManager;

import br.com.test.myloginapplication.R;

public class PlayerDetailActivity extends ActionBarActivity {

    private SessionManager session;
    private static final String CATEGORIA = "PlayerDetail ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player_detail);
        Log.i("", " - Exibe os detalhes do jogador");

        TextView txtProduct = (TextView) findViewById(R.id.player_label);

        Intent i = getIntent();
        // getting attached intent data
        String playerNameDetail = i.getStringExtra("player");
        // displaying selected product name
        txtProduct.setText(playerNameDetail);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Configurações", Toast.LENGTH_SHORT).show();
            Log.i(CATEGORIA, " - acessou configuracoes");
            return true;
        }
        if (id == R.id.action_settings_novo_jogador) {
            Toast.makeText(getApplicationContext(), "Novo jogador", Toast.LENGTH_SHORT).show();
            Log.i(CATEGORIA, " - acessou novo jogador");
            session = new SessionManager(getApplicationContext());
            if(session.isLoggedIn()){

                // criar nova tela de inclusao de jogador!
                Intent newPlayer;
                newPlayer = new Intent(getApplicationContext(), NewPlayerActivity.class);
                startActivity(newPlayer);

                Log.i(CATEGORIA, " - acessou novo jogador");

            }


            return true;
        }
        if (id == R.id.action_settings_logout) {
            Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();

            Intent logout;
            logout = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(logout);

            session.logoutUser();
            Log.i(CATEGORIA, " - realizou logout");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

