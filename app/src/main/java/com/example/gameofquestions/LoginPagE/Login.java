package com.example.gameofquestions.LoginPagE;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gameofquestions.NavigationDrawer;
import com.example.gameofquestions.R;

public class Login extends AppCompatActivity {

    DatabaseHelper db;

    EditText UsernameField;
    EditText PasswordField;



    private Button button;

    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //music starts
        startService(new Intent(this, MyService.class));



        //mute button
        FloatingActionButton fab = findViewById(R.id.mute);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 stopMusic();

            }
        });




        db = new DatabaseHelper(this);
        UsernameField = findViewById(R.id.username_text);
        PasswordField = findViewById(R.id.password_text);


        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);

        button = (Button) findViewById(R.id.RegisterButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openRegisterPage();
            }
                                  }


        );

        button = (Button) findViewById(R.id.LoginButton);
        button.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {

                                          LoginConfirmation();

                                      }
                                  }


        );





    }


    private void stopMusic() {
        stopService(new Intent(this, MyService.class));

    }

    public void LoginConfirmation() {
 String username = UsernameField.getText().toString().trim();
        String password = PasswordField.getText().toString().trim();
        boolean res = db.checkUser(username, password);

        //if statement checking if the username and password matches whats in the database
        if(res == true)
        {
openHomePage();
        }else{
            Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
        }


    }

    public void openRegisterPage() {

        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);

    }

    public void openHomePage() {

        Intent intent = new Intent(this, NavigationDrawer.class);
        startActivity(intent);
        stopService(new Intent(this, MyService.class));


    }




}
