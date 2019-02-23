import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;

public class Simulation extends Application {


    static Painter g;

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Double Pendulum");
        Group root=new Group();
        Scene scene=new Scene(root,1280,800, Color.WHITE);


        Canvas canvas = new Canvas(1280, 800);
        g = new GraphicsPainter(canvas.getGraphicsContext2D());
        root.getChildren().add(canvas);

        primaryStage.setScene(scene);
        primaryStage.show();

        PendSystem s = new PendSystem();


        s.start();
        Timer timer = new Timer();
        timer.schedule(new Calculate(),0,500);
    }


}
