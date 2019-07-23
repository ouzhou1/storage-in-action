package org.peterpark.storage.service.collections;

import java.util.PriorityQueue;

/**
 * Description: 优先级队列，内部默认维护小顶堆
 *
 * @author: peter
 * @date: 2019/1/25.
 */
public class QueueAnalyser {
    private static int[] TEST_CASE_1 = new int[]{23, 54, 12, 83, 99, 35, 74};

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int e : TEST_CASE_1) {
            priorityQueue.add(e);
        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    private class TestCase {

        private int age;

        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
