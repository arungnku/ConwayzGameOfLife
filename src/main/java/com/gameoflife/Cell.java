package com.gameoflife;

import com.gameoflife.state.Dead;
import com.gameoflife.state.State;

/**
 * 
 * @author ArunKumar
 *
 */
public class Cell {

	private State state; 
	private Integer noOfAliveNeighbours;

	public Cell() {
		this.state = new Dead();
		this.noOfAliveNeighbours = 0;
	}
	public void stepUp() {
		this.getState().stepUp(this);
	}

	
	public Integer getNoOfAliveNeighbours() {
		return noOfAliveNeighbours;
	}

	public void setNoOfAliveNeighbours(Integer noOfAliveNeighbours) {
		this.noOfAliveNeighbours = noOfAliveNeighbours;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		if (this.state.getClass() != state.getClass()) {
			this.state = state;
		}
	}

	}
