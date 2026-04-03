package DSA.Design;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {


    class CheckIn{
        String station;
        int time;

        CheckIn(String s,int t){
            station = s;
            time = t;
        }
    }

    class Route{
        int totalTime = 0;
        int count = 0;
    }

    Map<Integer,CheckIn> checkinMap;
    Map<String,Route> routeMap;

    public UndergroundSystem() {
        checkinMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id,new CheckIn(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn ci = checkinMap.get(id);
        checkinMap.remove(id);
        String key = ci.station + "->" + stationName;

        routeMap.putIfAbsent(key,new Route());

        Route r = routeMap.get(key);

        r.totalTime += t - ci.time;
        r.count++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;

        Route r = routeMap.get(key);

        return (double) r.totalTime / r.count;
    }
}