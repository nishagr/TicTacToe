package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buClick(View view) {
        Button buSelected = (Button) view;
        int CellID = 0;

        switch (buSelected.getId()) {
            case R.id.B1:
                CellID = 1;
                break;
            case R.id.B2:
                CellID = 2;
                break;
            case R.id.B3:
                CellID = 3;
                break;
            case R.id.B4:
                CellID = 4;
                break;
            case R.id.B5:
                CellID = 5;
                break;
            case R.id.B6:
                CellID = 6;
                break;
            case R.id.B7:
                CellID = 7;
                break;
            case R.id.B8:
                CellID = 8;
                break;
            case R.id.B9:
                CellID = 9;
                break;
        }
        PlayGame(CellID, buSelected);
    }

    int activePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();
    TextView tvShow;
    TextView p1Score;
    TextView p2Score;

    public int P1Score=0,P2score=0;

    protected void PlayGame(int CellID, Button buSelected) {
        int P1Color=getResources().getColor(R.color.green);
        int P2Color=getResources().getColor(R.color.blue);
        if (activePlayer == 1) {
            buSelected.setText("X");
            buSelected.setBackgroundColor(P1Color);
            Player1.add(CellID);
            activePlayer = 2;
            //AutoPlay();
        } else if (activePlayer == 2) {
            buSelected.setText("O");
            buSelected.setBackgroundColor(P2Color);
            Player2.add(CellID);
            activePlayer = 1;

        }
        buSelected.setEnabled(false);
        CheckWinner();
    }

    @SuppressLint({"SetTextI18n", "ShowToast"})
    void CheckWinner() {
        int P1Color=getResources().getColor(R.color.green);
        int P2Color=getResources().getColor(R.color.blue);
        int DrawColor=getResources().getColor(R.color.red);
        tvShow = findViewById(R.id.tvShow);
        p1Score=findViewById(R.id.P1Score);
        p2Score=findViewById(R.id.P2Score);
        if (Player1.size()+Player2.size()==9)
        {
            Toast.makeText(this,"Match is Draw",Toast.LENGTH_LONG);
            tvShow.setText("Draw");
            tvShow.setTextColor(DrawColor);
            P1Score++;
            P2score++;
            p1Score.setText("Player 'X': " + P1Score);
            p2Score.setText("Player 'O': " + P2score);
            return;
        }
        int winner = -1;
            //Row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3))
            winner = 1;
        else if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3))
            winner = 2;

            //Row 2
        else if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6))
            winner = 1;
        else if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6))
            winner = 2;

            //Row 3
        else if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9))
            winner = 1;
        else if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9))
            winner = 2;

            //Column 1
        else if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7))
            winner = 1;
        else if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7))
            winner = 2;

            //Column 2
        else if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8))
            winner = 1;
        else if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8))
            winner = 2;

            //Column 3
        else if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9))
            winner = 1;
        else if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9))
            winner = 2;

            //Diagonal 1
        else if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9))
            winner = 1;
        else if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9))
            winner = 2;

            //Diagonal 2
        else if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7))
            winner = 1;
        else if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7))
            winner = 2;

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 'X' is the Winner", Toast.LENGTH_LONG).show();
                tvShow.setText("Player 'X' Wins");
                tvShow.setTextColor(P1Color);
                P1Score+=2;
                P2score--;
            } else {
                Toast.makeText(this, "Player 'O' is the Winner", Toast.LENGTH_LONG).show();
                tvShow.setText("Player 'O' Wins");
                tvShow.setTextColor(P2Color);
                P2score+=2;
                P1Score--;
            }
            for (int i = 1; i < 10; i++) {
                Button btn;
                if (!Player1.contains(i) && !Player2.contains(i)) {
                    btn = getButton(i);
                    btn.setEnabled(false);
                }
            }
        }
        p1Score.setText("Player 'X': " + P1Score);
        p2Score.setText("Player 'O': " + P2score);
    }

    Button getButton(int CellID) {
        Button btn = null;
        switch (CellID) {
            case 1:
                btn = findViewById(R.id.B1);
                break;
            case 2:
                btn = findViewById(R.id.B2);
                break;
            case 3:
                btn = findViewById(R.id.B3);
                break;
            case 4:
                btn = findViewById(R.id.B4);
                break;
            case 5:
                btn = findViewById(R.id.B5);
                break;
            case 6:
                btn = findViewById(R.id.B6);
                break;
            case 7:
                btn = findViewById(R.id.B7);
                break;
            case 8:
                btn = findViewById(R.id.B8);
                break;
            case 9:
                btn = findViewById(R.id.B9);
                break;
        }
        return btn;
    }

    public void reset()
    {

        Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
        b1=findViewById(R.id.B1);
        b1.setEnabled(true);
        b1.setBackgroundResource(R.drawable.buttonlayout);
        b1.setText("");
        b2=findViewById(R.id.B2);
        b2.setEnabled(true);
        b2.setBackgroundResource(R.drawable.buttonlayout);
        b2.setText("");
        b3=findViewById(R.id.B3);
        b3.setEnabled(true);
        b3.setBackgroundResource(R.drawable.buttonlayout);
        b3.setText("");
        b4=findViewById(R.id.B4);
        b4.setEnabled(true);
        b4.setBackgroundResource(R.drawable.buttonlayout);
        b4.setText("");
        b5=findViewById(R.id.B5);
        b5.setEnabled(true);
        b5.setBackgroundResource(R.drawable.buttonlayout);
        b5.setText("");
        b6=findViewById(R.id.B6);
        b6.setEnabled(true);
        b6.setBackgroundResource(R.drawable.buttonlayout);
        b6.setText(null);
        b7=findViewById(R.id.B7);
        b7.setEnabled(true);
        b7.setBackgroundResource(R.drawable.buttonlayout);
        b7.setText(null);
        b8=findViewById(R.id.B8);
        b8.setEnabled(true);
        b8.setBackgroundResource(R.drawable.buttonlayout);
        b8.setText(null);
        b9=findViewById(R.id.B9);
        b9.setEnabled(true);
        b9.setBackgroundResource(R.drawable.buttonlayout);
        b9.setText(null);
        activePlayer=1;
        tvShow.setText("");
        Player2.clear();
        Player1.clear();
    }
    public void buReset(View view) {
        reset();
    }

    public void buRestart(View view) {
        Activity myActivity = this;
        myActivity.recreate();
    }

    /*void AutoPlay() {
        ArrayList<Integer> Empty = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (!Player1.contains(i) && !Player2.contains(i))
                Empty.add(i);
        }
        Random r = new Random();
        int rIndex = r.nextInt(Empty.size());
        int CellID = Empty.get(rIndex);
        Button buSelected;
        buSelected = getButton(CellID);
        PlayGame(CellID, buSelected);
    }*/
}

