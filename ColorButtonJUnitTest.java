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
         
        JButton button = new JButton();
        Color color = new Color(255, 0, 0);
        spektr.ColorButton(1, button);
        Color color1;
        color1 = button.getBackground();
        assertEquals(color1, color);}
}
