package GraphicObjects;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

public class Cooler implements Drawable{

    public Graphics2D graphics;
    public float strokeGage = 5.0f;
    private int radius = 20;

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

//
//    private void recalculateCoolersLocation(){
//        int xCoolerLocation = this.xLocation + this.unitWidth / 2 - coolerRadius;
//        int yCoolerLocation = this.yLocation + this.unitHeight / (coolers.size() + 1) - coolerRadius;
//        for (Integer[] coordinates: this.coolers){
//            coordinates[0] = xCoolerLocation;
//            coordinates[1] = yCoolerLocation;
//            yCoolerLocation += this.unitHeight / (coolers.size() + 1);
//        }
//    }
//
    @Override
    public void draw() {
//        Stroke prevStroke = graphics.getStroke();
//        Paint prevPaint = graphics.getPaint();
//        BasicStroke stroke = new BasicStroke(strokeGage);
//        graphics.setPaint(Color.black);
//        graphics.setStroke(stroke);
//
//        recalculateCoolersLocation();
//        LinkedList<ShapeVisualisationSettings> figures = new LinkedList<>();
//        Rectangle2D.Double rect = new Rectangle2D.Double(xLocation,yLocation, unitWidth,unitHeight);
//
//        figures.add(new ShapeVisualisationSettings(rect, stroke, Color.black));
//
//
//        for (Integer[] coordinates: this.coolers) {
//            figures.add(new ShapeVisualisationSettings(
//                    new Ellipse2D.Double(coordinates[0], coordinates[1], coolerRadius * 2, coolerRadius * 2),
//                    stroke, Color.blue));
//        }
//        for (ShapeVisualisationSettings shapeSettings: figures){
//            graphics.setStroke(shapeSettings.stroke);
//            graphics.setPaint(shapeSettings.paint);
//            graphics.draw(shapeSettings.shape);
//        }
    }
}
