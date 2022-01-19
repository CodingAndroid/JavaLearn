package Generic.model;

public class Point<T> implements Action<T>{

    T x;
    T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 该方法使用了泛型, 但不是泛型方法, 只是一个普通的成员方法
     * @return
     */
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

    /**
     * 定义泛型方法
     * @param t
     * @param <T>
     */
    public <T> void show(T t){
        System.out.println( "t=" + t);
    }

    @Override
    public T move() {
        return null;
    }

    public static <E extends Comparable> E get(E e1, E e2){
        if (e1.compareTo(e2) >= 0)
            return e1;
        return e2;
    }
}
