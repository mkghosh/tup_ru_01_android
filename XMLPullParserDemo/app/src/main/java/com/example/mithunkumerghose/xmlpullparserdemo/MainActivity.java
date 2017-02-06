package com.example.mithunkumerghose.xmlpullparserdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> students = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParsingHandler handler = new ParsingHandler();

        try {
            InputStream is = getAssets().open("data.xml");
            students = handler.parse(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ListView listView = (ListView) findViewById(R.id.list_View);

        ArrayAdapter<Student> adapter =new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, students);
        listView.setAdapter(adapter);
    }
}
