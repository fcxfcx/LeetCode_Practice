package Offer;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 45. 把数组排成最小的数
 * 标签：排序
 */
public class Offer_45 {
    public String minNumber(int[] nums) {
        // 本体要求排列成最小的数字，我们可以在拼接之前就对数组进行排序，保证拼接后更小的数在前
        // 排序过程需要我们自定义比较器，如果用Java内置方法，平均时间复杂度可以达到O(NlogN)，空间复杂度O(n)
        List<String> list = new ArrayList<>();
        for(int num : nums){
            list.add(String.valueOf(num));
        }
        // 注意这里的两个变量都是字符串，因此此处的+是拼接而不是数学意义上的加
        list.sort((o1,o2) -> (o1+o2).compareTo(o2+o1));
        return String.join("",list);
    }
}
