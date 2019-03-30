package com.example.listexam01;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookActivity extends AppCompatActivity {

    TextView txtResult;
    ListView list;
    List<PhoneBookDTO> items;
    Uri number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_demo2);

        txtResult = findViewById(R.id.txtResult);
        list = findViewById(R.id.list2);

        items = new ArrayList<>();
        items.add(new PhoneBookDTO("김태현", "010-5627-6737"));

        MyAdapter adapter = new MyAdapter(this, R.layout.phonebook, items);
        list.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<PhoneBookDTO> {

        public MyAdapter(Context context, int resource, List<PhoneBookDTO> objects) {
            super(context, resource, objects);


        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = getLayoutInflater();
                v = inflater.inflate(R.layout.phonebook, null);
            }
            final PhoneBookDTO dto = items.get(position);
            TextView txtName = v.findViewById(R.id.txtName);
            TextView txtTel = v.findViewById(R.id.txtTel);
            txtName.setText(dto.getName());
            txtTel.setText(dto.getTel());

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    number = Uri.parse(dto.getTel());
                    check();

                }
            });
            return v;
        }


    }

    void check() {
        int check = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (check != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    check();
                }
                break;
        }
    }
}
