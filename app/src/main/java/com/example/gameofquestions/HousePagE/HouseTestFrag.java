package com.example.gameofquestions.HousePagE;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.gameofquestions.R;


public class HouseTestFrag extends Fragment {

    ListView HouseLV;
    String HouseTitles[] = {"House Targaryen","House Stark","House Lannister","House Baratheon", "House Tyrell", "House Martell", "House Greyjoy", "House Tully", "House Arryn"};
    int sigils[] = {R.drawable.trgryn, R.drawable.stark, R.drawable.lannister, R.drawable.baratheon, R.drawable.tyrell, R.drawable.martell, R.drawable.greyjoy, R.drawable.tully, R.drawable.arryn};


    public HouseTestFrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.list_view, container, false);
        view.setBackgroundResource(R.color.grey);

        HouseLV = view.findViewById(R.id.MenuBar);
        CustomAdapter customAdapter = new CustomAdapter(view.getContext(), HouseTitles, sigils
        );
        HouseLV.setAdapter(customAdapter);

        // on click listener for each different house in the list view so that pop up will appear
        HouseLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    startActivity(new Intent(getActivity(),HouseTrgryn.class));
                }
                if (position==1)
                {
                    startActivity(new Intent(getActivity(),HouseStark.class));
                }
                if (position==2)
                {
                    startActivity(new Intent(getActivity(),HouseLannister.class));
                }
                if (position==3)
                {
                    startActivity(new Intent(getActivity(),HouseBara.class));
                }
                if (position==4)
                {
                    startActivity(new Intent(getActivity(),HouseTyrell.class));
                }
                if (position==5)
                {
                    startActivity(new Intent(getActivity(),HouseMartell.class));
                }
                if (position==6)
                {
                    startActivity(new Intent(getActivity(),HouseGJ.class));
                }
                if (position==7)
                {
                    startActivity(new Intent(getActivity(),HouseTully.class));
                }
                if (position==8)
                {
                    startActivity(new Intent(getActivity(),HouseArryn.class));
                }

            }
        });




        return view;
    }

}
