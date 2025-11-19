package DSA.intervals;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/my-calendar-ii/description/
//https://leetcode.com/problems/determine-if-two-events-have-conflict/description/
//https://leetcode.com/problems/my-calendar-iii/description/
class MyCalendarTwo {

    List<Booking> bookings;
    List<Booking> doublebookings;

    static class Booking{
        int start; int end;
        Booking(int startTime, int endTime){
            this.start=startTime;
            this.end=endTime;
        }
    }
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doublebookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for(Booking booking:doublebookings){

            // [2,4],[1,3]
            if(booking.start < endTime && startTime <booking.end){
                return false;
            }
        }

        for(Booking booking:bookings){

            // [2,4],[1,3]
            if(booking.start < endTime && startTime <booking.end){
                Booking booking1= new Booking(Math.max(booking.start,startTime),Math.min(booking.end,endTime));
                doublebookings.add(booking1);
            }
        }





        bookings.add(new Booking(startTime,endTime));
        return true;
    }
}
class Booking{
    int start; int end;
    Booking(int startTime, int endTime){
        this.start=startTime;
        this.end=endTime;
    }
}


