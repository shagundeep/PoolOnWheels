package com.example.shagun.poolonwheels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    EditText sid,password;
    Button login,signup;
    DatabaseReference databaseusers;
    List<User> userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sid = findViewById(R.id.sidedittext);
        password = findViewById(R.id.passedittext);
        login = findViewById(R.id.loginbtn);
        signup = findViewById(R.id.signupbtn);
        userlist = new ArrayList<>();
        databaseusers= FirebaseDatabase.getInstance().getReference("users");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to home page
                //data from the database should be fetched and checked.
                //check from the userlist;
                String usid = sid.getText().toString().trim();
                int flag=0;
                String upassword = password.getText().toString().trim();
                for(int i=0;i<userlist.size();i++)
                {
                    User user = userlist.get(i);
                    if(usid.equalsIgnoreCase(user.getUsername())&& upassword.equalsIgnoreCase(user.getUserpassword())) {
                        flag=1;
                        startActivity(new Intent(Login.this, Home.class));
                        Login.this.finish();
                    }
                }
                if(flag == 0)
                {
                    Toast.makeText(Login.this, "User not registered", Toast.LENGTH_SHORT).show();
                }
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

    @Override
    protected void onStart() {
        super.onStart();

        databaseusers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userlist.clear();

                for(DataSnapshot usersnapshot : dataSnapshot.getChildren()){
                    User user=usersnapshot.getValue(User.class);
                    userlist.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
