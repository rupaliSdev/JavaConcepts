package DSA.queue;

import java.util.LinkedList;
import java.util.Queue;
/*
we have given bridge length and weight limit of bridge and we have given an array of trucks
can u determine how much time will it take to cross the bridge minmize the time and we need to maintain
the order of trucks in the array
*/

public class CrossTheBridge {
    public static void main(String[] args) {

        int length = 2;
        int maxWeight = 10;
        int[] trucks = {7, 4, 5, 6};
        // 7  entry =1 exit = 3  t=1
        // 4 entry =3 exit = 5  t=4
        // 5 entry =4 exit = 6  t =6
        //6 entry = 6 exit = 8  t =7
//        int[] weightOfTrucks ={}
        int totalTime = minTimeToCrossTheBridge(length, maxWeight, trucks);
        System.out.println(totalTime);
    }

    private static int minTimeToCrossTheBridge(int length, int maxWeight, int[] trucks) {

        Queue<Truck> trucksOnTheBridge = new LinkedList<>();
        int time = 0, index = 0;
        int currentWeightOnTheBridge = 0;
        while (index < trucks.length || !trucksOnTheBridge.isEmpty()) {
            time++;
            if (!trucksOnTheBridge.isEmpty() && time - trucksOnTheBridge.peek().entryTime >= length) {
                currentWeightOnTheBridge -= trucksOnTheBridge.peek().weight;
                trucksOnTheBridge.poll();
            }
            if (index < trucks.length && currentWeightOnTheBridge + trucks[index] <= maxWeight) {
                trucksOnTheBridge.offer(new Truck(trucks[index], time));

                currentWeightOnTheBridge += trucks[index];
                index++;
            }
        }
        return time;
    }
    static class Truck {
        int weight;
        int entryTime;

        public Truck(int weight, int entryTime) {
            this.weight = weight;
            this.entryTime = entryTime;
        }
    }


}

