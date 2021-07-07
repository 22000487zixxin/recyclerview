package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> {
    Context context;
    ArrayList<String> data;

    MyListAdapter(Context context, ArrayList<String> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, null);

        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyListViewHolder holder, int position) {
        holder.text.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textTitle);
            text.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            text.setText("Clicked - "+text.getText().toString());
        }
    }
}