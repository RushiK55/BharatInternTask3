package com.example.rquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScr extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scr);

        img=findViewById(R.id.imageSplashScr);
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        img.startAnimation(blinkAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScr.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}