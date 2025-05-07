import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    
    public MainMenu(GUIManager manager){

        setLayout(new GridBagLayout());
        setBackground(Color.green);
        
        JButton addButton = new JButton("Add Video Game");
        JButton viewButton = new JButton("View Backlog");
        addButton.setPreferredSize(new Dimension(300,100));
        viewButton.setPreferredSize(new Dimension(300,100));
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        viewButton.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel title = new JLabel("Video Game Backlog");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;

        //formatting the main menu
        c.gridy = 0;
        add(title, c);
        c.gridy = 1;
        add(addButton, c);
        c.gridy = 2;
        add(viewButton, c);

        title.setFont(new Font("Arial", Font.BOLD, 50));

        //buttons for adding backlog/view backlog
        addButton.addActionListener(e -> manager.switchMenu("AddGame"));

        viewButton.addActionListener(e -> manager.switchMenu("ViewBacklog"));
        
    }
}
