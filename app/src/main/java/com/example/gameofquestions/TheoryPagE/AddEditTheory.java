package com.example.gameofquestions.TheoryPagE;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import com.example.gameofquestions.R;
import com.example.gameofquestions.TheoryPagE.db.TheoryDB;
import com.example.gameofquestions.TheoryPagE.db.TheoryDao;

import java.util.Date;

public class AddEditTheory extends AppCompatActivity {
private EditText enterTheory;

private TheoryDao dao;
private Theory temp;
public static final String THEORY_EXTRA_Key="theory_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_theory);
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);

        enterTheory = findViewById(R.id.enter_theory);
        dao = TheoryDB.getInstance(this).theoriesDao();


        if (getIntent().getExtras() != null)
        {
            int id = getIntent().getExtras().getInt(THEORY_EXTRA_Key, 0);
            temp = dao.getTheoryById(id);
            enterTheory.setText(temp.getTheoryText());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_theory_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.save_theory)
            onSaveTheory();

        return super.onOptionsItemSelected(item);
    }

    private void onSaveTheory() {

        String text = enterTheory.getText().toString();

        if(!text.isEmpty()) {
            //get time and date
            long date = new Date().getTime();


//if statement if it's a new theory create and insert to database else update current one and update in database
                if(temp==null){
                    temp = new Theory(text,date);
                    dao.insertTheory(temp);

                }else{
                    temp.setTheoryText(text);
                    temp.setTheoryDate(date);
                    dao.updateTheory(temp);
                }




            finish(); // return to the theories page
        }

    }
}
