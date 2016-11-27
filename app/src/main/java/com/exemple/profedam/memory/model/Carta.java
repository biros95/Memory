package com.exemple.profedam.memory.model;

import com.exemple.profedam.memory.R;

/**
 * Created by ALUMNEDAM on 29/01/2016.
 */
public class Carta {

    public enum Estat {BACK, FRONT, FIXED}

    private final int backImage = R.drawable.back;
    private int frontImage;
    private Estat estat;

    public Carta(int frontImage) {
        this.frontImage = frontImage;
        this.estat = Estat.BACK;
    }

    public int getFrontImage() {
        return frontImage;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    public Estat getEstat() {

        return estat;
    }

    public void girar()
    {
        //TODO gira la carta
        switch(estat) {
            case BACK:
                estat = Estat.FRONT;
                break;

            case FRONT:
                estat = Estat.BACK;
                break;

        }


    }

    public int getActive()
    {
        int imageActive = 0;
        switch(estat){
            case BACK:
                imageActive = this.backImage;
                break;

            case FRONT: FIXED:
                imageActive = this.frontImage;
                break;
        }
        return imageActive;
    }
}
