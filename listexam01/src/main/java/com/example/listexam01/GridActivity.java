package com.example.listexam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {
    TextView txtResult;
    GridView gridView01;
    String[] items={"사과","포도","귤","자몽","오렌지","한라봉","감",
            "사과","포도","귤","자몽","오렌지","한라봉","감",
            "사과","포도","귤","자몽","오렌지","한라봉","감"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        txtResult=findViewById(R.id.textView);
        gridView01=findViewById(R.id.grid01);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        gridView01.setAdapter(adapter);

        gridView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items[position]);
            }
        });
    }
}
