package com.example.tictactoe;

import static java.security.AccessController.getContext;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import java.util.Objects;

public class Congratulation_Activity extends AppCompatActivity {
    Play_with_AI playWithAi= new Play_with_AI();
    MainActivity mainActivity =new MainActivity();
    private ImageView congra_IconVW;
    private Dialog alert_dialog;
    private TextView congra_TileV,congra_messageV,alertDialog_title,alertDialog_message;;
    private Button playAgainBtn,takeMeHomeBtn,yesBtn,noBtn;
    private String congra_tile,congra_message,for_icon,for_where,p1name,p2name;
    private int p1point,p2point;
    private double p1time,p2time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_congratulation);
        congra_IconVW=findViewById(R.id.congra_iconId);
        congra_TileV=findViewById(R.id.congra_titleID);
        congra_messageV=findViewById(R.id.congra_messageID);
        playAgainBtn=findViewById(R.id.play_Again_btnID);
        takeMeHomeBtn=findViewById(R.id.takeMeHomeBtnID);
        alert_dialog= new Dialog(this);

        Intent intent = getIntent();

        congra_tile=intent.getStringExtra("Congrass_title");
        congra_message=intent.getStringExtra("congass_message");
        for_icon=intent.getStringExtra("for_icon");
        for_where=intent.getStringExtra("where");
        p1point=intent.getIntExtra("p1point",0);
        p2point=intent.getIntExtra("p2point",0);
        p1name=intent.getStringExtra("p1name");
        p2name=intent.getStringExtra("p2name");
        p1time=intent.getDoubleExtra("p1time",0.0);
        p2time=intent.getDoubleExtra("p2time",0.0);



        if(((p1point>0||p2point>0)&&p1point!=p2point)|| p1time>0||p2time>0){
            takeMeHomeBtn.setText("Finish Game");
        }

        if(congra_message.equals("AI wins the match")){
            congra_TileV.setText("You lose!");
            congra_messageV.setText("Good luck next time");
            congra_IconVW.setImageResource(R.drawable.sad);
        }
        else if(congra_message.equals("AI wins the game")){
            congra_TileV.setText("You lose the game!");
            congra_messageV.setText(congra_message);
            congra_IconVW.setImageResource(R.drawable.crying);
        }
        else{
            congra_TileV.setText(congra_tile);
            congra_messageV.setText(congra_message);

            if(Objects.equals(for_icon, "1")) congra_IconVW.setImageResource(R.drawable.congratulations);
            else if(Objects.equals(for_icon, "2")) congra_IconVW.setImageResource(R.drawable.draw);
            else if(Objects.equals(for_icon, "3")) congra_IconVW.setImageResource(R.drawable.trophy);
        }

        char last=congra_message.charAt(congra_message.length()-1);


        if(last=='h'||last=='s'){
            playAgainBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        else{
            playAgainBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(for_where.equals("ai")){
                        Intent intent1=new Intent(Congratulation_Activity.this,Play_with_AI.class);
                        startActivity(intent1);
                    }

                    else if (for_where.equals("OK")) {
                        Intent intent1=new Intent(Congratulation_Activity.this,MainActivity.class);

                        startActivity(intent1);
                    }
                    finish();
                }
            });
        }


        takeMeHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                back_button();


            }
        });


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                back_button();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


    }

    public void back_button(){
        if(((p1point>0||p2point>0)&&p1point!=p2point)|| p1time>0||p2time>0){
            alert();
        }
        else{
            Intent intent1=new Intent(Congratulation_Activity.this,Start_Page.class);
            startActivity(intent1);

            finishAffinity();

        }
    }

    public void take_me_home(){
        Intent intent1=new Intent(Congratulation_Activity.this,Congratulation_Activity.class);
        intent1.putExtra("Congrass_title","Congratulations!");
        if((p1time>0||p2time>0)&&p1point==p2point){

            if(p1time<p2time){
                intent1.putExtra("congass_message",p1name+" wins the game by time");
                intent1.putExtra("Congrass_title","Congrats "+p1name);
            }
            else{
                intent1.putExtra("congass_message",p2name+" wins the game by time");
                intent1.putExtra("Congrass_title","Congrats "+p2name);
            }
        }
        else if(p1point>p2point){
            intent1.putExtra("congass_message",p1name+" wins the game");
            intent1.putExtra("Congrass_title","Congrats "+p1name);
        }
        else{
            intent1.putExtra("congass_message",p2name+" wins the game");
            intent1.putExtra("Congrass_title","Congrats "+p2name);
        }
        intent1.putExtra("for_icon","3");
        if(for_where.equals("ai")) intent1.putExtra("where","ai");
        else if(for_where.equals("OK")) intent1.putExtra("where","OK");
        intent1.putExtra("p1point",0);
        intent1.putExtra("p2point",0);
        intent1.putExtra("p1name",p1name);
        intent1.putExtra("p2name",p2name);
        intent1.putExtra("p1time",0);
        intent1.putExtra("p2time",0);
        startActivity(intent1);
        finishAffinity();
    }

    public void alert(){
        alert_dialog.setContentView(R.layout.custom_alert_dialog);
        alertDialog_title=alert_dialog.findViewById(R.id.alertTitleId);
        alertDialog_message=alert_dialog.findViewById(R.id.alertMessageId);
        yesBtn=alert_dialog.findViewById(R.id.yesbtnID);
        noBtn=alert_dialog.findViewById(R.id.nobtnID);
        alert_dialog.setCancelable(false);
            alertDialog_title.setText("Finish?");
            alertDialog_message.setText("Are you sure to finish the game?");
            yesBtn.setText("Finish");


        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                take_me_home();
                alert_dialog.dismiss();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert_dialog.dismiss();
            }
        });
        alert_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert_dialog.show();


    }



}