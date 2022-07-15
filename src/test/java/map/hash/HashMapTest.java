package map.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    @Test
    @DisplayName("put, get Test")
    void hashMap() {
        HashMap<String, String> map = new HashMap<>();
        String key = "Q-1";
        String v1 = "안녕하세요";
        String v2 = "안녕하세요2";
        map.put(key, v1);
        map.put(key, v2);

        Assertions.assertNotEquals(map.get(key), v1);
        Assertions.assertEquals(map.get(key), v2);
    }


    @Test
    @DisplayName("remove Test")
    void hashMap_2() {
        HashMap<String, String> map = new HashMap<>();
        String key = "Q-1";
        String value = "안녕하세요";
        map.put(key, value);

        Assertions.assertEquals(map.size(), 1);
        String remove = map.remove(key);

        Assertions.assertEquals(map.size(), 0);
        Assertions.assertEquals(remove, value);
    }

    @Test
    @DisplayName("contain Test")
    void hashMap_3() {
        HashMap<String, String> map = new HashMap<>();
        String key1 = "Q-1";
        String key2 = "Q-2";
        String value = "안녕하세요";
        map.put(key1, value);

        Assertions.assertTrue(map.containsKey(key1));
        Assertions.assertFalse(map.containsKey(key2));
    }

    @Test
    @DisplayName("contain value Test")
    void hashMap_4() {
        HashMap<String, String> map = new HashMap<>();
        String key1 = "Q-1";
        String value1 = "안녕하세요";
        String value2 = "안녕하세요2";
        map.put(key1, value1);


        Assertions.assertTrue(map.containsValue(value1));
        Assertions.assertFalse(map.containsValue(value2));
    }

    @Test
    @DisplayName("keySet Test")
    void hashMap_5() {
        HashMap<String, String> map = new HashMap<>();
        String key1 = "Q-1";
        String key2 = "Q-2";
        String value1 = "안녕하세요";
        String value2 = "안녕하세요2";
        map.put(key1, value1);
        map.put(key2, value2);

        Set<String> keySet = map.keySet();

        Assertions.assertTrue(keySet.contains(key1));
        Assertions.assertTrue(keySet.contains(key2));
    }
}
