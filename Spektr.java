/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akvarel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Игра "Спектр".
 * @author Акварель.
 */
public final class Spektr extends JFrame {
    private final JPanel panel = new JPanel();
    private final JPanel panel2 = new JPanel(new GridLayout(5, 5, 2, 2));    
    public int[][] numbers = new int[5][5];   
    private final int button_width;
    private final int button_height;

   /**
    * Создание интерфейса приложение.
    */
    public  Spektr()
    {
        super("Спектр");
        panel.setLayout(null);             
        int screenheight;
        screenheight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
        setSize(screenheight, screenheight);        
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          
        JButton button; 
        button = new JButton("Новая игра");
        button.setFocusable(false);
        button_width = (int)getWidth() / 3;
        button_height =  (int)getHeight() / 10;
        button.setSize(button_width, button_height);
        button.setLocation(2,5);
        button.setBackground(Color.red);
        panel.add(button);
        button.addActionListener(new NewMenuListener());
       
               
        Container container = getContentPane();
        container.setBackground(new Color(255, 255, 255));
        panel.setDoubleBuffered(true);
        container.add(panel);
        container.add(panel2);
        panel.setBackground(new Color(255, 255, 255));
        panel.validate();
        panel.repaint();
        generate();
        DrawField();
        setLayout(null);
        panel.setBounds(0, 0, button_width * 3, button_height);        
        add(panel);
        add(panel2);        
    }
    /**
     * Перемешивание квадратов при нажатии на кнопку "Новая игра".
     */
    private class NewMenuListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if ("Новая игра".equals(command)) {
                generate();
                DrawField();
            }
        }
    }
    /**
     * Задаем цвет для кнопок.
     * @param number значение указанное на кнопке.
     * @param but кнопка.
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
     * Отображение на экране заданного поля.
     */    
    public void DrawField() 
    {
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
                } else
                    button.addActionListener(new ClickListener());
            }
        }
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setBounds(button_width / 2, button_height + button_height/2, button_width * 2, button_width * 2);
        panel2.validate();
        panel2.repaint();       
    }
    
    /**
     * Функция меняет местами две кнопки.
     * @param str Номер строки, в которой находится перемещаемая кнопка.  
     * @param stolb Номер столбца, в котором находится перемещаемая кнопка.
     * @param number Цифра, которая расположена на перемещаемой кнопке.
     */
    public void move(int str, int stolb, int number)
    {
        if (str > 0)
        {
            if (numbers[str - 1][stolb] == 0)
            {
                numbers[str - 1][stolb] = number;
                numbers[str][stolb] = 0;
            }
        }
        if (str < 4) {
            if (numbers[str + 1][stolb] == 0) {
                numbers[str + 1][stolb] = number;
                numbers[str][stolb] = 0;
            }
        }
        if (stolb > 0) {
            if (numbers[str][stolb - 1] == 0) {
                numbers[str][stolb - 1] = number;
                numbers[str][stolb] = 0;
            }
        }
        if (stolb < 4) {
            if (numbers[str][stolb + 1] == 0) {
                numbers[str][stolb + 1] = number;
                numbers[str][stolb] = 0;
            }
        }
    }
    
    /**
     * Функция меняет местами 2 произвольные кнопки.
     */
    public void auto_move(){
        Random generator = new Random();
        int k = 0;
        int l = 0;        
        k = generator.nextInt(5);
        l = generator.nextInt(5);
        move(k, l, numbers[k][l]);      
    }
    /**
     * Функция произвольно перемешивает кнопки на поле в начале игры.
     */
    public void generate() {      
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++)
            {
                numbers[i][j] = i * 5 + j;     
            }
        }        
        int count = 0;
        while( count < 1000)
        {          
            auto_move();
            count ++;   
            
        }  
        while (numbers[4][4] !=0 ){
            auto_move();
        }
    }
    
    /**
     * Класс вызывает функции перемещения кнопок при нажатии на любую из них.
     */
    private class ClickListener implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setVisible(false);
            String name = button.getText();
            change(Integer.parseInt(name));
            }
    }    
    /**
     * Проверка на выигрыш
     * @return выиграли или еще нет 
     */
    public boolean checkWin() { 
        boolean status = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 4 && j > 3)
                    break;
                if (numbers[i][j] != i * 5 + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }
    /**
     * Сдвиг выбранной кнопке на соседнее пустое место.
     * @param number Цифра на выбранной кнопке.
     */
    public void change(int number)
    {
        int i = 0;
        int j = 0;
        for (int k = 0; k < 5; k++)
        {
            for (int l = 0; l < 5; l++)
            {
                if (numbers[k][l] == number)
                {
                    i = k;
                    j = l;
                }
            }            
        }
        move(i, j, number);
        DrawField();
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "Вы выиграли", "Поздравляем!", JOptionPane.INFORMATION_MESSAGE);
            generate();
            DrawField();
        }      
    }


    public static void main(String[] args) {
        JFrame app = new Spektr();        
        app.setVisible(true);
    }
}