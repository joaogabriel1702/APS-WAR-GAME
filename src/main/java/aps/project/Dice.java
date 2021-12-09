package aps.project;

import java.util.Random;

public class Dice{
    public int faces;
    public int roll;
    
    Random number = new Random();

    public Dice(){
         faces = number.nextInt(6)+1 ;
        
    }

    public void Roll(){
        roll = number.nextInt(faces)+1;
        
    }

    public int getDice(){

        return roll;
    }
}

