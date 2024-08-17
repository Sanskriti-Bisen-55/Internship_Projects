package RandomPasswordProject;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;


public class RandomPasswordGenerator extends JFrame{
    
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    
    private JTextField passwordField;
    private JTextField lengthField;
    private JCheckBox uppercaseBox, lowercaseBox, numbersBox, specialCharBox;
    private JButton generateButton;
    private JLabel passwordLabel;
    
    public RandomPasswordGenerator () {
        
        super("Random Password Generator");
        pack();
        
//        Set up the frame
        setSize (550, 450);
        setLocation(350, 150);
        getContentPane().setBackground(Color.pink);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLayout (null);
        
//         Add label to display the generated password
        passwordLabel = new JLabel("Generated Password: ");
        passwordLabel.setBounds(20, 20, 160, 30);
        passwordLabel.setFont (new Font("Arial", Font.BOLD, 14));
        add(passwordLabel);
        
//        Add Text Fields for generated password
        passwordField = new JTextField();
        passwordField.setBounds(190, 15, 250, 40);
        passwordField.setFont (new Font("Arial", Font.BOLD, 14));
        passwordField.setBackground(Color.BLACK);
        passwordField.setForeground (Color.ORANGE);
        add(passwordField);
        
        
//        Add  Password Length Label
        JLabel lengthLabel = new JLabel ("Password Length:");
        lengthLabel.setBounds (20, 75, 120, 30);
        lengthLabel.setFont(new Font ("Arial", Font.BOLD, 13));
        add(lengthLabel);
        
//        Add Text Field for Password Length
        lengthField = new JTextField();
        lengthField.setBounds(140, 75, 200, 30);
        lengthField.setFont (new Font("Arial", Font.BOLD, 14));
        lengthField.setBackground(Color.BLACK);
        lengthField.setForeground(Color.ORANGE);
        add(lengthField);
        
//        Add CheckBoxes
        uppercaseBox = new JCheckBox("Include Uppercase Letters");
        uppercaseBox.setBounds(20, 130, 200, 30);
        uppercaseBox.setFont (new Font ("Arial", Font.BOLD, 13));
        add(uppercaseBox);
        
        lowercaseBox = new JCheckBox("Include Lowercase Letters");
        lowercaseBox.setBounds(20, 180, 200, 30);
        lowercaseBox.setFont (new Font ("Arial", Font.BOLD, 13));
        add(lowercaseBox);
        
        numbersBox = new JCheckBox("Include Numbers");
        numbersBox.setFont(new Font ("Arial", Font.BOLD, 13));
        numbersBox.setBounds(20, 230, 200, 30);
        add(numbersBox);
        
        specialCharBox = new JCheckBox ("Include Special Characters");
        specialCharBox.setBounds(20, 280, 200, 30);
        specialCharBox.setFont(new Font ("Arial", Font.BOLD, 13));
        add(specialCharBox);
        
        
//        Add Generate Button
        generateButton = new JButton ("Generate Password");
        generateButton.setFont (new Font("Arial", Font.BOLD, 16));
        generateButton.setForeground(Color.YELLOW);
        generateButton.setBackground(Color.BLACK);
        generateButton.setBounds(190, 345, 190, 35);
        add(generateButton);
       
        
//        Action Listener for Generate Button
         generateButton.addActionListener (new ActionListener() {
              @Override
              public void actionPerformed (ActionEvent ae){
                  
//          1. Check if the length input is empty
                  String lengthText = lengthField.getText().trim(); 
                  if (lengthText.isEmpty()){
                      lengthField.setText(" Please Enter Length!!");
                      return;
                  }
                  
//         //      Try to parse the length to an integer
                  int length;
                  try {
                      length = Integer.parseInt(lengthText);
                  }
                  catch (NumberFormatException ex)
                  {
                      lengthField.setText(" Invalid length!");
                      return;
                  }                       
                      
 // 2. Check which character sets are selected using the checkboxes or it is empty
 
                  boolean includeUppercase = uppercaseBox.isSelected();
                  boolean includeLowercase = lowercaseBox.isSelected();
                  boolean includeNumbers = numbersBox.isSelected();
                  boolean includeSpecialChars = specialCharBox.isSelected();
                  
                  String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
                  passwordField.setText(password);
               
              }
         });
    }
    
    private String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars){
        String characterPool  = "";
        
        if (includeUppercase) characterPool += UPPERCASE;
        if (includeLowercase) characterPool += LOWERCASE;
        if (includeNumbers) characterPool += NUMBERS;
        if (includeSpecialChars) characterPool += SPECIAL_CHARACTERS;
        
        if (characterPool.isEmpty()){
            return " Please select at least one character type!!";
           
        }
       
        
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }
        
        return password.toString();
    
    }

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
            new RandomPasswordGenerator().setVisible(true);
        }
     });    
    }
}


