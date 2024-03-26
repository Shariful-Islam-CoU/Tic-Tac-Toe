package com.example.tictactoe;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView b1,b2,b3,b4,b5,b6,b7,b8,b9,p1,p2,namep1,namep2,O_TV,X_TV,p1timeView,p2timeView,alertDialog_title,alertDialog_message;
    public int c=0,x1=0,x2=0,x3=0,y1=0,y2=0,y3=0,four=0,equ=0,one=0,two=0,three=0,fourr=0,five=0,six=0,seven=0,eight=0,nine=0;
    public   int x11=0,x22=0,x33=0,y11=0,y22=0,y33=0,four1=0,equ1=0,fp=0,sp=0,k=0,for_name_change=0,drw=0;
    private Button restart_button,newgameBtn,saveBtn,yesBtn,noBtn,setNameBtn,play_nowBtn;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2;
    private EditText pl1Edittx,pl2Edittx;
    private Dialog dialog, dialog2,alert_dialog,notice_dialog;
    private ImageView p1Icon,p2Icon;
    private String lightGreen="#FF5567",O_color="#FF5567",X_color="#3882E4",darkGreen="#FDA3AC",ss,player1name="Player 1",player2name="Player 2";
    private String O="O",X="X";
    private char ooo,xxx;
    private Handler customHandler1= new Handler();
    private Handler customHandler2= new Handler();
    private double p1time=0,p2time=0,startTime1=0,updateTime1=0,timeMilli1=0,timeSwapBuff1=0,startTime2=0,updateTime2=0,
            p1lastMatchTime=0,p2lastMatchTime=0,timeMilli2=0,timeSwapBuff2=0,p1bakiTime=0,p2bakiTime=0;

    private AlertDialog.Builder alertDialogBuilder,alertDialogBuilder1,alertDialogBuilder2,alertDialogBuilder3,alertDialogBuilder4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.txID1);
        b2=findViewById(R.id.txID2);
        b3=findViewById(R.id.txID3);
        b4=findViewById(R.id.txID4);
        b5=findViewById(R.id.txID5);
        b6=findViewById(R.id.txID6);
        b7=findViewById(R.id.txID7);
        b8=findViewById(R.id.txID8);
        b9=findViewById(R.id.txID9);
        p1= findViewById(R.id.plr1);
        p2=findViewById(R.id.plr2);
        O_TV=findViewById(R.id.Oid);
        X_TV=findViewById(R.id.Xid);
        namep1=findViewById(R.id.nameP1);
        namep2=findViewById(R.id.nameP2);
        p1timeView=findViewById(R.id.p1timeId);
        p2timeView=findViewById(R.id.p2timeId);
        restart_button=findViewById(R.id.restart_buttonID);
        newgameBtn=findViewById(R.id.newgamebuttonID);
        p1Icon=findViewById(R.id.player1IconId);
        p2Icon=findViewById(R.id.player2_iconId);




        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        restart_button.setOnClickListener(this);
        newgameBtn.setOnClickListener(this);
        namep1.setOnClickListener(this);
        namep2.setOnClickListener(this);
        O_TV.setOnClickListener(this);
        X_TV.setOnClickListener(this);
        p1Icon.setOnClickListener(this);
        p2Icon.setOnClickListener(this);


        dialog= new Dialog(this);
        dialog2= new Dialog(this);
        alert_dialog=new Dialog(this);
        notice_dialog=new Dialog(this);
        notice();

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                setPause1();
                setPause2();
                if(for_name_change>0||sp>0||fp>0) alert(2);
                else{
                    Intent intent =new Intent(MainActivity.this,Start_Page.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {




        if(R.id.txID1==view.getId()&&one==0){


            for_name_change++;
            finishBtn_nameChange();
            c++;
            one=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b1.setText(O);
                b1.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b1.setText(X);
                b1.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(1,1);
        }

        if(R.id.txID2==view.getId()&&two==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            two=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b2.setText(O);
                b2.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b2.setText(X);
                b2.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(1,2);
        }

        if(R.id.txID3==view.getId()&&three==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            three=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b3.setText(O);
                b3.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b3.setText(X);
                b3.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(1,3);
        }

        if(R.id.txID4==view.getId()&&fourr==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            fourr=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b4.setText(O);
                b4.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b4.setText(X);
                b4.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(2,1);
        }

        if(R.id.txID5==view.getId()&&five==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            five=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b5.setText(O);
                b5.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b5.setText(X);
                b5.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(2,2);
        }

        if(R.id.txID6==view.getId()&&six==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            six=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b6.setText(O);
                b6.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b6.setText(X);
                b6.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(2,3);
        }

        if(R.id.txID7==view.getId()&&seven==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            seven=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b7.setText(O);
                b7.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b7.setText(X);
                b7.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(3,1);
        }

        if(R.id.txID8==view.getId()&&eight==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            eight=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b8.setText(O);
                b8.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b8.setText(X);
                b8.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(3,2);
        }

        if(R.id.txID9==view.getId()&&nine==0){
            for_name_change++;
            finishBtn_nameChange();
            c++;
            nine=1;
            if(c%2==1){
                setP2time();
                setPause1();
                b9.setText(O);
                b9.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            else {
                setP1time();
                setPause2();
                b9.setText(X);
                b9.setTextColor(Color.parseColor(X_color));
                player1color();

            }

            calculation(3,3);
        }
        if(R.id.restart_buttonID==view.getId()){

            if(for_name_change%9!=0){
                setPause2();
                setPause1();

                alert(1);


            }
            else{
                Toast toast= Toast.makeText(MainActivity.this,"Start a match first",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }


        }

        if(R.id.newgamebuttonID==view.getId()){

            setPause1();
            setPause2();

           if(p1time>0||p2time>0) alert(2);
           else{
               Intent intent =new Intent(MainActivity.this,Start_Page.class);
               startActivity(intent);
               finish();
           }

        }

        if(view.getId()==R.id.nameP1||view.getId()==R.id.nameP2||view.getId()==R.id.Oid||view.getId()==R.id.Xid||view.getId()==R.id.player1IconId||view.getId()==R.id.player2_iconId){
            if(for_name_change%9==0&&drw==0&&fp==0&&sp==0){
                setname();
            }
            else{
                Toast.makeText(MainActivity.this,"Finish the Game to change names",Toast.LENGTH_LONG).show();
            }

        }
    }

    public void calculation(int x,int y){

        if(c%2==1){

            if(x==1) x1++;
            if(x==2) x2++;
            if(x==3) x3++;
            if(y==1) y1++;
            if(y==2) y2++;
            if(y==3) y3++;
            if(x==y) equ++;
            if(x+y==4) four++;

            if(x1==3||x2==3||x3==3||y1==3||y2==3||y3==3||equ==3||four==3){
                fp++;
                p1.setText(""+fp);


                setPause1();
                setPause2();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        congratulations(player1name);
                    }
                },400);
                one=1;two=1;three=1;fourr=1;five=1;six=1;seven=1;eight=1;nine=1;
            }
            else if((k%2==0&&c==9)||(k%2==1&&c==10)){
                drw++;
                c=0;
                draw();

            }

            if(x1==3) allGreen(1);
           else if(x2==3) allGreen(2);
           else if(x3==3) allGreen(3);
           else if(y1==3) allGreen(4);
           else if(y2==3) allGreen(5);
           else if(y3==3) allGreen(6);
           else if(equ==3) allGreen(7);
           else if(four==3) allGreen(8);
        }
        else{
            if(x==1) x11++;
            if(x==2) x22++;
            if(x==3) x33++;
            if(y==1) y11++;
            if(y==2) y22++;
            if(y==3) y33++;
            if(x==y) equ1++;
            if(x+y==4) four1++;


            if(x11==3||x22==3||x33==3||y11==3||y22==3||y33==3||equ1==3||four1==3){

                sp++;
                p2.setText(""+sp);
                setPause1();
                setPause2();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        congratulations(player2name);
                    }
                },400);


                one=1;two=1;three=1;fourr=1;five=1;six=1;seven=1;eight=1;nine=1;

            }
            else if((k%2==0&&c==9)||(k%2==1&&c==10)){
                drw++;
                c=0;
                draw();

            }

            if(x11==3) allGreen(1);
            else if(x22==3) allGreen(2);
            else if(x33==3) allGreen(3);
            else if(y11==3) allGreen(4);
            else if(y22==3) allGreen(5);
            else if(y33==3) allGreen(6);
            else if(equ1==3) allGreen(7);
            else if(four1==3) allGreen(8);

        }


    }

    public void allempty(){
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }


    public void allGreen(int a){

        String green="#009600";

        if(a==1){
            b1.setTextColor(Color.parseColor(green));
            b2.setTextColor(Color.parseColor(green));
            b3.setTextColor(Color.parseColor(green));
            b1.setBackgroundResource(R.drawable.rectangle_shap3);
            b2.setBackgroundResource(R.drawable.rectangle_shap3);
            b3.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==2){
            b4.setTextColor(Color.parseColor(green));
            b5.setTextColor(Color.parseColor(green));
            b6.setTextColor(Color.parseColor(green));
            b4.setBackgroundResource(R.drawable.rectangle_shap3);
            b5.setBackgroundResource(R.drawable.rectangle_shap3);
            b6.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==3){
            b7.setTextColor(Color.parseColor(green));
            b8.setTextColor(Color.parseColor(green));
            b9.setTextColor(Color.parseColor(green));
            b7.setBackgroundResource(R.drawable.rectangle_shap3);
            b8.setBackgroundResource(R.drawable.rectangle_shap3);
            b9.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==4){
            b1.setTextColor(Color.parseColor(green));
            b4.setTextColor(Color.parseColor(green));
            b7.setTextColor(Color.parseColor(green));
            b1.setBackgroundResource(R.drawable.rectangle_shap3);
            b4.setBackgroundResource(R.drawable.rectangle_shap3);
            b7.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==5){
            b2.setTextColor(Color.parseColor(green));
            b5.setTextColor(Color.parseColor(green));
            b8.setTextColor(Color.parseColor(green));
            b2.setBackgroundResource(R.drawable.rectangle_shap3);
            b5.setBackgroundResource(R.drawable.rectangle_shap3);
            b8.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==6){
            b3.setTextColor(Color.parseColor(green));
            b6.setTextColor(Color.parseColor(green));
            b9.setTextColor(Color.parseColor(green));
            b3.setBackgroundResource(R.drawable.rectangle_shap3);
            b6.setBackgroundResource(R.drawable.rectangle_shap3);
            b9.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==7){
            b1.setTextColor(Color.parseColor(green));
            b5.setTextColor(Color.parseColor(green));
            b9.setTextColor(Color.parseColor(green));
            b1.setBackgroundResource(R.drawable.rectangle_shap3);
            b5.setBackgroundResource(R.drawable.rectangle_shap3);
            b9.setBackgroundResource(R.drawable.rectangle_shap3);
        }
        if(a==8){
            b3.setTextColor(Color.parseColor(green));
            b5.setTextColor(Color.parseColor(green));
            b7.setTextColor(Color.parseColor(green));
            b3.setBackgroundResource(R.drawable.rectangle_shap3);
            b7.setBackgroundResource(R.drawable.rectangle_shap3);
            b5.setBackgroundResource(R.drawable.rectangle_shap3);
        }
    }

    public  void  allWhite(){

        b1.setBackgroundResource(R.drawable.rectangle_shap2);
        b2.setBackgroundResource(R.drawable.rectangle_shap2);
        b3.setBackgroundResource(R.drawable.rectangle_shap2);
        b4.setBackgroundResource(R.drawable.rectangle_shap2);
        b5.setBackgroundResource(R.drawable.rectangle_shap2);
        b6.setBackgroundResource(R.drawable.rectangle_shap2);
        b7.setBackgroundResource(R.drawable.rectangle_shap2);
        b8.setBackgroundResource(R.drawable.rectangle_shap2);
        b9.setBackgroundResource(R.drawable.rectangle_shap2);

    }

    public void congratulations(String a){
        p1lastMatchTime=p1time;
        p2lastMatchTime=p2time;

        Intent intent=new Intent(MainActivity.this,Congratulation_Activity.class);

        intent.putExtra("congass_message",a+" wins the match");

        intent.putExtra("Congrass_title","Congratulations!");

        intent.putExtra("for_icon","1");
        intent.putExtra("where","OK");
        intent.putExtra("p1point",fp);
        intent.putExtra("p2point",sp);
        intent.putExtra("p1time",p1time);
        intent.putExtra("p2time",p2time);
        intent.putExtra("p1name",player1name);
        intent.putExtra("p2name",player2name);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                restart();
            }
        },1000);



    }

    public void draw(){
        p1lastMatchTime=p1time;
        p2lastMatchTime=p2time;
        setPause1();
        setPause2();
        Intent intent=new Intent(MainActivity.this,Congratulation_Activity.class);

        intent.putExtra("congass_message","You are both intelligent competitors");

        intent.putExtra("Congrass_title","Draw!");

        intent.putExtra("for_icon","2");
        intent.putExtra("where","OK");
        intent.putExtra("p1point",fp);
        intent.putExtra("p2point",sp);
        intent.putExtra("p1time",p1time);
        intent.putExtra("p2time",p2time);
        intent.putExtra("p1name",player1name);
        intent.putExtra("p2name",player2name);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                restart();
            }
        },1000);



    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void restart(){
        p1timeView.setText(String.format("%.2f",p1lastMatchTime/1000));
        p2timeView.setText(String.format("%.2f",p2lastMatchTime/1000));
        timeSwapBuff1=p1lastMatchTime;
        timeSwapBuff2=p2lastMatchTime;
        p1time=0;p2time=0;timeMilli1=0;timeMilli2=0;




        for_name_change=9;
        k++;

        if(k%2==0) {
            namep2.setTextColor(Color.parseColor(darkGreen));
            p2Icon.setBackgroundColor(Color.parseColor(darkGreen));
            namep1.setTextColor(Color.parseColor(lightGreen));
            p1Icon.setBackgroundColor(Color.parseColor(lightGreen));
            c=0;
        }
        else {
            namep2.setTextColor(Color.parseColor(lightGreen));
            p2Icon.setBackgroundColor(Color.parseColor(lightGreen));
            namep1.setTextColor(Color.parseColor(darkGreen));
            p1Icon.setBackgroundColor(Color.parseColor(darkGreen));


            c=1;
        }

        allempty();
        allWhite();
        x1=0;x2=0;x3=0;y1=0;y2=0;y3=0;four=0;equ=0;
        x11=0;x22=0;x33=0;y11=0;y22=0;y33=0;four1=0;equ1=0;one=0;two=0;three=0;fourr=0;five=0;six=0;seven=0;eight=0;nine=0;
    }

    public void notice(){
        notice_dialog.setContentView(R.layout.custom_alert_dialog_rule);
        play_nowBtn=notice_dialog.findViewById(R.id.playNowId);
        setNameBtn=notice_dialog.findViewById(R.id.setNameID);
        play_nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_dialog.dismiss();
            }
        });

        setNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setname();
                notice_dialog.dismiss();
            }
        });

        notice_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        notice_dialog.show();
    }


    public void player1color(){
        namep2.setTextColor(Color.parseColor(darkGreen));
        p2Icon.setBackgroundColor(Color.parseColor(darkGreen));
        namep1.setTextColor(Color.parseColor(lightGreen));
        p1Icon.setBackgroundColor(Color.parseColor(lightGreen));
    }

    public void player2color(){
        namep2.setTextColor(Color.parseColor(lightGreen));
        p2Icon.setBackgroundColor(Color.parseColor(lightGreen));
        namep1.setTextColor(Color.parseColor(darkGreen));
        p1Icon.setBackgroundColor(Color.parseColor(darkGreen));
    }

    public  void congratulationsGame(int a){
        Intent intent=new Intent(MainActivity.this,Congratulation_Activity.class);
        if(a==1){
            intent.putExtra("congass_message",player1name+" wins the game");
            intent.putExtra("Congrass_title","Congrats "+player1name);
        }
        if(a==2){
            intent.putExtra("congass_message",player2name+" wins the game");
            intent.putExtra("Congrass_title","Congrats "+player2name);
        }
        if(a==11){
            intent.putExtra("congass_message",player1name+" wins the game by time");
            intent.putExtra("Congrass_title","Congrats "+player1name);
        }
        if(a==22){
            intent.putExtra("congass_message",player2name+" wins the game by time");
            intent.putExtra("Congrass_title","Congrats "+player2name);
        }


        intent.putExtra("for_icon","3");
        intent.putExtra("where","OK");
        intent.putExtra("p1point",0);
        intent.putExtra("p2point",0);
        intent.putExtra("p1time",0);
        intent.putExtra("p2time",0);
        intent.putExtra("p1name",player1name);
        intent.putExtra("p2name",player2name);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                restart();
                p1.setText("0");
                p2.setText("0");
                p1timeView.setText("0:00");
                p2timeView.setText("0:00");
            }
        },1000);


    }


    public void setname(){
        dialog.setContentView(R.layout.mainpopup);
        pl1Edittx=dialog.findViewById(R.id.plr1Id);
        pl1Edittx.setText(player1name);
        pl2Edittx=dialog.findViewById(R.id.plr2Id);
        pl2Edittx.setText(player2name);
        saveBtn=dialog.findViewById(R.id.savebtnID);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player1name=pl1Edittx.getText().toString();
                    player2name=pl2Edittx.getText().toString();
                    if(player1name.isEmpty() || player2name.isEmpty()||player1name.trim().isEmpty()||player2name.trim().isEmpty()){
                        Toast.makeText(MainActivity.this,"Please, fill up",Toast.LENGTH_LONG).show();
                    }
                    else if(player1name.length()>8||player2name.length()>8){
                        Toast.makeText(MainActivity.this,"Please, set name within 8 characters",Toast.LENGTH_LONG).show();
                    }
                    else if(player1name.equals(player2name)){
                        Toast.makeText(MainActivity.this,"Please, Set unique names",Toast.LENGTH_LONG).show();
                    }

                    else{
                        namep1.setText(player1name);
                        namep2.setText(player2name);
                        pl1Edittx.setText(player1name, TextView.BufferType.EDITABLE);
                        pl2Edittx.setText(player2name, TextView.BufferType.EDITABLE);
                        setChar();
                        dialog.dismiss();
                    }


                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Something Wrong"+e,Toast.LENGTH_LONG).show();
                }
            }


        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public void setChar(){
        if(!player1name.isEmpty() && !player2name.isEmpty()){
             ooo=player1name.charAt(0);
             xxx=player2name.charAt(0);
             O=String.valueOf(ooo);
            O=O.toUpperCase();
             X=String.valueOf(xxx);
            X=X.toUpperCase();
            if(((ooo>='a'&&ooo<='z')||(ooo>='A'&&ooo<='Z'))&&((xxx>='a'&&xxx<='z')||(xxx>='A'&&xxx<='Z'))&&ooo!=xxx){
              setOvsX();
               /* O_TV.setText(O);
                X_TV.setText(X);*/
            }
            else{
                O="O";
                X="X";
                O_TV.setText(O);
                X_TV.setText(X);
            }
        }

    }

    public void setP1time(){
         startTime1= SystemClock.uptimeMillis();
         customHandler1.postDelayed(runnable1,0);
    }
    Runnable runnable1 =new Runnable() {
        @SuppressLint("DefaultLocale")
        @Override
        public void run() {
            timeMilli1= SystemClock.uptimeMillis()-startTime1;
            p1time=timeSwapBuff1+timeMilli1;


            p1timeView.setText(String.format("%.2f",p1time/1000));

            customHandler1.postDelayed(runnable1,0);
        }
    };

    public void setPause1(){
        timeSwapBuff1+=timeMilli1;
        customHandler1.removeCallbacks(runnable1);
    }


    public void setP2time(){
         startTime2= SystemClock.uptimeMillis();
         customHandler2.postDelayed(runnable2,0);
    }
    Runnable runnable2 =new Runnable() {
        @SuppressLint("DefaultLocale")
        @Override
        public void run() {
            timeMilli2= SystemClock.uptimeMillis()-startTime2;
            p2time=timeSwapBuff2+timeMilli2;

            p2timeView.setText(String.format("%.2f",p2time/1000));

            customHandler2.postDelayed(runnable2,0);
        }
    };

    public void setPause2(){
        timeSwapBuff2+=timeMilli2;
        customHandler2.removeCallbacks(runnable2);
    }
public void alert(int a){
        alert_dialog.setContentView(R.layout.custom_alert_dialog);
        alertDialog_title=alert_dialog.findViewById(R.id.alertTitleId);
        alertDialog_message=alert_dialog.findViewById(R.id.alertMessageId);
        yesBtn=alert_dialog.findViewById(R.id.yesbtnID);
        noBtn=alert_dialog.findViewById(R.id.nobtnID);
        alert_dialog.setCancelable(false);
        if(a==1){
            alertDialog_title.setText("Restart?");
            alertDialog_message.setText("Are you sure to restart?");
        }
        else{
            alertDialog_title.setText("Finish?");
            alertDialog_message.setText("Are you sure to finish the game?");
            yesBtn.setText("Finish");
        }

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a==2) yes_for_newgame();
                else restart();
                alert_dialog.dismiss();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    if(c%2==1){
                        setP2time();
                        setPause1();
                    }
                    else{
                        setP1time();
                        setPause2();
                    }
                }
                alert_dialog.dismiss();
            }
        });
    alert_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    alert_dialog.show();
}


    public void yes_for_newgame(){
        newgameBtn.setText("Take me home");

        for_name_change=0;
        if(sp==0&&fp==0&&drw>0){
            if(p1time<p2time){
                congratulationsGame(11);
            }
            else congratulationsGame(22);
            drw=0;
        }

        else if(fp>0||sp>0){
            if(fp>sp) congratulationsGame(1);
            else if(fp<sp) congratulationsGame(2);
            else {
                if(p1time<p2time){
                    congratulationsGame(11);
                }
                else congratulationsGame(22);
            }
        }
        else{
            p1.setText("0");
            p2.setText("0");
            p1timeView.setText("0:00");
            p2timeView.setText("0:00");
        }




        allempty();
        allWhite();
        fp=0;
        sp=0;
        namep2.setTextColor(Color.parseColor(darkGreen));
        p2Icon.setBackgroundColor(Color.parseColor(darkGreen));
        namep1.setTextColor(Color.parseColor(lightGreen));
        p1Icon.setBackgroundColor(Color.parseColor(lightGreen));
        p1time=0;p2time=0;startTime1=0;updateTime1=0;timeMilli1=0;timeSwapBuff1=0;startTime2=0;updateTime2=0;timeMilli2=0;timeSwapBuff2=0;
        x1=0;x2=0;x3=0;y1=0;y2=0;y3=0;four=0;equ=0;one=0;two=0;three=0;fourr=0;five=0;six=0;seven=0;eight=0;nine=0;
        x11=0;x22=0;x33=0;y11=0;y22=0;y33=0;four1=0;equ1=0;one=0;two=0;three=0;fourr=0;five=0;six=0;seven=0;eight=0;nine=0;k=0;c=0;
    }

    public void setOvsX(){

            dialog2.setContentView(R.layout.ckeckoption);
           radioGroup=dialog2.findViewById(R.id.radiogoupId);
            radioButton1=dialog2.findViewById(R.id.ovsxId);
            radioButton2=dialog2.findViewById(R.id.cvscId);
            radioButton2.setText(O+" vs "+X );
            Button submitbtn=dialog2.findViewById(R.id.submitOptionId);
            submitbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(radioButton1.isChecked()){
                        O="O";
                        X="X";
                        O_TV.setText(O);
                        X_TV.setText(X);
                    }
                    if(radioButton2.isChecked()){
                        O_TV.setText(O);
                        X_TV.setText(X);
                    }
                    dialog2.dismiss();
                }
            });



                 /*    if(radioButton.getText().toString().equals("O vs X")){
                O="O";
                X="X";
                O_TV.setText(O);
                X_TV.setText(X);
            }
            else{
                O_TV.setText(O);
                X_TV.setText(X);
            }*/
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog2.show();


    }

    public void finishBtn_nameChange(){
        if(for_name_change>0||sp>0||fp>0) newgameBtn.setText("Finish Game");
        else{

            newgameBtn.setText("Take me home");
        }
    }

}