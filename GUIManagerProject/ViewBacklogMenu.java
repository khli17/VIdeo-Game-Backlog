import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewBacklogMenu extends JPanel{

    public ViewBacklogMenu (GUIManager manager){

    // view panel

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

        setBackground(Color.yellow);

        JButton viewReturn = new JButton("GO BACK TO MAIN");
        JLabel viewLabel = new JLabel("LOOK");
        c.gridy = 0;
        add(viewLabel, c);
        c.gridy = 1;
        add(viewReturn, c);

        //menu to return back to main menu
        viewReturn.addActionListener(e -> manager.switchMenu("PANEL1"));

        //add where to see the whole log 
    }
}
