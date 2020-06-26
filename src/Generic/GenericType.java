package Generic;

import Generic.model.Point;

import java.util.ArrayList;
import java.util.List;

public class GenericType {

    public static void main(String[] args) {

        List list = new ArrayList();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.toArray().toString());
        list.add("a");
        list.add(true);
        Object obj =  list.get(1);
        String str = (String)obj;
        System.out.println(str);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("java");
        arrayList.add("true");
        for (String string: arrayList) {
            System.out.println("=" + string);
        }


        Point<Integer> point = new Point<>(1, 2);
        point.setX(100);
        point.setY(200);
        System.out.println(point.getX());
        System.out.println(point.getY());
        point.show("java");

        Point<String> point1 = new Point<>("x轴", "y轴");
        System.out.println(point1.getX());
        System.out.println(point1.getY());
    }

}
