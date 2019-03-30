package com.example.listexam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListDemo2 extends AppCompatActivity {

    TextView txtResult;
    ListView listView;
    String[] items = {"TV", "냉장고", "세탁기", "장농", "컴퓨터", "셋톱"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_demo2);

        txtResult = findViewById(R.id.txtResult);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items[position]);
            }
        });
    }




}
