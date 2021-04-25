package Offer;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 38. 字符串的排列
 * 标签：回溯算法
 */
public class Problem_38 {
    public String[] permutation(String s) {
        // 看到全排列想到使用回溯算法去遍历，时间复杂度是O(n!n)，空间复杂度是O(n^2)
        int len = s.length();
        Set<String> res = new HashSet<>();
        if(len == 0){
           return res.toArray(new String[0]);
        }
        boolean[] used = new boolean[len];
        String path = "";
        backTrace(s, path, res, 0, len, used);
        return res.toArray(new String[0]);
    }

    /**
     * 回溯算法全排列
     *
     * @param s     提供的原初字符串
     * @param path  当前步骤组合的字符串
     * @param res   最终的全排列答案
     * @param index 当前处理第几个数
     * @param len   一共需要处理几个数
     * @param used  已经使用过的数
     */
    public void backTrace(String s, String path, Set<String> res, int index, int len, boolean[] used) {
        if (index == len) {
            res.add(path);
            return;
        }
        for(int i = 0; i<len; i++){
            if(!used[i]){
                path = path + s.charAt(i);
                used[i] = true;
                backTrace(s,path,res,index+1,len,used);
                used[i] = false;
                path = path.substring(0,path.length()-1);
            }
        }
    }
}
