package com.example.freakingmath.Model;

import android.app.*;
import android.content.Intent;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;

import com.example.freakingmath.R;

public class playTwoplayer extends Activity {
    private Button btnBack, btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play_twoplayer);
        btnBack=(Button)findViewById(R.id.back);
        btnStart=(Button)findViewById(R.id.playnow);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playTwoplayer.this, twoplayers.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playTwoplayer.this, Typeofplay.class));
            }
        });
    }
}
