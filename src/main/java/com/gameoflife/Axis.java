package com.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ArunKumar
 *
 */
public class Axis
{
    private List<Cell> cells;
    public Axis() 
    {
        cells = new ArrayList<Cell>();
    }
    public void stepUp()
    {
        for(Cell cell : cells)
        {
            cell.stepUp();
        }
    }
    public List<Cell> getCells() {
        return cells;
    }
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
