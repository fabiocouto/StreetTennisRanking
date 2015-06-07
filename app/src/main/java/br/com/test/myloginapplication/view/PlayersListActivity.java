package br.com.test.myloginapplication.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;


import java.util.ArrayList;

import br.com.test.myloginapplication.R;
import br.com.test.myloginapplication.adapter.PlayerListAdapter;
import br.com.test.myloginapplication.model.Player;
import br.com.test.myloginapplication.dto.PlayerDTO;

public class PlayersListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);
        Log.i("", "  - Ranking List ");

        final PlayerDTO player = new PlayerDTO();
        player.setPlayerName("Fábio");

        final ArrayList<PlayerDTO> players = new ArrayList<PlayerDTO>();
        players.add(0, player);

        //ArrayList<PlayerDTO> players = getResources().getStringArray(R.array.players);
        //this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, players));

        PlayerListAdapter adapter = new PlayerListAdapter(this, R.layout.activity_player_list_itens, players);

        ListView listView = (ListView) findViewById(R.id.listViewPLayers);

        View header = (View) getLayoutInflater().inflate(
                R.layout.activity_player_list_header, null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

        //ListView lv = getListView();

        // listening to single list item on click
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                // String playerName = ((TextView) view).getText().toString();

                TextView name = (TextView) findViewById(R.id.txtTitle);
                name.setText(player.getPlayerName().toString());

                String playerName = name.getText().toString();

                // Launching new Activity on selecting single List Item
                Intent playerDetails = new Intent(getApplicationContext(), PlayerDetailActivity.class);
                // sending data to new activity
                playerDetails.putExtra("player", playerName);
                Log.i("", " - chamada para os detalhes do jogador");

                startActivity(playerDetails);

            }
        });


    }

        private class AsyncTaskRetrievePlyersRanking extends AsyncTask<Integer, Integer, ArrayList<PlayerDTO>> {
            private ProgressDialog dialog;

            @SuppressWarnings("static-access")
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(PlayersListActivity.this);
                dialog.show();
            }

            @Override
            protected ArrayList<PlayerDTO> doInBackground(Integer... params) {

                publishProgress();
                //return buscarDisciplinas();
                return null;
            }

            @Override
            protected void onPostExecute(
                    @SuppressWarnings("rawtypes") ArrayList listaDisciplinas) {

                Log.d("Erro", "Chegou no metodo onPost" + listaDisciplinas.toString());

                if (!listaDisciplinas.isEmpty()) {

                    try {

                       // mostraListaDisciplinasVO(listaDisciplinas);

                    } catch (Exception e) {

                        Log.e("Erro", e.getMessage());

                    } finally {

                        dialog.dismiss();
                    }

                }
            }


    }
}
