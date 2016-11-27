package com.exemple.profedam.memory.controllers;

/**
 * Created by MarcosPortatil on 27/11/2016.
 */

public abstract class Puntuacio implements Comparable<Puntuacio>{
    private String scoreDate;
    public int scoreNum;

    public Puntuacio(String date, int num){
        scoreDate=date;
        scoreNum=num;
    }

    public int compareTo(Puntuacio sc){
        //return 0 if equal
        //1 if passed greater than this
        //-1 if this greater than passed
        return sc.scoreNum>scoreNum? 1 : sc.scoreNum<scoreNum? -1 : 0;
    }

    public String getScoreText()
    {
        return scoreDate+" - "+scoreNum;
    }
}
