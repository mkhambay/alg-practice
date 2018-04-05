package com.khambay.alg.trees;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //Time and Space - O(m) where m is key length
    public void insert(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c); //get the child to be the next to be linked
        }
        node.setEnd(); //important to set end for the word
    }

    //Time - O(m) Space - O(1)
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    //Time - O(m) Space - O(1)
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.containsKey(c)) {
                node = node.get(c); //get next child
            }
            else {
                return null; //fail fast if no further match
            }
        }
        return node;
    }

    public class TrieNode {
        private TrieNode[] links; //links to node children
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean containsKey(char c) {
            return links[c -'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("trie");
        System.out.println("Search trie " + obj.search("trie"));
        System.out.println("Search tri " + obj.search("tri"));
        System.out.println("Search ie " + obj.search("ie"));
        System.out.println("Search d " + obj.search("d"));
        System.out.println("Prefix Search tri " + obj.startsWith("tri"));
        System.out.println("Prefix Search ri " + obj.startsWith("ri"));
        System.out.println("Prefix Search d " + obj.startsWith("d"));
    }
}
