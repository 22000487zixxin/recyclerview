package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    MyListAdapter adapter;
    RecyclerView recyclerView;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        data.add("Mango");
        data.add("Strawberry");
        data.add("Watermelon");

        adapter = new MyListAdapter(this, data);
        recyclerView = findViewById(R.id.fruitList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        edit = findViewById(R.id.editFruit);
    }

    public void onAdd(View view){
        String newName = edit.getText().toString();
        data.add(newName);
        adapter.notifyDataSetChanged();
    }
}