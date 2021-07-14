package com.example.freakingmath.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.Button;

import com.example.freakingmath.Controller.MainActivity;
import com.example.freakingmath.R;

public class Setting extends Activity {
    private Button amluong, ngonngu, hinhnen, back;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_setting);
        anhxa();

        amluong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Amluong.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, MainActivity.class);
                startActivity(intent);
            }
        });
        hinhnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, Hinhnen.class);
                startActivity(intent);
            }
        });
        ngonngu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialongngonngu();
            }
        });
    }


    public void dialongngonngu()
    {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_ngonngu);
        dialog.show();
    }
    public void anhxa()
    {
        amluong=(Button)findViewById(R.id.amluong);
        ngonngu=(Button)findViewById(R.id.ngonngu);
        hinhnen=(Button)findViewById(R.id.hinhnen);
        back =(Button)findViewById(R.id.back);
    }
}
