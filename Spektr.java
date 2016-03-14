/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akvarel;

import static de.dislin.Dislin.frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Spektr extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel(new GridLayout(5, 5, 2, 2));    
    private int[][] numbers = new int[5][5];    
    public  Spektr()//создание интерфейса игры
    {
        super("Спектр ");
        panel.setLayout(null);        
        getContentPane().setBackground(new Color(255, 255, 255));      
        int screenheight;
        screenheight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
        setSize(screenheight, screenheight);        
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button; 
        button = new JButton("Новая игра");
        int button_width = (int)getWidth() / 3;
        int button_height =  (int)getHeight() / 10;
        button.setSize(button_width, button_height);
        button.setLocation(2,5);
        button.setBackground(Color.red);
        panel.add(button);
        Container container = getContentPane();
        panel.setDoubleBuffered(true);
        container.add(panel);
        container.add(panel2);
        panel.setBackground(new Color(255, 255, 255));
        panel.validate();
        panel.repaint();          
        DrawField(button_height, button_width);
        setLayout(null);
        panel.setBounds(0, 0, button_width * 3, button_height);        
        add(panel);
        add(panel2);        
    }
    public void DrawField(int button_height, int button_width) //Отображение на экране заданного поля
    {
        int k = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = k;
                k++;
            }
        }
        panel2.removeAll();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
              JButton button;
                button = new JButton( Integer.toString(numbers[i][j]));
                if (numbers[i][j] == 1)
                {
                    button.setBackground(new Color(255, 0, 0));                    
                }
                if (numbers[i][j] == 2)
                {
                    button.setBackground(new Color(252, 41, 0));                    
                }
                if (numbers[i][j] == 3)
                {
                    button.setBackground(new Color(255, 89, 0));                    
                }
                if (numbers[i][j] == 4)
                {
                    button.setBackground(new Color(255, 138, 0));                    
                }
                if (numbers[i][j] == 5)
                {
                    button.setBackground(new Color(255, 165, 0));                    
                }
                if (numbers[i][j] == 6)
                {
                    button.setBackground(new Color(255, 200, 0));                    
                }
                if (numbers[i][j] == 7)
                {
                    button.setBackground(new Color(255, 225, 0));                    
                }
                if (numbers[i][j] == 8)
                {
                    button.setBackground(new Color(255, 245, 0));                    
                }
                if (numbers[i][j] == 9)
                {
                    button.setBackground(new Color(255, 255, 0));                    
                }
                if (numbers[i][j] == 10)
                {
                    button.setBackground(new Color(200, 255, 7));                    
                }
                if (numbers[i][j] == 11)
                {
                    button.setBackground(new Color(173, 255, 47));                    
                }
                if (numbers[i][j] == 12)
                {
                    button.setBackground(new Color(0, 200, 0));                    
                }
                if (numbers[i][j] == 13)
                {
                    button.setBackground(new Color(0, 161, 0));                    
                }
                if (numbers[i][j] == 14)
                {
                    button.setBackground(new Color(0, 144, 0));                    
                }
                if (numbers[i][j] == 15)
                {
                    button.setBackground(new Color(0, 144, 144));                    
                }
                if (numbers[i][j] == 16)
                {
                    button.setBackground(new Color(0, 161, 207));                    
                }
                if (numbers[i][j] == 17)
                {
                    button.setBackground(new Color(0, 0, 255));                    
                }
                if (numbers[i][j] == 18)
                {
                    button.setBackground(new Color(0, 0, 207));                    
                }
                if (numbers[i][j] == 19)
                {
                    button.setBackground(new Color(136, 0, 200));                    
                }
                if (numbers[i][j] == 20)
                {
                    button.setBackground(new Color(161, 0, 192));                    
                }
                if (numbers[i][j] == 21)
                {
                    button.setBackground(new Color(161, 0, 161));                    
                }
                if (numbers[i][j] == 22)
                {
                    button.setBackground(new Color(120, 0, 120));                    
                }
                if (numbers[i][j] == 23)
                {
                    button.setBackground(new Color(80, 0, 80));                    
                }
                if (numbers[i][j] == 24)
                {
                    button.setBackground(new Color(136, 0, 80));                    
                }               
                button.setFocusable(false);
                panel2.add(button);
                if (numbers[i][j] == 25) {
                    button.setVisible(false);
                }
            }
        }
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setBounds(button_width / 2, button_height + button_height/2, button_width * 2, button_width * 2);
        panel2.validate();
        panel2.repaint();       
    }
    public static void main(String[] args) {
        JFrame app = new Spektr();        
        app.setVisible(true);
    }
}

    

