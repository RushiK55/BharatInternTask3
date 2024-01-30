package com.example.rquiz;
// THis Java File Contains Test no. and pass test number and file path
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Objects;

public class htmlTestactivity extends AppCompatActivity {
//public String t;
    Button Test1,Test2,Test3,Test4,Test5;
    TextView textView;
    ImageView imageView;
    String s;
    String  t1,t2,t3,t4,t5,data;
public void Data(String s){
    if (s.toString().trim().equals("htmlTest")){
        data="htmlTest";
        t1="htmlTest1.txt";
        t2="htmlTest2.txt";
        t3="htmlTest3.txt";
        t4="htmlTest4.txt";
        t5="htmlTest5.txt";
    }
    else if (s.toString().trim().equals("cssTest")){
        data="cssTest";
        t1="cssTest1.txt";
        t2="cssTest2.txt";
        t3="cssTest3.txt";
        t4="cssTest4.txt";
        t5="cssTest5.txt";
    }
    else if (s.toString().trim().equals("jsTest")){
        data="jsTest";
        t1="jsTest1.txt";
        t2="jsTest2.txt";
        t3="jsTest3.txt";
        t4="jsTest4.txt";
        t5="jsTest5.txt";
    }
    else if (s.toString().trim().equals("javaTest")){
        data="javaTest";
        t1="javaTest1.txt";
        t2="javaTest2.txt";
        t3="javaTest3.txt";
        t4="javaTest4.txt";
        t5="javaTest5.txt";
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_testactivity);

        Test1= findViewById(R.id.button6);
        Test2= findViewById(R.id.button5);
        Test3= findViewById(R.id.button4);
        Test4= findViewById(R.id.button3);
        Test5= findViewById(R.id.button2);

        textView=findViewById(R.id.textView4);
        imageView = findViewById(R.id.imageView);

        ConstraintLayout c=findViewById(R.id.activity_html_testactivity);
//        getSupportActionBar().show();
        AnimationDrawable animationDrawable = (AnimationDrawable) c.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        s = getIntent().getStringExtra("t");
        Data(Objects.requireNonNull(s));

        // Back To Home
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(htmlTestactivity.this, MainActivity.class);
                startActivity(io);
            }
        });


        Test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t1 = "htmlTest1.txt";
                Intent intent = new Intent(htmlTestactivity.this, TestActivity.class);
                intent.putExtra("t1",t1);
                startActivity(intent);
            }
        });
        Test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t2 = "htmlTest2.txt";
                Intent intent = new Intent(htmlTestactivity.this, TestActivity.class);
                intent.putExtra("t1",t2);
                startActivity(intent);
            }
        });
        Test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t3 = "htmlTest3.txt";
                Intent intent = new Intent(htmlTestactivity.this, TestActivity.class);
                intent.putExtra("t1",t3);
                startActivity(intent);
            }
        });
        Test4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t4 = "htmlTest4.txt";
                Intent intent = new Intent(htmlTestactivity.this, TestActivity.class);
                intent.putExtra("t1",t4);
                startActivity(intent);
            }
        });
        Test5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                t5 = "htmlTest5.txt";
                Intent intent = new Intent(htmlTestactivity.this, TestActivity.class);
                intent.putExtra("t1",t5);
                startActivity(intent);
            }
        });

    }

}