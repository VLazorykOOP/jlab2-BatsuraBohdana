public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveX(double dx) {
        this.x += dx;
    }


    public void moveY(double dy) {
        this.y += dy;
    }

        return Math.sqrt(x * x + y * y);
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }


    public double[] toPolar() {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x); 
        return new double[]{r, theta};
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return Double.compare(this.x, other.x) == 0 &&
               Double.compare(this.y, other.y) == 0;
    }


    public boolean notEquals(Point other) {
        return !this.equals(other);
    }

  
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

  
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);

        System.out.println("Точка p1: " + p1);
        System.out.println("Відстань p1 до початку координат: " + p1.distanceToOrigin());
        System.out.println("Відстань між p1 і p2: " + p1.distanceTo(p2));

        p1.moveX(2);
        p1.moveY(-1);
        System.out.println("p1 після переміщення: " + p1);

        double[] polar = p1.toPolar();
        System.out.println("Полярні координати p1: r = " + polar[0] + ", θ = " + polar[1]);

        System.out.println("p1 == p2 ? " + p1.equals(p2));
        System.out.println("p1 != p2 ? " + p1.notEquals(p2));
    }
}
