package com.example.lv2skrinjar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements NameClickInterface, XClickInterface {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private EditText etEnterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> data = new ArrayList<>();


        etEnterName = findViewById(R.id.etEnterName);
        recyclerView = findViewById(R.id.recyclerView); 
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); 

        adapter = new RecyclerAdapter(this, this);
        recyclerView.setAdapter(adapter);
        adapter.addData(data);
    }

    public void onBtnAddClicked(View view) {
        if(!etEnterName.getText().toString().equals("") && etEnterName.getText().toString().trim().length() > 0) {
            adapter.insertNewItem(etEnterName.getText().toString(), adapter.getItemCount());
            etEnterName.setText("");
        }
    }

    @Override
    public void onNameClicked() {
        String[] array = new String[]{"Prisutan", "Nazočan!", "Tu sam!", "E'o me!"};
        Random random = new Random();
        int n = random.nextInt(array.length);

        Toast.makeText(this, array[n], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onXClicked(int position) {
        adapter.removeItem(position);
    }
}