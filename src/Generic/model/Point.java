package Generic.model;

public class Point<T> {

    T x;
    T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public <T> void show(T t){
        System.out.println( "t=" + t);
    }
}
