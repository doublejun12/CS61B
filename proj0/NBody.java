public class NBody {
    public static double readRadius(String planetTxtPath) {
        In in = new In(planetTxtPath);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String planetTxtPath) {
        In in = new In(planetTxtPath);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] p = new Planet[number];
        for (int i = 0; i < number; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            p[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return p;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);

        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time < T) {

            StdDraw.clear();

            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, imageToDraw);

            for(Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        }
        
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}