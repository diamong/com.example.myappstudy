package com.example.lifesoftsqlite;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    Button btnAdd;
    ListView list;
    ProductDAO dao;
    List<ProductDTO> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        btnAdd = findViewById(R.id.btnAdd);
        list = findViewById(R.id.listview);
        dao = new ProductDAO(this);
        /*SQLiteDatabase db=dao.dbConn();
        Toast.makeText(this, "db가 생성되었습니다.", Toast.LENGTH_SHORT).show();
        db.close();*/

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductActivity.this,ProductAddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        items = dao.list();

        MyAdapter adapter = new MyAdapter(this, R.layout.product_row, items);
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<ProductDTO> {
        public MyAdapter(Context context, int resource, List<ProductDTO> objects) {
            super(context, resource, objects);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = getLayoutInflater();
                v = inflater.inflate(R.layout.product_row, null);
            }
            final ProductDTO dto = items.get(position);
            TextView txtProductName = v.findViewById(R.id.textProductName);
            TextView txtPrice = v.findViewById(R.id.textPrice);
            TextView txtAmount = v.findViewById(R.id.textAmount);

            txtProductName.setText(dto.getProduct_name());
            txtPrice.setText("가격: " + dto.getPrice());
            txtAmount.setText("수량: " + dto.getAmount());

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ProductActivity.this,ProductEditActivity.class);

                    intent.putExtra("dto",dto);
                    startActivity(intent);
                }
            });

            return v;
        }
    }
}
