package org.peterpark.storage.service.collections;

import java.util.*;

/**
 * Description:
 *
 * @author: peter
 * @date: 2019/1/25.
 */
public class MapAnalyser {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i));

    private static void testWeakHashMapAPIs() {
        // 初始化3个“弱键”
        String w1 = "one";
        String w2 = "two";
        String w3 = "three";

        Map<String, String> weakHashMap = new WeakHashMap<>();
        Map<String, String> hashMap = new HashMap<>();

        // 添加键值对
        weakHashMap.put(w1, "w1");
        weakHashMap.put(w2, "w2");
        weakHashMap.put(w3, "w3");
        hashMap.put(w1, "w1");
        hashMap.put(w2, "w2");
        hashMap.put(w3, "w3");

        System.out.printf("\nweakHashMap:%s\n", weakHashMap);
        System.out.printf("\nhashMap:%s\n", hashMap);

        // remove(Object key) ： 删除键key对应的键值对
        weakHashMap.remove("three");

        System.out.printf("weakHashMap: %s\n", weakHashMap);

        // 将w1设置null。
        // 这意味着“弱键”w1再没有被其它对象引用，调用gc时会回收WeakHashMap中与“w1”对应的键值对
        w1 = null;
        // 内存回收。这里，会回收WeakHashMap中与“w1”对应的键值对
        System.gc();
        // 打印WeakHashMap的实际大小
        System.out.printf(" after gc WeakHashMap size:%s\n", weakHashMap.size());
        System.out.printf(" after gc HashMap size:%s\n", hashMap.size());
        System.out.println(w1);
        List<Integer> list = new ArrayList<>();
        list.toArray(new Integer[1]);
    }

    public static void main(String[] args) {
        testWeakHashMapAPIs();
    }
}
