package com.example.freakingmath.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.app.*;

import com.example.freakingmath.DataBase.Database;
import com.example.freakingmath.Controller.MainActivity;
import com.example.freakingmath.R;

public class HighScore extends Activity {
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.highscores);
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HighScore.this, MainActivity.class));
            }
        });
        Database dtb = new Database(this,"",null,1);
        TextView TOF_de, TOF_tb, TOF_kho,Hainguoichoi;
        TextView oneplay11,oneplay12, oneplay13;
        TextView oneplay21,oneplay22, oneplay23;
        TextView oneplay31,oneplay32, oneplay33;
        TextView oneplay41,oneplay42, oneplay43;
        TextView oneplay51,oneplay52, oneplay53;

        TOF_de = (TextView)findViewById(R.id.TOFde);
        TOF_tb = (TextView)findViewById(R.id.TOFtb);
        TOF_kho = (TextView)findViewById(R.id.TOFkho);
        oneplay11=(TextView)findViewById(R.id.oneplay11);
        oneplay12=(TextView)findViewById(R.id.oneplay12);
        oneplay13=(TextView)findViewById(R.id.oneplay13);
        oneplay21=(TextView)findViewById(R.id.oneplay21);
        oneplay22=(TextView)findViewById(R.id.oneplay22);
        oneplay23=(TextView)findViewById(R.id.oneplay23);
        oneplay31=(TextView)findViewById(R.id.oneplay31);
        oneplay32=(TextView)findViewById(R.id.oneplay32);
        oneplay33=(TextView)findViewById(R.id.oneplay33);
        oneplay41=(TextView)findViewById(R.id.oneplay41);
        oneplay42=(TextView)findViewById(R.id.oneplay42);
        oneplay43=(TextView)findViewById(R.id.oneplay43);
        oneplay51=(TextView)findViewById(R.id.oneplay51);
        oneplay52=(TextView)findViewById(R.id.oneplay52);
        oneplay53=(TextView)findViewById(R.id.oneplay53);

        Hainguoichoi=(TextView)findViewById(R.id.hainguoichoi);
        TOF_de.setText(String.valueOf(dtb.getScore(this,"Diemcao","TOF",1)));
        TOF_tb.setText(String.valueOf(dtb.getScore(this,"Diemcao","TOF",2)));
        TOF_kho.setText(String.valueOf(dtb.getScore(this,"Diemcao","TOF",3)));
        Hainguoichoi.setText(String.valueOf(dtb.getScore(this,"Diemcao","2NC",1)));
        oneplay11.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepcong",1)));
        oneplay12.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepcong",2)));
        oneplay13.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepcong",3)));
        oneplay21.setText(String.valueOf(dtb.getScore(this,"Diemcao","pheptru",1)));
        oneplay22.setText(String.valueOf(dtb.getScore(this,"Diemcao","pheptru",2)));
        oneplay23.setText(String.valueOf(dtb.getScore(this,"Diemcao","pheptru",3)));
        oneplay31.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepnhan",1)));
        oneplay32.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepnhan",2)));
        oneplay33.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepnhan",3)));
        oneplay41.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepchia",1)));
        oneplay42.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepchia",2)));
        oneplay43.setText(String.valueOf(dtb.getScore(this,"Diemcao","phepchia",3)));
        oneplay51.setText(String.valueOf(dtb.getScore(this,"Diemcao","all",1)));
        oneplay52.setText(String.valueOf(dtb.getScore(this,"Diemcao","all",2)));
        oneplay53.setText(String.valueOf(dtb.getScore(this,"Diemcao","all",3)));
        dtb.close();

    }
}
