package com.example.rquiz;
// This activity Contains Description of Test Language
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class html_activity extends AppCompatActivity {
    TextView head,desc;

    String s;
    public void htmlData(){
        head.setText(R.string.htmlHead);
        desc.setText(R.string.htmlDesc);

    }
    public void cssData(){
        head.setText(R.string.cssHead);
        desc.setText(R.string.cssDesc);
    }
    public void jsData(){
        head.setText(R.string.jsHead);
        desc.setText(R.string.jsDesc);
    }
    public void javaData(){
        head.setText(R.string.javaHead);
        desc.setText(R.string.javaDesc);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        ConstraintLayout c=findViewById(R.id.activity_html_Layout);
//        getSupportActionBar().show();


        AnimationDrawable animationDrawable = (AnimationDrawable) c.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        head=findViewById(R.id.textView2);
        desc=findViewById(R.id.textView3);
         s=getIntent().getStringExtra("t");
//        tv.setText(s);
        if (s.toString().trim().equals("htmlTest")) {
            htmlData();
        }
       else if (s.toString().trim().equals("cssTest")) {
            cssData();
        }
       else if (s.toString().trim().equals("jsTest")) {
            jsData();
        }
        else if (s.toString().trim().equals("javaTest")) {
            javaData();
        }


    }
    public void htmlSelectTest(View view){
        Intent intent = new Intent(this, htmlTestactivity.class);
        String t;
        if (s.toString().trim().equals("htmlTest")){
//            htmlData();
            t="htmlTest";
            intent.putExtra("t",t);
        }
        if (s.toString().trim().equals("cssTest")){
//            htmlData();
            t="cssTest";
            intent.putExtra("t",t);
        }
        if (s.toString().trim().equals("jsTest")){
//            htmlData();
            t="jsTest";
            intent.putExtra("t",t);
        }
        if (s.toString().trim().equals("javaTest")){
//            htmlData();
            t="javaTest";
            intent.putExtra("t",t);
        }
        startActivity(intent);
        finish();
    }
}