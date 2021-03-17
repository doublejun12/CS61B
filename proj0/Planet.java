public class Planet {
    public double xxPos; //Its current x position
    public double yyPos; //Its current y position
    public double xxVel; //Its current velocity in the x direction
    public double yyVel; //Its current velocity in the y direction
    public double mass; //Its mass
    public String imgFileName; //The name of the file that corresponds to the image that depicts the planet
    static final double graviCons = 6.67e-11;

    /**
    A constructor
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
    Another constructor
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
    Calulate the distance between this planet and another planet
     */
    public double calcDistance(Planet p) {
        double dist;
        dist = Math.sqrt((p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos));
        return dist;
    }

    /**
    Calculating the force exerted on this planet by the given planet
     */
    public double calcForceExertedBy(Planet p) {
        double dist = this.calcDistance(p);
        double force = (graviCons * mass * p.mass) / (dist * dist);
        return force;
    }

    /**
    Calculating the force exerted in the X and Y directions 
    */
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        double forceX = (force * dx) / dist;
        return forceX;
    }
    public double calcForceExertedByY(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double dist = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        double forceX = (force * dy) / dist;
        return forceX;
    }

    /**
    Calculating the net X and net Y force exerted by all planets in that array upon the current Planet 
    */
    public double calcNetForceExertedByX(Planet[] p) {
        double netForceX = 0;
        for(int i = 0; i < p.length; i++) {
            if(this.equals(p[i])) {
                continue;
            }
            else {
                netForceX += this.calcForceExertedByX(p[i]);
            }
            
        }
        return netForceX;
    }
    public double calcNetForceExertedByY(Planet[] p) {
        double netForceY = 0;
        for(Planet pp : p) {
            if(this.equals(pp)) {
                continue;
            }
            else {
                netForceY += this.calcForceExertedByY(pp);
            }
        }
        return netForceY;
    }

    /**
    Update the planet’s position and velocity instance variables
     */
    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}