package com.example.gameofquestions.TheoryPagE;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gameofquestions.NavigationDrawer;
import com.example.gameofquestions.R;
import com.example.gameofquestions.TheoryPagE.db.TheoryDB;
import com.example.gameofquestions.TheoryPagE.db.TheoryDao;

import java.util.ArrayList;
import java.util.List;

import static com.example.gameofquestions.TheoryPagE.AddEditTheory.THEORY_EXTRA_Key;

public class TheoryMainPage extends AppCompatActivity implements TheoryGestures {

    private static final String TAG = "TheoryMainPage";
    private RecyclerView recyclerView;
    private ArrayList<Theory> theories;
    private TheoriesAdapter adapter;
    private TheoryDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_theory_main_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);




        recyclerView=findViewById(R.id.theories_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


 // fab button to add theory

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                onAddNewTheory();

            }
        });

        dao= TheoryDB.getInstance(this).theoriesDao();
    }

    private void loadTheories() {
        //loads theories from database
        this.theories =new ArrayList<>();
        List<Theory> list =dao.getTheories();
        this.theories.addAll(list);
        this.adapter = new TheoriesAdapter(this, theories);

        this.adapter.setListener(this);
        this.recyclerView.setAdapter(adapter);
        showEmptyView();


        swipeToDeleteHelper.attachToRecyclerView(recyclerView);
    }

    private void showEmptyView() {
        //if there are no theories then show comment to prompt an add
        if (theories.size() == 0) {
            this.recyclerView.setVisibility(View.GONE);
            findViewById(R.id.no_theories).setVisibility(View.VISIBLE);

        }else {
            this.recyclerView.setVisibility(View.VISIBLE);
            findViewById(R.id.no_theories).setVisibility(View.GONE);
        }
    }


    private void onAddNewTheory() {
        //call class to add theory
        startActivity(new Intent(this, AddEditTheory.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        getMenuInflater().inflate(R.menu.back_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        //back button because i used a activity which doesn't have navigation drawer menu
        if (id == R.id.back_theory) {
            Intent intent = new Intent(this, NavigationDrawer.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTheories();
    }

    @Override
    public void onTheoryClick(Theory theory) {


Intent edit= new Intent(this, AddEditTheory.class);
edit.putExtra(THEORY_EXTRA_Key, theory.getId());
startActivity(edit);

    }

    @Override
    public void onTheoryLongClick(final Theory theory) {

        //on long click i can either cancel, delete or share the theory
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
              })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.deleteTheory(theory);
                        loadTheories();

                    }
                })

                .setNegativeButton("Share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        //intent to share theory
                        Intent shareT = new Intent(Intent.ACTION_SEND);
                        String text = theory.getTheoryText()+"\n I created this on :" +
                        TheoryDate.dateFromLong(theory.getTheoryDate()) + " By :" + getString(R.string.app_name);
                        shareT.setType("text/plain");
                        shareT.putExtra(Intent.EXTRA_TEXT, text);
                        startActivity(shareT);

                    }
                })

                .create()
                .show();



    }

    // when swipe left or right call function
    private ItemTouchHelper swipeToDeleteHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            if(theories !=null){
              Theory swipedTheory = theories.get(viewHolder.getAdapterPosition());
              if (swipedTheory !=null){
                  //function to delete when swiped
                  swipeToDelete(swipedTheory, viewHolder);
              }
            }

        }
    });

    private void swipeToDelete(final Theory swipedTheory, final RecyclerView.ViewHolder viewHolder) {
        new AlertDialog.Builder(TheoryMainPage.this)
                .setMessage("Delete Theory?")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dao.deleteTheory(swipedTheory);
                        theories.remove(swipedTheory);
                        adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                        showEmptyView();

                    }
                })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                recyclerView.getAdapter().notifyItemChanged(viewHolder.getAdapterPosition());



            }
        })

                .setCancelable(false)
                .create().show();
    }


}

