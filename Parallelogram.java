public class Parallelogram {
    private double a;   // перша сторона
    private double b;   // друга сторона
    private double angle; // кут між сторонами (у градусах)

    public Parallelogram(double a, double b, double angle) {
        this.a = a;
        this.b = b;
        this.angle = angle;
    }

    // метод для обчислення периметра
    public double perimeter() {
        return 2 * (a + b);
    }

    // метод для обчислення площі
    public double area() {
        double radians = Math.toRadians(angle);
        return a * b * Math.sin(radians);
    }

    // метод для порівняння з іншим паралелограмом (за площею)
    public boolean isEqual(Parallelogram other) {
        return Double.compare(this.area(), other.area()) == 0 &&
               Double.compare(this.perimeter(), other.perimeter()) == 0;
    }

    // метод для визначення подібності до іншого паралелограма
    public boolean isSimilar(Parallelogram other) {
        double ratio1 = this.a / other.a;
        double ratio2 = this.b / other.b;
        return Double.compare(ratio1, ratio2) == 0 &&
               Double.compare(this.angle, other.angle) == 0;
    }

    // перевизначимо toString для зручності
    @Override
    public String toString() {
        return "Parallelogram{" +
                "a=" + a +
                ", b=" + b +
                ", angle=" + angle +
                ", perimeter=" + perimeter() +
                ", area=" + area() +
                '}';
    }

    // тест
    public static void main(String[] args) {
        Parallelogram p1 = new Parallelogram(5, 8, 60);
        Parallelogram p2 = new Parallelogram(10, 16, 60);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("p1 і p2 рівні: " + p1.isEqual(p2));
        System.out.println("p1 і p2 подібні: " + p1.isSimilar(p2));
    }
}
