package com.example.freakingmath.Controller;

import android.app.*;
import android.content.Intent;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;

import com.example.freakingmath.R;
import com.example.freakingmath.Model.onePlayer;
import com.example.freakingmath.Model.playOnePlayer;

public class MucChoi1NC extends Activity {
    private Button back, de, kho, trungbinh;
    private Intent intent;
    private String pheptoan;
    int mucchoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_muc_choi);
        Anhxa();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MucChoi1NC.this, onePlayer.class));
            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MucChoi1NC.this, playOnePlayer.class);
                it.putExtra("mucchoi",10);
                it.putExtra("pheptoan",pheptoan);
                startActivity(it);
            }
        });
        trungbinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MucChoi1NC.this,playOnePlayer.class);
                it.putExtra("mucchoi",100);
                it.putExtra("pheptoan",pheptoan);
                startActivity(it);
            }
        });
        kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MucChoi1NC.this,playOnePlayer.class);
                it.putExtra("mucchoi", 1000);
                it.putExtra("pheptoan",pheptoan);
                startActivity(it);
            }
        });
    }
    void Anhxa()
    {
        back=(Button)findViewById(R.id.back);
        de=(Button)findViewById(R.id.easy);
        trungbinh=(Button)findViewById(R.id.normal);
        kho=(Button)findViewById(R.id.difficult);
        intent = getIntent();
        pheptoan = intent.getStringExtra("pheptoan");
    }
}
