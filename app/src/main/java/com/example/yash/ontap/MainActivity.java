package com.example.yash.ontap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.yash.ontap.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        Button next = (Button) findViewById(R.id.btn1);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Eat.class);
                startActivity(intent);
            }

        });
        Button places = (Button) findViewById(R.id.btn2);
        places.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(),PlacesActivity.class);
                startActivity(intent);
            }
        });
    }



}
