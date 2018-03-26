package com.gameoflife;

import java.util.ArrayList;
import java.util.List;

import com.gameoflife.state.Alive;

/**
 * @author ArunKumar
 *
 */
public class Grid {

	private List<Axis> rows;

	/**
	 * Fill the grid (Axis/Cells) based on input
	 * 
	 * @param input
	 */
	public void fillGrid(String[] input) {
		rows = new ArrayList<Axis>();
		for (int x = 0; x < input.length; x++) {
			Axis axis = new Axis();
			List<Cell> row = new ArrayList<Cell>();
			axis.setCells(row);
			for (int y = 0; y < input[0].length(); y++) {
				row.add(new Cell());
			}
			rows.add(axis);
		}

		createGrid(input);
		updateLiveCount();
	}

	private void updateLiveCount() {
		for (int x = 0; x < rows.size(); x++) {
			for (int y = 0; y < rows.get(x).getCells().size(); y++) {
				Cell cell = rows.get(x).getCells().get(y);
				int liveCount = countlivingNeighbours(x, y);
				cell.setNoOfAliveNeighbours(liveCount);
			}
		}
	}

	/**
	 * A cell's neighbours are those cells which are horizontally, vertically or
	 * diagonally adjacent. Most cells will have eight neighbours. Cells placed on
	 * the edge of the grid will have fewer.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public int countlivingNeighbours(int row, int column) {
		int[][] cellsToCheck = { { row - 1, column - 1 }, { row - 1, column }, { row - 1, column + 1 },
				{ row, column + 1 }, { row + 1, column + 1 }, { row + 1, column }, { row + 1, column - 1 },
				{ row, column - 1 }, };

		int livingNeighbours = 0;

		for (int i = 0; i < cellsToCheck.length; i++) {

			int rowToCheck = cellsToCheck[i][0];
			int colTocheck = cellsToCheck[i][1];

			if (isInTheGrid(rowToCheck, colTocheck) && isAlive(rowToCheck, colTocheck)) {
				livingNeighbours++;
			}

		}

		return livingNeighbours;

	}

	public boolean isAlive(int row, int column) {
		return rows.get(row).getCells().get(column).getState().getClass() == Alive.class;
	}

	private boolean isInTheGrid(int row, int col) {
		return row >= 0 && col >= 0 && row < rows.size() && col < rows.get(0).getCells().size();
	}

	public void createGrid(String[] input) {
		int x = 0, y = 0;
		for (String line : input) {
			Axis axis = rows.get(x);
			y = 0;
			for (char character : line.toCharArray()) {
				List<Cell> cells = axis.getCells();
				if (character == 'O') {
					cells.get(y).setState(new Alive());
				}
				y++;
			}
			x++;
		}
	}

	public void stepUp() {
		Axis topRow = instantiateNewRow(0);
		Axis bottomRow = instantiateNewRow(rows.size() - 1);
		List<Cell> leftColumn = instantiateNewColumn(0);
		int rightColumnIndex = rows.get(0).getCells().size() - 1;
		List<Cell> rightColumn = instantiateNewColumn(rightColumnIndex);
		int index = 0;
		for (Axis axis : rows) {
			axis.stepUp();
		}
		if (topRow != null)
			rows.add(0, topRow);
		if (bottomRow != null)
			rows.add(bottomRow);
		if (leftColumn != null)
			insertNewColumn(leftColumn, index);
		index = rows.get(0).getCells().size();
		if (rightColumn != null)
			insertNewColumn(rightColumn, index);
		String[] stringArray = gridToStringArray();
		fillGrid(stringArray);
	}

	public Axis instantiateNewRow(int i) {
		int flag = 0;
		int index = -1;
		Axis tempRow = rows.get(i);
		for (Cell cell : tempRow.getCells()) {
			index++;
			if (cell.getState().getClass() == Alive.class) {
				flag++;
				if (flag == 3)
					break;
				continue;
			}
			flag = 0;
		}
		index--;
		if (flag == 3) {
			return createAxisObject(tempRow.getCells().size(), index);
		}
		return null;
	}

	private Axis createAxisObject(int size, int index) {
		Axis newRow = null;
		newRow = new Axis();
		List<Cell> cells = new ArrayList<Cell>();
		newRow.setCells(cells);
		for (int x = 0; x < size; x++) {
			Cell cell = new Cell();
			cells.add(cell);
			if (x == index) {
				cell.setState(new Alive());
			}
		}
		return newRow;
	}

	public List<Cell> instantiateNewColumn(int i) {
		List<Cell> tempColumn = new ArrayList<Cell>();
		for (Axis axis : rows) {
			tempColumn.add(axis.getCells().get(i));
		}
		int flag = 0;
		int index = -1;
		for (Cell cell : tempColumn) {
			index++;
			if (cell.getState().getClass() == Alive.class) {
				flag++;
				if (flag == 3)
					break;
				continue;
			}
			flag = 0;
		}
		index--;
		if (flag == 3) {
			return createColumn(tempColumn.size(), index);
		}
		return null;
	}

	private List<Cell> createColumn(int size, int index) {
		List<Cell> newColumn = null;
		newColumn = new ArrayList<Cell>();
		for (int x = 0; x < size; x++) {
			Cell cell = new Cell();
			newColumn.add(cell);
			if (x == index) {
				cell.setState(new Alive());
			}
		}
		return newColumn;
	}

	public void insertNewColumn(List<Cell> column, int index) {
		int x = 0;
		for (Axis axis : rows) {
			axis.getCells().add(index, column.get(x));
			x++;
		}
	}

	public String[] gridToStringArray() {
		List<String> stringArray = new ArrayList<String>();
		for (Axis axis : rows) {
			stringArray.add(rowToString(axis));
		}
		return stringArray.toArray(new String[0]);
	}

	private String rowToString(Axis axis) {
		StringBuilder element = new StringBuilder();
		for (Cell cell : axis.getCells()) {
			if (cell.getState().getClass() == Alive.class) {
				element.append('O');
				continue;
			}
			element.append('.');
		}
		return element.toString();
	}

	public void printGrid() {
		String[] strArray = gridToStringArray();
		for (String row : strArray) {
			System.out.println(row);
		}
	}

	public List<Axis> getRows() {
		return rows;
	}

	public void setRows(List<Axis> rows) {
		this.rows = rows;
	}
}
