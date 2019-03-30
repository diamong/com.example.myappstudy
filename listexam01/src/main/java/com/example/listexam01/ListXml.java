package com.example.listexam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ListXml extends AppCompatActivity {
    TextView txtResult;
    ListView list;
    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_demo2);

        txtResult=findViewById(R.id.txtResult);
        list=findViewById(R.id.list);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.fruit,
                android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        items= Arrays.asList(getResources().getStringArray(R.array.fruit));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items.get(position));
            }
        });
    }
}
