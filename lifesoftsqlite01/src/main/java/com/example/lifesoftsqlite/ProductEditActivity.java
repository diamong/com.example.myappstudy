package com.example.lifesoftsqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductEditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editProductName, editPrice, editAmount;
    Button btnUpdate, btnDelete;
    ProductDTO dto;
    ProductDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_edit);

        editProductName = findViewById(R.id.editProduct);
        editPrice = findViewById(R.id.editPrice);
        editAmount = findViewById(R.id.editAmount);

        btnUpdate=findViewById(R.id.btnEdit01);
        btnDelete=findViewById(R.id.btnDelete);

        dao = new ProductDAO(this);

        Intent intent = getIntent();
        dto = (ProductDTO) intent.getSerializableExtra("dto");
        editProductName.setText(dto.getProduct_name());
        editPrice.setText(Integer.toString(dto.getPrice()));
        editAmount.setText(Integer.toString(dto.getAmount()));

        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEdit01:
                String product_name=editProductName.getText().toString();
                int price =Integer.parseInt(editPrice.getText().toString());
                int amount = Integer.parseInt(editAmount.getText().toString());

                dto.setProduct_name(product_name);
                dto.setPrice(price);
                dto.setAmount(amount);
                dao.update(dto);

                Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.btnDelete:
                /*dao.delete(dto.getId());
                finish();*/

                new AlertDialog.Builder(this)
                        .setTitle("확인")
                        .setMessage("삭제")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dao.delete(dto.getId());
                                finish();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                break;

        }
    }
}
