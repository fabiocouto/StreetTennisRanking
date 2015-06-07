package br.com.test.myloginapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.test.myloginapplication.util.SessionManager;

import br.com.test.myloginapplication.R;


public class LoginActivity extends Activity implements OnClickListener{


    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        EditText login = (EditText) findViewById(R.id.editTextLogin);
        EditText password = (EditText) findViewById(R.id.editTextPassword);

        if(login.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin")){

            Intent telaInicial;
            telaInicial = new Intent(getApplicationContext(),
                    PlayersListActivity.class);
            startActivity(telaInicial);

            session = new SessionManager(getApplicationContext());

            session.createLoginSession(login.toString(), password.toString());

        }
        else{

        Toast.makeText(getApplicationContext(), "Login inválido!", Toast.LENGTH_SHORT).show();

        }

    }



}
