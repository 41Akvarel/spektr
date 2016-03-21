/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import akvarel.Spektr;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author км
 */
public class GenerateJUnitTest extends TestCase{
    
    Spektr spektr;
    
    @Before
    public void setUp() {
        spektr = new Spektr();
    }
    
    @After
    public void tearDown() {
        spektr = null;
    }

    
    public void testGenerate() 
    {
        int[][] NewNum = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
            {
                NewNum[i][j] = spektr.numbers[i][j];                
            }
        spektr.generate();        
        assertFalse(spektr.numbers == NewNum);
        assertEquals(spektr.numbers[4][4], 0);
                
    }
} 
