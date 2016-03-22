/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import akvarel.Spektr;
import junit.framework.TestCase;

/**
 * Проверка правильности перемещения кнопок.
 * @author Акварель.
 */
public class AutoMoveJUnitTest extends TestCase{
    private Spektr spektr;
    
    @Override
    public void setUp() {
        spektr = new Spektr();
    }
    
    @Override
    public void tearDown() {
        spektr = null;
    }
    
     public void testMove()
     {
         int[][] NewNumbers = new int[5][5];
         for (int i = 0; i < 5; i++) 
         {
            for (int j = 0; j < 5; j++)
            {
                spektr.numbers[i][j] = i * 5 + j;
                NewNumbers[i][j] = i * 5 + j;
            }
         }         
         NewNumbers[0][0] = NewNumbers[1][0];         
         NewNumbers[1][0] = 0;
         spektr.move(1, 0, spektr.numbers[1][0]);//ноль в строке сверху
         for (int i = 0; i < 5; i++)
             for(int j = 0; j < 5; j ++)
             {
                 assertEquals( spektr.numbers[i][j] , NewNumbers[i][j]);
             }
         
         NewNumbers[1][0] = NewNumbers[0][0];         
         NewNumbers[0][0] = 0;
         spektr.move(0, 0, spektr.numbers[0][0]);//ноль в строке снизу
         for (int i = 0; i < 5; i++)
             for(int j = 0; j < 5; j ++)
             {
                 assertEquals( spektr.numbers[i][j] , NewNumbers[i][j]);
             }
         NewNumbers[0][0] = NewNumbers[0][1];         
         NewNumbers[0][1] = 0;
         spektr.move(0, 1, spektr.numbers[0][1]);//ноль в строке сверху
         for (int i = 0; i < 5; i++)
             for(int j = 0; j < 5; j ++)
             {
                 assertEquals( spektr.numbers[i][j] , NewNumbers[i][j]);
             }
         NewNumbers[0][1] = NewNumbers[0][0];         
         NewNumbers[0][0] = 0;
         spektr.move(0, 0, spektr.numbers[0][0]);//ноль в строке сверху
         for (int i = 0; i < 5; i++)
             for(int j = 0; j < 5; j ++)
             {
                 assertEquals( spektr.numbers[i][j] , NewNumbers[i][j]);
             }
     }

}