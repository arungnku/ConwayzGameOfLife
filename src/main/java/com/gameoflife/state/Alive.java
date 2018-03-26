package com.gameoflife.state;

import com.gameoflife.Cell;

/**
 * 
 * @author ArunKumar
 *
 */
public class Alive implements State 
{

    /* (non-Javadoc)
     * @see com.gameoflife.state.State#stepUp(com.gameoflife.Cell)
     */
    public void stepUp(Cell cell) 
    {
        if(cell.getNoOfAliveNeighbours()<2||cell.getNoOfAliveNeighbours()>3)
        {
            cell.setState(new Dead());
        }
    }

}
