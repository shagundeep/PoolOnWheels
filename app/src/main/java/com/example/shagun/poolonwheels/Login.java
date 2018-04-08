package com.example.shagun.poolonwheels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText sid,password;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sid = findViewById(R.id.sidedittext);
        password = findViewById(R.id.passedittext);
        login = findViewById(R.id.loginbtn);
        signup = findViewById(R.id.signupbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to home page
                //data from the database should be fetched and checked.
                startActivity(new Intent(Login.this,Home.class));
                Login.this.finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to signup page
                startActivity(new Intent(Login.this,signup.class));
                Login.this.finish();
            }
        });
    }
}
