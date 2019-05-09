package com.ren.hao.leetcode.findWords;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2019/5/9-21:35
 * 作者：任皓
 * 链接：
 */
public class Solution {
    public String[] findWords(String[] words) {
        char[] l1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] l2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] l3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        List<String> result = new ArrayList<String>();

        char currentChar;
        int currentSet;
        int previousSet;
        int currentIteration;
        boolean isResult;

        for (String currentString: words){
            currentIteration = 0;
            isResult = true;
            String lowString = currentString.toLowerCase();
            previousSet = 0;
            for (int i=0; i< lowString.length(); i++){
                currentChar = lowString.charAt(i);
                if (currentIteration == 0){
                    previousSet = whichSet( currentChar, l1, l2, l3);
                }
                currentSet = whichSet( currentChar, l1, l2, l3);
                if (previousSet != currentSet){
                    isResult = false;
                    break;
                }
                currentIteration++;
            }
            if (isResult){
                result.add(currentString);
            }
        }

        String[] resultsArray = new String[result.size()];
        currentIteration = 0;
        for (String tmp : result){
            resultsArray[currentIteration] = tmp;
            currentIteration++;
        }

        return resultsArray;
    }

    private int whichSet(char currentChar, char[] l1, char[] l2, char[] l3){
        if (isInSet(currentChar, l1))
            return 1;
        if (isInSet(currentChar, l2))
            return 2;
        return 3;
    }

    private boolean isInSet(char currentChar, char[] l){
        boolean result = false;
        for (char current : l){
            if (currentChar==current){
                result = true;
                break;
            }
        }
        return result;
    }
}
