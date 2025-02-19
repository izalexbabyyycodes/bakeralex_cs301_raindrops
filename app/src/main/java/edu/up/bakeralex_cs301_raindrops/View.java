package edu.up.bakeralex_cs301_raindrops;

import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import java.util.Random;
import java.util.ArrayList;


/**
 * desc: this class creates a View object that the surfaceView will display
 * - creates a Circle object that will be drawn inside the view
 * - randomizes the number, location, and color of the circles
 * <p>
 * author: BakerAlexander
 * date: February 11, 2024
 * version: 1
 */
public class View extends SurfaceView implements SurfaceHolder.Callback {


    /*initializes variables*/
    ArrayList<Paint> paints = new ArrayList<>();
    Paint red = new Paint();
    Paint yellow = new Paint();
    Paint green = new Paint();
    Paint blue = new Paint();
    Paint pink = new Paint();
    Random rng = new Random();
    //added a different color for the players circle
    Paint playerBlue = new Paint();
    float playerX;
    float playerY;


    /*constructor for the view object
    * initializes the params to the surfaceView*/
    public View(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        getHolder().addCallback(this);

        /*Paint colors init*/
        red.setColor(0xFFFF0000);
        red.setStyle(Paint.Style.FILL);
        paints.add(red);
        yellow.setColor(0xFFEAED2F);
        yellow.setStyle(Paint.Style.FILL);
        paints.add(yellow);
        green.setColor(0xFF00FF00);
        green.setStyle(Paint.Style.FILL);
        paints.add(green);
        blue.setColor(0xFF0000FF);
        blue.setStyle(Paint.Style.FILL);
        paints.add(blue);
        pink.setColor(0xFFD261D4);
        pink.setStyle(Paint.Style.FILL);
        paints.add(pink);
        //initializing the color for the player
        playerBlue.setColor(0xFF6EF3F5);
        playerBlue.setStyle(Paint.Style.FILL);
    }


    /*Randomized number as well as color of the circles*/
    public int rngNumCircles(){
        //changed the bounds to account for a player circle always being implemented
        return rng.nextInt(6) + 6;
    }
    public Paint rngColor(){
        return paints.get(rng.nextInt(5));
    }


    /*Randomized X and Y position for the circle*/
    public float rngX(){
        return rng.nextInt(800) + 50;
    }
    public float rngY(){
        return rng.nextInt(800) + 50;
    }


    /*creates the circles to be drawn in the onDraw method*/
    public void Circles(Canvas paper){
        float tempX = rngX();
        float tempY = rngY();
        paper.drawOval(tempX-30.0f, tempY-30.0f, tempX + 30.0f, tempY + 30.0f, rngColor());
    }
    public void PlayerCircle(Canvas paper){
        //used a lot of context actions as suggested by android studio
        playerX = rngX();
        playerY = rngY();
        paper.drawOval(playerX-30.0f, playerY-30.0f, playerX + 30.0f, playerY + 30.0f, playerBlue);
    }


    public void setCirclePositions(int x, int y){
        this.playerX = x;
        this.playerY = y;
        invalidate();
    }


    /*draws on the surfaceView*/
    @Override
    public void onDraw(@NonNull Canvas paper){

        //draws the circles using the needed parameters
        for (int i = 0; i < rngNumCircles(); i++){
            Circles(paper);
        }

        //draws the circle for the user to control
        //updated for the SurfaceView with inputs for the seekBar
        PlayerCircle(paper);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        PlayerCircle(paper);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
    }

}