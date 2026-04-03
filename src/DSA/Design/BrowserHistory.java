package DSA.Design;

import java.util.ArrayList;
import java.util.List;

class BrowserHistory {

    List<String> history;
    int curr;

    public BrowserHistory(String homepage) {

        history = new ArrayList<>();
        history.add(homepage);
        curr=0;
    }

    //o(1)
    public void visit(String url) {
        while (history.size()>curr+1){
            history.remove(history.size()-1);
        }
        history.add(url);
        curr++;
    }


    public String back(int steps) {
        curr =Math.max(0,curr-steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr= Math.min(history.size()-1 , curr+steps);
        return history.get(curr);
    }
}