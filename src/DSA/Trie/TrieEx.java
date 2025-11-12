package DSA.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://medium.com/@kirti07arora/mastering-trie-data-structure-implementation-and-application-in-java-e7d371e5eafc
public class TrieEx {
    public static void main(String[] args) {

    }


    public boolean insertWord(TrieNode root,String word){
        TrieNode node= root;
        char[] wordArray= word.toCharArray();

        for(char c:wordArray){
            if(node.children[c-'a']==null){
                node.children[c-'a']= new TrieNode();
            }
            else{
                node.children[c-'a'].count++;
            }
            node = node.children[c-'a'];
        }
        node.isEnd=true;
        return true;
    }

    public boolean searchTheWord(TrieNode root,String word){
        TrieNode node= root;
        char[] wordArray= word.toCharArray();

        for(char c:wordArray){
            if(node.children[c-'a']==null){
                return false;
            }
            node = node.children[c-'a'];
        }

        return node.isEnd;

    }

    public boolean deleteTheWord(TrieNode root,String word){
        TrieNode node= root;
        char[] wordArray= word.toCharArray();
        Stack<TrieNode> stack= new Stack<>();
        for(char c:wordArray){
            if(node.children[c-'a']==null){
                return false;
            }
            else{
                stack.push(node.children[c-'a']);
            }
            node = node.children[c-'a'];
        }
        TrieNode leaf = stack.peek();
        leaf.isEnd= false;
        while(!stack.isEmpty()){

            TrieNode rt = stack.peek();
            if(rt.isEnd==false && rt.children.length==0){
                rt=null;
            }

        }


        return node.isEnd;

    }

    public ArrayList<String> prefix(ArrayList<String> A) {

        List<String> uniquePrefixes = new ArrayList<>();

        for(String word: A){

        }
       return null;
    }



    class TrieNode{

        TrieNode[] children;
        int count;
        boolean isEnd;

        public TrieNode(){
            this.children= new TrieNode[26];
            this.count=1;
            this.isEnd= false;
        }


    }




}
