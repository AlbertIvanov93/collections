import java.util.ArrayList;

public class MyLinkedListRunner {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(3);
        list.remove(1);
        list.remove(5);

        System.out.println(list);

        System.out.println(list.get(0));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(13);
        arrayList.add(23);
        arrayList.add(22);
        arrayList.add(17);

        list.addAll(arrayList);

        System.out.println(list);

        list.sort((o1, o2) -> o1 - o2);

        System.out.println(list);

    }
}
