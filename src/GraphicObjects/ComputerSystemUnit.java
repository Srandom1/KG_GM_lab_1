package GraphicObjects;

import java.awt.*;
import java.awt.geom.*;
import java.util.LinkedList;
import java.util.List;

public class ComputerSystemUnit implements Drawable {
    public Graphics2D graphics;
    public float strokeGage = 5.0f;
    private int coolerRadius = 55;
    private int panelProportions = 6;
    private int unitWidth = 60;
    private int unitHeight = 100;
    private final Stroke startStroke;
    private final Paint startPaint;
    //Каждый элемент - координаты верхнего левого угла для куллера
    private List<Cooler> coolers = new LinkedList<>();


    private int xLocation;
    private int yLocation;

    public ComputerSystemUnit(Graphics2D graphics, int x_location, int y_location) {
        this.graphics = graphics;
        startStroke = graphics.getStroke();
        startPaint = graphics.getPaint();
        this.xLocation = x_location;
        this.yLocation = y_location;
        this.coolers.add(new Cooler(graphics, x_location, y_location));
        this.coolers.add(new Cooler(graphics, x_location, y_location));
        for (Cooler cooler: coolers){
            cooler.setRadius(coolerRadius);
        }
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
            for (Cooler cooler: coolers){
                cooler.setRadius(coolerRadius);
            }
            coolerRadius = value;
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
        double yTehPanelSize = (double) unitHeight / panelProportions;
        double yCoolerPanelSize = (double) unitHeight - yTehPanelSize;

        int yCoolerLocation = (int) (this.yLocation + yTehPanelSize +yCoolerPanelSize /  (coolers.size() + 1));
        for (Cooler cooler: this.coolers){
            yCoolerLocation += - cooler.getRadius();
            int xCoolerLocation = (int) (this.xLocation  + this.unitWidth / 2 - cooler.getRadius());
            cooler.setXLocation(xCoolerLocation);
            cooler.setYLocation(yCoolerLocation);
            yCoolerLocation += (int) (yCoolerPanelSize / (coolers.size() + 1) + cooler.getRadius());
        }
    }

    public void move(double angle){
        for (Cooler cooler: this.coolers){
            cooler.move(angle);
        }
    }

    @Override
    public void draw() {

        BasicStroke stroke = new BasicStroke(strokeGage);
        graphics.setPaint(Color.black);
        graphics.setStroke(stroke);

        recalculateCoolersLocation();
        LinkedList<ShapeVisualisationSettings> figures = new LinkedList<>();

        Rectangle2D.Double rect = new Rectangle2D.Double(xLocation,yLocation, unitWidth,unitHeight);
        double off_button_location_position = 0.75;
        double off_button_size_proportions = 0.6;

        figures.add(new ShapeVisualisationSettings(rect, stroke, Color.black));

        graphics.setPaint(Color.black);
        graphics.fillRect(xLocation, yLocation + (unitHeight/ panelProportions), unitWidth, unitHeight - (unitHeight / panelProportions));
        graphics.setPaint(Color.darkGray);
        graphics.fillRect(xLocation, yLocation, unitWidth, unitHeight / panelProportions);
        double yTehPanelSize = (double) unitHeight / panelProportions;
        // double xTehPanelSize = (double) unitWidth / proportions;
        graphics.setPaint(Color.red);
        graphics.fillOval( (int) (xLocation + unitWidth * off_button_location_position),
                (int) (yLocation + yTehPanelSize * (1 - off_button_size_proportions) / 2 ),
                (int) (off_button_size_proportions * yTehPanelSize),
                (int) (off_button_size_proportions * yTehPanelSize));

        LinkedList<Drawable> drawablesObjects = new LinkedList<>(this.coolers);
        
        for (Drawable geomObject: drawablesObjects) {
           geomObject.draw();
        }

        for (ShapeVisualisationSettings shapeSettings: figures){
            graphics.setStroke(shapeSettings.stroke);
            graphics.setPaint(shapeSettings.paint);
            graphics.draw(shapeSettings.shape);
        }

        graphics.setStroke(startStroke);
        graphics.setPaint(startPaint);
    }
}
