// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;

// public class GUIManager {

//     //initialize everything outside of it so method could use it
    
//     public GUIManager() {
//         // FRAME CONTAINS EVERYTHING
//         JFrame frame = new JFrame();
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setTitle("GUI MANAGER");
//         frame.setSize(1280, 720);
//         frame.setResizable(false);

//         // main
//         JPanel panel = new JPanel(new GridBagLayout());
//         panel.setBackground(Color.red);
        
//         JButton button = new JButton("ADDDDDD");
//         JButton viewButton = new JButton("VIEWWWWWWW");
//         JLabel label = new JLabel("BACKLOG");

//         GridBagConstraints c = new GridBagConstraints();
//         c.insets = new Insets(10,10,10,10);
//         c.gridx = 0;

//         //formatting the main menu
//         c.gridy = 0;
//         panel.add(label, c);
//         c.gridy = 1;
//         panel.add(button, c);
//         c.gridy = 2;
//         panel.add(viewButton, c);

//         label.setFont(new Font("Arial", Font.PLAIN, 50));

//         // add menu
//         JPanel panel2 = new JPanel(new GridBagLayout());
//         panel2.setBackground(Color.blue);

//         JButton button2 = new JButton("GO BACK");
//         JLabel label2 = new JLabel("SET BACKLOG");

//         //formatting for add panel
//         c.gridy = 0;
//         panel2.add(label2, c);
//         c.gridy = 1;
//         panel2.add(button2, c);


//         // view panel
//         JPanel viewPanel = new JPanel(new GridBagLayout());
//         viewPanel.setBackground(Color.yellow);

//         JButton viewReturn = new JButton("GO BACK TO MAIN");
//         JLabel viewLabel = new JLabel("LOOK");
//         c.gridy = 0;
//         viewPanel.add(viewLabel, c);
//         c.gridy = 1;
//         viewPanel.add(viewReturn, c);

//         // CardLayout Container
//         JPanel cards = new JPanel(new CardLayout());
//         cards.add(panel, "PANEL1");   
//         cards.add(panel2, "PANEL2");  
//         cards.add(viewPanel, "VIEWPANEL"); 

//         // Add cards to frame
//         frame.getContentPane().add(cards, BorderLayout.CENTER);

//         // main menu --> add
//         button.addActionListener(e -> {
//             CardLayout c1 = (CardLayout) cards.getLayout();
//             c1.show(cards, "PANEL2");
//         });

//         // add --> main menu
//         button2.addActionListener(e -> {
//             CardLayout c1 = (CardLayout) cards.getLayout();
//             c1.show(cards, "PANEL1");
//         });

//         // main menu --> view
//         viewButton.addActionListener(e -> {
//             CardLayout c1 = (CardLayout) cards.getLayout();
//             c1.show(cards, "VIEWPANEL");
//         });

//         // view --> main menu
//         viewReturn.addActionListener(e -> {
//             CardLayout c1 = (CardLayout) cards.getLayout();
//             c1.show(cards, "PANEL1");
//         });

       
//         frame.setVisible(true);
//     }


//     public static void main(String[] args) {
//         new GUIManager();
//     }


//     public Object switchMenu(String string) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'switchMenu'");
//     }
// }