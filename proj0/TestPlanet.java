public class TestPlanet {
    public static void main (String[] args) {
        Planet p1 = new Planet(1.0, 2.0, 3.0, 4.0, 5.0, "ball.gif");
        Planet p2 = new Planet(5.0, 4.0, 3.0, 2.0, 1.0, "ball.gif");
        System.out.println(p1.calcForceExertedBy(p2));
        System.out.println(p2.calcForceExertedBy(p1));
    }
}