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

    final static int FORM_WIDTH = 700;
    final static int FORM_HEIGHT = 700;
    private BufferedImage txtr;

    Main(){
        setSize(FORM_WIDTH, FORM_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    ;
    public void paint(Graphics g) {

        Point anchor = new Point(240, 180);
        // преобразование графического объекта
        Graphics2D graph2d = (Graphics2D) g;
        graph2d.clearRect(0, 0, FORM_HEIGHT, FORM_WIDTH);
        setBackground(Color.yellow);
        // построение геометрических примитивов

        BasicStroke stroke = new BasicStroke(7.0f);
        graph2d.setPaint(Color.blue);

        ComputerSystemUnit unit = new ComputerSystemUnit(graph2d, anchor.x, anchor.y + 60);
        unit.setCoolerRadius(50);
        unit.setUnitHeight(420);
        unit.setUnitWidth(220);
        unit.draw();
        graph2d.setFont(new Font("Arial", Font.BOLD, 24));
        graph2d.drawString("This is computer", anchor.x, anchor.y);

    }

    public static void main(String[] args) {
        new Main();
    }
}