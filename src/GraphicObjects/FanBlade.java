package GraphicObjects;

import java.awt.*;
import java.awt.geom.*;

public class FanBlade implements Drawable {

    private Graphics2D graphics;
    private Ellipse2D.Double internalCircle;
    private Ellipse2D.Double externalCircle;
    private double startAngle;
    private double endAngle;

    private Stroke startStroke;
    private Paint startPaint;

    private Arc2D arc;

    public FanBlade(Graphics2D graphics, Ellipse2D.Double internalCircle, Ellipse2D.Double externalCircle,
                    double startAngle, double endAngle){
        this.graphics = graphics;
        this.internalCircle = internalCircle;
        this.externalCircle = externalCircle;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.arc = new Arc2D.Double(externalCircle.x, externalCircle.y, externalCircle.width,
                externalCircle.height, this.startAngle, this.endAngle, Arc2D.PIE);

        this.graphics.fill(arc);
        this.startStroke = graphics.getStroke();
        this.startPaint = graphics.getPaint();
    }

    public void move(double angle){

        this.arc.setAngleExtent(arc.getAngleExtent() + angle);
        this.arc.setAngleStart(arc.getAngleExtent() + angle);
        draw();
    }

    public void draw(){
        graphics.setPaint(Color.black);
        this.graphics.fill(this.arc);
        graphics.setPaint(startPaint);
    }

}
