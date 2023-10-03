package test10.sx.obj;

import test10.sx.GameWin;

import java.awt.*;

public class BodyObj extends GameObj{
    public BodyObj(Image img, int x, int y, GameWin frame) {
    super(img, x, y, frame);
}
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}