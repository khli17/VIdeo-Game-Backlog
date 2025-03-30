import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame(){
        
        JLabel label = new JLabel();
        label.setText("Backlog Organizer");
        label.setFont(new Font("Arial", Font.PLAIN, 50));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        //label.setBounds(640, 100, 250,0250);
        
        JButton addGames = new JButton("Add Game");
        addGames.setSize(100, 50);
        

        //Main Menu Panel
        JPanel mainMenu = new JPanel();
        // mainPanel.setLayout(new BorderLayout());
        mainMenu.setBackground(Color.green);
        mainMenu.add(label);
        mainMenu.add(addGames);
        JPanel addPanel = new JPanel();
        addPanel.add(new JTextField("Enter", 20));
        addPanel.setBackground(Color.blue);

        addGames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) mainMenu.getLayout()).show(addPanel, "Add Games");
            }
        });


        JPanel mainPanel = new JPanel(new CardLayout());
        mainPanel.add(mainMenu);
        mainPanel.add(addPanel);
      
        

        //frame
        this.setTitle("Manager Test");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(mainPanel);
        this.add(addPanel);
       
        

        
    }

    // public void itemStateChanged(ItemEvent evt){
    //     CardLayout c1 = (CardLayout)(mainPanel.getLayout());
    // }
}
