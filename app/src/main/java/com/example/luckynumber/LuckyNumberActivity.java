package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView welcomeTxt, luckyNumberTxt;


    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        welcomeTxt=findViewById(R.id.textView2);
        luckyNumberTxt=findViewById(R.id.luckyNumber);
        share_btn=findViewById(R.id.share_number_btn);


        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        Toast.makeText(this, "Username: "+userName, Toast.LENGTH_SHORT).show();

        //Random no generate
        int random_num=generateRandomNumber();
        luckyNumberTxt.setText("" + random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);

            }
        });
    }
    public  int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
        int randomNumberGenerated=random.nextInt(1000);
        return  randomNumberGenerated;

    }
    public void shareData(String username,int randomNum){

        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String number= String.valueOf(randomNum);
        i.putExtra(Intent.EXTRA_SUBJECT,username+" is your lucky number");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is "+number);
        startActivity(Intent.createChooser(i,"Choose a platform"));


    }
}