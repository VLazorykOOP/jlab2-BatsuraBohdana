import java.util.Scanner;

public class Balloon {
    private int x, y, z, r;

    public Balloon(int x, int y, int z, int r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    public double distance(Balloon other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) +
                         Math.pow(this.y - other.y, 2) +
                         Math.pow(this.z - other.z, 2));
    }

    public double intersectionVolume(Balloon other) {
        double d = this.distance(other);
        if (d >= this.r + other.r) return 0;
        if (d <= Math.abs(this.r - other.r)) {
            int smaller = Math.min(this.r, other.r);
            return (4.0 / 3.0) * Math.PI * Math.pow(smaller, 3);
        }

        double r1 = this.r;
        double r2 = other.r;
        double part1 = Math.pow(r1 + r2 - d, 2);
        double part2 = (d * d + 2 * d * r2 - 3 * r2 * r2 + 2 * d * r1 + 6 * r1 * r2 - 3 * r1 * r1);
        return Math.PI * part1 * part2 / (12 * d);
    }

    public double unionVolume(Balloon other) {
        return this.volume() + other.volume() - this.intersectionVolume(other);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть x1 y1 z1 r1:");
        int x1 = sc.nextInt(), y1 = sc.nextInt(), z1 = sc.nextInt(), r1 = sc.nextInt();

        System.out.println("Введіть x2 y2 z2 r2:");
        int x2 = sc.nextInt(), y2 = sc.nextInt(), z2 = sc.nextInt(), r2 = sc.nextInt();

        Balloon b1 = new Balloon(x1, y1, z1, r1);
        Balloon b2 = new Balloon(x2, y2, z2, r2);

        System.out.println("Об'єм першої кулі: " + b1.volume());
        System.out.println("Об'єм другої кулі: " + b2.volume());
        System.out.println("Об'єм перетину: " + b1.intersectionVolume(b2));
        System.out.println("Об'єм об'єднання: " + b1.unionVolume(b2));
    }
}
