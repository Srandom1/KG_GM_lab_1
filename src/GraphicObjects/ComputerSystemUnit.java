package GraphicObjects;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ComputerSystemUnit implements Drawable {
    public Graphics2D graphics;
    public float strokeGage = 5.0f;
    private int coolerRadius = 20;
    private int unitWidth = 60;
    private int unitHeight = 100;

    //Каждый элемент - координаты верхнего левого угла для куллера
    private List<Integer[]> coolers = new LinkedList<>();


    private int xLocation;
    private int yLocation;

    public ComputerSystemUnit(Graphics2D graphics, int x_location, int y_location) {
        this.graphics = graphics;
        this.xLocation = x_location;
        this.yLocation = y_location;
        this.coolers.add(new Integer[]{0,0});
        this.coolers.add(new Integer[]{0,0});
    }


    public int getYLocation() {
        return this.yLocation;
    }
    public int getXLocation() {
        return this.xLocation;
    }

    public int getCoolerRadius() {
        return this.coolerRadius;
    }

    public int getUnitWidth(){
        return this.unitWidth;
    }
    public int getUnitHeight(){
        return this.unitHeight;
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

    public void setCoolerRadius(int value) {
        /*Устанавливает местоположение на холсте относительно левого верхнего края.
        Можно устонавливать только положительный чилса.*/
        if (value > 0) {
            this.coolerRadius = value;
        } else {
            throw new RuntimeException("could be positive");
        }
    }

    public void setUnitWidth(int value) {
        /*Устанавливает местоположение на холсте относительно левого верхнего края.
        Можно устонавливать только положительный чилса.*/
        if (value > 0) {
            this.unitWidth = value;
        } else {
            throw new RuntimeException("could be positive");
        }
    }

    public void setUnitHeight(int value) {
        /*Устанавливает местоположение на холсте относительно левого верхнего края.
        Можно устонавливать только положительный чилса.*/
        if (value > 0) {
            this.unitHeight = value;
        } else {
            throw new RuntimeException("could be positive");
        }
    }

    private void recalculateCoolersLocation(){
        int xCoolerLocation = this.xLocation + this.unitWidth / 2 - coolerRadius;
        int yCoolerLocation = this.yLocation + this.unitHeight / (coolers.size() + 1) - coolerRadius;
        for (Integer[] coordinates: this.coolers){
            coordinates[0] = xCoolerLocation;
            coordinates[1] = yCoolerLocation;
            yCoolerLocation += this.unitHeight / (coolers.size() + 1);
        }
    }

    @Override
    public void draw() {
        Stroke prevStroke = graphics.getStroke();
        Paint prevPaint = graphics.getPaint();
        BasicStroke stroke = new BasicStroke(strokeGage);
        graphics.setPaint(Color.black);
        graphics.setStroke(stroke);

        recalculateCoolersLocation();
        LinkedList<ShapeVisualisationSettings> figures = new LinkedList<>();
        Rectangle2D.Double rect = new Rectangle2D.Double(xLocation,yLocation, unitWidth,unitHeight);

        figures.add(new ShapeVisualisationSettings(rect, stroke, Color.black));


        for (Integer[] coordinates: this.coolers) {
            figures.add(new ShapeVisualisationSettings(
                    new Ellipse2D.Double(coordinates[0], coordinates[1], coolerRadius * 2, coolerRadius * 2),
                    stroke, Color.blue));
        }
        for (ShapeVisualisationSettings shapeSettings: figures){
            graphics.setStroke(shapeSettings.stroke);
            graphics.setPaint(shapeSettings.paint);
            graphics.draw(shapeSettings.shape);
        }
    }
}
