package com.example.yash.ontap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EatItemActivity extends AppCompatActivity {

    TextView title;
    TextView addr;
    TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_item);
        String str = getIntent().getStringExtra("val");
        title = (TextView) findViewById(R.id.title);
        title.setText(str);

        addr = (TextView) findViewById(R.id.addr);
        addr.setText("Manipal , Mangalore , Karnataka , India ");

        contact = (TextView) findViewById(R.id.contact);
        contact.setText("0141220022");
    }
}
