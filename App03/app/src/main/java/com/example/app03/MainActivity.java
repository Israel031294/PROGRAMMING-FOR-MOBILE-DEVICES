package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] myStringArray;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myStringArray = new String[]{"Amigo","Bosque","Casa","Dado","Emanuel","Faraon","Gato","Hetero"};
        myStringArray=getResources().getStringArray(R.array.countries_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myStringArray);
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(adapter);
        EditText editText  = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String match = ((TextView) findViewById(R.id.editText)).getText().toString();
                ArrayList<String> newArray = new ArrayList<>();
                int n = 0;
                for (int i = 0; i < myStringArray.length; i++) {
                    if (myStringArray[i].contains(match)) {
                        newArray.add(myStringArray[i]);
                        n++;
                    }
                }
                String arrayString[] = new String[n];
                for (int i = 0; i < newArray.size(); i++) {
                    arrayString[i] = newArray.get(i);
                }
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayString);
                ListView listView = findViewById(R.id.listView);
                listView.setAdapter(adapter);

            }
        });
        /*editText.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        String match = ((TextView) findViewById(R.id.editText)).getText().toString();
                        ArrayList<String> newArray = new ArrayList<>();
                        int n = 0;
                        for (int i = 0; i < myStringArray.length; i++) {
                            if (myStringArray[i].contains(match)) {
                                newArray.add(myStringArray[i]);
                                n++;
                            }
                        }
                        String arrayString[] = new String[n];
                        for (int i = 0; i < newArray.size(); i++) {
                            arrayString[i] = newArray.get(i);
                        }
                        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayString);
                        ListView listView = findViewById(R.id.listView);
                        listView.setAdapter(adapter);
                        return true;
                    }

                    //new View.() {
            @Override
            public void onClick(View v) {
                String match=((TextView)findViewById(R.id.editText)).getText().toString();
                ArrayList<String> newArray=new ArrayList<>();
                int n=0;
                for(int i=0;i<myStringArray.length;i++){
                    if(myStringArray[i].contains(match)){
                        newArray.add(myStringArray[i]);
                        n++;
                    }
                }
                String arrayString[]=new String[n];
                for(int i=0;i<newArray.size();i++){
                    arrayString[i]=newArray.get(i);
                }
                adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrayString);
                ListView listView=findViewById(R.id.listView);
                listView.setAdapter(adapter);
            }


                });*/
    }
}
