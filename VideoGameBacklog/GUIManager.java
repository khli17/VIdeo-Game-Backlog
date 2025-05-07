import java.awt.*;
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
        MainMenu mainPanel = new MainMenu(this);
        AddGameLogMenu addPanel = new AddGameLogMenu(this);
        ViewBacklogMenu viewPanel = new ViewBacklogMenu(this);

        //layout for variables fields etc
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.add(mainPanel, "MainMenu");   
        cards.add(addPanel, "AddGame");  
        cards.add(viewPanel, "ViewBacklog"); 

        // Add cards to frame
        frame.getContentPane().add(cards, BorderLayout.CENTER);
        frame.add(cards);
       
        frame.setVisible(true);
    }

    public void switchMenu(String toMenu){
        if (toMenu.equals("ViewBacklog")) {
            // Remove the old panel if it exists and adds new one
            cards.remove(2); 
            ViewBacklogMenu newViewPanel = new ViewBacklogMenu(this);
            cards.add(newViewPanel, "ViewBacklog");
        }
        cardLayout.show(cards, toMenu);
    }
    //makes it so view backlog actually updates without having to exit whole program
    public void refreshView(){
        cards.remove(2); 
        ViewBacklogMenu refresh = new ViewBacklogMenu(this);
        cards.add(refresh, "ViewBacklog");
        cardLayout.show(cards, "ViewBacklog");
        cards.revalidate();
        cards.repaint();
    }


    public static void main(String[] args) {
        new GUIManager();
    }
}
