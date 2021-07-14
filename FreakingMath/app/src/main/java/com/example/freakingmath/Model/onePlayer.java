package com.example.freakingmath.Model;


import android.app.*;
import android.content.Intent;
import android.view.*;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freakingmath.Controller.MucChoi1NC;
import com.example.freakingmath.R;

public class onePlayer extends Activity {
    private TextView back;
    private LinearLayout phepcong, pheptru,phepnhan,phepchia,phepall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_one_player);
        anhxa();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(onePlayer.this, Typeofplay.class));
            }
        });
        phepcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onePlayer.this, MucChoi1NC.class);
                intent.putExtra("pheptoan","phepcong");
                startActivity(intent);
            }
        });
        pheptru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onePlayer.this,MucChoi1NC.class);
                intent.putExtra("pheptoan","pheptru");
                startActivity(intent);
            }
        });
        phepnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onePlayer.this,MucChoi1NC.class);
                intent.putExtra("pheptoan","phepnhan");
                startActivity(intent);
            }
        });
        phepchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onePlayer.this,MucChoi1NC.class);
                intent.putExtra("pheptoan","phepchia");
                startActivity(intent);
            }
        });
        phepall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onePlayer.this,MucChoi1NC.class);
                intent.putExtra("pheptoan","all");
                startActivity(intent);
            }
        });
    }
    private void anhxa()
    {
        back=(TextView) findViewById(R.id.back);
        phepcong=(LinearLayout)findViewById(R.id.Phepcong);
        pheptru=(LinearLayout)findViewById(R.id.Pheptru);
        phepnhan=(LinearLayout)findViewById(R.id.Phepnhan);
        phepchia=(LinearLayout)findViewById(R.id.Phepchia);
        phepall=(LinearLayout)findViewById(R.id.Phepall);
    }
}
