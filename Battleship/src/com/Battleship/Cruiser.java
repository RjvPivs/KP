package com.Battleship;

/**
 * Корабль типа крейсер.
 */
public class Cruiser extends Ship {
    public Cruiser(){
        health = 3;
        type = "cruiser";
        firstCoordinate = new Coordinate();
    }
}
