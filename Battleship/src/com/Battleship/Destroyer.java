package com.Battleship;

/**
 * Корабль типа эсминец.
 */
public class Destroyer extends Ship {
    public Destroyer(){
        health = 2;
        type = "destroyer";
        firstCoordinate = new Coordinate();
    }
}
