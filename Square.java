import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Square implements Shape {

    public static final String SHAPE_NAME = "square";
    private int id;
    private int side;
    private int width;
    private int height;

    public Square(int side) {
        this.side = side;
    }

    public Square() {
        System.out.println("You are creating square now.");
        createSquare();
    }

    private void createSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set side:");
        try {
            this.side = sc.nextInt();
            System.out.println("You created the square with sides " + side);
        } catch (InputMismatchException e) {
            System.out.println("You wrote not a number. Try again.");
            createSquare();
        }
        width = side;
        height = side;
    }

    @Override
    public void paint(Graphics g, int x, int y) {
        g.setColor(Color.red);
        g.drawRect(x, y, side, side);
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
