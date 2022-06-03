package array;

public class CustomIntegerArrayList {
    private Integer[] list;
    private int currentIndex;

    public CustomIntegerArrayList() {
        this.list = new Integer[10];
        this.currentIndex = 0;
    }

    public void add(int data) {
        if (this.currentIndex == (list.length - 1)) {
            Integer[] tmpList = list;
            this.list = new Integer[list.length + 10];
            for (int i = 0; i < tmpList.length; i++) {
                list[i] = tmpList[i];
            }
        }
        this.list[currentIndex++] = data;
    }

    public Integer get(int index) {
        if (index < 0) throw new IllegalArgumentException("Index cannot be less than zero.");
        return list[index];
    }

    public void remove(int index) {
        for (int i = index; i < this.currentIndex; i++) {
            this.list[i] = this.list[i + 1];
        }
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) count++;
        }
        return count;
    }

    public void clear() {
        this.list = new Integer[10];
    }


}

