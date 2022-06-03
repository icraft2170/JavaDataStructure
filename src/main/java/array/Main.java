package array;


public class Main {

    public static void main(String[] args) {
        CustomIntegerArrayList customIntegerArrayList = new CustomIntegerArrayList();
        customIntegerArrayList.add(1);
        customIntegerArrayList.add(2);
        customIntegerArrayList.add(3);
        customIntegerArrayList.add(4);
        customIntegerArrayList.add(5);
        customIntegerArrayList.add(6);
        customIntegerArrayList.add(7);
        customIntegerArrayList.add(8);
        customIntegerArrayList.add(9);
        customIntegerArrayList.add(10);
        customIntegerArrayList.add(11);



        int size = customIntegerArrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(customIntegerArrayList.get(i));
        }

        customIntegerArrayList.remove(10);

        size = customIntegerArrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(customIntegerArrayList.get(i));
        }

        customIntegerArrayList.clear();


        size = customIntegerArrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(customIntegerArrayList.get(i));
        }
    }
}
