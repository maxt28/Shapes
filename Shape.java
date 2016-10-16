import java.awt.*;

public interface Shape {

    void paint(Graphics g, int x, int y);

    void setId(int id);

    int getId();

    String getShapeName();

    int getWidth();

    int getHeight();
}