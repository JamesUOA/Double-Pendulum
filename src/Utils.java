public class Utils {
    public static final double GRAVITY = 9.807;

    public static double[] calculatePosition(double theta1, Rod rod1,double theta2, Rod rod2){
        double length1 = rod1.getLength();
        double length2 = rod2.getLength();


        double x1 = length1*Math.sin(theta1);
        double y1 = length1*Math.cos(theta1);

        double x2 = x1 + length2*Math.sin(theta2);
        double y2 = y1 + length2*Math.cos(theta2);

        return new double[]{x1,y1,x2,y2};
    }

    public static double accelerationMass1(Mass mass1, Mass mass2,Rod rod1, Rod rod2,double theta1, double theta2, double theta1Velocity, double theta2Velocity){


        double n1 = -1 * GRAVITY * (2 * mass1.getMass() + mass2.getMass()) * Math.sin(theta1);
        double n2 = 1 * mass2.getMass() * GRAVITY * Math.sin(theta1 - 2 * theta2);
        double n3 = 2 * Math.sin(theta1-theta2) * mass2.getMass() *
                ((theta2Velocity * theta2Velocity)* rod2.getLength() - (theta1Velocity * theta1Velocity) * rod1.getLength() * Math.cos(theta1-theta2));
        double denominator = 1*rod1.getLength() * (2 * mass1.getMass() + mass2.getMass() - mass2.getMass() * Math.cos(2 * theta1 - 2 * theta2));
        double numerator = n1 - n2 - n3;

        return numerator/denominator;
    }

    public static double accelerationMass2(Mass mass1, Mass mass2,Rod rod1, Rod rod2,double theta1, double theta2, double theta1Velocity, double theta2Velocity){

        double n1 = 2 * Math.sin(theta1 - theta2);
        double n2 = (theta1Velocity * theta1Velocity) * rod1.getLength() * (mass1.getMass() + mass2.getMass());
        double n3 = GRAVITY * (mass1.getMass() + mass2.getMass()) * Math.cos(theta1);
        double n4 = (theta2Velocity * theta2Velocity) * rod2.getLength() * mass2.getMass() * Math.cos(theta1 - theta2);
        double numerator = (n2 + n3 + n4);
        numerator = numerator * n1;
        double denominator = rod2.getLength() * (2 * mass1.getMass() + mass2.getMass() - mass2.getMass() * Math.cos(2*theta1 - 2*theta2));


        return numerator/denominator;
    }

}
