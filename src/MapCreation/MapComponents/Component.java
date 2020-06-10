package MapCreation.MapComponents;

import java.awt.*;

public abstract class Component {
    public int xPos, yPos, width, height, screenWidth, screenHeight;
    Color c;

    public Component(int x, int y, int width, int height, Color color){
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.height = height;
        this.c = color;
    }

    public abstract void draw(Graphics g);

    public abstract void updateWidth(int w);

    public abstract void updateHeight(int h);

    public abstract boolean MapCollisionDetection(int leftX, int rightX, int topY, int bottomY);

}
