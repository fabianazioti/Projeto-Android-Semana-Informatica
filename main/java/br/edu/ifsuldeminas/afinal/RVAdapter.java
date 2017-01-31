package br.edu.ifsuldeminas.afinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personData;
        ImageView personPhoto;



        PersonViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personData = (TextView) itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

        }


    }

    List<Icone> persons;

    RVAdapter(List<Icone> persons){

        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int i) {
        personViewHolder.personName.setText(persons.get(i).icone_nome);
        personViewHolder.personData.setText(persons.get(i).data);
        personViewHolder.personPhoto.setImageResource(persons.get(i).icone_photoId);
        personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i){
                    case 0:
                        Toast.makeText(v.getContext(), "Recycle Click" + i, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(v.getContext(), "Recycle Click" + i, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(v.getContext(), "Recycle Click" + i, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(v.getContext(), "Recycle Click" + i, Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


}
