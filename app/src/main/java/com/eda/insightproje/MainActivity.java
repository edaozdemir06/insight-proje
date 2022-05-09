package com.eda.insightproje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tanımlamalar
        TextView Kullaniciadi = (TextView) findViewById(R.id.kullaniciadi);
        TextView Sifre = (TextView) findViewById(R.id.sifre);
        MaterialButton Girisbtn = (MaterialButton) findViewById(R.id.girisbtn);
        CheckBox cbSifre = findViewById(R.id.cbsifre);
        //admin and admin

        Girisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Kullaniciadi.getText().toString().equals("admin") && Sifre.getText().toString().equals("admin")) {
                    //correct
                    Toast.makeText(MainActivity.this, "Giriş Doğru", Toast.LENGTH_SHORT).show();
                } else
                    //incorrect
                    Toast.makeText(MainActivity.this, "Giriş Hatalı", Toast.LENGTH_SHORT).show();

                //Sayfa değiştirme

                Intent AnaMenu=new Intent(MainActivity.this,AnaMenu.class);
                startActivity(AnaMenu);
            }

        });
        cbSifre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //
                if (!isChecked) {
                    Sifre.setTransformationMethod(PasswordTransformationMethod.getInstance());

                } else {
                    Sifre.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });
    }
}