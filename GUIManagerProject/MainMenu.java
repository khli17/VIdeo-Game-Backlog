import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel {
    
    public MainMenu(GUIManager manager){

        setLayout(new GridBagLayout());
        setBackground(Color.red);
        
        JButton button = new JButton("ADDDDDD");
        JButton viewButton = new JButton("VIEWWWWWWW");
        JLabel label = new JLabel("BACKLOG");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;

        //formatting the main menu
        c.gridy = 0;
        add(label, c);
        c.gridy = 1;
        add(button, c);
        c.gridy = 2;
        add(viewButton, c);

        label.setFont(new Font("Arial", Font.PLAIN, 50));

        // main menu --> add
        button.addActionListener(e -> manager.switchMenu("PANEL2"));

        viewButton.addActionListener(e -> manager.switchMenu("VIEW"));
        
    }
}
