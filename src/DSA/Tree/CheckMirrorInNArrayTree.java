package DSA.Tree;

import java.util.ArrayList;
import java.util.List;

public class CheckMirrorInNArrayTree {


    public boolean areMirror(NarrayNode narrayNode1,NarrayNode narrayNode2){
        if(narrayNode1==null && narrayNode2==null) return true;
        if(narrayNode1==null || narrayNode2==null) return false;

        if (narrayNode1.val!=narrayNode2.val || narrayNode1.nodes.size()!=narrayNode2.nodes.size()){
            return false;
        }
        int n =narrayNode1.nodes.size();
        for (int i =0;i<n;i++){
            if(!areMirror(narrayNode1.nodes.get(i),narrayNode2.nodes.get(n-i-1))){
                return false;
            }
        }
        return true;
    }

    static class NarrayNode{
        int val;
        List<NarrayNode> nodes;

        public NarrayNode(int val) {
            this.val = val;
            this.nodes = new ArrayList<>();
        }
    }
}
