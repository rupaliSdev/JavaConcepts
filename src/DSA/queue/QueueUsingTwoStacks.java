package DSA.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {


    Stack<Integer> in=new Stack<>();
    Stack<Integer> out= new Stack<>();

    public QueueUsingTwoStacks() {
    }

    public void push(int x){
        while(!out.isEmpty()){
            in.push(out.pop());
        }
        out.push(x);
        while(!in.isEmpty()){
            out.push(in.pop());
        }

    }
    public int pop(){
        if(!out.isEmpty()){
            out.pop();
        }
        return -1;
    }
    public int peek(){
        if(!out.isEmpty()){
            out.peek();
        }
        return -1;
    }
    public int size(){

        return out.size();
    }

    public static void main(String[] args) {




    }

}
