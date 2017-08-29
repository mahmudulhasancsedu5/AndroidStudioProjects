package com.hasancsedu5gmail.tictactoegameapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MultiPlayerActivity extends AppCompatActivity {

    private int[][] grid = new int[3][3];
    private int moves=1;
    private int whoseMove=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);

        startGame();

    }

    public  void startGame(){

        Toast.makeText(this,"Start a new Game",Toast.LENGTH_LONG).show();

        Button btn;
        btn = (Button) findViewById(R.id.button_1_1);
        btn.setText("");
        btn.setBackgroundColor(Color.RED);
        btn = (Button) findViewById(R.id.button_1_2);
        btn.setText("");
        btn.setBackgroundColor(Color.BLUE);
        btn = (Button) findViewById(R.id.button_1_3);
        btn.setText("");
        btn.setBackgroundColor(Color.RED);
        btn = (Button) findViewById(R.id.button_2_1);
        btn.setText("");
        btn.setBackgroundColor(Color.BLUE);
        btn = (Button) findViewById(R.id.button_2_2);
        btn.setText("");
        btn.setBackgroundColor(Color.RED);
        btn = (Button) findViewById(R.id.button_2_3);
        btn.setText("");
        btn.setBackgroundColor(Color.BLUE);
        btn = (Button) findViewById(R.id.button_3_1);
        btn.setText("");
        btn.setBackgroundColor(Color.RED);
        btn = (Button) findViewById(R.id.button_3_2);
        btn.setText("");
        btn.setBackgroundColor(Color.BLUE);
        btn = (Button) findViewById(R.id.button_3_3);
        btn.setText("");
        btn.setBackgroundColor(Color.RED);
        //btn.setBackgroundResource(R.drawable.image_wolf1);

        moves=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]=-1;
            }
        }


    }


    public boolean winTheGame(int player){


        for(int i=0;i<3;i++)
        {
            boolean win=true;
            for(int j=0;j<3;j++){

                if(grid[i][j]!=player)
                {
                    win = false;
                    break;
                }

            }
            if(win) return win;
        }

        for(int i=0;i<3;i++)
        {
            boolean win=true;
            for(int j=0;j<3;j++){

                if(grid[j][i]!=player)
                {
                    win = false;
                    break;
                }

            }
            if(win) return win;
        }

        boolean win = true;
        for(int i=0;i<3;i++){

            if(grid[i][i]!=player)
            {
                win = false;
                break;
            }
        }
        if(win) return true;


        win = true;
        for(int i=0;i<3;i++){

            if(grid[i][2-i]!=player)
            {
                win = false;
                break;
            }
        }
        if(win) return true;



        return false;
    }

    public void onClickButton11(View view) {

        if(grid[0][0]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[0][0]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }

    public void onClickButton12(View view) {

        if(grid[0][1]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{


            Button btn = (Button)view;
            int player = moves%2;
            grid[0][1]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }
    public void onClickButton13(View view) {

        if(grid[0][2]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[0][2]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }
    public void onClickButton21(View view) {

        if(grid[1][0]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[1][0]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }
    public void onClickButton22(View view) {

        if(grid[1][1]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[1][1]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }
    public void onClickButton23(View view) {

        if(grid[1][2]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[1][2]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }

        }


    }

    public void onClickButton31(View view) {

        if(grid[2][0]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[2][0]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }
    public void onClickButton32(View view) {

        if(grid[2][1]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{
            Button btn = (Button)view;
            int player = moves%2;
            grid[2][1]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }

    public void onClickButton33(View view) {

        if(grid[2][2]!=-1){

            Toast.makeText(this,"Try anothor cell",Toast.LENGTH_SHORT).show();

        }
        else{

            Button btn = (Button)view;
            int player = moves%2;
            grid[2][2]=player;
            String text = ""+player;
            moves++;
            btn.setText(text);

            if(winTheGame(player)){

                Toast.makeText(this,"Player "+player+" win the game",Toast.LENGTH_LONG).show();
                startGame();

            }else{

                if(moves==10)
                {
                    Toast.makeText(this,"Game is Draw.",Toast.LENGTH_LONG).show();
                    startGame();
                }

            }


        }


    }




}
