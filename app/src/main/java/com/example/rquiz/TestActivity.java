package com.example.rquiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TestActivity extends AppCompatActivity {
    String data = "";
    static int i=0;
     int fail=0;
     static int cAns=0;
     static int Que=1;
    static boolean b =true; // b is checking if user is any option is selected
    static boolean c= true;
    static boolean clicked=false;
//    static boolean c=true;
    Button nxtBtn;
    Button opt1,opt2,opt3,opt4;
    TextView queTxt,QueNo,scr,ScoreTv,DescTv;
    Dialog dialog;
    ImageView diaImg;
    Button diabtn;
    String optcorrect1,optcorrect2,optcorrect3,optcorrect4;

//    Intent int1 = new Intent(this,htmlTestScore.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent inte = new Intent(TestActivity.this, htmlTestactivity.class);

        nxtBtn= findViewById(R.id.button11);

        queTxt= findViewById(R.id.textView6);
        QueNo= findViewById(R.id.textView5);

        opt1= findViewById(R.id.button7);
        opt2= findViewById(R.id.button8);
        opt3= findViewById(R.id.button9);
        opt4= findViewById(R.id.button10);

        scr= findViewById(R.id.textView9);

        ConstraintLayout c11=findViewById(R.id.activity_test);
//        getSupportActionBar().show();
        // Custom Dialog Box For Displaying Result
        AnimationDrawable animationDrawable = (AnimationDrawable) c11.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        dialog = new Dialog(TestActivity.this);
        dialog.setContentView(R.layout.custom_message);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ScoreTv=dialog.findViewById(R.id.textView7);
        DescTv=dialog.findViewById(R.id.textView8);
        diabtn=dialog.findViewById(R.id.button14);
        diaImg=dialog.findViewById(R.id.imageView2);



        String path= getIntent().getStringExtra("t1");
            b=true;

            if (b){

                try {
                    InputStream inputStream = getAssets().open(path);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        data += line + "\n";
                    }
                    String[] subQue = data.split(",");
                    String que1 = subQue[i].substring(0, subQue[i].length() - 0);
                    i++;
                    String option1 = subQue[i].substring(0,subQue[i].length()-1);
                    optcorrect1= subQue[i].substring(subQue[i].lastIndexOf(" "));
                    opt1.setText(optcorrect1);
                    i++;
                    String option2 = subQue[i].substring(1,subQue[i].length()-1);
                    optcorrect2= subQue[i].substring(subQue[i].lastIndexOf(" "));
                    i++;
                    String option3 = subQue[i].substring(1,subQue[i].length()-1);
                    optcorrect3= subQue[i].substring(subQue[i].lastIndexOf(" "));
                    i++;
                    String option4 = subQue[i].substring(1,subQue[i].length()-1);
                    optcorrect4= subQue[i].substring(subQue[i].lastIndexOf(" "));
                    i++;
                    queTxt.setText(que1);
                    opt1.setText(option1);
                    opt2.setText(option2);
                    opt3.setText(option3);
                    opt4.setText(option4);
                    b=false;
                } catch (IOException e) {
                    // Handle the exception
                }
            }




            opt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (optcorrect1.toString().trim().equals("T")){
                        opt1.setText("Correct");
                        opt1.setBackgroundColor(Color.GREEN);
                        opt1.setTextColor(Color.BLACK);

                        if (c){
                            cAns++;
                            String strOfCAns=" "+cAns;
                            scr.setText(strOfCAns);
                            c=false;
                        }
                        clicked=true;
                        b=true;
                    }else {
                        b=true;
                        opt2.setAlpha(0.3f);
                        opt3.setAlpha(0.3f);
                        opt4.setAlpha(0.3f);
                        if (optcorrect2.toString().trim().equals("T")) {
//                            opt2.setText("Correct");
                            opt2.setBackgroundColor(Color.GREEN);
                            opt2.setTextColor(Color.BLACK);
                            opt2.setAlpha(1.0f);
                        } else if (optcorrect3.toString().trim().equals("T") ) {
//                            opt3.setText("Correct");
                            opt3.setBackgroundColor(Color.GREEN);
                            opt3.setTextColor(Color.BLACK);
                            opt3.setAlpha(1.0f);
                        } else if (optcorrect4.toString().trim().equals("T")) {
//                            opt4.setText("Correct");
                            opt4.setBackgroundColor(Color.GREEN);
                            opt4.setTextColor(Color.BLACK);
                            opt4.setAlpha(1.0f);
                        }

                        opt1.setText("Incorrect");
                        opt1.setBackgroundColor(Color.RED);
                        opt1.setTextColor(Color.BLACK);
                        fail++;
                        c=false;
                    }
                }
            });
            opt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (optcorrect2.toString().trim().equals("T")){
                        opt2.setText("Correct");
                        opt2.setBackgroundColor(Color.GREEN);
                        opt2.setTextColor(Color.BLACK);
                        if (c){
                            cAns++;
                            String strOfCAns=" "+cAns;
                            scr.setText(strOfCAns);
                            c=false;
                        }
                        b=true;
                        clicked=true;
                    }else {
                        b=true;
                        opt1.setAlpha(0.3f);
                        opt3.setAlpha(0.3f);
                        opt4.setAlpha(0.3f);
                        if (optcorrect1.toString().trim().equals("T")) {
//                            opt1.setText("Correct");
                            opt1.setBackgroundColor(Color.GREEN);
                            opt1.setTextColor(Color.BLACK);
                            opt1.setAlpha(1.0f);
                        } else if (optcorrect3.toString().trim().equals("T") ) {
//                            opt3.setText("Correct");
                            opt3.setBackgroundColor(Color.GREEN);
                            opt3.setTextColor(Color.BLACK);
                            opt3.setAlpha(1.0f);
                        } else if (optcorrect4.toString().trim().equals("T")) {
//                            opt4.setText("Correct");
                            opt4.setBackgroundColor(Color.GREEN);
                            opt4.setTextColor(Color.BLACK);
                            opt4.setAlpha(1.0f);
                        }

                        opt2.setText("Incorrect");
                        opt2.setBackgroundColor(Color.RED);
                        opt2.setTextColor(Color.BLACK);
                        fail++;
                        c=false;

                    }
                }
            });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optcorrect3.toString().trim().equals("T")){
                    opt3.setText("Correct");
                    opt3.setBackgroundColor(Color.GREEN);
                    opt3.setTextColor(Color.BLACK);
                    if (c){
                        cAns++;
                        String strOfCAns=" "+cAns;
                        scr.setText(strOfCAns);
                        c=false;
                    }
                    b=true;
                    clicked=true;
                }else {
                    b=true;
                    opt1.setAlpha(0.3f);
                    opt2.setAlpha(0.3f);
                    opt4.setAlpha(0.3f);
                    if (optcorrect1.toString().trim().equals("T")) {
//                        opt1.setText("Correct");
                        opt1.setBackgroundColor(Color.GREEN);
                        opt1.setTextColor(Color.BLACK);
                        opt1.setAlpha(1.0f);
                    } else if (optcorrect2.toString().trim().equals("T") ) {
//                        opt2.setText("Correct");
                        opt2.setBackgroundColor(Color.GREEN);
                        opt2.setTextColor(Color.BLACK);
                        opt2.setAlpha(1.0f);
                    } else if (optcorrect4.toString().trim().equals("T")) {
//                        opt4.setText("Correct");
                        opt4.setBackgroundColor(Color.GREEN);
                        opt4.setTextColor(Color.BLACK);
                        opt4.setAlpha(1.0f);
                    }

                    opt3.setText("Incorrect");
                    opt3.setBackgroundColor(Color.RED);
                    opt3.setTextColor(Color.BLACK);
                    fail++;
                    c=false;
                }
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optcorrect4.toString().trim().equals("T")){
                    opt4.setText("Correct");
                    opt4.setBackgroundColor(Color.GREEN);
                    opt4.setTextColor(Color.BLACK);
                    if (c){
                        cAns++;
                        String strOfCAns=" "+cAns;
                        scr.setText(strOfCAns);
                        c=false;
                    }
                    b=true;
                    clicked=true;
                }else {
                    b=true;
                    opt2.setAlpha(0.3f);
                    opt3.setAlpha(0.3f);
                    opt1.setAlpha(0.3f);
                    if (optcorrect1.toString().trim().equals("T")) {
//                        opt1.setText("Correct");
                        opt1.setBackgroundColor(Color.GREEN);
                        opt1.setTextColor(Color.BLACK);
                        opt1.setAlpha(1.0f);
                    } else if (optcorrect2.toString().trim().equals("T") ) {
//                        opt2.setText("Correct");
                        opt2.setBackgroundColor(Color.GREEN);
                        opt2.setTextColor(Color.BLACK);
                        opt2.setAlpha(1.0f);
                    } else if (optcorrect3.toString().trim().equals("T")) {
//                        opt3.setText("Correct");
                        opt3.setBackgroundColor(Color.GREEN);
                        opt3.setTextColor(Color.BLACK);
                        opt3.setAlpha(1.0f);
                    }

                    opt4.setText("Incorrect");
                    opt4.setBackgroundColor(Color.RED);
                    opt4.setTextColor(Color.BLACK);
                    fail++;
                    c=false;
                }
            }
        });
        //next Button For Updating the Question, Options and UI
            nxtBtn.setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {

//                    String[] que = data.split("\n");
                    String[] subQue = data.split(",");
                    if (b) {
                        opt1.setAlpha(1.0f);
                        opt2.setAlpha(1.0f);
                        opt3.setAlpha(1.0f);
                        opt4.setAlpha(1.0f);
                        c=true;
                        if (subQue[i].toString().trim().equals("END")){
                            String scrd="Score: " + cAns;
                            ScoreTv.setText(scrd);
                            if (cAns>=8){
                                DescTv.setText("!!!Congratulation!!!\nYou Passed The Test\n With Great Score");
                                diaImg.setImageResource(R.drawable.pass);
                                diabtn.setTextColor(getResources().getColor(R.color.white));
                                diabtn.setBackgroundTintList(getResources().getColorStateList(R.color.green));
                            }
                            else if (5<=cAns) {
                                DescTv.setText("!!!Congrats!!!\nYou Passed The Test");
                                diaImg.setImageResource(R.drawable.pass);
                                diabtn.setTextColor(getResources().getColor(R.color.black));
                                diabtn.setBackgroundTintList(getResources().getColorStateList(R.color.yellow));
                            }
                            else{
                                DescTv.setText("Test Failed\nTry Your Best Next Time");
                                diaImg.setImageResource(R.drawable.fail);
                                diabtn.setTextColor(getResources().getColor(R.color.black));
                                diabtn.setBackgroundTintList(getResources().getColorStateList(R.color.red));
                            }
                            diabtn.setText("Next Tests");
                            dialog.show();
                            diabtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(TestActivity.this, htmlTestactivity.class));
                                    finish();
                                }
                            });
                            String strOfCAns=" "+cAns;
                            Toast.makeText(TestActivity.this, "Total Correct Attempts"+strOfCAns, Toast.LENGTH_SHORT).show();


                        }else {
                            Que++;
                            QueNo.setText("Question:"+Que);
                            optcorrect1="";
                            optcorrect2="";
                            optcorrect3="";
                            optcorrect4="";//rgba(103,80,164,255) rgb(170, 119, 255)rgb(0, 169, 255)
                            opt1.setBackgroundColor(Color.rgb(160, 233, 255));
                            opt2.setBackgroundColor(Color.rgb(160, 233, 255));
                            opt3.setBackgroundColor(Color.rgb(160, 233, 255));
                            opt4.setBackgroundColor(Color.rgb(160, 233, 255));



                            String que1 = subQue[i].substring(0, subQue[i].length()-1);
                            i++;
                            String option1 = subQue[i].substring(0,subQue[i].length()-1);
                            optcorrect1= subQue[i].substring(subQue[i].lastIndexOf(" "));
                            i++;
                            String option2 = subQue[i].substring(1,subQue[i].length()-1);
                            optcorrect2= subQue[i].substring(subQue[i].lastIndexOf(" "));
                            i++;
                            String option3 = subQue[i].substring(1,subQue[i].length()-1);
                            optcorrect3= subQue[i].substring(subQue[i].lastIndexOf(" "));
                            i++;
                            String option4 = subQue[i].substring(1,subQue[i].length()-1);
                            optcorrect4= subQue[i].substring(subQue[i].lastIndexOf(" "));
                            i++;
                            queTxt.setText(que1);
                            opt1.setText(option1);
                            opt2.setText(option2);
                            opt3.setText(option3);
                            opt4.setText(option4);
                            b=false;
//                    recreate();

                            if (subQue[i].toString().trim().equals("END")){
                                nxtBtn.setText("Submit Test");
//
                            }
                        }

                    }else {
                        Toast.makeText(TestActivity.this, "Choose the Correct Option!!!", Toast.LENGTH_SHORT).show();
                    }





                }
            });

    }

}