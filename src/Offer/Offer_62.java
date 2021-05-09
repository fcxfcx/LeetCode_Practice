package Offer;

import java.util.ArrayList;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 62. 圆圈中最后剩下的数字
 * 标签：数学
 */
public class Offer_62 {
    public int lastRemaining(int n, int m) {
        // 关于约瑟夫环问题，除了数学方法外就是普通模拟法，在模拟法中需要注意数据结构的选择
        // 如果我们使用LinkedList的话，在删除操作中时间复杂度会很大，而如果我们能算出待删除的index，我们可以使用ArrayList去代替
        // 这样的时间复杂度可以达到O(n^2),空间复杂度为O(1)
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            list.add(i);
        }
        int index = 0;
        while(n > 1){
            index = (index + m -1) % n;
            list.remove(index);
            n --;
        }
        return list.get(0);
    }
}
