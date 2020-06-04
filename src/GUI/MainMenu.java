package GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private JButton playBtn;
    private CardLayout cardLayout = Frame.cardLayout;
    public JPanel mainPanel;

    public MainMenu(){
        mainPanel = Frame.cardPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.blue));

        playBtn = new JButton("Play");
        add(playBtn);

        buttonListeners();
    }

    private void buttonListeners(){
        playBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "TestingMap");
            //Testing map should be started here
        });
    }
}
