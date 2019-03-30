package com.example.listexam01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button01:
                intent = new Intent(this, ListDemo01.class);
                break;
            case R.id.button02:
                intent=new Intent(this,ListDemo2.class);
                break;
            case R.id.button03:
                intent=new Intent(this,ListXml.class);
                break;
            case R.id.button04:
                intent=new Intent(this,ListArray.class);
                break;
            case R.id.button05:
                intent=new Intent(this,PhoneBookActivity.class);
                break;
            case R.id.button06:
                intent=new Intent(this,SpinnerActivity.class);
                break;
            case R.id.button07:
                intent=new Intent(this,GridActivity.class);
                break;
            case R.id.button08:
                intent=new Intent(this,AutoActivity.class);
                break;
        }
        startActivity(intent);
    }
}
