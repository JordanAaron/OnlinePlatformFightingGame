package MapCreation.MapComponents;

import java.awt.*;

public class Platform extends Component {
    public Platform(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double) this.xPos /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPos /100) * this.screenHeight);
        int width = (int)(((double) this.width/100) * this.screenWidth);
        int height = (int)(((double) this.height/100) * this.screenHeight);

        g.setColor(c);
        g.fillRect(xPos, yPos,width, height);
    }

    @Override
    public void updateWidth(int w) {
        this.screenWidth = w;
    }

    @Override
    public void updateHeight(int h) {
        this.screenHeight = h;
    }

    @Override
    public boolean MapCollisionDetection(int playerLeft, int playerRight, int playerTop, int playerBottom) {
        if (playerRight > platformLeft() && playerLeft < platformRight()){
            if (playerBottom > platformTop() && playerTop < platformBottom()){
                return true;
            }
        }
        return false;
    }

    public int platformLeft(){
        return xPos;
    }

    public int platformRight(){
        return xPos + width;
    }

    public int platformTop(){
        return yPos;
    }

    public int platformBottom(){
        return yPos + height;
    }
}
