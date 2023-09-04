package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() > another.getArea()) {
            return 1;
        } else if (this.getArea() < another.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return "" + floorCount + " этажный коттедж площадью " + area + " метров";
    }

}
// END
