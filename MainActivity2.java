package com.example.aliyiyakala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageView aliPng;
    TextView skorText,sayac;
    ImageView[] chars;
    boolean control = true;
    int skor,random,sayacSayi = 10;
    CountDownTimer countDownTimer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aliPng = findViewById(R.id.imageView);
        skorText = findViewById(R.id.textView);
        sayac = findViewById(R.id.textView2);
        chars = new ImageView[9];
        chars[0] = (ImageView) findViewById(R.id.imageView);
        chars[1] = (ImageView) findViewById(R.id.imageView1);
        chars[2] = (ImageView) findViewById(R.id.imageView2);
        chars[3] = (ImageView) findViewById(R.id.imageView4);
        chars[4] = (ImageView) findViewById(R.id.imageView5);
        chars[5] = (ImageView) findViewById(R.id.imageView6);
        chars[6] = (ImageView) findViewById(R.id.imageView7);
        chars[7] = (ImageView) findViewById(R.id.imageView8);
        chars[8] = (ImageView) findViewById(R.id.imageView9);

        random = (int) (Math.random()*9);

        for(int i=0;i<9;i++){
            if(i == random)
                continue;
            chars[i].setVisibility(View.INVISIBLE);
        }
        skor = 0;
    }
    public void icreaseScore(View view){
        skor++;
        skorText.setText("Skor: "+skor);
        for(int i =0;i<9;i++){
            if(chars[i].getVisibility() == View.VISIBLE){
                random = i;
            }
        }
        chars[random].setVisibility(View.INVISIBLE);
        int random2 = (int) (Math.random()*9);
        chars[random2].setVisibility(View.VISIBLE);
        if(control){
            new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long l) {
                    sayacSayi--;
                    sayac.setText("Sayac: " + sayacSayi);
                }

                @Override
                public void onFinish() {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);
                    alertDialog.setTitle("Game");
                    alertDialog.setMessage("Are you plan again?");
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    }).show();
                    alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity2.this,"Your Score:",Toast.LENGTH_LONG);
                        }
                    }).show();
                }
            }.start();}
        control =false;


    }

}