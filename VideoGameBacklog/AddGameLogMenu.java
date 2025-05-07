import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


public class AddGameLogMenu extends JPanel{

    private ArrayList<Game> gameBacklog = new ArrayList<>();

    public AddGameLogMenu(GUIManager manager){
    // add menu

    setLayout(new GridBagLayout());
    setBackground(Color.cyan);

    //gridbag layout
    GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;

        JLabel addLabelTitle = new JLabel("Add a Game!");
        

        JButton returnButton = new JButton("Return to Menu");

        addLabelTitle.setFont(new Font("Arial", Font.BOLD, 50));

        returnButton.setPreferredSize(new Dimension(300,100));
        returnButton.setFont(new Font("Arial", Font.PLAIN, 20));
    
        //button to return to main menu
        returnButton.addActionListener(e -> manager.switchMenu("MainMenu"));

        //create the place to enter the info
        JLabel gameName = new JLabel("Name of Game:");
        gameName.setFont(new Font("Arial", Font.BOLD, 30));
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 30));

        JLabel gameHoursLabel = new JLabel("Hours:");
        gameHoursLabel.setFont(new Font("Arial", Font.BOLD, 30));
        JTextField hoursField = new JTextField();
        hoursField.setPreferredSize(new Dimension(80, 30));

        JLabel gameStatusLabel = new JLabel("Game Status:");
        gameStatusLabel.setFont(new Font("Arial", Font.BOLD, 30));
        String[] options = {"Not Played Yet", "Currently Playing", "Completed"};
        JComboBox<String> statusBox = new JComboBox<>(options);

        JButton saveLog = new JButton("Save Log");
        saveLog.setPreferredSize(new Dimension(200, 80));

        //saving info from user to a file txt
        saveLog.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                try {
                String name = nameField.getText();
                int hours = Integer.parseInt(hoursField.getText());
                String gameStatus = (String) statusBox.getSelectedItem();
                Game newGame = new Game(name, hours, gameStatus);
                gameBacklog.add(newGame);

                //adding to file
                FileWriter writer = new FileWriter("backlog.txt", true);
                writer.write(name+ "," + hours + "," + gameStatus + "\n");
                writer.close();
            
                //Clear fields
                nameField.setText("");
                hoursField.setText("");
                statusBox.setSelectedIndex(0);

                 } catch (IOException ioEx) {
            ioEx.printStackTrace(); // for any posssible errors when adding games
            JOptionPane.showMessageDialog(null, "Error saving log to file.", "File Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException numEx) {
            JOptionPane.showMessageDialog(null, "Please fill each field.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
            }
        });


        //attempt at formatting 
        c.gridy = 0;
        add(addLabelTitle, c);
        c.gridy = 1;
        add(gameName, c);
        c.gridx = 1;
        add(nameField, c);

        c.gridy = 2;
        c.gridx = 0;
        add(gameHoursLabel, c);
        c.gridx = 1;
        add(hoursField, c);

        c.gridy = 3;
        c.gridx = 0;
        add(gameStatusLabel, c);
        c.gridx = 1;
        add(statusBox, c);

        c.gridx = 0;
        c.gridy=4;
        add(saveLog,c);

        c.gridy = 5;
        add(returnButton, c);


    }
}
