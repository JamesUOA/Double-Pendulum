import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicsPainter implements Painter{

    private final double MASS_SIZE = 20;
    static GraphicsContext g;

    public GraphicsPainter(GraphicsContext g){
        this.g = g;


    }


    @Override
    public void drawMass(double x, double y) {

        g.fillOval(x-MASS_SIZE/2,y-MASS_SIZE/2,MASS_SIZE,MASS_SIZE);
    }

    @Override
    public void drawRod(double x1,double y1,double x2,double y2) {
        g.strokeLine(x1, y1, x2, y2);
    }

    public void translate(double x,double y){
        g.translate(x,y);
    }

    public void clear(){

        translate(-640,-100);
        g.setFill(Color.WHITE);
        g.fillRect(0,0,1280,1280);

        Simulation.g.setColor(Color.GRAY);
        g.fillRect(0,0, 1280,100);

        Simulation.g.translate(640,100);
        Simulation.g.setColor(Color.GREEN);
        Simulation.g.drawMass(0,0);
        g.setFill(Color.BLACK);

    }

    public void setColor(Color c){
        g.setFill(c);
    }
}
