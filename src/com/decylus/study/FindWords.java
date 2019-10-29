package com.decylus.study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 2019-10-25.
 *
 * @author jiawei
 */
public class FindWords {

    public static void main(String[] args) {

        char[][] c = new char[][]{{'a', 'a'}};
        String[] words = new String[]{"aaa"};
        FindWords fw = new FindWords();
        List<String> result = fw.findWords(c, words);
        result.forEach(s -> System.out.println(s));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                boolean[][] used = new boolean[board.length][board[0].length];
                search(board, i, j, trie, result, used);
            }
        }
        return new ArrayList<>(result);

    }

    private void search(char[][] board, int x, int y, Trie trie, Set<String> result, boolean[][] used){
        trie = trie.getChildren(board[x][y]);
        if (trie == null || used[x][y]) {
            return;
        }
        used[x][y] = true;
        if (x < board.length - 1){
            search(board, x + 1, y, trie, result, used);
        }
        if (x > 0){
            search(board, x - 1, y, trie, result, used);
        }
        if (y < board[x].length - 1){
            search(board, x, y + 1, trie, result, used);
        }
        if (y > 0){
            search(board, x, y - 1, trie, result, used);
        }
        if (trie.isEnd()){
            result.add(trie.getWord());
        }
        used[x][y] = false;

    }
}
