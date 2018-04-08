package com.example.shagun.poolonwheels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText name,sid,password,age,number;
    RadioGroup gender;
    RadioButton male,female;
    Button register;

    DatabaseReference databaseusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.nameedittext);
        sid = findViewById(R.id.sidedittext);
        password = findViewById(R.id.passwordedittext);
        age = findViewById(R.id.ageedittext);
        number = findViewById(R.id.numberedittext);
        gender = findViewById(R.id.gendergroup);
        male = findViewById(R.id.malebtn);
        female = findViewById(R.id.femalebtn);

        databaseusers= FirebaseDatabase.getInstance().getReference("Users");

        register = findViewById(R.id.registerbtn);

        //add to database on clicking register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(signup.this, "Registered SuccessFully", Toast.LENGTH_SHORT).show();
                addUser();
            }
        });
    }

    private void addUser() {
        String uname=name.getText().toString().trim();
        String usid =sid.getText().toString().trim();
        String upassword=password.getText().toString().trim();
        String uage=age.getText().toString().trim();
        String unumber=number.getText().toString().trim();
        String ugender;
        if(gender.getCheckedRadioButtonId()==R.id.malebtn)
        {
            ugender="Male";
        }else
        {
            ugender="Female";
        }
        //sid and password should not be empty
        if(!TextUtils.isEmpty(usid) || !TextUtils.isEmpty(upassword)){
            User user = new User(uname,usid,upassword,uage,unumber,ugender);
            databaseusers.child(usid).setValue(user);
        }
        else
        {
            Toast.makeText(this, "Sid and Password need to be Entered", Toast.LENGTH_SHORT).show();
        }

    }
}
