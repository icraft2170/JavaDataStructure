package arraylist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    @DisplayName("arrayList 의 생성자 중 ArrayList(Collections)")
    void arrayListConstructor() {
        List<Integer> intArray = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

        int size = intArray.size();
        for (int i = 0; i < size; i++) {
            assertEquals(intArray.get(i), i);
        }
    }


    @Test
    @DisplayName("arrayList add Test")
    void arrayListAdd() {
        List<Integer> intArray = new ArrayList<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        assertEquals(intArray.size(), 3);
        assertEquals(intArray.get(0), 1);
        assertEquals(intArray.get(1), 2);
        assertEquals(intArray.get(2), 3);
    }

    @Test
    @DisplayName("arrayList 의 addAll(Collection)")
    void arrayListAddAll() {
        List<Integer> intArray = new ArrayList<>();
        intArray.addAll(Arrays.asList(0, 1, 2, 3, 4, 5));

        int size = intArray.size();
        assertEquals(size, 6);
        for (int i = 0; i < size; i++) {
            assertEquals(intArray.get(i), i);
        }
        intArray.addAll(3, Arrays.asList(2, 2, 2));
        size = intArray.size();
        assertEquals(size, 9);
        for (int i = 0; i < size; i++) {
            System.out.print(intArray.get(i) + " ");
            // 출력 결과 -> 0 1 2 2 2 2 3 4 5
        }

    }

    @Test
    @DisplayName("arrayList 의 addAll(null)")
    void arrayListAddAllException() {
        List<Integer> intArray = new ArrayList<>();
        assertThrows(NullPointerException.class, () -> intArray.addAll(null));
    }


    @Test
    @DisplayName("ArrayList의 없는 인덱스 데이터 get(index) 할 때 Index Out Of Exception")
    void arrayListIndexOutOfException() {
        List<Integer> intArray = new ArrayList<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        assertThrows(
                IndexOutOfBoundsException.class
                , () -> intArray.get(3)
        );
    }

    @Test
    @DisplayName("arrayList 삭제")
    void arrayListRemove() {
        List<Integer> intArray = new ArrayList<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        assertEquals(intArray.size(), 3);

        Integer removeIndexZero = intArray.remove(2);
        assertEquals(intArray.size(), 2);
        assertEquals(removeIndexZero, 3);

        Integer removeIndexOne = intArray.remove(1);
        assertEquals(intArray.size(), 1);
        assertEquals(removeIndexOne, 2);

        Integer removeIndexTwo = intArray.remove(0);
        assertEquals(intArray.size(), 0);
        assertEquals(removeIndexTwo, 1);
    }


    @Test
    @DisplayName("arrayList 의 removeAll(Collection)")
    void arrayListRemoveAll() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0);
        List<Integer> removeArray = Arrays.asList(0, 1, 2, 3, 4);
        intArray.addAll(zeroToFiveArray);

        assertEquals(intArray.size(), 11);

        intArray.removeAll(removeArray);
        assertEquals(intArray.size(), 1);
        assertEquals(intArray.get(0), 5);
    }


    @Test
    @DisplayName("arrayList 의 removeAll(null)")
    void arrayListRemoveAllException() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0);
        intArray.addAll(zeroToFiveArray);

        assertThrows(
                NullPointerException.class
                , () -> intArray.removeAll(null)
        );
    }


    @Test
    @DisplayName("arrayList removeIf(Predicate)")
    void arrayListRemoveIf() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToTenArray = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        intArray.addAll(zeroToTenArray);

        intArray.removeIf((number) -> {
            return number > 5;
        });

        int size = intArray.size();
        assertEquals(size, 6);
        assertFalse(intArray.containsAll(Arrays.asList(6,7,8,9,10)));
    }

    @Test
    @DisplayName("arrayList 의 size()")
    void arrayListSize() {
        List<Integer> intArray = new ArrayList<>(10);

        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5);
        intArray.addAll(zeroToFiveArray);

        assertNotEquals(intArray.size(), 10);
        assertEquals(intArray.size(), 6);
    }


    @Test
    @DisplayName("arrayList 의 isEmpty()")
    void arrayListIsEmpty() {
        List<Integer> intArray = new ArrayList<>();

        intArray.addAll(Arrays.asList(0, 1, 2, 3, 4, 5));

        assertFalse(intArray.isEmpty());

        intArray.clear();

        assertTrue(intArray.isEmpty());
    }

    @Test
    @DisplayName("arrayList 의 contains()")
    void arrayListContains() {
        List<Integer> intArray = new ArrayList<>();
        int zero = 0;
        int one = 1;
        intArray.addAll(Arrays.asList(zero, 2, 3, 4, 5));

        assertTrue(intArray.contains(zero));
        assertFalse(intArray.contains(one));
    }


    @Test
    @DisplayName("arrayList 의 containsAll(Collection)")
    void arrayListContainsAll() {
        List<Integer> intArray = new ArrayList<>();

        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> zeroToSix = Arrays.asList(0, 1, 2, 3, 4, 6);
        List<Integer> sixToTen = Arrays.asList(6, 7, 8, 9, 10);
        intArray.addAll(zeroToFiveArray);

        assertTrue(intArray.containsAll(zeroToFiveArray));
        assertFalse(intArray.containsAll(sixToTen));
        assertFalse(intArray.containsAll(zeroToSix));
        // 하나라도 틀리면 false
    }


    @Test
    @DisplayName("arrayList 의 IndexOf(Object)")
    void arrayListIndexOf() {
        List<Integer> intArray = new ArrayList<>();

        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0);
        intArray.addAll(zeroToFiveArray);

        assertAll(
                () -> assertEquals(intArray.indexOf(0), 0),
                () -> assertEquals(intArray.indexOf(1), 1),
                () -> assertEquals(intArray.indexOf(2), 2),
                () -> assertEquals(intArray.indexOf(3), 3),
                () -> assertEquals(intArray.indexOf(4), 4),
                () -> assertEquals(intArray.indexOf(5), 5)
        );
    }

    @Test
    @DisplayName("arrayList 의 lastIndexOf(Object)")
    void arrayListLastIndexOf() {
        List<Integer> intArray = new ArrayList<>();

        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0);
        intArray.addAll(zeroToFiveArray);

        assertAll(
                () -> assertEquals(intArray.lastIndexOf(0), 10),
                () -> assertEquals(intArray.lastIndexOf(1), 9),
                () -> assertEquals(intArray.lastIndexOf(2), 8),
                () -> assertEquals(intArray.lastIndexOf(3), 7),
                () -> assertEquals(intArray.lastIndexOf(4), 6),
                () -> assertEquals(intArray.lastIndexOf(5), 5)
        );
    }

    @Test
    @DisplayName("arrayList 의 retainAll(Collection)")
    void arrayListRetainAll() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0);
        List<Integer> retainArray = Arrays.asList(0, 1, 2, 3, 4);
        intArray.addAll(zeroToFiveArray);

        assertEquals(intArray.size(), 11);

        intArray.retainAll(retainArray);
        assertEquals(intArray.size(), 10);

        assertAll(
                () -> assertEquals(intArray.indexOf(0), 0),
                () -> assertEquals(intArray.indexOf(1), 1),
                () -> assertEquals(intArray.indexOf(2), 2),
                () -> assertEquals(intArray.indexOf(3), 3),
                () -> assertEquals(intArray.indexOf(4), 4),
                () -> assertEquals(intArray.lastIndexOf(0), 9),
                () -> assertEquals(intArray.lastIndexOf(1), 8),
                () -> assertEquals(intArray.lastIndexOf(2), 7),
                () -> assertEquals(intArray.lastIndexOf(3), 6),
                () -> assertEquals(intArray.lastIndexOf(4), 5)
        );
    }


    @Test
    @DisplayName("arrayList 의 iterator()")
    void arrayListIterator() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5);
        intArray.addAll(zeroToFiveArray);

        Iterator<Integer> iterator = intArray.iterator();

        int count = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            assertEquals(next, count);
            count++;
        }

    }




    @Test
    @DisplayName("arrayList subList(fromIndex, toIndex)")
    void arrayListSubList() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToTenArray = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        intArray.addAll(zeroToTenArray);


        List<Integer> subList = intArray.subList(2, 6);
        // 시작 인덱스 포함, 끝 인덱스 미포함

        int size = subList.size();
        assertEquals(size, 4);
        assertTrue(subList.containsAll(Arrays.asList(2, 3, 4, 5)));
    }

    @Test
    @DisplayName("arrayList set(index, value)")
    void arrayListSet() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToFiveArray = Arrays.asList(0, 1, 2, 3, 4, 5);
        intArray.addAll(zeroToFiveArray);

        intArray.set(0, 6); // 0 -> 6
        intArray.set(1, 7); // 1 -> 7
        intArray.set(2, 8); // 2 -> 8
        intArray.set(3, 9); // 3 -> 9
        intArray.set(4, 10); // 4 -> 10
        intArray.remove(5);

        assertFalse(intArray.containsAll(zeroToFiveArray));
        assertTrue(intArray.containsAll(Arrays.asList(6, 7, 8, 9, 10)));
    }


    @Test
    @DisplayName("arrayList sort(Comparator)")
    void arrayListSort() {
        List<Integer> intArray = new ArrayList<>();
        List<Integer> zeroToTenArray = Arrays.asList(10, 8, 5, 3, 1, 9, 7, 4, 2, 0, 6);
        intArray.addAll(zeroToTenArray);


        intArray.sort(
                (n1, n2) -> {
                    return n1 - n2;
                }
        );
        // 0 ~ 10 까지 정렬
        intArray.forEach(System.out::println);
        assertAll(
                () -> assertEquals(intArray.indexOf(0), 0),
                () -> assertEquals(intArray.indexOf(1), 1),
                () -> assertEquals(intArray.indexOf(2), 2),
                () -> assertEquals(intArray.indexOf(3), 3),
                () -> assertEquals(intArray.indexOf(4), 4),
                () -> assertEquals(intArray.indexOf(5), 5),
                () -> assertEquals(intArray.indexOf(6), 6),
                () -> assertEquals(intArray.indexOf(7), 7),
                () -> assertEquals(intArray.indexOf(8), 8),
                () -> assertEquals(intArray.indexOf(9), 9),
                () -> assertEquals(intArray.indexOf(10), 10)
        );
    }



}
