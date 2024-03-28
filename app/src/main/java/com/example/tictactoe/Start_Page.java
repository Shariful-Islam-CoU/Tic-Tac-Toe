package com.example.tictactoe;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
import static java.lang.Math.abs;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import java.util.Random;

public class Start_Page extends AppCompatActivity {

    public Button aibtn, multibtn;
    private double backPressTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_page);





        aibtn=findViewById(R.id.play_ai_ID);
        multibtn=findViewById(R.id.play_two_playersID);




        aibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 Intent intent = new Intent(Start_Page.this,Play_with_AI.class);
                  startActivity(intent);
            }
        });

        multibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start_Page.this,MainActivity.class);
               startActivity(intent);
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(backPressTime+2000>System.currentTimeMillis()){
                    backToast.cancel();
                    finishAffinity();
                }else{
                    backToast = Toast.makeText(Start_Page.this,"Press back again to exit",Toast.LENGTH_SHORT);
                    backToast.show();
                }
                backPressTime=System.currentTimeMillis();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


    }



}
