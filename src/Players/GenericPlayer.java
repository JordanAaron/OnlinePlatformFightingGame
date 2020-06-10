package Players;

import java.awt.*;

public class GenericPlayer extends Player {
    public static int playerWidth,playerHeight;

    private Color color;

    public GenericPlayer(int x, int y, Color c) {
        super(x, y);
        this.color = c;

        playerWidth = 4;
        playerHeight = 7;
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double)this.xPos/100) * this.getScreenWidth);
        int yPos = (int)(((double)this.yPos/100) * this.getScreenHeight);
        int w = (int)(((double) playerWidth /100) * this.getScreenWidth);
        int h = (int)(((double) playerHeight /100) * this.getScreenHeight);

        g.setColor(color);
        g.drawRect(xPos,yPos,w,h);
    }

    @Override
    public void updateWidth(int w) {
        this.getScreenWidth = w;
    }

    @Override
    public void updateHeight(int h) {
        this.getScreenHeight = h;
    }

    @Override
    public void movement() {

    }

    @Override
    public void collisionDetection() {

    }

    @Override
    public boolean playerColliding(int x, int y) {
        return false;
    }
}
