package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/9/11 16:57
 */
public class TrieTree {

    public static TrieNode trie=new TrieNode('/');
    public static class TrieNode{
        public TrieNode(char cc){
            data=cc;
        }
        public char data;
        public int priority;
        public TrieNode children[]=new TrieNode[26];
    }

    public static void main(String[] args) {

        String str="THISIS";
        insert(str);
    }

    public static void  insert(String str) {

        TrieNode current = trie;
        for (int i = 0; i < str.toCharArray().length; i++) {
            char[] inodes = str.toCharArray();
            char currentChar = inodes[i];
            TrieNode node = new TrieNode(currentChar);
            int index = 'a' - currentChar;
            current.children[index]=node;
            current=node;
        }

        System.out.println("-----------");
    }

}
