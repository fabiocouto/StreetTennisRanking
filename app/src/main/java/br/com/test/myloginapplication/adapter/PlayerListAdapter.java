package br.com.test.myloginapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.test.myloginapplication.R;
import br.com.test.myloginapplication.dto.PlayerDTO;

/**
 * Created by fabiodocoutooliveira on 05/06/15.
 */
public class PlayerListAdapter extends ArrayAdapter<PlayerDTO>{


    Context context;
    ArrayList<PlayerDTO> lista;
    Integer layoutResourceID;

    public PlayerListAdapter(Context context, Integer layoutResourceID, ArrayList<PlayerDTO> lista) {
        super(context, layoutResourceID, lista);
        this.context = context;
        this.lista = lista;
        this.layoutResourceID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        PlayerDTOHolder holder = null;


        if (rowView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            rowView = inflater.inflate(layoutResourceID, parent, false);

            holder = new PlayerDTOHolder();
            //holder.imgIcon = (ImageView) rowView.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);

            rowView.setTag(holder);

        }
        else{

            holder = (PlayerDTOHolder) rowView.getTag();
        }


        for(int i = 0; i < lista.size(); i++){
            PlayerDTO player = lista.get(position);

            PlayerDTO playerAux = player;
            playerAux.setTitle(player.toString());
            holder.txtTitle.setText(player.getTitle());
           // holder.imgIcon.setImageBitmap(player.getPicture());

        }

        return rowView;

    }

    static class PlayerDTOHolder{
        //ImageView imgIcon;
        TextView txtTitle;
    }
}
