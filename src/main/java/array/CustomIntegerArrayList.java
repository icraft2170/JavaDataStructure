package array;

public class CustomIntegerArrayList {
    private int[] list;
    private int currentIndex;

    public CustomIntegerArrayList() {
        this.list = new int[10];
        this.currentIndex = 0;
    }

    public void add(int data) {
        if (this.currentIndex == list.length) {
            int[] tmpList = list;
            this.list = new int[list.length + 10];
            for (int i = 0; i < tmpList.length; i++) {
                list[i] = tmpList[i];
            }
        }
        this.list[++currentIndex] = data;
    }

    public void remove(int index) {
        for (int i = index; i < this.currentIndex; i++) {
            this.list[i] = this.list[i + 1];
        }
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {
        this.list = new int[10];
    }


}

