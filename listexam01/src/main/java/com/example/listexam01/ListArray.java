package com.example.listexam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListArray extends AppCompatActivity {

    ListView list;
    EditText edit1;
    Button button1;

    List<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_array);

        list=findViewById(R.id.list);
        edit1=findViewById(R.id.edit1);
        button1=findViewById(R.id.button1);

        items=new ArrayList<>();
        items.add("사과");
        items.add("토마토");
        items.add("딸기");
        items.add("쥬스");
        items.add("망고");
        items.add("오렌지");

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        list.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=edit1.getText().toString();
                items.add(str);
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                items.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }
}
