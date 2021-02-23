package com.example.gameofquestions.LoginPagE;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gameofquestions.R;

public class RegisterPage extends AppCompatActivity {

    DatabaseHelper db;
    EditText UsernameField;
    EditText PasswordField;
    EditText PasswordCnfField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        db = new DatabaseHelper(this);
        UsernameField = findViewById(R.id.username_text);
        PasswordField = findViewById(R.id.password_text);
        PasswordCnfField = findViewById(R.id.edittext_cnf_password);




        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);


        Button button = (Button) findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Register();
            }
        });

}



    public void openLoginPage() {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        stopService(new Intent(this, MyService.class));

    }

    public void Register() {

        String username = UsernameField.getText().toString().trim();
        String password = PasswordField.getText().toString().trim();
        String cnf_password = PasswordCnfField.getText().toString().trim();

        //if statement checking if confirm password and password matches
        if(password.equals(cnf_password))
        {

           long val = db.addUser(username,password);
            if (val > 0) {


                Toast.makeText(RegisterPage.this, "Register successful", Toast.LENGTH_SHORT).show();
                openLoginPage();

            }else {
                Toast.makeText(RegisterPage.this, "Register error", Toast.LENGTH_SHORT).show();

            }

        }else{
            Toast.makeText(RegisterPage.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }

    }
}