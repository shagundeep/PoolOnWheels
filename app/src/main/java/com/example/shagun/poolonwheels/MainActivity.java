package com.example.shagun.poolonwheels;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    TextView start;
    ConstraintLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.starttextview);
        home = findViewById(R.id.homelayout);
        blink();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });


    }

    private void blink()
    {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{Thread.sleep(800);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if(start.getVisibility() == View.VISIBLE){
                            start.setVisibility(View.INVISIBLE);
                        }else{
                            start.setVisibility(View.VISIBLE);
                        }
                        blink();
                    }
                });
            }
        }).start();

    }
}
