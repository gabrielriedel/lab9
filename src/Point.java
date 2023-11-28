/**
 * A simple class representing a location in 2D space.
 */
public final class Point {
    public double x;
    public double y;
    public double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean adjacent(Point p2) {
        return (x == p2.x && Math.abs(y - p2.y) == 1) || (y == p2.y && Math.abs(x - p2.x) == 1);
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    public Point scale(double s){
        return new Point(x*s, y*s, z*s);
    }

    public Point translate(double a, double b){
        return new Point(x+a, y+b, z);
    }

    public boolean equals(Object other) {
        return other instanceof Point && ((Point) other).x == this.x && ((Point) other).y == this.y && ((Point) other).z == this.z;
    }

    public int hashCode() {
        int result = 17;
        result = result * 31 + (int)x;
        result = result * 31 + (int)y;
        result = result * 31 + (int)z;
        return result;
    }
}
