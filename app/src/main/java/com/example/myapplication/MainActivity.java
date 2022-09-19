package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener wybranyElement = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String prdukt = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, prdukt, Toast.LENGTH_SHORT).show();

            }
        };
        ListView listViewZakupy=findViewById(R.id.listView);
        listViewZakupy.setOnItemClickListener(wybranyElement);
    }
}