package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jcminarro.philology.Philology;
import com.jcminarro.philology.PhilologyInterceptor;
import com.jcminarro.philology.PhilologyRepository;
import com.jcminarro.philology.PhilologyRepositoryFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class MainActivity extends AppCompatActivity {

    Button truebtn;
    Button falsebtn;
    ProgressBar progress;
    TextView questions;
    TextView scr;
    int index=0;
    int score=0;



    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    final int pro=(int)Math.ceil(100/mQuestionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(super.getClass());
        Log.d("hello", String.valueOf(super.getClass()));
        Log.d("hii",this.getClass().toString());
        if(savedInstanceState!=null){
            score=savedInstanceState.getInt("scorekey");
            index=savedInstanceState.getInt("indx");
        }else{
            score=0;
        }

        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        Log.d("check", String.valueOf(R.string.app_name));


        truebtn=(Button)findViewById(R.id.true_button);
        falsebtn=(Button)findViewById(R.id.false_button);
        progress=(ProgressBar)findViewById(R.id.progress_bar);
        questions=(TextView)findViewById(R.id.question_text_view);
        scr=(TextView)findViewById(R.id.score);
        questions.setText(mQuestionBank[index].getCquestions());
        scr.setText("score"+score+"/"+mQuestionBank.length);
        truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(true);
                update();

            }
        });
        falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(false);
                update();
            }
        });
    }
    public void update(){

        index=(index+1)%mQuestionBank.length;
        if(index==0){
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game over");
            alert.setCancelable(false);
            alert.setMessage("Your score is"+score);
            alert.setPositiveButton("close application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }
        questions.setText(mQuestionBank[index].getCquestions());
        scr.setText("score"+score+"/"+mQuestionBank.length);
        progress.incrementProgressBy(pro);
    }
    public void check(Boolean val){
        Boolean ans=mQuestionBank[index].getAns();
        if(ans==val){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            score=score+1;
        }else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }
    public void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putInt("scorekey",score);
        outstate.putInt("indx",index);
    }
}

