package com.example.mytodo.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mytodo.MainActivity;
import com.example.mytodo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewActivity extends AppCompatActivity implements MessageAdapter.OnDetailsButtonClickListener {

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        mRecyclerView = findViewById(R.id.recycler_view);

        //set up layoutmanager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //set up adapter
        mRecyclerView.setAdapter(new MessageAdapter(createDataSource(), this));


    }

    private List<String> createDataSource() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add("new message:" + i);
        }

        return list;
    }

    @Override
    public void onDetailsButtonClick() {
        Intent intent = new Intent(RecyclerviewActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
