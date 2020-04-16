package com.example.app06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app06.model.Planet;
import com.example.app06.model.PlanetListAdapter;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Planet> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li= new LinkedList<>();
        li.add(new Planet("Earth",2,3));
        li.add(new Planet("Jupiter",22,32));
        li.add(new Planet("Venus",22,32));
        ListView l=findViewById(R.id.listv);

        //ArrayAdapter<Planet> aa=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,li);
        PlanetListAdapter adapter=new PlanetListAdapter(this,li);

        l.setAdapter(adapter);

    }


}
