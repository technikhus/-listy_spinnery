package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> zakupy = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zakupy.add("śliwki", checkBox.class,null);
        zakupy.add("gruszubki");
        zakupy.add("ziemniaki");
        AdapterView.OnItemClickListener wybranyElement = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,  View view, int position, long id) {
                String produkt = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,produkt,Toast.LENGTH_SHORT).show();
            }

        };
        ListView listViewZakupy=findViewById(R.id.listView);
        listViewZakupy.setOnItemClickListener(wybranyElement);

        //lista dodawana dynamicznie z listy ArrayList zakupy
        ArrayAdapter<String> zakupyAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                zakupy
        );

        ListView listViewDynamiczne = findViewById(R.id.listViewDynamiczne);
        listViewDynamiczne.setAdapter(zakupyAdapter);

        AdapterView.OnItemClickListener kliknentyElement = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String produktKliknenty = adapterView.getItemAtPosition(i).toString();
                zakupy.remove(produktKliknenty);
                zakupyAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,produktKliknenty, Toast.LENGTH_SHORT).show();
            }
        };
        listViewDynamiczne.setOnItemClickListener(kliknentyElement);

        Button dodawanieButton = findViewById(R.id.button2);
        dodawanieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText produktEditText = findViewById(R.id.editTextTextPersonName);
                String dodawanyProdukt = produktEditText.getText().toString();
                zakupy.add(dodawanyProdukt);
                zakupyAdapter.notifyDataSetChanged();
            }
        });
    }
}