package com.example.listexam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    TextView txtResult;
    Spinner spinner01;
    String[] arr={"포도","사과","배"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        txtResult=findViewById(R.id.txtResult);
        spinner01=findViewById(R.id.spinner01);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arr);
        spinner01.setAdapter(adapter);

        spinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(arr[position]);
                Toast.makeText(SpinnerActivity.this, arr[position]+"이 선택되었지", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
