import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddGameLogMenu extends JPanel{

    public AddGameLogMenu(GUIManager manager){
    // add menu

    setLayout(new GridBagLayout());
    setBackground(Color.blue);

    //gridbag layout
    GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;

        JLabel label2 = new JLabel("SET BACKLOG");

        JButton button2 = new JButton("GO BACK");


        //formatting for add panel
        c.gridy = 0;
        add(label2, c);
        c.gridy = 1;
        add(button2, c);

        //bbutton to treutnr back to main menu
        button2.addActionListener(e -> manager.switchMenu("PANEL1"));

        //create the place to enter the info
        

    }
}
