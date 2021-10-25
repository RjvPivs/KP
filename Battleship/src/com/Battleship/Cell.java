package com.Battleship;

/**
 * Класс клетки игрового поля.
 */
public class Cell {
    public Cell(){
        ship = null;
        shotStatus = WasShot.NO;
        shipStatus = HasShip.NO;
        sunkStatus = WasSunk.NO;
        torpedoStatus = WasTorpedoed.NO;
    }
    WasTorpedoed torpedoStatus;
    WasShot shotStatus;
    HasShip shipStatus;
    WasSunk sunkStatus;
    Ship ship;
}
