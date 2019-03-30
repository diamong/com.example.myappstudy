package com.example.lifesoftsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductAddActivity extends AppCompatActivity {
    EditText editProductName,editPrice,editAmount;
    Button btnSave;
    ProductDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_add);

        editProductName=findViewById(R.id.editProduct);
        editPrice=findViewById(R.id.editPrice);
        editAmount=findViewById(R.id.editAmount);
        btnSave=findViewById(R.id.btnAdd);
        dao=new ProductDAO(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product_name=editProductName.getText().toString();

                if(editPrice.getText().toString().equals("")) editPrice.setText("0");
                int price=Integer.parseInt(editPrice.getText().toString());
                if(editAmount.getText().toString().equals("")) editAmount.setText("0");
                int amount= Integer.parseInt(editAmount.getText().toString());
                ProductDTO dto=new ProductDTO(product_name,price,amount);
                dao.insert(dto);

                Toast.makeText(ProductAddActivity.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
