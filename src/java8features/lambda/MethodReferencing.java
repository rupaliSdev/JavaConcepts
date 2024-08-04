package java8features.lambda;

import Basics.Basic.Array;

import java.util.Arrays;

public class MethodReferencing {
    public static void main(String[] args) {

        String[] lst= {"John","Rupali","Anchal"};
       // Class:: method we want to point
        Arrays.sort(lst,String::compareToIgnoreCase);
    }
}
