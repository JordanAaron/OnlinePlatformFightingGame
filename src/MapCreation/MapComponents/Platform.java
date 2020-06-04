package MapCreation.MapComponents;

import java.awt.*;

public class Platform extends Component {
    public Platform(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void updateWidth(int w) {

    }

    @Override
    public void updateHeight(int h) {

    }

    @Override
    public boolean MapCollisionDetection(int leftX, int rightX, int topY, int bottomY) {
        return false;
    }
}
