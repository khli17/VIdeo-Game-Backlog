import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;

public class AddGameLogMenu extends JPanel{

    private ArrayList<Game> gameBacklog = new ArrayList<>();

    public AddGameLogMenu(GUIManager manager){
    // add menu

    setLayout(new GridBagLayout());
    setBackground(Color.blue);

    //gridbag layout
    GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;

        JLabel addLabelTitle = new JLabel("Set Backlog");

        JButton returnButton = new JButton("Return to Menu");

        addLabelTitle.setFont(new Font("Arial", Font.BOLD, 50));

        returnButton.setPreferredSize(new Dimension(300,100));
        returnButton.setFont(new Font("Arial", Font.PLAIN, 20));
     
        //formatting for add panel
        c.gridy = 0;
        add(addLabelTitle, c);
        c.gridy = 10;
        add(returnButton, c);

        //bbutton to treutnr back to main menu
        returnButton.addActionListener(e -> manager.switchMenu("PANEL1"));

        //create the place to enter the info
        
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100, 30));
        JTextField hours = new JTextField();
        String[] options = {"Not Played Yet", "Currently Playing", "Completed"};
        JComboBox<String> status = new JComboBox<>(options);

        c.gridy = 1;
        add(nameField, c);
        c.gridy = 2;
        add(hours, c);
        c.gridy = 3;
        add(status, c);

        String text = nameField.getText();
        File file = new File("backlog.txt");



    }
}
