package com.example.gameofquestions.TheoryPagE;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gameofquestions.R;


import java.util.ArrayList;

public class TheoriesAdapter extends RecyclerView.Adapter<TheoriesAdapter.TheoryHolder>{

    private Context context;
    private ArrayList<Theory> theories;
    private TheoryGestures listener;

    public TheoriesAdapter(Context context, ArrayList<Theory> theories) {
        this.context = context;
        this.theories = theories;
    }


    @Override
    public TheoryHolder onCreateViewHolder( ViewGroup parent, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.theory_p_layout,parent,false);
        return new TheoryHolder(v);
    }

    @Override
    public void onBindViewHolder( TheoryHolder holder, int position) {

        final Theory theory = getTheory(position);
        if (theory !=null) {
            holder.theoryText.setText(theory.getTheoryText());
            holder.theoryDate.setText(TheoryDate.dateFromLong(theory.getTheoryDate()));
            //click event
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onTheoryClick(theory);
                }
            });

            //long click event
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onTheoryLongClick(theory);
                return false;
            }
        });
        }


    }

    @Override
    public int getItemCount() {
        return theories.size();
    }

    private Theory getTheory(int position){

        return theories.get(position);
    }

    class TheoryHolder extends RecyclerView.ViewHolder {
       TextView theoryText, theoryDate;

       public TheoryHolder (View itemView){
           super(itemView);
theoryDate=itemView.findViewById(R.id.theory_date);
           theoryText=itemView.findViewById(R.id.theory_text);


       }
   }

    public void setListener(TheoryGestures listener) {
        this.listener = listener;
    }
}
