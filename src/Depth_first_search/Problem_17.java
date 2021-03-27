package Depth_first_search;

import java.util.*;

public class Problem_17 {
    public static final Map<Character, String[]> map = new HashMap<>();

    static {
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if ("".equals(digits)) {
            return list;
        }
        return combine(list, digits);
    }

    public List<String> combine(List<String> list, String digit) {
        if ("".equals(digit)) {
            return list;
        }
        String[] characters = map.get(digit.charAt(0));
        // 维护digit以进行下一次递归
        digit = digit.substring(1);
        List<String> temp = new ArrayList<>();
        if (list.size() == 0) {
            temp = Arrays.asList(characters);
        } else {
            for (String s1 : list) {
                for (String s2 : characters) {
                    temp.add(s1 + s2);
                }
            }
        }
        return combine(temp, digit);
    }
}
