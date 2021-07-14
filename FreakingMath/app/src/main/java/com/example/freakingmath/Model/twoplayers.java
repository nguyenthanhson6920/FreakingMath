package com.example.freakingmath.Model;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.*;
import android.app.*;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.freakingmath.Controller.GameOverTwoPlay;
import com.example.freakingmath.R;

import java.util.Random;

public class twoplayers extends Activity {
    private Button btnPlayer1a, btnPlayer1b, btnPlayer1c, btnPlayer1d;
    private Button btnPlayer2a, btnPlayer2b, btnPlayer2c, btnPlayer2d;
    TextView questionPlayer1, questionPlayer2, scoresPlayer1, scoresPlayer2;
    SeekBar seekBarPlayer1, seekBarPlayer2;
    private CountDownTimer cTimer1 = null;
    private MediaPlayer media;
    private int tg1=39, tg2=39;
    private boolean isOver1 = false, isOver2=false;
    int dapandung=0, dapandung1=0, scores1=0, scores2=0;
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
        setContentView(R.layout.activity_twoplayers);
        anhxa();
        startTimer1();
        RandomPlayer1();
        RandomPlayer2();
        btnPlayer1();
        btnPlayer2();
    }


    public void startTimer1() {
        cTimer1 = new CountDownTimer(4100, 100) {
            public void onTick(long millisUntilFinished) {
                seekBarPlayer1.setProgress(tg1);
                seekBarPlayer2.setProgress(tg2);
                if(tg1==0){
                    isOver1=true;questionPlayer1.setText("GAME OVER");
                }else tg1--;
                if(tg2==0) {
                    isOver2=true;questionPlayer2.setText("GAME OVER");
                }else tg2--;
            }
            public void onFinish() {
                thuaman();
            }
        };
        cTimer1.start();
    }
    public void quaman()
    {
        media= MediaPlayer.create(twoplayers.this,R.raw.quaman);
        media.start();
    }
    public void thuaman()
    {
        media= MediaPlayer.create(twoplayers.this,R.raw.thuacuoc);
        media.start();
        onDestroy();
        Intent it = new Intent(twoplayers.this, GameOverTwoPlay.class);
        it.putExtra("score1", scores1);
        it.putExtra("score2",scores2);
        startActivity(it);
    }
    public void btnPlayer2()
    {

        btnPlayer2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver2==false)
                {
                    if(dapandung!=1){
                        isOver2=true; RandomPlayer2(); tg2=0;questionPlayer2.setText("GAME OVER");
                    }
                    else {
                        quaman();
                        cTimer1.cancel(); tg2=39;startTimer1();RandomPlayer2();
                        scores2++; scoresPlayer2.setText("Scores: "+String.valueOf(scores2));
                    }
                }
            }
        });
        btnPlayer2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver2==false)
                {
                    if(dapandung!=2){
                        isOver2=true; RandomPlayer2(); tg2=0;questionPlayer2.setText("GAME OVER");
                    }
                    else {
                        quaman();
                        cTimer1.cancel(); tg2=39;startTimer1();RandomPlayer2();
                        scores2++; scoresPlayer2.setText("Scores: "+String.valueOf(scores2));
                    }
                }
            }
        });
        btnPlayer2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver2==false)
                {
                    if(dapandung!=3){
                        isOver2=true; RandomPlayer2(); tg2=0;questionPlayer2.setText("GAME OVER");
                    }
                    else {
                        quaman();
                        cTimer1.cancel(); tg2=39;startTimer1();RandomPlayer2();
                        scores2++; scoresPlayer2.setText("Scores: "+String.valueOf(scores2));
                    }
                }
            }
        });
        btnPlayer2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver2==false)
                {
                    if(dapandung!=4){
                        isOver2=true; tg2=0; RandomPlayer2(); questionPlayer2.setText("GAME OVER");
                    }
                    else{
                        quaman();
                        scores2++; scoresPlayer2.setText("Scores: "+String.valueOf(scores2));
                        cTimer1.cancel(); tg2=39;startTimer1();RandomPlayer2();
                    }
                }
            }
        });
    }
    public void btnPlayer1()
    {
        btnPlayer1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver1==false)
                {
                    if(dapandung1!=1){
                        isOver1=true;tg1=0;questionPlayer1.setText("GAME OVER");
                    }
                    else{
                        quaman();
                        scores1++; scoresPlayer1.setText("Scores: "+String.valueOf(scores1));
                        cTimer1.cancel(); tg1=39;startTimer1();RandomPlayer1();
                    }
                }
            }
        });
        btnPlayer1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver1==false)
                {
                    if(dapandung1!=2){
                        isOver1=true;tg1=0;questionPlayer1.setText("GAME OVER");
                    }
                    else{
                        quaman();
                        scores1++; scoresPlayer1.setText("Scores: "+String.valueOf(scores1));
                        cTimer1.cancel(); tg1=39;startTimer1();RandomPlayer1();
                    }
                }
            }
        });
        btnPlayer1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver1==false)
                {
                    if(dapandung1!=3){
                        isOver1=true;tg1=0;questionPlayer1.setText("GAME OVER");
                    }
                    else{
                        quaman();
                        scores1++; scoresPlayer1.setText("Scores: "+String.valueOf(scores1));
                        cTimer1.cancel(); tg1=39;startTimer1();RandomPlayer1();
                    }
                }
            }
        });
        btnPlayer1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOver1==false)
                {
                    if(dapandung1!=4){
                        isOver1=true;tg1=0;questionPlayer1.setText("GAME OVER");
                    }
                    else{
                        quaman();
                        scores1++; scoresPlayer1.setText("Scores: "+String.valueOf(scores1));
                        cTimer1.cancel(); tg1=39;startTimer1();RandomPlayer1();
                    }
                }
            }
        });
    }
    public void RandomPlayer2()
    {
        Random random = new Random();
        int a,b,c;
        int operations=random.nextInt(4)+1;
        if(operations==1){
            dapandung = random.nextInt(4)+1;
            a=random.nextInt(20); b=random.nextInt(20);
            questionPlayer2.setText(String.valueOf(a)+" + "+String.valueOf(b)+" = ?");
            c=a+b;
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt(Math.max(a,b))+Math.min(a,b);
                if(arr[i]==c) i--;
            }
            btnPlayer2a.setText(String.valueOf(arr[0]));
            btnPlayer2b.setText(String.valueOf(arr[1]));
            btnPlayer2c.setText(String.valueOf(arr[2]));
            btnPlayer2d.setText(String.valueOf(arr[3]));
            if(dapandung==1) btnPlayer2a.setText(String.valueOf(c));
            else if(dapandung==2) btnPlayer2b.setText(String.valueOf(c));
            else if(dapandung==3) btnPlayer2c.setText(String.valueOf(c));
            else if(dapandung==4) btnPlayer2d.setText(String.valueOf(c));
        }else if(operations==2)
        {
            dapandung = random.nextInt(4)+1;
            a=random.nextInt(30);
            do{
                b=random.nextInt(20);
            }while (a<b);
            questionPlayer2.setText(String.valueOf(a)+" - "+String.valueOf(b)+" = ?");
            c=a-b;
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt(Math.max(a,b)-Math.min(a,b))+Math.min(a,b);
                if(arr[i]==c) i--;
            }
            btnPlayer2a.setText(String.valueOf(arr[0]));
            btnPlayer2b.setText(String.valueOf(arr[1]));
            btnPlayer2c.setText(String.valueOf(arr[2]));
            btnPlayer2d.setText(String.valueOf(arr[3]));
            if(dapandung==1) btnPlayer2a.setText(String.valueOf(c));
            else if(dapandung==2) btnPlayer2b.setText(String.valueOf(c));
            else if(dapandung==3) btnPlayer2c.setText(String.valueOf(c));
            else if(dapandung==4) btnPlayer2d.setText(String.valueOf(c));
        }else if(operations==3)
        {
            dapandung = random.nextInt(4)+1;
            a=random.nextInt(11);
                b=random.nextInt(11);
            questionPlayer2.setText(String.valueOf(a)+" x "+String.valueOf(b)+" = ?");
            c=a*b;
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt((Math.max(a,b)*Math.max(a,b)) - (Math.min(a,b)*Math.min(a,b))) + (Math.min(a,b)*Math.min(a,b));
                if(arr[i]==c) i--;
            }
            btnPlayer2a.setText(String.valueOf(arr[0]));
            btnPlayer2b.setText(String.valueOf(arr[1]));
            btnPlayer2c.setText(String.valueOf(arr[2]));
            btnPlayer2d.setText(String.valueOf(arr[3]));
            if(dapandung==1) btnPlayer2a.setText(String.valueOf(c));
            else if(dapandung==2) btnPlayer2b.setText(String.valueOf(c));
            else if(dapandung==3) btnPlayer2c.setText(String.valueOf(c));
            else if(dapandung==4) btnPlayer2d.setText(String.valueOf(c));
        }else if(operations==4)
        {
            dapandung = random.nextInt(4)+1;
            b=random.nextInt(11);
            c=random.nextInt(11);
            a=c*b;
            questionPlayer2.setText(String.valueOf(a)+" / "+String.valueOf(b)+" = ?");
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt(11)+1;
                if(arr[i]==c) i--;
            }
            btnPlayer2a.setText(String.valueOf(arr[0]));
            btnPlayer2b.setText(String.valueOf(arr[1]));
            btnPlayer2c.setText(String.valueOf(arr[2]));
            btnPlayer2d.setText(String.valueOf(arr[3]));
            if(dapandung==1) btnPlayer2a.setText(String.valueOf(c));
            else if(dapandung==2) btnPlayer2b.setText(String.valueOf(c));
            else if(dapandung==3) btnPlayer2c.setText(String.valueOf(c));
            else if(dapandung==4) btnPlayer2d.setText(String.valueOf(c));
        }
    }
    public void RandomPlayer1()
    {
        Random random = new Random();
        int a,b,c;
        int operations=random.nextInt(4)+1;
        if(operations==1){
            dapandung1 = random.nextInt(4)+1;
            a=random.nextInt(20); b=random.nextInt(20);
            questionPlayer1.setText(String.valueOf(a)+" + "+String.valueOf(b)+" = ?");
            c=a+b;
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt(Math.max(a,b))+Math.min(a,b);
                if(arr[i]==c) i--;
            }
            btnPlayer1a.setText(String.valueOf(arr[0]));
            btnPlayer1b.setText(String.valueOf(arr[1]));
            btnPlayer1c.setText(String.valueOf(arr[2]));
            btnPlayer1d.setText(String.valueOf(arr[3]));
            if(dapandung1==1) btnPlayer1a.setText(String.valueOf(c));
            else if(dapandung1==2) btnPlayer1b.setText(String.valueOf(c));
            else if(dapandung1==3) btnPlayer1c.setText(String.valueOf(c));
            else if(dapandung1==4) btnPlayer1d.setText(String.valueOf(c));
        }else if(operations==2)
        {
            dapandung1 = random.nextInt(4)+1;
            a=random.nextInt(30);
            do{
                b=random.nextInt(20);
            }while (a<=b);
            questionPlayer1.setText(String.valueOf(a)+" - "+String.valueOf(b)+" = ?");
            c=a-b;
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt(Math.max(a,b)-Math.min(a,b))+Math.min(a,b);
                if(arr[i]==c) i--;
            }
            btnPlayer1a.setText(String.valueOf(arr[0]));
            btnPlayer1b.setText(String.valueOf(arr[1]));
            btnPlayer1c.setText(String.valueOf(arr[2]));
            btnPlayer1d.setText(String.valueOf(arr[3]));
            if(dapandung==1) btnPlayer1a.setText(String.valueOf(c));
            else if(dapandung1==2) btnPlayer1b.setText(String.valueOf(c));
            else if(dapandung1==3) btnPlayer1c.setText(String.valueOf(c));
            else if(dapandung1==4) btnPlayer1d.setText(String.valueOf(c));
        }else if(operations==3)
        {
            dapandung1 = random.nextInt(4)+1;
            a=random.nextInt(11);
            b=random.nextInt(11);
            questionPlayer1.setText(String.valueOf(a)+" x "+String.valueOf(b)+" = ?");
            c=a*b;
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt((Math.max(a,b)*Math.max(a,b)) - (Math.min(a,b)*Math.min(a,b))) + (Math.min(a,b)*Math.min(a,b));
                if(arr[i]==c) i--;
            }
            btnPlayer1a.setText(String.valueOf(arr[0]));
            btnPlayer1b.setText(String.valueOf(arr[1]));
            btnPlayer1c.setText(String.valueOf(arr[2]));
            btnPlayer1d.setText(String.valueOf(arr[3]));
            if(dapandung1==1) btnPlayer1a.setText(String.valueOf(c));
            else if(dapandung1==2) btnPlayer1b.setText(String.valueOf(c));
            else if(dapandung1==3) btnPlayer1c.setText(String.valueOf(c));
            else if(dapandung1==4) btnPlayer1d.setText(String.valueOf(c));
        }else if(operations==4)
        {
            dapandung1 = random.nextInt(4)+1;
            b=random.nextInt(11);
            c=random.nextInt(11);
            a=c*b;
            questionPlayer1.setText(String.valueOf(a)+" / "+String.valueOf(b)+" = ?");
            int arr[] = new int[4];
            for(int i=0;i<4;i++)
            {
                arr[i]=random.nextInt(11)+1;
                if(arr[i]==a) i--;
            }
            btnPlayer1a.setText(String.valueOf(arr[0]));
            btnPlayer1b.setText(String.valueOf(arr[1]));
            btnPlayer1c.setText(String.valueOf(arr[2]));
            btnPlayer1d.setText(String.valueOf(arr[3]));
            if(dapandung1==1) btnPlayer1a.setText(String.valueOf(c));
            else if(dapandung1==2) btnPlayer1b.setText(String.valueOf(c));
            else if(dapandung1==3) btnPlayer1c.setText(String.valueOf(c));
            else if(dapandung1==4) btnPlayer1d.setText(String.valueOf(c));
        }
    }
    void anhxa()
    {
        btnPlayer1a=(Button)findViewById(R.id.answerplayer1a);
        btnPlayer1b=(Button)findViewById(R.id.answerplayer1b);
        btnPlayer1c=(Button)findViewById(R.id.answerplayer1c);
        btnPlayer1d=(Button)findViewById(R.id.answerplayer1d);

        btnPlayer2a=(Button)findViewById(R.id.answerplayer2a);
        btnPlayer2b=(Button)findViewById(R.id.answerplayer2b);
        btnPlayer2c=(Button)findViewById(R.id.answerplayer2c);
        btnPlayer2d=(Button)findViewById(R.id.answerplayer2d);

        questionPlayer1=(TextView)findViewById(R.id.questionplayer1);
        questionPlayer2=(TextView)findViewById(R.id.questionplayer2);

        scoresPlayer1=(TextView)findViewById(R.id.scores1);
        scoresPlayer2=(TextView)findViewById(R.id.scores2);

        seekBarPlayer1=(SeekBar)findViewById(R.id.seekbar1);
        seekBarPlayer2=(SeekBar)findViewById(R.id.seekbar2);
    }
}
