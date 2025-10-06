package DSA.interviewProblems;

import java.time.LocalDateTime;
import java.util.*;

public class test {
}
class Meeting {
    int id;
    String title;
    LocalDateTime start;
    LocalDateTime end;
    List<User> participants;
}

class User{
    public Integer id;

}

class Calendar {
    List<Meeting> meetings = new ArrayList<>();

    TreeMap<LocalDateTime, Meeting> calendar = new TreeMap<>();

    boolean hasConflict(LocalDateTime start, LocalDateTime end) {
        // floor: last meeting that starts before 'start'
        Map.Entry<LocalDateTime, Meeting> floor = calendar.floorEntry(start);
        if (floor != null && floor.getValue().end.isAfter(start)) {
            return true; // overlap with previous
        }
        // ceiling: first meeting that starts after 'start'
        Map.Entry<LocalDateTime, Meeting> ceil = calendar.ceilingEntry(start);
        if (ceil != null && end.isAfter(ceil.getKey())) {
            return true; // overlap with next
        }
        return false;
    }

    void addMeeting(Meeting m) {
        meetings.add(m);
    }
}

class MeetingService {
    Map<Integer, Calendar> userCalendars = new HashMap<>();

    boolean bookMeeting(Meeting m) {
        // check conflicts
        for (User u : m.participants) {
            if (userCalendars.get(u.id).hasConflict(m.start, m.end)) {
                return false; // reject
            }
        }
        // add meeting to all participant calendars
        for (User u : m.participants) {
            userCalendars.get(u.id).addMeeting(m);
        }

        return true;
    }
}
