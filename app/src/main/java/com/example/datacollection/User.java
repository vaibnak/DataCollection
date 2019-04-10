package com.example.datacollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class User extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private UserproposallistAdapter exampleAdapter;
    private LinearLayout linearLayout;
    private RecyclerView.LayoutManager mLayoutManager;
    private UserproposallistAdapter mAdapter;
    ArrayList<Userproposals> exampleList = new ArrayList<>();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.more){
            Intent intent = new Intent(getApplicationContext(), proposal.class);
            startActivity(intent);
            return true;

        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        linearLayout = findViewById(R.id.layout);
//        createExampleList();
        buildRecyclerView();
    }

    private void createExampleList() {
        Userproposals a = new Userproposals("Agriculture", "28-04-19");
        Userproposals b = new Userproposals("Technology", "28-03-19");
        exampleList.add(a);
        exampleList.add(b);

        mAdapter.notifyDataSetChanged();
    }
    private void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new UserproposallistAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        createExampleList();
    }
}
