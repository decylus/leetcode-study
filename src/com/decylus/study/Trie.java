package com.decylus.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019-10-25.
 *
 * @author jiawei
 */

public class Trie {
    private Map<Character, Trie> children;
    private boolean end;
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Trie getChildren(Character c){
        return this.children.get(c);
    }

    public Trie putChildren(Character c, Trie t){
        return this.children.put(c, t);
    }

    public boolean isEnd(){
        return this.end;
    }

    public void setEnd(boolean end){
        this.end = end;
    }


    /** Initialize your data structure here. */
    public Trie() {
        children = new HashMap<>();
        end = false;
    }

    public Trie(Map<Character, Trie> c, boolean end) {
        this.children = c;
        this.end = end;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for(int i = 0; i < word.length(); i++){
            Trie child = trie.getChildren(word.charAt(i));
            boolean end = i == word.length()-1;
            if(child == null){
                trie.putChildren(word.charAt(i), new Trie(new HashMap<>(), end));

            }
            trie = trie.getChildren(word.charAt(i));
            trie.setEnd(end || trie.isEnd());
            if (end){
                trie.setWord(word);
            }
        }
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for(int i = 0; i < word.length(); i++){
            trie = trie.getChildren(word.charAt(i));
            if(trie == null){
                return false;
            }
        }
        return trie.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for(int i = 0; i < prefix.length(); i++){
            trie = trie.getChildren(prefix.charAt(i));
            if(trie == null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean a = trie.search("apple");
    }
}
