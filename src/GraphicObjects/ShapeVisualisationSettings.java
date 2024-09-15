package GraphicObjects;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;

public class ShapeVisualisationSettings {
    public Shape shape;
    public Stroke stroke;
    public Paint paint;

    public ShapeVisualisationSettings(Shape shape, Stroke stroke, Paint paint){
        this.shape = shape;
        this.stroke = stroke;
        this.paint = paint;
    }
}
