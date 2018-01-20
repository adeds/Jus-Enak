package com.noes.adeyds.ujicepat;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private TextView quantity, harga;
private EditText nama ;
private Button order, plus, minus;
private CheckBox wCream, choco;

private int qty,satuan;
private String totalBayar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity=findViewById(R.id.tv_qty);
        harga=findViewById(R.id.tv_harga);
        nama=findViewById(R.id.nama);
        order=findViewById(R.id.btn_order);
        plus=findViewById(R.id.btn_plus);
        minus=findViewById(R.id.btn_minus);
        wCream=findViewById(R.id.cb_wCream);
        choco= findViewById(R.id.cb_choco);


        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        order.setOnClickListener(this);

    }

    private void hitung(){
        satuan=10000;
        if (wCream.isChecked()) satuan+=3000;
        if (choco.isChecked())  satuan+=2000;
        totalBayar="Rp. "+String.valueOf(satuan*qty);
        quantity.setText(String.valueOf(qty));
        harga.setText(totalBayar);
    }



    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(nama.getText().toString().trim())){
            Toast.makeText(this, "Masukkan nama dahulu", Toast.LENGTH_SHORT).show();
        }else{
        int id=v.getId();

        switch (id) {
            case R.id.btn_plus:

                qty += 1;
                hitung();
                break;

            case R.id.btn_minus:
                if (qty != 0) {
                    qty -= 1;
                    hitung();
                }
                break;

            case R.id.btn_order:
                hitung();
                Toast.makeText(this, "Pesanan " + nama.getText() + " seharga " + totalBayar

                        , Toast.LENGTH_SHORT).show();


                break;
        }
        }
    }


}
