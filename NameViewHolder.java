package com.example.lv2skrinjar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private NameClickInterface clickInterface;
    private ImageView ivRemoveX;

    private XClickInterface xClickListener;

    public NameViewHolder(@NonNull View itemView, NameClickInterface nameClickInterface, XClickInterface xClickInterface) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        ivRemoveX = itemView.findViewById(R.id.ivRemoveX);
        clickInterface = nameClickInterface;
        this.xClickListener = xClickInterface;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.onNameClicked();
            }
        });

        ivRemoveX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xClickListener.onXClicked(getAdapterPosition());
            }
        });
    }

    public void setName(String name){
        tvName.setText(name);
    }

}
