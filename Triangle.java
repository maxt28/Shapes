import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle implements Shape {

    public static final String SHAPE_NAME = "triangle";
    private int id;
    private int sideOne;
    private int sideTwo;
    private int width;
    private int height;

    public Triangle(int sideOne, int sideTwo) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    public Triangle() {
        System.out.println("You are creating triangle now.");
        createTriangle();
    }

    private void createTriangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set two sides:");
        try {
            this.sideOne = sc.nextInt();
            this.sideTwo = sc.nextInt();
            System.out.println("You created the circle with sides " + sideOne + " and " + sideTwo);
        } catch (InputMismatchException e) {
            System.out.println("You wrote not a number. Try again.");
            createTriangle();
        }
        width = sideOne;
        height = sideTwo;
    }

    @Override
    public void paint(Graphics g, int x, int y) {
        g.drawPolygon(new int[]{x, x, x + sideOne}, new int[]{y, y + sideTwo, y + sideTwo}, 3);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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
