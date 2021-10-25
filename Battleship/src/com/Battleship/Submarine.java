package com.Battleship;

/**
 * Корабль типа субмарина.
 */
public class Submarine extends Ship {
    public Submarine(){
        type = "submarine";
        health = 1;
        firstCoordinate = new Coordinate();
    }
}
