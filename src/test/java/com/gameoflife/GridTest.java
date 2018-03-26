package com.gameoflife;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GridTest {
	
    static Grid instance;
    
    @BeforeAll
    public static void setUp() {
        instance = new Grid();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testBoatPattern()
    {
        System.out.println("testBoatPattern-Begin");
        String[] input = {".....",".OO..",".O.O.","..O..","....."};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        String [] output = {".....",".OO..",".O.O.","..O..","....."};
        System.out.println("testBoatPattern-End\n\n");
        
        assertArrayEquals(output, instance.gridToStringArray());
    }
    
    
    @Test
    public void testLoafPattern()
    {
        System.out.println("testLoafPattern-Begin");
        String[] input = {"......","..OO..",".O..O.",".O.O..","..O..."};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        String [] output = {"......","..OO..",".O..O.",".O.O..","..O..."};
      
        assertArrayEquals(output, instance.gridToStringArray());
        System.out.println("testLoafPattern-End\n\n");
        
    }
    
    @Test
    public void testShipPattern()
    {
        System.out.println("testShipPattern-Begin");
        String[] input = {"......",".OO...",".O.O..","..OO..","......"};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        String [] output = {"......",".OO...",".O.O..","..OO..","......"};
      
        assertArrayEquals(output, instance.gridToStringArray());
        System.out.println("testShipPattern-End\n\n");
        
    }

    @Test
    public void testBlockPattern1()
    {
        System.out.println("testBlockPattern1-Begin");
        String[] input = {"....",".OO.","..O.","...."};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        String [] output = {"....",".OO.",".OO.","...."};
        System.out.println("testBlockPattern1-End\n\n");
        
        assertArrayEquals(output, instance.gridToStringArray());
    }
    
    
    @Test
    public void testBlockPattern2()
    {
        System.out.println("testBlockPattern2-Begin");
        String[] input = {"......O.","OOO...O.","......O.","........","...OO...","...OO..."};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        System.out.println("testBlockPattern2-End\n\n");
        
        String [] output = {".O......",".O...OOO",".O......","........","...OO...","...OO..."};
        assertArrayEquals(output, instance.gridToStringArray());
    }
    
    @Test
    public void testTetroMinoPattern1()
    {
        System.out.println("testTetroMinoPattern1-Begin");
        String[] input = {"....",".OO.",".OO.","...."};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        String [] output = {"....",".OO.",".OO.","...."};
        System.out.println("testTetroMinoPattern1-End\n\n");
        
        assertArrayEquals(output, instance.gridToStringArray());
        
    }
    
    
    @Test
    public void testTetroMinoPattern2()
    {
        System.out.println("testTetroMinoPattern2-Begin");
        String[] input = {".....",".OOO.",".O...",".....","....."};
        instance.fillGrid(input);
        instance.printGrid();
        System.out.println("Updated state");
        instance.stepUp();
        instance.printGrid();
        String [] output = {"..O..",".OO..",".O...",".....","....."};
        System.out.println("testTetroMinoPattern2-End\n\n");
        
        assertArrayEquals(output, instance.gridToStringArray());
    }
    
        
}
