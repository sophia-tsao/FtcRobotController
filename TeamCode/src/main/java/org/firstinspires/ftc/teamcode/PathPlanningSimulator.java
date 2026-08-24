package org.firstinspires.ftc.teamcode;

public class PathPlanningSimulator {

    /**
     * Stores the robot's position and direction.
     */
    static class Robot {
        double x;
        double y;
        double heading;

        /**
         * Creates a robot at a starting position.
         */
        public Robot(double x, double y, double heading) {
            this.x = x;
            this.y = y;
            this.heading = heading;
        }

        /**
         * Moves the robot to a target point.
         *
         * @param targetX target X position
         * @param targetY target Y position
         */
        public void moveTo(double targetX, double targetY) {

            // Find the change in X and Y
            double deltaX = targetX - x;
            double deltaY = targetY - y;

            // Calculate distance to target
            double distance = Math.sqrt(
                    deltaX * deltaX + deltaY * deltaY
            );

            // Calculate direction to target
            double angle = Math.toDegrees(
                    Math.atan2(deltaY, deltaX)
            );

            System.out.println("Moving from:");
            System.out.println("(" + x + ", " + y + ")");

            System.out.println("Target:");
            System.out.println("(" + targetX + ", " + targetY + ")");

            System.out.println("Distance: " + distance);
            System.out.println("Turn to angle: " + angle + " degrees");

            // Update robot position
            x = targetX;
            y = targetY;
            heading = angle;

            System.out.println();
        }

        /**
         * Prints the robot's current position.
         */
        public void printPosition() {
            System.out.println(
                    "Robot Position: (" + x + ", " + y + ")"
            );

            System.out.println(
                    "Heading: " + heading + " degrees"
            );
        }
    }

    /**
     * Runs the simulation.
     */
    public static void main(String[] args) {

        // Start robot at (0, 0)
        Robot robot = new Robot(0, 0, 0);

        robot.printPosition();

        System.out.println();

        // Move through three points
        robot.moveTo(24, 0);
        robot.moveTo(24, 24);
        robot.moveTo(48, 36);

        robot.printPosition();
    }
}
