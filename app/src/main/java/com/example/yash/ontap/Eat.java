package com.example.yash.ontap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Eat extends AppCompatActivity {
    String[] mobileArray = {"Dollops","Eye of the Tiger","Saiba","Atil","Red Kitchen","Burger King"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,mobileArray);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str = mobileArray[position];
                Intent intent = new Intent(Eat.this,EatItemActivity.class);
                intent.putExtra("val",str);
                startActivity(intent);

            }
        });
    }
}
