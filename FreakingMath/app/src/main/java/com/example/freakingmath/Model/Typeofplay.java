package com.example.freakingmath.Model;

import android.content.Intent;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.Button;

import com.example.freakingmath.Controller.MainActivity;
import com.example.freakingmath.Controller.MucChoiToF;
import com.example.freakingmath.R;

public class Typeofplay extends Activity {
    private Button trueorfalse, back, twoplayer, onePlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_typeofplay);
        anhxa();
        trueorfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Typeofplay.this, MucChoiToF.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Typeofplay.this, MainActivity.class);
                startActivity(intent);
            }
        });
        twoplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Typeofplay.this, playTwoplayer.class));
            }
        });
        onePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Typeofplay.this, onePlayer.class));
            }
        });
    }
    public void anhxa()
    {
        onePlay=(Button)findViewById(R.id.onePlay);
        trueorfalse=(Button)findViewById(R.id.trueorfalse);
        back=(Button)findViewById(R.id.back);
        twoplayer=(Button)findViewById(R.id.twoplayers);
    }
}
