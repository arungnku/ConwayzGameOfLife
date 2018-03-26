package com.gameoflife.state;

import com.gameoflife.Cell;

/**
 * 
 * @author ArunKumar
 *
 */
public interface State  {
	
    /**
     * 	
	 * Alive state gets changed to Dead on #1 and #2 and remains as is on #3
	 * 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
     * 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
     * 3. Any live cell with two or three live neighbours lives on to the next generation.
     * 
     * Dead state gets changed to Alive on
     * 1. Any dead cell with exactly three live neighbours cells becomes a live cell
     * 
     * @param cell
     */
    public abstract void stepUp(Cell cell);
}
