package wordlegame.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import wordlegame.controller.*;

import javax.swing.*;

public class CategorySelectionGUI implements ActionListener
{
    ArrayList<JButton> categoryButtons = new ArrayList<JButton>();
    Controller controller;
    JFrame mainFrame;
    public CategorySelectionGUI(Controller controller)
    {
        this.controller = controller;
        mainFrame = new JFrame("Wordle");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));  
        mainPanel.setPreferredSize(new Dimension(580,800));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel title = new JLabel("WORDLE");
        title.setFont(new Font("Serif", Font.BOLD, 80));
        title.setForeground(Color.WHITE);
        titlePanel.setPreferredSize(new Dimension(580,80));
        
        JPanel instructionPanel = new JPanel();
        instructionPanel.setBackground(Color.BLACK);
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.X_AXIS));
        JLabel instructions = new JLabel ("<html>Please select which category you would like your five letter word to be chosen from.</html>");
        instructions.setFont(new Font("Serif", Font.PLAIN, 24));
        instructions.setForeground(Color.WHITE);
        instructionPanel.setPreferredSize(new Dimension(580,80));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));

        JButton animalsButton = new JButton("Animals");
        categoryButtons.add(animalsButton);
        JButton citiesButton = new JButton("Cities");
        categoryButtons.add(citiesButton);
        JButton countriesButton = new JButton("Countries");
        categoryButtons.add(countriesButton);

        for (JButton categoryButton : categoryButtons)
        {
            categoryButton.setOpaque(true);
            categoryButton.setBorderPainted(false);
            categoryButton.setBackground(Color.YELLOW);
            categoryButton.addActionListener(this);
            buttonPanel.add(categoryButton);
        }

        titlePanel.add(title);
        mainPanel.add(titlePanel);
        instructionPanel.add(instructions);
        mainPanel.add(instructionPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,150)));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,250)));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainFrame.getContentPane().add(mainPanel);
  
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        JButton jButton = (JButton)event.getSource();
        this.controller.getCategory(jButton.getText());
        mainFrame.setVisible(false);
        mainFrame.dispose();
    } 
}
