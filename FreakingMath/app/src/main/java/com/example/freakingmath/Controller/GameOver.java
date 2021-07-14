package com.example.freakingmath.Controller;

import android.app.*;
import android.content.Intent;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.freakingmath.DataBase.Database;
import com.example.freakingmath.R;
import com.example.freakingmath.Model.Typeofplay;
import com.example.freakingmath.Model.onePlayer;
import com.example.freakingmath.Model.playOnePlayer;
import com.example.freakingmath.Model.trueorfalse;

public class GameOver extends Activity {
    private Button back, mainmaenu, playgain;
    private int chuyentumanhinh=0, mucchoi, diemcao;
    private TextView score, highscore;
    private TextView lever;
    Database database;
    String pheptoan = new String();
    Intent it;
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
        setContentView(R.layout.activity_game_over);
        anhxa();
        chuyentumanhinh = it.getIntExtra("playagain",0);
        mucchoi=it.getIntExtra("mucchoi",0);
        if(chuyentumanhinh==2) pheptoan = it.getStringExtra("pheptoan");
        database = new Database(this,"",null,1);
        if(chuyentumanhinh==1) {
            trueorFalse();
        }else if(chuyentumanhinh==2) onePlayer();
       score.setText("Score: "+String.valueOf(it.getIntExtra("score",0)));
        highscore.setText(("High Score: " +String.valueOf(diemcao)));
        database.close();

        mainmaenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onDestroy();
                Intent intent = new Intent(GameOver.this, Typeofplay.class);
                finish();
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
                Intent intent = new Intent();
                if(chuyentumanhinh == 1)  intent = new Intent(GameOver.this, MucChoiToF.class);
                else if(chuyentumanhinh == 2)  intent = new Intent(GameOver.this, onePlayer.class);
                startActivity(intent);
            }
        });
        playgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
                Intent intent = new Intent();
                if(chuyentumanhinh == 1){
                    intent = new Intent(GameOver.this, trueorfalse.class);
                    intent.putExtra("mucchoi",mucchoi);
                }
                else if(chuyentumanhinh == 2){
                    intent = new Intent(GameOver.this, playOnePlayer.class);
                    intent.putExtra("mucchoi",mucchoi);
                    intent.putExtra("pheptoan",pheptoan);
                }
                startActivity(intent);
            }
        });

    }

    public void trueorFalse()
    {
        if(mucchoi==10) {
            if(it.getIntExtra("score",0) > database.getScore(this,"Diemcao","TOF",1))
            {
                database.setScore(this,"Diemcao","TOF","EASY",it.getIntExtra("score",0));
            }
            diemcao = database.getScore(this,"Diemcao","TOF",1);
            lever.setText("Mức độ dễ");
        }else if(mucchoi==100) {
            if(it.getIntExtra("score",0) > database.getScore(this,"Diemcao","TOF",2))
            {
                database.setScore(this,"Diemcao","TOF","TRUNGBINH",it.getIntExtra("score",0));
            }
            diemcao = database.getScore(this,"Diemcao","TOF",2);
            lever.setText("Mức trung bình");
        } else {
            if(it.getIntExtra("score",0) > database.getScore(this,"Diemcao","TOF",3))
            {
                database.setScore(this,"Diemcao","TOF","KHO",it.getIntExtra("score",0));
            }
            diemcao = database.getScore(this,"Diemcao","TOF",3);
            lever.setText("Mức độ khó");
        }
    }

    public void onePlayer()
    {
        if(mucchoi==10) {
            if(it.getIntExtra("score",0) > database.getScore(this,"Diemcao",pheptoan,1))
            {
                database.setScore(this,"Diemcao",pheptoan,"EASY",it.getIntExtra("score",0));
            }
            diemcao = database.getScore(this,"Diemcao",pheptoan,1);
            lever.setText("Mức độ dễ");
        }else if(mucchoi==100) {

            if(it.getIntExtra("score",0) > database.getScore(this,"Diemcao",pheptoan,2))
            {
                database.setScore(this,"Diemcao",pheptoan,"TRUNGBINH",it.getIntExtra("score",0));
            }
            diemcao = database.getScore(this,"Diemcao",pheptoan,2);
            lever.setText("Mức trung bình");
        } else {
            if(it.getIntExtra("score",0) > database.getScore(this,"Diemcao",pheptoan,3))
            {
                database.setScore(this,"Diemcao",pheptoan,"KHO",it.getIntExtra("score",0));
            }
            diemcao = database.getScore(this,"Diemcao",pheptoan,3);
            lever.setText("Mức độ khó");
        }
    }
    private void anhxa()
    {
        it = getIntent();
        back=(Button)findViewById(R.id.back);
        mainmaenu=(Button)findViewById(R.id.mainmenu);
        playgain=(Button)findViewById(R.id.TryAgain);
        score=(TextView)findViewById(R.id.txtScore);
        highscore = (TextView)findViewById(R.id.txtHighScore);
        lever=(TextView)findViewById(R.id.lever);
    }
}
