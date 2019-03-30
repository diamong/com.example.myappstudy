package com.example.listexam01;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListDemo01 extends ListActivity {

    TextView txtResult;
    String[]items={"사과","포도","레몬","딸기","오렌지","배"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.list_demo01);

        txtResult=findViewById(R.id.txtResult);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.i("Test","Position: "+ position);
        txtResult.setText("좋아하는 과일은: "+items[position]);
    }
}
