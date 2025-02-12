package edu.up.bakeralex_cs301_raindrops;

import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.Paint;
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
public class View extends SurfaceView{


    /*initializes variables*/
    ArrayList<Paint> paints = new ArrayList<>();
    Paint red = new Paint();
    Paint yellow = new Paint();
    Paint green = new Paint();
    Paint blue = new Paint();
    Paint pink = new Paint();
    Random rng = new Random();


    /*constructor for the view object
    * initializes the params to the surfaceView*/
    public View(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);

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
    }


    /*Randomized number as well as color of the circles*/
    public int rngNumCircles(){
        return rng.nextInt(7) + 6;
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


    /*draws on the surfaceView*/
    @Override
    public void onDraw(@NonNull Canvas paper){

        //draws the circles using the needed parameters
        for (int i = 0; i < rngNumCircles(); i++){
            Circles(paper);
        }
    }

}