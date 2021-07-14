package com.example.freakingmath.Model;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.*;
import android.app.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.freakingmath.Controller.GameOver;
import com.example.freakingmath.R;

import java.util.Random;

public class playOnePlayer extends Activity {
    private Button a, b, c, d;
    private TextView txt, score;
    private String pheptoan;
    int mucchoi;
    private Intent it;
    private CountDownTimer cTimer1 = null;
    private SeekBar seekBar;
    private int tg = 39;
    private int dapandung;
    private int scores=0;
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
        setContentView(R.layout.activity_play_one_player);
        Anhxa();
        startTimer1();
        RandomQuestion();
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dapandung==1)lvup();
                else{
                    thuagame();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dapandung==2)lvup();
                else{
                    thuagame();
                }
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dapandung==3)lvup();
                else{
                    thuagame();
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dapandung==4)lvup();
                else{
                    thuagame();
                }
            }
        });
    }
    public void lvup(){
        MediaPlayer player;
        player = MediaPlayer.create(this, R.raw.quaman);
        player.start();
        scores++; cTimer1.cancel();
        tg=39;
        score.setText("Scores: "+String.valueOf(scores));
        startTimer1();
        RandomQuestion();
    }
    public void thuagame()
    {
        MediaPlayer player;
        player = MediaPlayer.create(this, R.raw.thuacuoc);
        player.start();
        cTimer1.cancel();
        onDestroy();
        Intent intent = new Intent(playOnePlayer.this, GameOver.class);
        intent.putExtra("mucchoi", mucchoi);
        intent.putExtra("pheptoan",pheptoan);
        intent.putExtra("playagain", 2);
        intent.putExtra("score",scores);
        startActivity(intent);
    }
    public void startTimer1() {
        cTimer1 = new CountDownTimer(4000, 100) {
            public void onTick(long millisUntilFinished) {
                tg--;
                seekBar.setProgress(tg);
            }
            public void onFinish() {
                thuagame();
            }
        };
        cTimer1.start();
    }
    public void randomPhepcong()
    {
        Random random = new Random();
        dapandung = random.nextInt(4)+1;
        int nb1,nb2,nb3;
        nb1=random.nextInt(mucchoi); nb2=random.nextInt(mucchoi);
        txt.setText(String.valueOf(nb1)+ " + " +String.valueOf(nb2)+" = ?");
        nb3=nb1+nb2;
        int arr[] = new int[4];
        for(int i=0;i<4;i++)
        {
            arr[i]=random.nextInt(Math.max(nb1,nb2))+Math.min(nb1,nb2);
            if(arr[i]==nb3) i--;
        }
        a.setText(String.valueOf(arr[0]));
        b.setText(String.valueOf(arr[1]));
        c.setText(String.valueOf(arr[2]));
        d.setText(String.valueOf(arr[3]));
        if(dapandung==1) a.setText(String.valueOf(nb3));
        else if(dapandung==2) b.setText(String.valueOf(nb3));
        else if(dapandung==3) c.setText(String.valueOf(nb3));
        else if(dapandung==4) d.setText(String.valueOf(nb3));
    }
    public void randomPheptru()
    {
        Random random = new Random();
        dapandung = random.nextInt(4)+1;
        int nb1,nb2,nb3;
        nb1=random.nextInt(mucchoi);
        do{
            nb2=random.nextInt(mucchoi);
        }while (nb2>=nb1);
        txt.setText(String.valueOf(nb1)+" - "+String.valueOf(nb2)+" = ?");
        nb3=nb1-nb2;
        int arr[] = new int[4];
        for(int i=0;i<4;i++)
        {
            arr[i]=random.nextInt(Math.max(nb1,nb2))+Math.min(nb1,nb2);
            if(arr[i]==nb3) i--;
        }
        a.setText(String.valueOf(arr[0]));
        b.setText(String.valueOf(arr[1]));
        c.setText(String.valueOf(arr[2]));
        d.setText(String.valueOf(arr[3]));
        if(dapandung==1) a.setText(String.valueOf(nb3));
        else if(dapandung==2) b.setText(String.valueOf(nb3));
        else if(dapandung==3) c.setText(String.valueOf(nb3));
        else if(dapandung==4) d.setText(String.valueOf(nb3));
    }
    public void randomphepnhan()
    {
        int mucchoi1=10;
        if(mucchoi==100) mucchoi1=40;
        else if(mucchoi==1000) mucchoi1=90;
        Random random = new Random();
        dapandung = random.nextInt(4)+1;
        int nb1,nb2,nb3;
        nb1=random.nextInt(mucchoi1);
        nb2=random.nextInt(mucchoi1);
        txt.setText(String.valueOf(nb1)+" * "+String.valueOf(nb2)+" = ?");
        nb3=nb1*nb2;
        int arr[] = new int[4];
        for(int i=0;i<4;i++)
        {
            arr[i]=random.nextInt((Math.max(nb1,nb2)*Math.max(nb1,nb2)) - (Math.min(nb1,nb2)*Math.min(nb1,nb2))) + (Math.min(nb1,nb2)*Math.min(nb1,nb2));
            if(arr[i]==nb3) i--;
        }
        a.setText(String.valueOf(arr[0]));
        b.setText(String.valueOf(arr[1]));
        c.setText(String.valueOf(arr[2]));
        d.setText(String.valueOf(arr[3]));
        if(dapandung==1) a.setText(String.valueOf(nb3));
        else if(dapandung==2) b.setText(String.valueOf(nb3));
        else if(dapandung==3) c.setText(String.valueOf(nb3));
        else if(dapandung==4) d.setText(String.valueOf(nb3));
    }
    public void randomPhepchia()
    {
        int mucchoi1=10;
        if(mucchoi==100) mucchoi1=40;
        else if(mucchoi==1000) mucchoi1=90;
        Random random = new Random();
        dapandung = random.nextInt(4)+1;
        int nb1,nb2,nb3;
        nb2=random.nextInt(mucchoi1);
        nb3=random.nextInt(mucchoi1);
        nb1=nb3*nb2;
        txt.setText(String.valueOf(nb1)+" / "+String.valueOf(nb2)+" = ?");
        int arr[] = new int[4];
        for(int i=0;i<4;i++)
        {
            arr[i]=random.nextInt(11)+1;
            if(arr[i]==nb1) i--;
        }
        a.setText(String.valueOf(arr[0]));
        b.setText(String.valueOf(arr[1]));
        c.setText(String.valueOf(arr[2]));
        d.setText(String.valueOf(arr[3]));
        if(dapandung==1) a.setText(String.valueOf(nb3));
        else if(dapandung==2) b.setText(String.valueOf(nb3));
        else if(dapandung==3) c.setText(String.valueOf(nb3));
        else if(dapandung==4) d.setText(String.valueOf(nb3));
    }    public void RandomQuestion()
    {
        if(pheptoan.equals("phepcong") == true)
        {
            randomPhepcong();
        }else  if(pheptoan.equals("pheptru") == true){
            randomPheptru();
        }else  if(pheptoan.equals("phepnhan") == true)
        {
            randomphepnhan();
        }else if(pheptoan.equals("phepchia") == true)
        {
            randomPhepchia();
        }else{
            Random random = new Random();
            int operations=random.nextInt(4)+1;
            if(operations==1){
                randomPhepcong();
            }else if(operations==2){
                randomPheptru();
            }else if(operations==3){
                randomphepnhan();
            }else{
                randomPhepchia();
            }
        }
    }
    void Anhxa()
    {
        a=(Button)findViewById(R.id.answerplayera);
        b=(Button)findViewById(R.id.answerplayerb);
        c=(Button)findViewById(R.id.answerplayerc);
        d=(Button)findViewById(R.id.answerplayerd);
        it=getIntent() ;
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        txt=(TextView)findViewById(R.id.txt);
        score=(TextView)findViewById(R.id.sorce);
        mucchoi=it.getIntExtra("mucchoi",1);
        pheptoan=it.getStringExtra("pheptoan");
    }
}
