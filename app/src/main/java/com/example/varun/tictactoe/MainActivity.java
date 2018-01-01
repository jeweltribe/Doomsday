package com.example.varun.tictactoe;

import android.app.AlertDialog;
import android.app.usage.UsageEvents;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    int player = 0; // player 1 is yellow and player 2 is red

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void dropIn(View view) {
        ImageView imageView = (ImageView) view;
        int index = Integer.valueOf(view.getTag().toString());
        if (gameState[index] == 2) {
            gameState[index] = player;
            imageView.setTranslationY(-1000f);
            if (player == 0) {
                imageView.setImageResource(R.drawable.yellow);
                player = 1;
            }else if (player == 1) {
                imageView.setImageResource(R.drawable.red);
                player = 0;
            }
            imageView.animate().translationYBy(1000f);
            int result = checkGameState(gameState);
            if (result == 0) {
                playAgain();
            } else if (result == 1) {
                playAgain();
            } else { // check to see if there was a scratch
                int count = 0;
                for (int i = 0; i < 9; i++) {
                    if (gameState[i] == 2) {
                        count++;
                    }
                }
                if (count == 0) {
                    playAgain();
                }
            }
        }


    }

    public int checkGameState(int[] boardState) {
        int winner = 100;
        // horizontal check
        if (boardState[0] != 2 && boardState[0] == boardState[1] && boardState[2] == boardState[1]) {
            winner = boardState[0];
        } else if (boardState[3] != 2 && boardState[3] == boardState[4] && boardState[5] == boardState[4]) {
            winner = boardState[3];
        } else if (boardState[6] != 2 && boardState[6] == boardState[7] && boardState[8] == boardState[7]) {
            winner = boardState[6];
        } else if (boardState[0] != 2 && boardState[0] == boardState[3] && boardState[6] == boardState[3]) { // vertical check
            winner = boardState[0];
        } else if (boardState[1] != 2 && boardState[1] == boardState[4] && boardState[7] == boardState[4]) {
            winner = boardState[1];
        } else if (boardState[2] != 2 && boardState[2] == boardState[5] && boardState[8] == boardState[5]) {
            winner = boardState[2];
        } else if (boardState[0] != 2 && boardState[0] == boardState[4] && boardState[8] == boardState[4]) { // diagonal check
            winner = boardState[0];
        } else if (boardState[2] != 2 && boardState[2] == boardState[4] && boardState[6] == boardState[4]) {
            winner = boardState[2];
        }
        Log.d("CheckGameState", String.valueOf(winner));
        return winner;
    }

    public void playAgain() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(R.string.dialog_message);
        builder.setTitle("Game Over");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setContentView(R.layout.activity_main);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}