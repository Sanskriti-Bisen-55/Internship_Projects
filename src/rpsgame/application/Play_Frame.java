package rpsgame.application;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;


public class Play_Frame extends javax.swing.JFrame {
    
//    Create Border
    Border gray_b1 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY);
    Border orange_b2 = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE);
    
//    Images Path
    String rock = "/rpsIcons/Stone_image.jpeg";
    String paper = "/rpsIcons/Paper_image.jpeg";
    String scissor = "/rpsIcons/Scissor_image.jpeg";
    
//    Creat an ArrayList
    ArrayList<String> list = new ArrayList<>();
    Random random = new Random();
    int Your_wins = 0, Computer_wins = 0;
    String random_selection;
    
//    Creates new form Play_Frame
   
    public Play_Frame() {
        initComponents();
        
        jLabel_You.setBorder(gray_b1);
        jLabel_Computer.setBorder(gray_b1);
        jLabel_rock.setBorder(gray_b1);
        jLabel_paper.setBorder(gray_b1);
        jLabel_scissor.setBorder(gray_b1);
        
//        Display image in jLabels
        displayImage (rock, jLabel_rock, 147, 120);
        displayImage (paper, jLabel_paper, 147, 120);
        displayImage (scissor, jLabel_scissor, 147, 120);
        
        list.add(rock);
        list.add(paper);
        list.add(scissor);

        
    }
    
    public void displayImage (String imagePath, javax.swing.JLabel label, int width, int height)
    {
        
        ImageIcon img = new ImageIcon (getClass().getResource (imagePath));
        Image imgI = img.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon (imgI));
    }
    
    public void getWinner (String You, String Computer){
        if (You.equals(Computer))
        {
            System.out.println("Draw");
        }
        else if (You.equals(rock))
        {
            if (Computer.equals(scissor))
            {
                 Your_wins++;
                jLabel_YouWins.setText(String.valueOf(Your_wins));
            }
            else
            {
                Computer_wins++;
                jLabel_ComputerWins.setText(String.valueOf(Computer_wins));
            }
        }
        else if (You.equals(paper))
        {
            if (Computer.equals(rock))
            {
                Your_wins++;
                jLabel_YouWins.setText(String.valueOf(Your_wins));
            }
            else
            {
               Computer_wins++;
                jLabel_ComputerWins.setText(String.valueOf(Computer_wins));          
            }
        }
        
        else if (You.equals(scissor))
        {
            if(Computer.equals(paper))
            {
                Your_wins++;
                jLabel_YouWins.setText(String.valueOf(Your_wins));
            }
            else
            {
                Computer_wins++;
                jLabel_ComputerWins.setText(String.valueOf(Computer_wins));
            }
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Computer = new javax.swing.JLabel();
        jLabel_You = new javax.swing.JLabel();
        jLabel_ComputerWins = new javax.swing.JLabel();
        jLabel_YouWins = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_paper = new javax.swing.JLabel();
        jLabel_scissor = new javax.swing.JLabel();
        jLabel_rock = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 51, 0));
        jLabel4.setText("0");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("You");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.pink);

        jLabel_Computer.setOpaque(true);

        jLabel_You.setOpaque(true);

        jLabel_ComputerWins.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel_ComputerWins.setForeground(new java.awt.Color(0, 153, 51));
        jLabel_ComputerWins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ComputerWins.setText("0");

        jLabel_YouWins.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel_YouWins.setForeground(new java.awt.Color(204, 51, 0));
        jLabel_YouWins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_YouWins.setText("0");

        jLabel6.setFont(new java.awt.Font("SansSerif", 2, 23)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("You");

        jLabel8.setFont(new java.awt.Font("SansSerif", 2, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Computer");

        jLabel_paper.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_paper.setOpaque(true);
        jLabel_paper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_paperMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_paperMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_paperMouseExited(evt);
            }
        });

        jLabel_scissor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_scissor.setOpaque(true);
        jLabel_scissor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_scissorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_scissorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_scissorMouseExited(evt);
            }
        });

        jLabel_rock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_rock.setOpaque(true);
        jLabel_rock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_rockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_rockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_rockMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_YouWins, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel_ComputerWins, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel_rock, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_paper, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_scissor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabel_You, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(441, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_ComputerWins, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_YouWins, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_scissor, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel_paper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_rock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jLabel_You, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(298, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(634, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_rockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_rockMouseClicked
        // Display rock image
        displayImage (rock, jLabel_You, 150, 120);
//        Random selection
        random_selection = list.get(random.nextInt(list.size()));
//        Display image        
        displayImage (random_selection, jLabel_Computer, 150, 120);
        getWinner(rock, random_selection);
    }//GEN-LAST:event_jLabel_rockMouseClicked

    private void jLabel_paperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_paperMouseClicked
        // Display paper image
        displayImage (paper, jLabel_You, 150, 120);
        random_selection = list.get(random.nextInt(list.size()));
        displayImage (random_selection, jLabel_Computer, 150, 120);
        getWinner(paper, random_selection);
    }//GEN-LAST:event_jLabel_paperMouseClicked

    private void jLabel_scissorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_scissorMouseClicked
        // Display scissor image
        displayImage (scissor, jLabel_You, 150, 120);
        random_selection = list.get(random.nextInt(list.size()));
        displayImage (random_selection, jLabel_Computer, 150, 120);
        getWinner(scissor, random_selection);
    }//GEN-LAST:event_jLabel_scissorMouseClicked

    private void jLabel_rockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_rockMouseEntered
        // Change Border
        jLabel_rock.setBorder(orange_b2);
    }//GEN-LAST:event_jLabel_rockMouseEntered

    private void jLabel_rockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_rockMouseExited
        // Change Border
        jLabel_rock.setBorder(gray_b1);
    }//GEN-LAST:event_jLabel_rockMouseExited

    private void jLabel_paperMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_paperMouseEntered
        // Change Border
        jLabel_paper.setBorder(orange_b2);
    }//GEN-LAST:event_jLabel_paperMouseEntered

    private void jLabel_paperMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_paperMouseExited
        // Change Border

        jLabel_paper.setBorder(gray_b1);
    }//GEN-LAST:event_jLabel_paperMouseExited

    private void jLabel_scissorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_scissorMouseEntered
        // Change Border
        jLabel_scissor.setBorder(orange_b2);
    }//GEN-LAST:event_jLabel_scissorMouseEntered

    private void jLabel_scissorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_scissorMouseExited
        // Change Border
        jLabel_scissor.setBorder(gray_b1);
    }//GEN-LAST:event_jLabel_scissorMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                
        
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Play_Frame().setVisible(true);
            
        });
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Computer;
    private javax.swing.JLabel jLabel_ComputerWins;
    private javax.swing.JLabel jLabel_You;
    private javax.swing.JLabel jLabel_YouWins;
    private javax.swing.JLabel jLabel_paper;
    private javax.swing.JLabel jLabel_rock;
    private javax.swing.JLabel jLabel_scissor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
             
}
