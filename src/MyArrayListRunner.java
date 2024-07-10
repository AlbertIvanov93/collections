import java.util.ArrayList;
import java.util.List;

public class MyArrayListRunner {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        myArrayList.add(null);
        System.out.println("size before " + myArrayList.size());

        System.out.println("elem removed " + myArrayList.remove(10));

        System.out.println("elem got " + myArrayList.get(6));

        myArrayList.remove(Integer.valueOf(5));

        System.out.println(myArrayList);

        System.out.println("size after remove " + myArrayList.size());

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 70; i > 40; i--) {
            arrayList.add(i);
        }

        myArrayList.addAll(arrayList);

        System.out.println(myArrayList);

        myArrayList.sort(((o1, o2) -> o1 - o2));

        System.out.println(myArrayList);

        System.out.println("size after sort " + myArrayList.size());
    }
}
