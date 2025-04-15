import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIManager {

    //initialize everything outside of it so method could use it
    JFrame frame;
    JPanel cards;
    CardLayout cardLayout;
    
    public GUIManager() {
        // FRAME CONTAINS EVERYTHING
        frame = new JFrame("Video Game Backlog Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 720);
        frame.setResizable(false);


        //adding the menus
        MainMenu panel = new MainMenu(this);
        AddGameLogMenu panel2 = new AddGameLogMenu(this);
        ViewBacklogMenu viewPanel = new ViewBacklogMenu(this);

        // CardLayout Container
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.add(panel, "PANEL1");   
        cards.add(panel2, "PANEL2");  
        cards.add(viewPanel, "VIEW"); 

        // Add cards to frame
        frame.getContentPane().add(cards, BorderLayout.CENTER);
        frame.add(cards);
       
        frame.setVisible(true);
    }

    public void switchMenu(String toMenu){
        cardLayout.show(cards, toMenu);
    }

    public static void main(String[] args) {
        new GUIManager();
    }
}