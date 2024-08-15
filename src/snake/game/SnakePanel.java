package snake.game;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SnakePanel extends JPanel implements ActionListener{
    
    private Image Red_Image;
    private Image Green_Image;
    private Image Fruit_Image;
    
    private final int ALL_SQUARE = 900;
    private final int SQUARE_SIZE = 10;
    private final int RANDOM_POSITION = 20;
    
    private int fruit_x;
    private int fruit_y;
    
    private final int x[] = new int [ALL_SQUARE];
    private final int y[] = new int [ALL_SQUARE];
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
     private boolean inGame = true;
    
     private int square;
     private int score = 0;
     private Timer timer;
    
    SnakePanel (){
        addKeyListener(new TAdapter());
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 300));
        setFocusable(true);
        
        loadImages ();
        InitSnake ();
        
    }
    
    public void loadImages(){ 
      
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("SnakeIcons/Fruit_Image.jpeg"));
        Fruit_Image = I1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        ImageIcon I2 = new ImageIcon(ClassLoader.getSystemResource("SnakeIcons/Red_Image.jpeg"));
        Red_Image = I2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        
        ImageIcon I3 = new ImageIcon(ClassLoader.getSystemResource("SnakeIcons/Green_Image.jpeg"));
        Green_Image = I3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    }
    
    public void InitSnake(){
        square = 3;
        
        for (int i = 0; i <= square; i++){
             y[i] = 50;
            x[i] = 50 - i * SQUARE_SIZE;
        }
        
        locateFruit();
        
        timer = new Timer(140, this );
        timer.start();
    }
    
    public void locateFruit(){
          int r = (int)(Math.random() * RANDOM_POSITION);
        fruit_x = r * SQUARE_SIZE;
        
          r = (int)(Math.random() * RANDOM_POSITION);
        fruit_y = r * SQUARE_SIZE;
    }
    
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        
        draw(g);
    }
    
    public void draw(Graphics g) {
        if (inGame){
            g.drawImage (Fruit_Image, fruit_x, fruit_y, this);
       
            for (int i = 0; i < square; i++){
                if ( i == 0){
                    g.drawImage(Red_Image, x[i], y[i], this);
                }
                else {
                    g.drawImage(Green_Image, x[i], y[i], this);
                }
            }
            
            Toolkit.getDefaultToolkit().sync();
            
//            Draw the Score
        String scoreText = "Score: " + score;
        Font font = new Font(" Viner Hand ITC ", Font.BOLD, 30);
        FontMetrics metrices = getFontMetrics(font);
        
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString(scoreText,(500 -  metrices.stringWidth (scoreText))/2, g.getFont().getSize());
             
        }
         else
        {
          GameOver(g);
        }   
    }
    
    public void GameOver (Graphics g){
        String msg = "Game Over !";
        Font font = new Font("Arial Black", Font.ITALIC, 45);
        FontMetrics metrices = getFontMetrics(font);
        
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString(msg, (490 - metrices.stringWidth(msg))/2, 490/2);
        
    }
    
    public void move(){
        for (int i = square; i > 0; i--){
         x[i] = x[i - 1];
         y[i] = y[i - 1];
     }   
     
     if (leftDirection){
         x[0] = x[0] - SQUARE_SIZE;
        }
        if (rightDirection) {
            x[0] = x[0] + SQUARE_SIZE;
        }
        if (upDirection) {
            y[0] = y[0] - SQUARE_SIZE;
        }
        if (downDirection) {
            y[0] = y[0] + SQUARE_SIZE;
        }
    }
    
     public void checkFruit() {
        if ((x[0] == fruit_x) && (y[0] == fruit_y)) {
            square++;
            score++;
            locateFruit();
        }
    }
     
     public void checkCollision() {
        for(int i = square; i > 0; i--) {
            if (( i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }
        if (y[0] >= 435) {
            inGame = false;
        }
        if (x[0] >= 455) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
     }
     
     public void actionPerformed(ActionEvent ae) {
        if (inGame) {
            checkFruit();
            checkCollision();
            move();
        }
        
        repaint();
    }
     
     
      public class TAdapter extends KeyAdapter {
          @Override
          
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            
             if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                  rightDirection = true;
                upDirection = false;
                downDirection = false;
             }
             
              if (key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
             
            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false; 
            }
        }
    }
       
}
    
