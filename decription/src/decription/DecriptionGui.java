/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decription;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author eliot
 */
public class DecriptionGui extends JFrame{

    private DescriptionController controller;
    
    Font headersFont = new Font("TimesRoman", Font.BOLD, 60);
    Font textFont= new Font("SansSerif", Font.ITALIC, 25);
    JTextArea textReader = new JTextArea(5,50);
    JTextArea textDisplay = new JTextArea(5,50);

    
    
    
    public void decriptionGui() {
        JFrame frame = new JFrame("Decription maker");
        frame.setLayout(new GridLayout(3,1,10,10));
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(new JLabel("Enter message:"));
        p1.add(textReader);
        JButton button = new JButton("Submit");
        button.setFont(textFont);
        button.setSize(200,50);
        button.addActionListener(new ButtonListener());
        p2.add(button);
        p3.setLayout(new FlowLayout());
        p3.add(new JLabel("Decripted Message:"));
        p3.add(textDisplay);
        
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }// close class
    
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setText(textReader.getText());
            controller.modelCaller();
            textDisplay.setText(controller.getHash());
        }//close method
    }// close class

   
    public DescriptionController getController() {
        return controller;
    }// close class


    public void setController(DescriptionController controller) {
        this.controller = controller;
    }//close class
    
}// close class
