package com.example.gameofquestions.QuizPagE;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gameofquestions.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizPageFrag extends Fragment {


    public QuizPageFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_page, container, false);

        view.setBackgroundResource(R.color.grey);




      Button startButton = (Button) view.findViewById(R.id.startButton);
      startButton.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v){

              Intent in = new Intent(getActivity(), Quiz.class);
              startActivity(in);

          }

      });



        return view;


    }

}
