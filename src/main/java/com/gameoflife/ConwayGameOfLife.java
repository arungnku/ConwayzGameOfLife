package com.gameoflife;


/**
 * 
 * @author ArunKumar
 *
 */
public class ConwayGameOfLife {

    public static void main(String[] args) {
        String[] input = {"......O.","OOO...O.","......O.","........","...OO...","...OO..."};
        Grid grid = new Grid();
        grid.fillGrid(input);
        grid.printGrid();
        System.out.println("Updated State");
        grid.stepUp();
        grid.printGrid();
    }
}
