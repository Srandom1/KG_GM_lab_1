import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GraphicObjects.ComputerSystemUnit;

public class Window extends JPanel implements ActionListener {

    final static int FORM_WIDTH = 700;
    final static int FORM_HEIGHT = 700;

    private ComputerSystemUnit unit;

    private Timer timer;

    Window(){
        setSize(FORM_WIDTH, FORM_HEIGHT);


        setPreferredSize(new Dimension(FORM_WIDTH, FORM_HEIGHT));

        timer = new Timer(500, this);
        timer.start();

        setVisible(true);
    }

//    public void animate(){
//        for (int i = 0; i < 20; i++){
//            this.unit.move(10);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//     }

    public void actionPerformed(ActionEvent e) {
        this.unit.move(10);

        //repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Point anchor = new Point(240, 180);
        // преобразование графического объекта
        Graphics2D graph2d = (Graphics2D) g;
        graph2d.clearRect(0, 0, FORM_HEIGHT, FORM_WIDTH);
        setBackground(new Color(195, 195, 235));
        // построение геометрических примитивов

        BasicStroke stroke = new BasicStroke(7.0f);
        graph2d.setPaint(new Color(10, 25, 36));
        //graph2d.fillArc(-100, -100, 450, 450, -80, 90);
        this.unit = new ComputerSystemUnit(graph2d, anchor.x, anchor.y + 60);
        unit.setCoolerRadius(50);
        unit.setUnitHeight(420);
        unit.setUnitWidth(220);
        unit.draw();

        graph2d.setFont(new Font("Arial", Font.BOLD, 24));
        graph2d.drawString("This is computer", anchor.x, anchor.y);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("AnimationExample");

        Window window = new Window();

        frame.add(window);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}