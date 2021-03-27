package Depth_first_search;
import java.util.*;

public class Problem_394 {
    class Solution {
        public String decodeString(String s) {
            Deque<String> stringStack = new LinkedList<>();
            Deque<Integer> intStack = new LinkedList<>();
            StringBuilder ret = new StringBuilder();
            int multi = 0;
            for(int i=0; i<s.length(); i++){
                char tempChar = s.charAt(i);
                if(Character.isDigit(tempChar)){
                    multi = multi*10 + (tempChar - '0');
                }else if(tempChar == '['){
                    intStack.addLast(multi);
                    stringStack.addLast(ret.toString());
                    multi = 0;
                    ret = new StringBuilder();
                }else if(tempChar == ']'){
                    StringBuilder tmp = new StringBuilder();
                    int cur_multi = intStack.removeLast();
                    for(int j = 0; j < cur_multi; j++) tmp.append(ret.toString());
                    ret = new StringBuilder(stringStack.removeLast() + tmp);
                }else{
                    ret.append(tempChar);
                }
            }
            return ret.toString();

        }
    }
}
