package edu.up.bakeralex_cs301_raindrops;

import android.widget.SeekBar;


/**
 * desc: this class is the controller for the players circle
 * - listens for the inputs on the seekbars
 * - controls the different movement of the circle
 * <p>
 * author: BakerAlexander
 * date: February 17, 2025
 * version: 2
 */
public class Controller{


    /*initializes variables*/
    private View myView;
    private float playerX;
    private float playerY;
    private SeekBar verticalSeekBar;
    private SeekBar horizontalSeekBar;


    /*constructor for the controller class
    * initializes the view*/
    public Controller(View view, SeekBar verticalSeekBar, SeekBar horizontalSeekBar){
        this.myView = view;
        this.verticalSeekBar = verticalSeekBar;
        this.horizontalSeekBar = horizontalSeekBar;

    /*handles the inputs from the seekbars*/
        verticalSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                playerY = progress;
                updateCirclePosition();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        horizontalSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                playerX = progress;
                updateCirclePosition();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }


    public void updateCirclePosition(){
        View.setCirclePosition(playerX, playerY);
    }

}
