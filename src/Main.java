import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import GraphicObjects.ComputerSystemUnit;

public class Main extends JFrame {

    final static int FORM_WIDTH = 600;
    final static int FORM_HEIGHT = 500;
    private BufferedImage txtr;

    Main(){
        setSize(FORM_WIDTH, FORM_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    ;
    public void paint(Graphics g) {

        // преобразование графического объекта
        Graphics2D graph2d = (Graphics2D) g;
        // построение геометрических примитивов
        Ellipse2D.Double circle = new Ellipse2D.Double(60, 80, 120, 120);
        Ellipse2D.Double first_circle = new Ellipse2D.Double(260, 70, 60, 60);
        Ellipse2D.Double second_circle = new Ellipse2D.Double(260, 170, 60, 60);
        Rectangle2D.Double rect = new Rectangle2D.Double(230,60, 100,170);

        BasicStroke stroke = new BasicStroke(7.0f);
        graph2d.setPaint(Color.blue);

        ComputerSystemUnit unit = new ComputerSystemUnit(graph2d, 240, 240);
        unit.setCoolerRadius(50);
        unit.setUnitHeight(420);
        unit.setUnitWidth(220);
        unit.draw();

//        graph2d.setStroke(stroke);
//        graph2d.draw(first_circle);
//        graph2d.draw(second_circle);
//        graph2d.setPaint(Color.black);
//        graph2d.draw(rect);


        //Arc2D.Double segm = new Arc2D.Double(350,80,180,180,0,140,Arc2D.PIE);

//        // визуализация геометрических примитивов
//        graph2d.setPaint(new GradientPaint(5, 30, Color.BLUE, 35,100,Color.YELLOW,true));
//        graph2d.fill(circle);
//        graph2d.setStroke(new BasicStroke(10.0f));
//        graph2d.setPaint(Color.red);
//        graph2d.draw(segm);
//        try {
//            txtr = ImageIO.read(new File("bricks.jpg"));
//        }
//        catch(IOException ex){System.out.println("Sorry!!");}
//        graph2d.setPaint(new TexturePaint(txtr, new Rectangle(0,0,20,20)));
//        graph2d.fill(rect);
//        graph2d.drawRect(450, 300,40,70);
//
//        // построение отрезков прямых
//        BasicStroke bs = new BasicStroke(5);
//        graph2d.setStroke(bs);
//        graph2d.drawLine(20, 240, 350, 240);
//
//        float[] dash1 = {2f, 0f, 2f};
//        float[] dash2 = {1f, 1f, 1f};
//        float[] dash3 = {4f, 0f, 2f};
//        float[] dash4 = {4f, 4f, 1f};
//
//        BasicStroke bs1 = new BasicStroke(5, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
//
//        BasicStroke bs2 = new BasicStroke(5, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);
//
//        BasicStroke bs3 = new BasicStroke(5, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);
//
//        BasicStroke bs4 = new BasicStroke(5, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);
//
//        graph2d.setStroke(bs1);
//        graph2d.drawLine(20, 280, 350, 280);
//
//        graph2d.setStroke(bs2);
//        graph2d.drawLine(20, 320, 350, 320);
//
//        graph2d.setStroke(bs3);
//        graph2d.drawLine(20, 360, 350, 360);
//
//        graph2d.setStroke(bs4);
//        graph2d.drawLine(20, 400, 350, 400);
    }

    public static void main(String[] args) {
        new Main();
    }
}