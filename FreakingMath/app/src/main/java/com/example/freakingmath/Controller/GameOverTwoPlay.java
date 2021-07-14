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
import com.example.freakingmath.Model.twoplayers;

public class GameOverTwoPlay extends Activity {
    private Button back, mainmaenu, playgain;
    private TextView score, highscore;
    Database database;
    Intent it=null;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_over_two_play);
        anhxa();
            int diemcao=0;
            int scr1=it.getIntExtra("score1",0), scr2 = it.getIntExtra("score2",0);
            if(scr1 >= scr2)
            {
                if(scr1 > database.getScore(this,"Diemcao","2NC",1))
                {
                    database.setScore(this,"Diemcao","2NC","EASY",scr1);
                }
            }else if(scr2 > database.getScore(this,"Diemcao","2NC",1)){
                database.setScore(this,"Diemcao","2NC","EASY",scr2);
            }
            diemcao = database.getScore(this,"Diemcao","2NC",1);

        score.setText(String.valueOf(scr1) +" - " + String.valueOf(scr2)) ;
        highscore.setText(("High Score: " +String.valueOf(diemcao)));
        database.close();
        mainmaenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
                Intent intent = new Intent(GameOverTwoPlay.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
                Intent intent = new Intent(GameOverTwoPlay.this, Typeofplay.class);
                startActivity(intent);
            }
        });
        playgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
                Intent intent = new Intent(GameOverTwoPlay.this, twoplayers.class);
                startActivity(intent);
            }
        });
    }

    private void anhxa()
    {
        database = new Database(this,"",null,1);
        it = getIntent();
        back=(Button)findViewById(R.id.back);
        mainmaenu=(Button)findViewById(R.id.mainmenu);
        playgain=(Button)findViewById(R.id.TryAgain);
        score=(TextView)findViewById(R.id.scores);
        highscore = (TextView)findViewById(R.id.txtHighScore);
    }
}
