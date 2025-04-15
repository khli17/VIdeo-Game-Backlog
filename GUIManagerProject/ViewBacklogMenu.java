import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewBacklogMenu extends JPanel{

    public ViewBacklogMenu (GUIManager manager){

    // view panel

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;

        setBackground(Color.yellow);

        JButton viewReturn = new JButton("Return to Menu");
        
        JLabel viewLabel = new JLabel("Backlog");
        
        viewLabel.setFont(new Font("Arial", Font.BOLD, 50));

        viewReturn.setPreferredSize(new Dimension(300,100));
        viewReturn.setFont(new Font("Arial", Font.PLAIN, 20));
     
        c.gridy = 0;
        add(viewLabel, c);
        c.gridy = 1;
        add(viewReturn, c);

        //menu to return back to main menu
        viewReturn.addActionListener(e -> manager.switchMenu("PANEL1"));

        //add where to see the whole log 
    }
}
