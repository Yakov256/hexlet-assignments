package exercise;

// BEGIN
public class Segment {
    Point BeginPoint;
    Point EndPoint;

    public Segment(Point beginPoint, Point endPoint) {
        BeginPoint = beginPoint;
        EndPoint = endPoint;
    }

    public Point getBeginPoint() {
        return BeginPoint;
    }

    public Point getEndPoint() {
        return EndPoint;
    }

    public Point getMidPoint() {
        int midX = (BeginPoint.getX() + EndPoint.getX()) / 2;
        int midY = (BeginPoint.getY() + EndPoint.getY()) / 2;
        Point EndPoint = new Point(midX, midY);

        return EndPoint;
    }

}
// END
