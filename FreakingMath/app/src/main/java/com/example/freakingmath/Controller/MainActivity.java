package com.example.freakingmath.Controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.freakingmath.DataBase.Database;
import com.example.freakingmath.R;
import com.example.freakingmath.Model.Typeofplay;
import com.example.freakingmath.View.HighScore;

public class MainActivity extends Activity {
    private Button btntacgia, choingay, setting, highscore;
    private MediaPlayer media;
    private Database database;
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
        setContentView(R.layout.activity_main);
        anhxa();
        database.Create(this);
        media=MediaPlayer.create(MainActivity.this, R.raw.startgame);
        media.setLooping(true);
        media.start();
        btntacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.stop();
                Tacgia();

            }
        });
        choingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.stop();
                Intent intent = new Intent(MainActivity.this, Typeofplay.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialongsetting();
            }
        });
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.stop();
                startActivity(new Intent(MainActivity.this, HighScore.class) );
            }
        });
    }
    public void Tacgia()
    {
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.dialog_tacgia);
        dialog.show();
    }
    public void dialongsetting()
    {
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.activity_amluong);
        dialog.show();
    }

    public void anhxa()
    {
        database =  new Database(this,"",null,1);
        btntacgia=(Button)findViewById(R.id.tacgia);
        choingay=(Button)findViewById(R.id.choingay);
        setting=(Button)findViewById(R.id.setting);
        highscore =(Button)findViewById(R.id.highscore);
    }
}
