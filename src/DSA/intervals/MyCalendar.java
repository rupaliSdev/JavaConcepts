package DSA.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
//https://leetcode.com/problems/my-calendar-i/description/
class MyCalendar {


    public static void main(String[] args) {
        /**
         * Your MyCalendar object will be instantiated and called as such:
         * MyCalendar obj = new MyCalendar();
         * boolean param_1 = obj.book(startTime,endTime);
         */
    }
    static class Booking{
        int start; int end;
        Booking(int startTime, int endTime){
            this.start=startTime;
            this.end=endTime;
        }
    }

    List<Booking> bookings;

    TreeMap<Integer,Integer> map;

    public MyCalendar() {
        bookings= new ArrayList<>();
        map=new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Booking booking = new Booking(startTime,endTime);
        for(Booking b :bookings){
            if( booking.start >= b.start && booking.start < b.end
                    ||booking.start <= b.start && booking.end > b.start){
                return false;
            }
        }
        bookings.add(booking);
        return true;
    }

    public boolean bookOptimized(int startTime, int endTime) {
        int prevStart = map.floorKey(startTime),nextStart=map.ceilingKey(startTime);
        if( map.get(prevStart)>= endTime ||endTime >= nextStart )return false;
        map.put(startTime,endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
