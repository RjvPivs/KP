package com.Battleship;

/**
 * Корабль типа линкор.
 */
public class Battleship extends Ship {
    public Battleship(){
        health = 4;
        type = "battleship";
        firstCoordinate = new Coordinate();
    }
}
