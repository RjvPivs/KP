package com.Battleship;

/**
 * Класс координаты.
 */
public class Coordinate {

    public Coordinate(int a, int b){
        x = a;
        y = b;
    }

    public Coordinate(){
        x = 0;
        y = 0;
    }
    int x;
    int y;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()){
            return false;
        }
        if(((Coordinate)obj).x == x &  ((Coordinate)obj).y == y){
            return true;
        }
        else {return false;}
    }
}
