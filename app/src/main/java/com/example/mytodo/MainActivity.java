package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    private ListView mListView;

    private ListViewAdapter mListViewAdapter;

    private List<String> mMessagesList;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessagesList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            mMessagesList.add("Message:" + i);
        }
        mListViewAdapter = new ListViewAdapter(mMessagesList);

        mListView = findViewById(R.id.list_view);

        View headerView = LayoutInflater.from(MainActivity.this).inflate(R.layout.header_view, mListView, false);
        mListView.setAdapter(mListViewAdapter);

        mListView.addHeaderView(headerView);
        mListView.addFooterView(headerView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Timber.d( parent.getItemAtPosition(position).toString());
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        Timber.d("SCROLL_STATE_IDLE");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        Timber.d("SCROLL_STATE_TOUCH_SCROLL");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        Timber.d("SCROLL_STATE_FLING");
                        break;

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    Toast.makeText(MainActivity.this, "Add new data", Toast.LENGTH_LONG).show();
                    for (int i = 0; i < 50; i++) {
                        mMessagesList.add("Message:" + i);
                    }
                    mListViewAdapter.notifyDataSetChanged();

                }
            }
        });

    }
}
