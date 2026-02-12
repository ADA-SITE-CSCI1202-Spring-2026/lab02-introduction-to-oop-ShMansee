package week03.geometry;

public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public Segment(float x1, float y1, float x2, float y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Point getP1() {
        return new Point(this.p1);
    }

    public void setP1(Point p) {
        this.p1 = new Point(p);
    }

    public Point getP2() {
        return new Point(this.p2);
    }

    public void setP2(Point p) {
        this.p2 = new Point(p);
    }

    public void translate(float dX, float dY) {
        p1.translate(dX, dY);
        p2.translate(dX, dY);
    }

    public float length() {
        return p1.distance(p2);
    }

    public boolean equals(Segment s) {
        return this.p1.equals(s.p1) && this.p2.equals(s.p2);
    }

    public float getSlope() {
        if (p2.getX() == p1.getX()) {
            throw new ArithmeticException("Vertical line: slope undefined");
        }
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

    public float getIntercept() {
        float k = getSlope();
        return p1.getY() - k * p1.getX();
    }

    public boolean isOnLine(Point p) {

        if (p2.getX() == p1.getX()) {
            return p.getX() == p1.getX();
        }

        float k = getSlope();
        float b = getIntercept();
        return p.getY() == k * p.getX() + b;
    }

    public boolean isOnSegment(Point p) {
        if (!isOnLine(p)) return false;

        float minX = Math.min(p1.getX(), p2.getX());
        float maxX = Math.max(p1.getX(), p2.getX());
        float minY = Math.min(p1.getY(), p2.getY());
        float maxY = Math.max(p1.getY(), p2.getY());

        return p.getX() >= minX && p.getX() <= maxX &&
                p.getY() >= minY && p.getY() <= maxY;
    }
}
