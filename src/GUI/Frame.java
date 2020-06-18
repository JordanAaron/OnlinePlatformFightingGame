package GUI;

import InputHandling.KeyboardHandler;
import MapCreation.Maps.TestingMap;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static CardLayout cardLayout;
    public static JPanel cardPanel;

    MainMenu menuPanel;
    TestingMap testingMap;

    public Frame() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        menuPanel = new MainMenu();
        testingMap = new TestingMap(this);

        cardPanel.add(menuPanel,"menu");
        cardPanel.add(testingMap,"TestingMap");

        add(cardPanel);
        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Frame();
    }
}
