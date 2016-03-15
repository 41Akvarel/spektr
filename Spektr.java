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

/**
 *
 * @author км
 */
public class Spektr extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel(new GridLayout(5, 5, 2, 2));    
    private int[][] numbers = new int[5][5];    

    /**
     *
     */
    public  Spektr()//создание интерфейса игры
    {
        super("Спектр");
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
        generate();
        DrawField(button_height, button_width);
        setLayout(null);
        panel.setBounds(0, 0, button_width * 3, button_height);        
        add(panel);
        add(panel2);     
        
        
    
    }
    
    
    /**
     * Задаем цвет для кнопок
     * @param number номер кнопки
     * @param but кнопка
     */
    public void ColorButton(int number, JButton but)
    {
        switch(number)
        {
            case 1:
                but.setBackground(new Color(255, 0, 0));
                break;
                case  2:
                    but.setBackground(new Color(252, 41, 0));
                    break;
                case 3:
                    but.setBackground(new Color(255, 89, 0));
                    break;
                case 4:
                    but.setBackground(new Color(255, 138, 0));
                    break;
                case 5:
                    but.setBackground(new Color(255, 165, 0));
                    break;
                case 6:
                    but.setBackground(new Color(255, 200, 0));
                    break;
                case 7:
                    but.setBackground(new Color(255, 225, 0));
                    break;
                case 8:
                    but.setBackground(new Color(255, 245, 0));
                    break;
                case 9:
                    but.setBackground(new Color(255, 255, 0));
                    break;
                case 10:
                    but.setBackground(new Color(200, 255, 7));
                    break;
                case 11:
                    but.setBackground(new Color(173, 255, 47));
                    break;
                case 12:
                    but.setBackground(new Color(0, 200, 0));
                    break;
                case 13:
                    but.setBackground(new Color(0, 161, 0));
                    break;
                case 14:
                    but.setBackground(new Color(0, 144, 0));
                    break;
                case 15:
                    but.setBackground(new Color(0, 144, 144));
                    break;
                case 16:
                    but.setBackground(new Color(0, 161, 207));
                    break;
                case 17:
                    but.setBackground(new Color(0, 0, 255));
                    break;
                case 18:
                    but.setBackground(new Color(0, 0, 207));
                    break;
                case 19:
                    but.setBackground(new Color(136, 0, 200));
                    break;
                case 20:
                    but.setBackground(new Color(161, 0, 192));
                    break;
                case 21:
                    but.setBackground(new Color(161, 0, 161));
                    break;
                case 22:
                    but.setBackground(new Color(120, 0, 120));
                    break;
                case 23:
                    but.setBackground(new Color(80, 0, 80));
                    break;
                case 24:
                    but.setBackground(new Color(136, 0, 80));
                    break;         
        }
                
    }
    

    /**
     * nbnb
     * @param button_height hghg1hh
     * @param button_width mbjbj
     */
    public void DrawField(int button_height, int button_width) //Отображение на экране заданного поля
    {
//        int k = 1;
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                numbers[i][j] = k;
//                k++;
//            }
//        }
        panel2.removeAll();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
              JButton button;
                button = new JButton( Integer.toString(numbers[i][j]));
                ColorButton(numbers[i][j], button);
                button.setFocusable(false);
                panel2.add(button);
                if (numbers[i][j] == 0) {
                    button.setVisible(false);
                }
            }
        }
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setBounds(button_width / 2, button_height + button_height/2, button_width * 2, button_width * 2);
        panel2.validate();
        panel2.repaint();       
    }
    public void auto_move(){
        Random generator = new Random();
        int k = 0;
        int l = 0;        
        k = generator.nextInt(5);
        l = generator.nextInt(5);
        if ((k > 0) & (k < 4) & (l > 0) & (l < 4)) 
        {
            if (numbers[k - 1][l] == 0)
            {                    
                 numbers[k - 1][l] = numbers[k][l];
                 numbers[k][l] = 0;
            }
            if (numbers[k + 1][l] == 0)
            {
                 numbers[k + 1][l] = numbers[k][l];
                 numbers[k][l] = 0;
            }
            if (numbers[k][l - 1] == 0)
            {
                 numbers[k][l - 1] = numbers[k][l];
                 numbers[k][l] = 0;
            }
                if (numbers[k][l + 1] == 0)
                {
                    numbers[k][l + 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k == 0) & (l > 0) & (l < 4)) 
            {
                if (numbers[k + 1][l] == 0)
                {
                    numbers[k + 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l - 1] == 0)
                {
                    numbers[k][l - 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l + 1] == 0)
                {
                    numbers[k][l + 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k == 4) & (l > 0) & (l < 4)) 
            {
                if (numbers[k - 1][l] == 0)
                {
                    numbers[k - 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l - 1] == 0)
                {
                    numbers[k][l - 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l + 1] == 0)
                {
                    numbers[k][l + 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k > 0) & (k < 4) & (l == 0)) 
            {
                if (numbers[k - 1][l] == 0)
                {
                    numbers[k - 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k + 1][l] == 0)
                {
                    numbers[k + 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l + 1] == 0)
                {
                    numbers[k][l + 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k > 0) & (k < 4) & (l == 4)) 
            {
                if (numbers[k - 1][l] == 0)
                {
                    numbers[k - 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k + 1][l] == 0)
                {
                    numbers[k + 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l - 1] == 0)
                {
                    numbers[k][l - 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k == 0) & (l == 0)) 
            {
                if (numbers[k + 1][l] == 0)
                {
                    numbers[k + 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l + 1] == 0)
                {
                    numbers[k][l + 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k == 0) & (l == 4)) 
            {
                if (numbers[k + 1][l] == 0)
                {
                    numbers[k + 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l - 1] == 0)
                {
                    numbers[k][l - 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k == 4) & (l == 0)) 
            {
                if (numbers[k - 1][l] == 0)
                {
                    numbers[k - 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l + 1] == 0)
                {
                    numbers[k][l + 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }

            if ((k == 4) & (l == 4)) 
            {
                if (numbers[k - 1][l] == 0)
                {
                    numbers[k - 1][l] = numbers[k][l];
                    numbers[k][l] = 0;
                }
                if (numbers[k][l - 1] == 0)
                {
                    numbers[k][l - 1] = numbers[k][l];
                    numbers[k][l] = 0;
                }
            }
        return;
    }
    public void generate() {      
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++)
            {
                numbers[i][j] = i * 5 + j;     
            }
        }        
        int count = 0;
        while( count < 5000)
        {          
            auto_move();
            count ++;   
            
        }  
        while (numbers[4][4] !=0 ){
            auto_move();
        }
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        JFrame app = new Spektr();        
        app.setVisible(true);
    }
}

    

