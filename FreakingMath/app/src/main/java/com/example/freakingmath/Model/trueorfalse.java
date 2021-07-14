package com.example.freakingmath.Model;

import android.app.*;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.*;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.freakingmath.Controller.GameOver;
import com.example.freakingmath.R;

import java.util.Random;

public class trueorfalse extends Activity {
    private CountDownTimer cTimer = null;
    private TextView txt;
    private LinearLayout btntrue, btnfalse;
    private SeekBar seekBar;
    private int tg=39;
    private int number1, number2, result;
    private boolean check;
    private int mucchoi;
    private int score=0;
    private TextView sc;
    private MediaPlayer media;
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
        setContentView(R.layout.activity_trueorfalse);
        Intent intent = getIntent();
        mucchoi = intent.getIntExtra("mucchoi", 0);
        anhxa();
        GenerateRandomQuestions();
        startTimer();
        btntrue.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(check==true)
                {
                    score++;
                    sc.setText("Scores: "+String.valueOf(score));
                    media=MediaPlayer.create(trueorfalse.this,R.raw.quaman);
                    media.start();
                    GenerateRandomQuestions();
                    tg=39; cTimer.cancel();
                    startTimer();
                }else Thuagame();
            }
        });
        btnfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==false)
                {
                    score++;
                    sc.setText("Scores: "+String.valueOf(score));
                    media=MediaPlayer.create(trueorfalse.this,R.raw.quaman);
                    media.start();
                    GenerateRandomQuestions();
                    tg=39; cTimer.cancel();
                    startTimer();
                }else Thuagame();
            }
        });
    }
    private void Thuagame()
    {
        media=MediaPlayer.create(trueorfalse.this,R.raw.thuacuoc);
        media.start();
        cTimer.cancel();
        onDestroy();
        Intent it = new Intent(trueorfalse.this, GameOver.class);
        it.putExtra("playagain",1);
        it.putExtra("mucchoi",mucchoi);
        it.putExtra("score", score);
        startActivity(it);
    }
    public  void startTimer() {
        cTimer = new CountDownTimer(4000, 100) {
            public void onTick(long millisUntilFinished) {
                tg--;
                seekBar.setProgress(tg);
            }
            public void onFinish() {
                media=MediaPlayer.create(trueorfalse.this,R.raw.thuacuoc);
                media.start();
                onDestroy();
                Intent it = new Intent(trueorfalse.this, GameOver.class);
                it.putExtra("playagain",1);
                it.putExtra("mucchoi",mucchoi);
                it.putExtra("score", score);
                startActivity(it);
            }
        };
        cTimer.start();
    }

    public void GenerateRandomQuestions()
    {
        Random random = new Random();
        int rd = random.nextInt(2);
        number1 = random.nextInt(mucchoi);
        number2 = random.nextInt(mucchoi);
        if(rd==0)
        {
            check=false;
            rd = random.nextInt(2);
            if(rd==0)
            {
                result=number1+number2+random.nextInt((number1+number2)/2) +1;
                txt.setText(number1+" + "+number2+" = "+result);
            }else{
                result=number1-number2+random.nextInt((number1+number2)/2) +1;
                txt.setText(number1+" - "+number2+" = "+result);
            }
        }else{
            while(number1 <= number2) number2 = random.nextInt(mucchoi);
            check=true;
            rd = random.nextInt(2);
            if(rd==0)
            {
                result=number1+number2;
                txt.setText(number1+" + "+number2+" = "+result);
            }else{
                result=number1-number2;
                txt.setText(number1+" - "+number2+" = "+result);
            }
        }
    }
    private void anhxa(){
        txt=(TextView)findViewById(R.id.txt);
        btnfalse=(LinearLayout)findViewById(R.id.btnFalse);
        btntrue=(LinearLayout)findViewById(R.id.btntrue);
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        sc=(TextView)findViewById(R.id.sorce);
    }
}
