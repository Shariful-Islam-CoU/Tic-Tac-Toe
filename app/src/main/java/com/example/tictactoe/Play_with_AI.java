package com.example.tictactoe;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
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

import java.util.Random;

public class Play_with_AI extends AppCompatActivity implements View.OnClickListener {


    private TextView b1,b2,b3,b4,b5,b6,b7,b8,b9,p1,p2,namep1,namep2,O_TV,X_TV,alertDialog_title,alertDialog_message;
    public int x1=0,x2=0,x3=0,y1=0,y2=0,y3=0,four=0,equ=0,one=0,two=0,three=0,fourr=0,five=0,six=0,seven=0,eight=0,nine=0;
    public   int x11=0,x22=0,x33=0,y11=0,y22=0,y33=0,four1=0,equ1=0,fp=0,sp=0,k=0,for_name_change=0,drw=0,clicked=0;
    private Button button,newgameBtn,saveBtn,yesBtn,noBtn;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2;
    private EditText pl1Edittx,pl2Edittx;
    private Dialog dialog, dialog2,alert_dialog;
    private String lightGreen="#FF5567",O_color="#FF5567",X_color="#3882E4",darkGreen="#FDA3AC",ss,player1name="Player 1",player2name="AI";
    private String O="O",X="X";
    private Handler customHandler1= new Handler();
    private Handler customHandler2= new Handler();
    private ImageView p1Icon,aiIcon;
    private double lastTimeClicked=0;

    private AlertDialog.Builder alertDialogBuilder,alertDialogBuilder1,alertDialogBuilder2,alertDialogBuilder3,alertDialogBuilder4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_play_with_ai);
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
        p1Icon=findViewById(R.id.player1IconId);
        aiIcon=findViewById(R.id.ai_iconId);
        namep1=findViewById(R.id.nameP1);
        namep2=findViewById(R.id.nameP2);
        button=findViewById(R.id.buttonID);
        newgameBtn=findViewById(R.id.newgamebuttonID);




        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        button.setOnClickListener(this);
        newgameBtn.setOnClickListener(this);
        namep1.setOnClickListener(this);
        O_TV.setOnClickListener(this);
        p1Icon.setOnClickListener(this);



        dialog= new Dialog(this);
        dialog2= new Dialog(this);
        alert_dialog= new Dialog(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                if(for_name_change>0||sp>0||fp>0) alert(2);
                else{
                    Intent intent =new Intent(Play_with_AI.this,Start_Page.class);
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



        if (SystemClock.elapsedRealtime() - lastTimeClicked <= 400) {
            return;
        }
        lastTimeClicked = SystemClock.elapsedRealtime();


        if(R.id.txID1==view.getId()&&one==0){

            for_name_change++;
            finishBtn_nameChange();
            
            one=1;
            {

                b1.setText(O);
                b1.setTextColor(Color.parseColor(O_color));
                player2color();
            }
            


            clicked++;
            not_clickable();
           if(calculation(1,1)==0) taketime();

        }

        else if(R.id.txID2==view.getId()&&two==0){
            for_name_change++;
            finishBtn_nameChange();
            
            two=1;
            {
                b2.setText(O);
                b2.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(1,2)==0) taketime();

        }

       else  if(R.id.txID3==view.getId()&&three==0){
            for_name_change++;
            finishBtn_nameChange();
            
            three=1;
            {
                b3.setText(O);
                b3.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(1,3)==0) taketime();

        }

       else if(R.id.txID4==view.getId()&&fourr==0){
            for_name_change++;
            finishBtn_nameChange();
            
            fourr=1;
            {
                b4.setText(O);
                b4.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(2,1)==0) taketime();

        }

        else if(R.id.txID5==view.getId()&&five==0){
            for_name_change++;
            finishBtn_nameChange();
            
            five=1;
            {
                b5.setText(O);
                b5.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(2,2)==0) taketime();

        }

      else   if(R.id.txID6==view.getId()&&six==0){
            for_name_change++;
            finishBtn_nameChange();
            
            six=1;
            {
                b6.setText(O);
                b6.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(2,3)==0) taketime();

        }

       else  if(R.id.txID7==view.getId()&&seven==0){
            for_name_change++;
            finishBtn_nameChange();
            
            seven=1;
            {
                b7.setText(O);
                b7.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(3,1)==0) taketime();

        }

      else   if(R.id.txID8==view.getId()&&eight==0){
            for_name_change++;
            finishBtn_nameChange();
            
            eight=1;
            {
                b8.setText(O);
                b8.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(3,2)==0) taketime();

        }

       else  if(R.id.txID9==view.getId()&&nine==0){
            for_name_change++;
            finishBtn_nameChange();
            
            nine=1;
            {
                b9.setText(O);
                b9.setTextColor(Color.parseColor(O_color));
                player2color();
            }



            clicked++;
            not_clickable();
            if(calculation(3,3)==0) taketime();

        }
        if(R.id.buttonID==view.getId()){

            if(for_name_change>0){
                alert(1);
            }
            else{
                Toast toast= Toast.makeText(Play_with_AI.this,"Start a match first",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }

        }

        if(R.id.newgamebuttonID==view.getId()){

            if(for_name_change>0||sp>0||fp>0) alert(2);
            else{
                Intent intent =new Intent(Play_with_AI.this,Start_Page.class);
                startActivity(intent);
                finish();
            }

        }

        if(view.getId()==R.id.nameP1||view.getId()==R.id.Oid||view.getId()==R.id.player1IconId){
            if(for_name_change==0){
                setname();
            }
            else{
                Toast.makeText(Play_with_AI.this,"Finish the game to set name",Toast.LENGTH_LONG).show();
            }

        }

    }


    public  void ai_play(){

        if(clicked==1){
            if(five==0){
                five=1;
                x22++;y22++;four1++;equ1++;
                b5.setText(X);
                b5.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else{

                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b>=0&&b<=2){
                    x11++;y11++; equ1++;
                    one=1;
                    b1.setText(X);
                    b1.setTextColor(Color.parseColor(X_color));
                    player1color();
                }
                else if(b>=3&&b<=4){
                    three=1;x11++;y33++;four1++;
                    b3.setText(X);
                    b3.setTextColor(Color.parseColor(X_color));
                    player1color();
                }
                else if(b>=5&&b<=6){
                    seven=1;x33++;y11++;four1++;
                    b7.setText(X);
                    b7.setTextColor(Color.parseColor(X_color));
                    player1color();
                }
                else{
                    nine=1;x33++;y33++;equ1++;
                    b9.setText(X);
                    b9.setTextColor(Color.parseColor(X_color));
                    player1color();
                }


            }
            
        }
        else{

            if(one==0&&cal2(1,1)==1){
                one=1;
                b1.setText(X);
                b1.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x11==3) allGreen(1);
                if(y11==3) allGreen(4);
                if(equ1==3) allGreen(7);
                taketime2();
            }
            else if(two==0&&cal2(1,2)==1){
                two=1;
                b2.setText(X);
                b2.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x11==3) allGreen(1);
                if(y22==3) allGreen(5);
                taketime2();
            }
            else if(three==0&&cal2(1,3)==1){
                three=1;
                b3.setText(X);
                b3.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x11==3) allGreen(1);
                if(y33==3) allGreen(6);
                if(four1==3) allGreen(8);
                taketime2();
            }
            else if(fourr==0&&cal2(2,1)==1){
                fourr=1;
                b4.setText(X);
                b4.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x22==3) allGreen(2);
                if(y11==3) allGreen(4);
                taketime2();
            }
            else if(five==0&&cal2(2,2)==1){
                five=1;
                b5.setText(X);
                b5.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x22==3) allGreen(2);
                if(y22==3) allGreen(5);
                if(equ1==3) allGreen(7);
                if(four1==3) allGreen(8);
                taketime2();
            }
            else if(six==0&&cal2(2,3)==1){
                six=1;
                b6.setText(X);
                b6.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x22==3) allGreen(2);
                if(y33==3) allGreen(6);
                taketime2();
            }
            else if(seven==0&&cal2(3,1)==1){
                seven=1;
                b7.setText(X);
                b7.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x33==3) allGreen(3);
                if(y11==3) allGreen(4);
                if(four1==3) allGreen(8);
                taketime2();
            }
            else if(eight==0&&cal2(3,2)==1){
                eight=1;
                b8.setText(X);
                b8.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x33==3) allGreen(3);
                if(y22==3) allGreen(5);
                taketime2();
            }
            else if(nine==0&&cal2(3,3)==1){
                nine=1;
                b9.setText(X);
                b9.setTextColor(Color.parseColor(X_color));
                player1color();
                if(x33==3) allGreen(3);
                if(y33==3) allGreen(6);
                if(equ1==3) allGreen(7);
                taketime2();
            }


            else if(one==0&&cal(1,1)==1){
                one=1;x11++;y11++;equ1++;
                b1.setText(X);
                b1.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(two==0&&cal(1,2)==1){
                two=1;x11++;y22++;
                b2.setText(X);
                b2.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(three==0&&cal(1,3)==1){
                three=1;x11++;y33++;four1++;
                b3.setText(X);
                b3.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(fourr==0&&cal(2,1)==1){
                fourr=1;x22++;y11++;
                b4.setText(X);
                b4.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(five==0&&cal(2,2)==1){
                five=1;x22++;y22++;equ1++;four1++;
                b5.setText(X);
                b5.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(six==0&&cal(2,3)==1){
                six=1;x22++;y33++;
                b6.setText(X);
                b6.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(seven==0&&cal(3,1)==1){
                seven=1;x33++;y11++;four1++;
                b7.setText(X);
                b7.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(eight==0&&cal(3,2)==1){
                eight=1;x33++;y22++;
                b8.setText(X);
                b8.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(nine==0&&cal(3,3)==1){
                nine=1;x33++;y33++;equ1++;
                b9.setText(X);
                b9.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(seven==0&&x11==1&&y11==1&&x2==1&&y2==1&&x3==1&&y3==1){

                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b%3!=0){
                    if(three==0){
                        three=1;x11++;y33++;four1++;
                        b3.setText(X);
                        b3.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else{
                        seven=1;x33++;y11++;four1++;
                        b7.setText(X);
                        b7.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }
                else{
                    if(one==1||three==1){
                        if(two==0){
                            two=1;x11++;y22++;
                            b2.setText(X);
                            b2.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                        else if(eight==0){
                            eight=1;x33++;y22++;
                            b8.setText(X);
                            b8.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                        else if(six==0){
                            six=1;x22++;y33++;
                            b6.setText(X);
                            b6.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }

                        else if(fourr==0){
                            fourr=1;x22++;y11++;
                            b4.setText(X);
                            b4.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                    }


                }


            }
            else if(nine==0&&x11==1&&y33==1&&x2==1&&y2==1&&x3==1&&y1==1){

                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b%3!=0){
                    if(one==0){
                        one=1;x11++;y11++;equ1++;
                        b1.setText(X);
                        b1.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else{
                        nine=1;x33++;y33++;equ1++;
                        b9.setText(X);
                        b9.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }
                else{
                    if(seven==1||nine==1){
                        if(eight==0){
                            eight=1;x33++;y22++;
                            b8.setText(X);
                            b8.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }


                        else if(six==0){
                            six=1;x22++;y33++;
                            b6.setText(X);
                            b6.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }

                        else if(fourr==0){
                            fourr=1;x22++;y11++;
                            b4.setText(X);
                            b4.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                        else if(two==0){
                            two=1;x11++;y22++;
                            b2.setText(X);
                            b2.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                    }


                }


            }
            else if(nine==0&&x33==1&&y11==1&&x2==1&&y2==1&&x1==1&&y3==1){

                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b%3!=0){
                    if(one==0){
                        one=1;x11++;y11++;equ1++;
                        b1.setText(X);
                        b1.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else{
                        nine=1;x33++;y33++;equ1++;
                        b9.setText(X);
                        b9.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }
                else{
                    if(seven==1||nine==1){
                        if(eight==0){
                            eight=1;x33++;y22++;
                            b8.setText(X);
                            b8.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }


                        else if(six==0){
                            six=1;x22++;y33++;
                            b6.setText(X);
                            b6.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }

                        else if(fourr==0){
                            fourr=1;x22++;y11++;
                            b4.setText(X);
                            b4.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                        else if(two==0){
                            two=1;x11++;y22++;
                            b2.setText(X);
                            b2.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                    }


                }


            }
            else if(seven==0&&x33==1&&y33==1&&x2==1&&y2==1&&x1==1&&y1==1){
                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b%3!=0){
                    if(three==0){
                        three=1;x11++;y33++;four1++;
                        b3.setText(X);
                        b3.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else{
                        seven=1;x33++;y11++;four1++;
                        b7.setText(X);
                        b7.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }
                else{
                    if(one==1||three==1){
                        if(two==0){
                            two=1;x11++;y22++;
                            b2.setText(X);
                            b2.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                        else if(eight==0){
                            eight=1;x33++;y22++;
                            b8.setText(X);
                            b8.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                        else if(six==0){
                            six=1;x22++;y33++;
                            b6.setText(X);
                            b6.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }

                        else if(fourr==0){
                            fourr=1;x22++;y11++;
                            b4.setText(X);
                            b4.setTextColor(Color.parseColor(X_color));
                            player1color();
                        }
                    }


                }
            }
            else if((one==1&&nine==1&&x1==1&&y1==1&&x3==1&&y3==1)){

                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b%3==0){
                    if(three==0){
                        three=1;x11++;y33++;four1++;
                        b3.setText(X);
                        b3.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else{
                        seven=1;x33++;y11++;four1++;
                        b7.setText(X);
                        b7.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }
                else{
                    if(six==0){
                        six=1;x22++;y33++;
                        b6.setText(X);
                        b6.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }

                    else if(fourr==0){
                        fourr=1;x22++;y11++;
                        b4.setText(X);
                        b4.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else if(two==0){
                        two=1;x11++;y22++;
                        b2.setText(X);
                        b2.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else if(eight==0){
                        eight=1;x33++;y22++;
                        b8.setText(X);
                        b8.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }


            }
            else if(((three==1&&seven==1&&x1==1&&y1==1&&x3==1&&y3==1))){

                Random random= new Random();
                int d= random.nextInt();
                if(d<0) d=d*(-1);
                int b=d%10;

                if(b%3==0){
                    if(one==0){
                        one=1;x11++;y11++;equ1++;
                        b1.setText(X);
                        b1.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else{
                        nine=1;x33++;y33++;equ1++;
                        b9.setText(X);
                        b9.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }
                else{
                    if(six==0){
                        six=1;x22++;y33++;
                        b6.setText(X);
                        b6.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }

                    else if(fourr==0){
                        fourr=1;x22++;y11++;
                        b4.setText(X);
                        b4.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else if(two==0){
                        two=1;x11++;y22++;
                        b2.setText(X);
                        b2.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                    else if(eight==0){
                        eight=1;x33++;y22++;
                        b8.setText(X);
                        b8.setTextColor(Color.parseColor(X_color));
                        player1color();
                    }
                }

            }
            else if(one==0&&x1>=1&&y1>=1){
                one=1;x11++;y11++;equ1++;
                b1.setText(X);
                b1.setTextColor(Color.parseColor(X_color));
                player1color();
            }

            else if(three==0&&x1>=1&&y3>=1){
                three=1;x11++;y33++;four1++;
                b3.setText(X);
                b3.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(seven==0&&x3>=1&&y1>=1){
                seven=1;x33++;y11++;four1++;
                b7.setText(X);
                b7.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(nine==0&&x3>=1&&y3>=1){
                nine=1;x33++;y33++;equ1++;
                b9.setText(X);
                b9.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(two==0){
                two=1;x11++;y22++;
                b2.setText(X);
                b2.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(fourr==0){
                fourr=1;x22++;y11++;
                b4.setText(X);
                b4.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(six==0){
                six=1;x22++;y33++;
                b6.setText(X);
                b6.setTextColor(Color.parseColor(X_color));
                player1color();
            }
            else if(eight==0){
                eight=1;x33++;y22++;
                b8.setText(X);
                b8.setTextColor(Color.parseColor(X_color));
                player1color();
            }


        }

        if(clicked==5){
            draw();
        }

    }

    public int cal(int x,int y){
        if(x==1) x1++;
        if(x==2) x2++;
        if(x==3) x3++;
        if(y==1) y1++;
        if(y==2) y2++;
        if(y==3) y3++;
        if(x==y) equ++;
        if(x+y==4) four++;



        if(x1==3||x2==3||x3==3||y1==3||y2==3||y3==3||equ==3||four==3){
            if(x==1) x1--;
            if(x==2) x2--;
            if(x==3) x3--;
            if(y==1) y1--;
            if(y==2) y2--;
            if(y==3) y3--;
            if(x==y) equ--;
            if(x+y==4) four--;
            return 1;

        }else{
            if(x==1) x1--;
            if(x==2) x2--;
            if(x==3) x3--;
            if(y==1) y1--;
            if(y==2) y2--;
            if(y==3) y3--;
            if(x==y) equ--;
            if(x+y==4) four--;
            return  0;
        }

    }

    public int cal2(int x,int y){
        if(x==1) x11++;
        if(x==2) x22++;
        if(x==3) x33++;
        if(y==1) y11++;
        if(y==2) y22++;
        if(y==3) y33++;
        if(x==y) equ1++;
        if(x+y==4) four1++;



        if(x11==3||x22==3||x33==3||y11==3||y22==3||y33==3||equ1==3||four1==3){
            return 1;

        }else{
            if(x==1) x11--;
            if(x==2) x22--;
            if(x==3) x33--;
            if(y==1) y11--;
            if(y==2) y22--;
            if(y==3) y33--;
            if(x==y) equ1--;
            if(x+y==4) four1--;
            return  0;

        }

    }
    public int calculation(int x,int y){

        {

            if(x==1) x1++;
            if(x==2) x2++;
            if(x==3) x3++;
            if(y==1) y1++;
            if(y==2) y2++;
            if(y==3) y3++;
            if(x==y) equ++;
            if(x+y==4) four++;

            if(x1==3) allGreen(1);
            else if(x2==3) allGreen(2);
            else if(x3==3) allGreen(3);
            else if(y1==3) allGreen(4);
            else if(y2==3) allGreen(5);
            else if(y3==3) allGreen(6);
            else if(equ==3) allGreen(7);
            else if(four==3) allGreen(8);

            if(x1==3||x2==3||x3==3||y1==3||y2==3||y3==3||equ==3||four==3){

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        congratulations(player1name);
                    }
                },400);


                one=1;two=1;three=1;fourr=1;five=1;six=1;seven=1;eight=1;nine=1;
                return 1;
            }
            else return 0;



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

        if(a=="AI"){

            sp++;
            p2.setText(""+sp);
            one=1;two=1;three=1;fourr=1;five=1;six=1;seven=1;eight=1;nine=1;
        }
        else{
            fp++;
            p1.setText(""+fp);
        }

        Intent intent=new Intent(Play_with_AI.this,Congratulation_Activity.class);

        intent.putExtra("congass_message",a+" wins the match");

        intent.putExtra("Congrass_title","Congratulations!");

        intent.putExtra("for_icon","1");
        intent.putExtra("where","ai");
        intent.putExtra("p1point",fp);
        intent.putExtra("p2point",sp);
        intent.putExtra("p1time",0);
        intent.putExtra("p2time",0);
        intent.putExtra("p1name",player1name);
        intent.putExtra("p2name",player2name);
        startActivity(intent);
        taketime3();



    }

    public void draw(){
        Intent intent=new Intent(Play_with_AI.this,Congratulation_Activity.class);
        intent.putExtra("Congrass_title","Draw!");
        intent.putExtra("congass_message","You are both intelligent competitors");
        intent.putExtra("for_icon","2");
        intent.putExtra("where","ai");
        intent.putExtra("p1point",fp);
        intent.putExtra("p2point",sp);
        intent.putExtra("p1time",0);
        intent.putExtra("p2time",0);
        intent.putExtra("p1name",player1name);
        intent.putExtra("p2name",player2name);
        startActivity(intent);
        taketime3();

    }


    public void restart(){
        finishBtn_nameChange();

        {
            namep2.setTextColor(Color.parseColor(darkGreen));
            aiIcon.setBackgroundColor(Color.parseColor(darkGreen));
            namep1.setTextColor(Color.parseColor(lightGreen));
            p1Icon.setBackgroundColor(Color.parseColor(lightGreen));
        }

        clickable();
        allempty();
        allWhite();
        x1=0;x2=0;x3=0;y1=0;y2=0;y3=0;four=0;equ=0;
        x11=0;x22=0;x33=0;y11=0;y22=0;y33=0;four1=0;equ1=0;one=0;two=0;three=0;fourr=0;five=0;six=0;seven=0;eight=0;nine=0;
    }


    public void player1color(){
        namep2.setTextColor(Color.parseColor(darkGreen));
        aiIcon.setBackgroundColor(Color.parseColor(darkGreen));
        namep1.setTextColor(Color.parseColor(lightGreen));
        p1Icon.setBackgroundColor(Color.parseColor(lightGreen));
    }

    public void player2color(){
        namep2.setTextColor(Color.parseColor(lightGreen));
        aiIcon.setBackgroundColor(Color.parseColor(lightGreen));
        namep1.setTextColor(Color.parseColor(darkGreen));
        p1Icon.setBackgroundColor(Color.parseColor(darkGreen));
    }
    public  void congratulationsGame(int a){



        Intent intent=new Intent(Play_with_AI.this,Congratulation_Activity.class);
        if(a==1){
            intent.putExtra("congass_message",player1name+" wins the game.");
            intent.putExtra("Congrass_title","Congrats "+player1name);
        }
        if(a==2){
            intent.putExtra("congass_message",player2name+" wins the game");
            intent.putExtra("Congrass_title","Congrats "+player2name);
        }


        intent.putExtra("for_icon","3");
        intent.putExtra("where","ai");
        intent.putExtra("p1point",0);
        intent.putExtra("p2point",0);
        intent.putExtra("p1time",0);
        intent.putExtra("p2time",0);
        intent.putExtra("p1name",player1name);
        intent.putExtra("p2name",player2name);
        startActivity(intent);
        taketime4();
        finish();


    }



    public void setname(){
        dialog.setContentView(R.layout.ai_popup);
        pl1Edittx=dialog.findViewById(R.id.plr1Id);
        pl1Edittx.setText(player1name);
        saveBtn=dialog.findViewById(R.id.savebtnID);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player1name=pl1Edittx.getText().toString();
                    if(player1name.isEmpty() || player1name.trim().isEmpty()){
                        Toast.makeText(Play_with_AI.this,"Please, fill up",Toast.LENGTH_LONG).show();
                    }
                    else if(player1name.length()>8){
                        Toast.makeText(Play_with_AI.this,"Please, set name within 8 characters",Toast.LENGTH_LONG).show();
                    }
                    else if(player1name.equals(player2name)){
                        Toast.makeText(Play_with_AI.this,"Please, Set unique names",Toast.LENGTH_LONG).show();
                    }

                    else{
                        namep1.setText(player1name);
                        pl1Edittx.setText(player1name, TextView.BufferType.EDITABLE);
                       // setChar();
                        dialog.dismiss();
                    }


                }catch (Exception e){
                    Toast.makeText(Play_with_AI.this,"Something Wrong"+e,Toast.LENGTH_LONG).show();
                }
            }


        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }



    public void yes_for_newgame(){

        clicked=0;
        for_name_change=0;
         if(fp>0||sp>0){
            if(fp>sp) congratulationsGame(1);
            else if(fp<sp) congratulationsGame(2);
            else {
                Intent intent=new Intent(Play_with_AI.this,Congratulation_Activity.class);
                intent.putExtra("Congrass_title","Wow Draw!");
                intent.putExtra("congass_message","You are intelligent like AI");
                intent.putExtra("for_icon","2");
                intent.putExtra("where","ai");
                intent.putExtra("p1point",fp);
                intent.putExtra("p2point",sp);
                intent.putExtra("p1time",0);
                intent.putExtra("p2time",0);
                intent.putExtra("p1name",player1name);
                intent.putExtra("p2name",player2name);
                startActivity(intent);
                taketime4();
                finish();
            }
            fp=0;sp=0;

        }
        else{
             newgameBtn.setText("Take me home");
            p1.setText("0");
            p2.setText("0");

        }




        allempty();
        allWhite();
        fp=0;
        sp=0;
        namep2.setTextColor(Color.parseColor(darkGreen));
        aiIcon.setBackgroundColor(Color.parseColor(darkGreen));
        namep1.setTextColor(Color.parseColor(lightGreen));
        p1Icon.setBackgroundColor(Color.parseColor(lightGreen));

        x1=0;x2=0;x3=0;y1=0;y2=0;y3=0;four=0;equ=0;
        x11=0;x22=0;x33=0;y11=0;y22=0;y33=0;four1=0;equ1=0;one=0;two=0;three=0;fourr=0;five=0;six=0;seven=0;eight=0;nine=0;k=0;
    }


    private void taketime() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ai_play();
                clickable();
            }
        },400);
    }

    private void taketime2() {
        lastTimeClicked = SystemClock.elapsedRealtime();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                congratulations("AI");
            }
        },600);
    }

    private void taketime3() {
        lastTimeClicked = SystemClock.elapsedRealtime();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                clicked=0;
                for_name_change=0;
                restart();
            }
        },400);
    }
    private void taketime4() {
        lastTimeClicked = SystemClock.elapsedRealtime();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newgameBtn.setText("Take me home");
                clicked=0;
                for_name_change=0;
                p1.setText("0");
                p2.setText("0");
                restart();
            }
        },400);
    }
    public void clickable(){
        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        b4.setClickable(true);
        b5.setClickable(true);
        b6.setClickable(true);
        b7.setClickable(true);
        b8.setClickable(true);
        b9.setClickable(true);
    }

    public void not_clickable(){
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
        b5.setClickable(false);
        b6.setClickable(false);
        b7.setClickable(false);
        b8.setClickable(false);
        b9.setClickable(false);
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
                else{
                    clicked=0;
                    for_name_change=0;
                    restart();
                }
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

    public void finishBtn_nameChange(){
        if(for_name_change>0||sp>0||fp>0) newgameBtn.setText("Finish Game");
        else{

            newgameBtn.setText("Take me home");
        }
    }

}