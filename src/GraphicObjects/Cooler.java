package GraphicObjects;

import java.awt.*;
import java.awt.geom.*;
import java.util.LinkedList;

public class Cooler implements Drawable{

    public Graphics2D graphics;
    public float strokeGage = 5.0f;
    private int radius = 20;
    private int cooler_coefficient = 4;

    private Stroke startStroke;
    private Paint startPaint;

    private int xLocation;
    private int yLocation;

    public Cooler(Graphics2D graphics, int x_location, int y_location){
        this.graphics = graphics;
        this.xLocation = x_location;
        this.yLocation = y_location;
    }

    public int getYLocation() {
        return this.yLocation;
    }

    public int getXLocation() {
        return this.xLocation;
    }

    public int getRadius(){
        return this.radius;
    }

    public void setYLocation(int new_location) {
        /*Устанавливает местоположение на холсте относительно левого верхнего края.
        Можно устонавливать только положительный чилса.*/
        if (new_location > 0) {
            this.yLocation = new_location;
        } else {
            throw new RuntimeException("could be positive");
        }
    }

    public void setXLocation(int new_location) {
        /*Устанавливает местоположение на холсте относительно левого верхнего края.
        Можно устонавливать только положительный чилса.*/
        if (new_location > 0) {
            this.xLocation = new_location;
        } else {
            throw new RuntimeException("could be positive");
        }
    }

    public void setRadius(int value) {
        /*Устанавливает местоположение на холсте относительно левого верхнего края.
        Можно устонавливать только положительный чилса.*/
        if (value > 0) {
            this.radius = value;
        } else {
            throw new RuntimeException("could be positive");
        }
    }

    private void calculateFiguresParametrs(){

    }

    @Override
    public void draw() {
        this.startStroke = graphics.getStroke();
        this.startPaint = graphics.getPaint();
        BasicStroke stroke = new BasicStroke(strokeGage);

        //LinkedList<ShapeVisualisationSettings> figures = new LinkedList<>();

        graphics.setPaint(Color.GRAY);

        graphics.fill(new Rectangle2D.Double(xLocation, yLocation, radius *2, radius*2));

        graphics.setStroke(stroke);
        graphics.setPaint(Color.WHITE);
        graphics.fill(new Ellipse2D.Double(xLocation, yLocation, radius * 2, radius *2));

        graphics.setPaint(Color.black);
        graphics.fill(new Ellipse2D.Double(xLocation +  radius * Math.PI / cooler_coefficient,
                yLocation +  radius * Math.PI / cooler_coefficient,
                (double) radius * 2 / cooler_coefficient,
                (double) radius * 2 / cooler_coefficient));

        graphics.setPaint(startPaint);
        graphics.setStroke(startStroke);


    }
}
