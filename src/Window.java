import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GraphicObjects.ComputerSystemUnit;

public class Window extends JPanel implements ActionListener {

    final static int FORM_WIDTH = 700;
    final static int FORM_HEIGHT = 700;

    private double bladeOffset = 0;

    private ComputerSystemUnit unit;

    private Timer timer;

    private double fps = 144;

    //Колличество оборотов в минуту
    public double maxCoolersSpeed = 1600;

    public double currentCoolerSpeed = 0;
    // изменение кол-во оборотов в секунду
    public double acceleration = 10;

    Window(){
        setSize(FORM_WIDTH, FORM_HEIGHT);


        setPreferredSize(new Dimension(FORM_WIDTH, FORM_HEIGHT));

        timer = new Timer((int)(1000 / fps), this);

        setVisible(true);
    }

    public void changeFps(int value){
        if (value < 0){
            throw new IllegalArgumentException("Fps must be positive int");
        }
        this.fps = value;
    }

    public void activateButtonPressed(){
        timer.setDelay((int) (1000 / fps));
        if (timer.isRunning()){
            currentCoolerSpeed = 0;
            timer.stop();
        }
        else {
            timer.start();
        }
    }

    public void actionPerformed(ActionEvent e) {
        double secondsPerTick = 1 / fps;

        if (currentCoolerSpeed < maxCoolersSpeed){
            currentCoolerSpeed += secondsPerTick * acceleration;
        }
        if (currentCoolerSpeed > maxCoolersSpeed){
            currentCoolerSpeed = maxCoolersSpeed;
        }
        double spinAngel = currentCoolerSpeed * 360 / 60 / fps;
        this.bladeOffset += spinAngel;

        repaint();
    }

    @Override
    public void paint(Graphics g) {

        Point anchor = new Point(240, 180);
        // преобразование графического объекта
        Graphics2D graph2d = (Graphics2D) g;
        graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graph2d.clearRect(0, 0, FORM_HEIGHT, FORM_WIDTH);
        setBackground(new Color(195, 195, 235));
        // построение геометрических примитивов

        BasicStroke stroke = new BasicStroke(7.0f);
        graph2d.setPaint(new Color(10, 25, 36));
        //graph2d.fillArc(-100, -100, 450, 450, -80, 90);
        this.unit = new ComputerSystemUnit(graph2d, anchor.x, anchor.y + 60, bladeOffset);
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