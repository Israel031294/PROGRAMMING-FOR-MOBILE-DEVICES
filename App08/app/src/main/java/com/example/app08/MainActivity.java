package com.example.app08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app08.db.DBMessages;
import com.example.app08.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lst);
        List<Message> values = new ArrayList<>();
        // use the SimpleCursorAdapter to show the elements in a ListView
        ArrayAdapter<Message> adapter = new ArrayAdapter<Message>(this,
                android.R.layout.simple_list_item_1, values);
        ListView l = findViewById(R.id.lst);
        l.setAdapter(adapter);

        DBMessages.init(this);

        refreshListOfMessages();

        ImageButton ib =findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et  =findViewById(R.id.editText);
                Message m=new Message(et.getText().toString());
                et.setText("");
                DBMessages.saveMessage(m);

                MainActivity.this.refreshListOfMessages();

            }
        });
    }

    private void refreshListOfMessages() {

        ListView listView = findViewById(R.id.lst);
        ArrayAdapter<Message> adapter = (ArrayAdapter)listView.getAdapter();
        List<Message> messages= DBMessages.loadAllMessages();
        adapter.clear();
        adapter.addAll(messages);
        adapter.notifyDataSetChanged();
    }
}
