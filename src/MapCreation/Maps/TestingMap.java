package MapCreation.Maps;

import GUI.Frame;
import GUI.MainMenu;
import InputHandling.KeyboardHandler;
import MapCreation.MapComponents.Component;
import MapCreation.MapComponents.Platform;
import Players.GenericPlayer;
import Players.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestingMap extends JPanel implements Runnable, Map {
    private Frame frame;

    private static Thread thread;
    private static Boolean running;

    private static Platform floor = new Platform(0,100 - 5,100,5,Color.gray);
    private static Platform leftPlatform = new Platform(20,60,15,5,Color.white);
    private static Platform rightPlatform = new Platform(80 - 15,60,15,5,Color.white);

    public static GenericPlayer genericPlayer = new GenericPlayer(72, rightPlatform.yPos-7,Color.pink);

    private  ArrayList<MapCreation.MapComponents.Component> components = new ArrayList<>();
    private ArrayList<Players.Player> players = new ArrayList<>();

    public TestingMap(Frame frame){
        this.frame = frame;

        frame.addKeyListener(new KeyboardHandler());

        setBackground(Color.black);

        this.components.add(floor);
        this.components.add(leftPlatform);
        this.components.add(rightPlatform);

        this.players.add(genericPlayer);

        MainMenu.getMapReference(this, "TestingMap");

        running = false;
        //start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Component c : this.components){
            c.updateWidth(this.getWindowWidth());
            c.updateHeight(this.getWindowHeight());
            c.draw(g);
        }

        for(Player p : this.players){
            p.updateWidth(this.getWindowWidth());
            p.updateHeight(this.getWindowHeight());
            p.draw(g);
        }
    }

    public void start() {
        if (running){
            return;
        } else {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public int getWindowWidth(){
        return frame.getContentPane().getSize().width;
    }

    @Override
     public int getWindowHeight(){
        return frame.getContentPane().getSize().height;
    }

    @Override
    public void run() {
        System.out.println("running...");
        while (running) {

            genericPlayer.movement();
            repaint();

            try {
                thread.sleep(28);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
