package DSA.stack;

import java.util.Stack;

public class GetMinFromStack {

     Stack<Integer> s=new Stack<>(), mins=new Stack<>();
    public static void main(String[] args) {

    }
    public void push(int x){

        s.push(x);
        if(mins.isEmpty() || x<=mins.peek()) mins.push(x);

    }

    public int pop(int x){
        int v= s.pop();
        if(v==mins.peek()) mins.pop();
       return v;
    }

    private int findMin() {
        return mins.peek();
    }


}
