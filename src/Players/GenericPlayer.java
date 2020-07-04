package Players;

import MapCreation.Maps.TestingMap;

import java.awt.*;

public class GenericPlayer extends Player {
    private static int playerWidth,playerHeight;

    private Color color;

//    public int xPos;
//    public int yPos;

    public static double playerSpeed,xSpeed, ySpeed, jumpCounter;
    private boolean canMove;

    public GenericPlayer(int x, int y, Color c) {
        super(x, y);
        this.color = c;

        playerWidth = 4;
        playerHeight = 7;

        playerSpeed = 0.5;
        xSpeed = 0;

        jumpCounter = 0;

        canMove = true;
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
        xPos += xSpeed;
        yPos -= ySpeed;
        collisionDetection();
        outOfBounds();
        initiateGravity();

        if(!canMove){
            if (xSpeed < 0){
                xSpeed += 0.5;
                if (xSpeed > 0){
                    xSpeed = 0;
                }
            } else if (xSpeed > 0) {
                xSpeed -= 0.5;
                if( xSpeed < 0){
                    xSpeed = 0;
                }
            }
        }
    }

    @Override
    public void collisionDetection() {
        if (TestingMap.floor.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPos = (TestingMap.floor.yPos - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        }
    }

    @Override
    public boolean playerColliding(int x, int y) {
        return false;
    }

    public void moveLeft(){
        xSpeed = -1;
    }

    public void moveRight(){
        xSpeed = 1;
    }

    public static void jump(){
        if(jumpCounter < 2){
            ySpeed = 6;
            jumpCounter++;
        }
    }

    public void startMoving(){
        canMove = true;
    }

    public void stopMoving(){
        canMove = false;
    }

    public void initiateGravity(){
        ySpeed -= 1;
        if (ySpeed < -4){
            ySpeed = -4;
        }
    }

    private void outOfBounds(){
        if(xPos < 0){
            xPos = 0;
        }
        if (getRightX() > 100){
            xPos = 100 - playerWidth;
            //xSpeed = 0;
        }
    }

    public int getLeftX(){
        return xPos;
    }

    public int getRightX(){
        return xPos + playerWidth;
    }

    public int getTopY(){
        return yPos;
    }

    public int getBottomY(){
        return yPos + playerHeight;
    }
}
