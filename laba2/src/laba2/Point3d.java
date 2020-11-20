package laba2;

public class Point3d extends Point2d {
    // координата Z
    private double zCoord;
    //  Конструктор инициализации
    public Point3d (double x, double y, double z) {
        super(x,y);
        zCoord = z;
    }
    //  Конструктор по умолчанию
    public Point3d () {
        this(0, 0, 0);
    }
    //  Возвращение координаты Z
    public double getZ () {
        return zCoord;
    }
    //  Установка значения координаты Z
    public void setZ (double val) {
        zCoord = val;
    }
    // ** Метод сравнения **
    public boolean compare (Point3d point){
        return this.getX() == point.getX() && this.getY() == point.getY() && this.getZ() == point.getZ();
    }
    // ** Метод подсчета площади **
    public Double distanceTo (Point3d point){
        double distance = Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2) + Math.pow(this.getZ() - point.getZ(), 2));
        return (double) Math.round(distance * 100) / 100;
    }
}
