package DSA.StringDemo;

import java.util.Stack;

public class BackSpaceStringCompare {

    public String findBackSpacedChar(String s){
        Stack<Character> stack= new Stack<Character>();

        int i =1;
        stack.push(s.charAt(0));
        while (i<s.length()){
            if(s.charAt(i)=='#' && !stack.isEmpty()){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
            i++;
        }
        return String.valueOf(stack);

    }
}
