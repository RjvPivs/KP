package com.Battleship;

/**
 * Корабль типа авианосец.
 */
public class Carrier extends Ship {
    public Carrier(){
        health = 5;
        type = "carrier";
        firstCoordinate = new Coordinate();
    }
}
