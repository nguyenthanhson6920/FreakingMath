package com.example.freakingmath.View;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.freakingmath.R;

public class Ngonngu extends Activity {
    private Button tv, ta, back;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ngonngu);
        anhxa();


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialongtiengviet();
            }
        });
    }


    public void dialongtiengviet()
    {
        setContentView(R.layout.activity_ngonngu);
    }
    public void anhxa()
    {

        tv=(Button)findViewById(R.id.tv);

    }
}
