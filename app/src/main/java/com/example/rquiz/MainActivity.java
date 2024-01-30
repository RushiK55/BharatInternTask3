package com.example.rquiz;
// This Java File Contains List Of Test Subjects or Languages
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
Button htmlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout c=findViewById(R.id.mainLayout);
        TextView blinkingText = findViewById(R.id.textView);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        blinkingText.startAnimation(blinkAnimation);

        AnimationDrawable animationDrawable = (AnimationDrawable) c.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
    }

    public void htmlClick(View view){
        Intent intent = new Intent(this, html_activity.class);
        String t="htmlTest";
        intent.putExtra("t",t);
        startActivity(intent);
    }
    public void cssClick(View view){
        Intent intent = new Intent(this, html_activity.class);
        String t="cssTest";
        intent.putExtra("t",t);
        startActivity(intent);
    }
    public void jsClick(View view){
        Intent intent = new Intent(this, html_activity.class);
        String t="jsTest";
        intent.putExtra("t",t);
        startActivity(intent);
    }
    public void javaClick(View view){
        Intent intent = new Intent(this, html_activity.class);
        String t="javaTest";
        intent.putExtra("t",t);
        startActivity(intent);
    }
}