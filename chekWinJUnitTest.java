/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import akvarel.Spektr;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;


/**
 *
 * @author км
 */
public class chekWinJUnitTest extends TestCase{
    
    Spektr spektr;    
    
    @Before
    public void setUp() {
        spektr = new Spektr();
    }
    
    @After
    public void tearDown() {
        spektr = null;
    }

    public void testChek()
    {  
        assertEquals(spektr.checkWin(), false);
        System.out.println(spektr.checkWin());
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
            {
                if((i == 4) && (j == 4))
                {
                    spektr.numbers[i][j] = 0;
                }
                else
                {
                    spektr.numbers[i][j] = i * 5 + j + 1 ;  
                }                              
            }
        assertEquals(spektr.checkWin(), true);  
        System.out.println(spektr.checkWin());
    }
}
