package com.example.lv2skrinjar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder> {
    private List<String> dataList = new ArrayList<>();
    private NameClickInterface clickInterface;
    private XClickInterface xClickListener;

    public RecyclerAdapter(NameClickInterface clickInterface, XClickInterface xClickInterface) {
        this.clickInterface = clickInterface;
        this.xClickListener = xClickInterface;
    }



    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);

        return new NameViewHolder(view, clickInterface, xClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int position) {
        nameViewHolder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<String> data){
        dataList= data;

        dataList.clear();
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void insertNewItem(String name, int position){

        if(position >= 0 && position <= dataList.size()){
            dataList.add(position, name);
            notifyItemInserted(position);
        }
    }

    public void removeItem(int position){
        if(position >= 0 && position < dataList.size()){
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
