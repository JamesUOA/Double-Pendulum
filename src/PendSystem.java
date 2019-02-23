import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PendSystem {



    private double theta1;
    private double theta1Velocity;
    private double theta1Acceleration;
    private Mass mass1;
    private Rod rod1;

    private double theta2;
    private double theta2Velocity;
    private double theta2Acceleration;
    private Mass mass2;
    private Rod rod2;

    public PendSystem(){
        rod1 = new Rod(200);
        rod2 = new Rod(100);

        mass1 = new Mass(40);
        mass2 = new Mass(40);

        theta1 = Math.PI/6;
        theta2 = Math.PI;

        theta1Velocity = 0;
        theta1Acceleration = 0;

        theta2Velocity = 0;
        theta2Acceleration = 0;
    }

    public void start(){
        Simulation.g.translate(640,100);
        draw();
        Timer timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                double temp1 = Utils.accelerationMass1(mass1,mass2,rod1,rod2,theta1,theta2,theta1Velocity,theta2Velocity);
                temp1 = Math.round (temp1 * 10000.0) / 10000.0;
                double temp2 = Utils.accelerationMass2(mass1,mass2,rod1,rod2,theta1,theta2,theta1Velocity,theta2Velocity);
                temp2 = Math.round (temp2 * 10000.0) / 10000.0;

                theta1Acceleration = temp1*0.1;
                theta2Acceleration = temp2*0.1;

                theta1Velocity+=theta1Acceleration;
                theta2Velocity+=theta2Acceleration;

                theta1+=theta1Velocity;
                theta2+=theta2Velocity;


                draw();
            }
        }, 0, 50);
    }

    private void draw(){
        Simulation.g.clear();


        double[] CoOrds = Utils.calculatePosition(theta1,rod1,theta2,rod2);

        Simulation.g.drawMass(CoOrds[0],CoOrds[1]);
        Simulation.g.drawRod(0,0,CoOrds[0],CoOrds[1]);

        Simulation.g.drawMass(CoOrds[2],CoOrds[3]);
        Simulation.g.drawRod(CoOrds[0],CoOrds[1],CoOrds[2],CoOrds[3]);
    }









}
