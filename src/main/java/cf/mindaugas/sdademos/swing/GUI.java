package cf.mindaugas.sdademos.swing;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI{

    private JButton button;
    private JLabel label;
    private ButtonCounter counter;

    public GUI() {
        button = new JButton("Push Me");
        counter = new ButtonCounter(this);
        button.addActionListener(counter);
        label = new JLabel("Waiting...");
        JFrame frame = new JFrame("GUI");
        frame.add(label);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        System.out.println("GUI started!");
    }

    public void setLabel(String s){
        label.setText(s);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("starting GUI");
                GUI mf = new GUI();
            }
        });
    }
}

class ButtonCounter implements ActionListener
{
    private GUI gui;
    private int count;
    public ButtonCounter(GUI view) {
        gui = view;
        count = 0;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed");
        count = count + 1;
    }

    public void reset(){
        count = 0;
    }
}