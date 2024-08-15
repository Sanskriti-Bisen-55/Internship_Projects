package snake.game;

import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;

public class SnakeGame extends JFrame{
    
    private static final int FRAME_WIDTH = 500;  
    private static final int FRAME_HEIGHT = 500;  
    
     SnakeGame(){
          super("SNAKE GAME");
          add(new SnakePanel());
          pack();
          
         setSize(FRAME_WIDTH, FRAME_HEIGHT);
         setLocationRelativeTo(null);
         setResizable(false);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    }
     
    public static void main(String[] args) {
        new SnakeGame().setVisible(true);
        
    }
    
}
