package DSA.heapdemo;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {

        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(chars, n));


    }

    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Task> maxHeap = new PriorityQueue<>(Comparator.comparing(Task::getFreq).reversed());
        Queue<Task> waitQueue = new LinkedList<>();

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.offer(new Task(entry.getKey(), entry.getValue(), 0));
        }
        int time = 0;

        while (!waitQueue.isEmpty() || !maxHeap.isEmpty()) {

            while (!waitQueue.isEmpty() && waitQueue.peek().avail <= time) {
                maxHeap.offer(waitQueue.poll());
            }

            if (!maxHeap.isEmpty()) {
                Task task = maxHeap.poll();
                task.freq--;

                if (task.freq > 0){
                    task.avail = time + n + 1;
                    waitQueue.offer(task);
                }

            }
            time++;


        }


        return time;
    }

    class Task {
        char c;
        int freq;
        int avail;

        Task(char c, int freq, int avail) {
            this.c = c;
            this.freq = freq;
            this.avail = avail;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public int getAvail() {
            return avail;
        }

        public void setAvail(int avail) {
            this.avail = avail;
        }
    }

}
