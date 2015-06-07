package br.com.test.myloginapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import br.com.test.myloginapplication.R;


public class GuestLoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnGuest = (Button) findViewById(R.id.buttonGuest);
        Button btnAdm = (Button) findViewById(R.id.buttonLoginAdm);

        btnGuest.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(null, "  - login usuario guest");

                Intent playersList;
                playersList = new Intent(getApplicationContext(),
                        PlayersListActivity.class);
                startActivity(playersList);

                Toast.makeText(getApplicationContext(), "Olá visitante! Bem-vindo ao UniOpenRanking!", Toast.LENGTH_SHORT).show();


            }
        });



        btnAdm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(null, "  - login usuario admin");

                Intent loginAdm;
                loginAdm = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(loginAdm);

                Toast.makeText(getApplicationContext(), "Olá administrador! Bem-vindo ao UniOpenRanking!", Toast.LENGTH_SHORT).show();

            }
        });

    }


    }

