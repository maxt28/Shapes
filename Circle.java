import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle implements Shape {

    public static final String SHAPE_NAME = "circle";
    private int id;
    private int radius;
    private int width;
    private int height;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
        System.out.println("You are creating circle now.");
        createCircle();
    }

    private void createCircle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set radius:");
        try {
            this.radius = sc.nextInt();
            System.out.println("You created the circle with radius " + radius);
        } catch (InputMismatchException e) {
            System.out.println("You wrote not a number. Try again.");
            createCircle();
        }
        width = radius * 2;
        height = radius * 2;
    }

    public void paint(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.drawOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getShapeName() {
        return SHAPE_NAME;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
