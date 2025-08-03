package com.dsa.questions.potd;
// Day - 31/07/25

import java.util.*;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<board.length;i++){
            Set<Character> st = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if(board[i][j] != '.'){
                    if(st.contains(board[i][j])){
                        return false;
                    }
                    st.add(board[i][j]);
                }
            }

        }
        for(int i=0;i<board.length;i++){
            Set<Character> st = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if(board[j][i] != '.'){
                    if(st.contains(board[j][i])){
                        return false;
                    }
                    st.add(board[j][i]);
                }
            }

        }

        int i=0;
        for(;i<board.length;i=i+3){
            int l=0;
            for(;l<board.length;l=l+3){
                Set<Character> st = new HashSet<>();
                for(int j=i;j<i+3;j++){
                    for(int k=l;k<l+3;k++){
                        if(board[j][k] != '.'){
                            if(st.contains(board[j][k])){
                                return false;
                            }
                            st.add(board[j][k]);
                        }
                    }
                }
            }
        }
        return true;
    }
};
