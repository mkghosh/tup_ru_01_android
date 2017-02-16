package com.example.mithunkumerghose.startingmaterialdesign.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mithunkumerghose.startingmaterialdesign.R;
import com.example.mithunkumerghose.startingmaterialdesign.adaptor.RecyclerAdaptorCustomized;
import com.example.mithunkumerghose.startingmaterialdesign.model.StudentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<StudentModel> studentModels = new ArrayList<>();
        for (int i = 0; i < 100; i++ ) {
            StudentModel stModel = new StudentModel("St Name " + i, "St ID : " + i, "TUP-RU-01");
            studentModels.add(stModel);
        }

        RecyclerAdaptorCustomized adaptorCustomized = new RecyclerAdaptorCustomized(studentModels);

        getRecyclerView().setLayoutManager( new LinearLayoutManager(this));
        getRecyclerView().setAdapter(adaptorCustomized);

    }

    private RecyclerView getRecyclerView() {
        return (RecyclerView) findViewById(R.id.myRecyclerView);
    }
}
