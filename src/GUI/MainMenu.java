package GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private JButton playBtn;
    private CardLayout cardLayout = Frame.cardLayout;
    private JPanel mainPanel = Frame.cardPanel;

    public MainMenu(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.blue));
        components();
        buttonListeners();
    }

    private void components(){
        playBtn = new JButton("Play");
        add(playBtn);
    }

    private void buttonListeners(){
        playBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "TestingMap");
            //Testing map should be started here
        });
    }
}
