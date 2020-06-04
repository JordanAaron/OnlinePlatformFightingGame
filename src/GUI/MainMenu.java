package GUI;

import Main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private JFrame frame;
    private JButton playBtn;

    public MainMenu(JFrame frame){
        this.frame = frame;
        setLayout(new BorderLayout());
        components();
        buttonListeners();
    }

    private void components(){
        playBtn = new JButton("Play");
        add(playBtn);
    }

    private void buttonListeners(){
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Game());
                frame.invalidate();
                frame.validate();
            }
        });
    }
}
