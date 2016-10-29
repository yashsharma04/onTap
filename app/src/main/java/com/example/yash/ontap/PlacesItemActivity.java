package com.example.yash.ontap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlacesItemActivity extends AppCompatActivity {

    TextView title ;
    TextView addr ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_item);
        String str = getIntent().getStringExtra("val");
        title = (TextView) findViewById(R.id.title);
        title.setText(str);

        addr = (TextView) findViewById(R.id.addr);
        addr.setText("Manipal , Mangalore , Karnataka , India");
    }
}
