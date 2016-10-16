import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Group extends JFrame {

    private static final int DISTANCE = 50;
    ArrayList<Shape> figures = new ArrayList<>();

    public Group() {
        createFiguresArray();
        makeFrame();
        Serializer.serializeToXML(figures);
    }
    public Group(ArrayList<Shape> figures) {
        this.figures = figures;
        makeFrame();
        Serializer.serializeToXML(figures);
    }

    public static void main(String[] args) {
        new Group();
    }

    private void makeFrame() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createFiguresArray() {
        Scanner sc = new Scanner(System.in);
        String shapeName;
        System.out.println("Create your figures group.");
        System.out.println("Write \"done\" when your group is done:");
        int id = 0;
        while (true) {
            shapeName = sc.nextLine();
            if (shapeName.equals(Circle.SHAPE_NAME)) {
                figures.add(new Circle());
                figures.get(id).setId(id++);
            } else if (shapeName.equals(Triangle.SHAPE_NAME)) {
                figures.add(new Triangle());
                figures.get(id).setId(id++);
            } else if (shapeName.equals(Square.SHAPE_NAME)) {
                figures.add(new Square());
                figures.get(id).setId(id++);
            } else if (shapeName.equals("done")) {
                sc.close();
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        int startDistance = 50;
        for (Shape figure : figures) {
            figure.paint(g, startDistance, 50);
            startDistance += DISTANCE;
        }
    }

}
