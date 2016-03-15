/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import akvarel.Spektr;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.text.html.CSS;
import junit.framework.TestCase;

/**
 *
 * @author км
 */
public class ColorButtonJUnitTest extends TestCase {
    private Spektr spektr;
    
    public ColorButtonJUnitTest() {       
    }
    
    @Override
    //befor
    protected void setUp() {
        spektr = new Spektr();
    }
    
    @Override
    //AFTER
    protected void tearDown() throws Exception {
        spektr = null;
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
     public void testHello() { 
        Color []color = new Color[24];
        color[0] = new Color(255, 0, 0);
        color[1] = new Color(252, 41, 0);
        color[2] = new Color(255, 89, 0);
        color[3] = new Color(255, 138, 0);
        color[4] = new Color(255, 165, 0);
        color[5] = new Color(255, 200, 0);
        color[6] = new Color(255, 225, 0);
        color[7] = new Color(255, 245, 0);
        color[8] = new Color(255, 255, 0);
        color[9] = new Color(200, 255, 7);        
        color[10] = new Color(173, 255, 47);
        color[11] = new Color(0, 200, 0);
        color[12] = new Color(0, 161, 0);
        color[13] = new Color(0, 144, 0);
        color[14] = new Color(0, 144, 144);
        color[15] = new Color(0, 161, 207);        
        color[16] = new Color(0, 0, 255);
        color[17] = new Color(0, 0, 207);
        color[18] = new Color(136, 0, 200);
        color[19] = new Color(161, 0, 192);
        color[20] = new Color(161, 0, 161);
        color[21] = new Color(120, 0, 120);        
        color[22] = new Color(80, 0, 80);
        color[23] = new Color(136, 0, 80);   
        Color color1;
        for(int i = 1; i < 25; i++)
        {
            JButton button = new JButton();        
            spektr.ColorButton(i, button);            
            color1 = button.getBackground();
            assertEquals(color1, color[i-1]); 
        }
     }
}
