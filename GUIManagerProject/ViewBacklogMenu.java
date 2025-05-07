import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ViewBacklogMenu extends JPanel {

    public ViewBacklogMenu(GUIManager manager) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;

        setBackground(Color.yellow);

        JButton viewReturn = new JButton("Return to Menu");
        JLabel viewLabel = new JLabel("Backlog");
        viewLabel.setFont(new Font("Arial", Font.BOLD, 50));
        viewReturn.setPreferredSize(new Dimension(300, 100));
        viewReturn.setFont(new Font("Arial", Font.PLAIN, 20));

        c.gridy = 0;
        add(viewLabel, c);

        //panel to display backlog games in a scrollable format
        JPanel backlogPanel = new JPanel();
        backlogPanel.setLayout(new BoxLayout(backlogPanel, BoxLayout.Y_AXIS));
        backlogPanel.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane(backlogPanel);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        JPanel scrollWrapper = new JPanel(new BorderLayout());
        scrollWrapper.setBackground(Color.yellow);
        scrollWrapper.add(scrollPane, BorderLayout.CENTER);
        scrollWrapper.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

        c.gridy = 1;
        add(scrollWrapper, c);

        //reading each game from backlog file
        File file = new File("backlog.txt");
        ArrayList<Game> games = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                //parses each variable in backlog.txt and sets it to game object
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String name = parts[0].trim();
                        double hours = Double.parseDouble(parts[1].trim());
                        String status = parts[2].trim();
                        games.add(new Game(name, hours, status));
                    }
                }
            } catch (IOException ex) {
                JLabel errorLabel = new JLabel("Error reading file.");
                backlogPanel.add(errorLabel);
                ex.printStackTrace();
            }

            //setting game object
            for (int i = 0; i < games.size(); i++) {
                Game game = games.get(i);
                String name = game.getName();
                String hours = String.valueOf(game.getHours());
                String status = game.getStatus();
                int index = i;

                //panel for putting each game and its info
                JPanel entryPanel = new JPanel(new BorderLayout());
                entryPanel.setBackground(Color.white);
                entryPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.gray),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                infoPanel.setBackground(Color.white);
                infoPanel.add(new JLabel("Game: " + name));
                infoPanel.add(new JLabel("Hours: " + hours));
                infoPanel.add(new JLabel("Status: " + status));
                entryPanel.add(infoPanel, BorderLayout.WEST);

                //panel for buttons
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
                buttonPanel.setBackground(Color.white);

                JButton editButton = new JButton("Edit");
                JButton deleteButton = new JButton("Delete");
                editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                //Edit button that is placed with each game if user wants to edit a specific log
                editButton.addActionListener(e -> {
                    JTextField nameField = new JTextField(name);
                    JTextField hoursField = new JTextField(hours);
                    String[] statusOptions = {"Not Played Yet", "Currently Playing", "Completed"};
                    JComboBox<String> statusBox = new JComboBox<>(statusOptions);
                    statusBox.setSelectedItem(status);

                    JPanel editPanel = new JPanel(new GridLayout(0, 1));
                    editPanel.add(new JLabel("Game Name:"));
                    editPanel.add(nameField);
                    editPanel.add(new JLabel("Hours:"));
                    editPanel.add(hoursField);
                    editPanel.add(new JLabel("Status:"));
                    editPanel.add(statusBox);

                    int result = JOptionPane.showConfirmDialog(this, editPanel, "Edit Game Log",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        game.setName(nameField.getText());
                        game.setHours(Double.parseDouble(hoursField.getText()));
                        game.setStatus((String) statusBox.getSelectedItem());
                        updateBacklogFile(games);
                        manager.refreshView();
                    }
                });

                //Delete button, same as edit button but deletes game
                deleteButton.addActionListener(e -> {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "Delete \"" + name + "\"?", "Confirm Delete",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        games.remove(index);
                        updateBacklogFile(games);
                        manager.refreshView();
                    }
                });

                buttonPanel.add(editButton);
                buttonPanel.add(Box.createVerticalStrut(10));
                buttonPanel.add(deleteButton);

                entryPanel.add(buttonPanel, BorderLayout.EAST);
                backlogPanel.add(entryPanel);
                backlogPanel.add(Box.createVerticalStrut(10));
            }

        } else {
            JLabel noFileLabel = new JLabel("No file found.");
            backlogPanel.add(noFileLabel);
        }

        c.gridy = 2;
        add(viewReturn, c);

        viewReturn.addActionListener(e -> manager.switchMenu("MainMenu"));
    }

    //updates arraylist of all of the games in backlog
    private void updateBacklogFile(ArrayList<Game> games) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("backlog.txt"))) {
            for (Game g : games) {
                writer.write(g.getName() + "," + g.getHours() + "," + g.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}