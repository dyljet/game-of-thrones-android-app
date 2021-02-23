package com.example.gameofquestions.HousePagE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameofquestions.R;

public class CustomAdapter extends BaseAdapter {
    String HouseTitles[];
    int sigils[];
    LayoutInflater popUP;

    public CustomAdapter(Context applicationContext, String[] HouseTitles, int[] sigils) {
        this.HouseTitles = HouseTitles;
        this.sigils = sigils;
        popUP = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return HouseTitles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = popUP.inflate(R.layout.house_list_layout, null);
        TextView houseT = view.findViewById(R.id.textView);
        ImageView sigil = view.findViewById(R.id.sigil);
        houseT.setText(HouseTitles[i]);
        sigil.setImageResource(sigils[i]);
        return view;
    }


}