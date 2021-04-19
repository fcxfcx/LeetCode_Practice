package MeiTuan;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class Main {
    static class Toys {
        private HashMap<Integer, Integer> map;
        private int k;

        public Toys(int k) {
            this.map = new HashMap<>();
            this.k = k;
        }

        public void add(int x, int y) {
            map.put(x, y);
        }

        public int getScore() {
            int score = 0;
            Iterator iter = map.keySet().iterator();
            while (iter.hasNext()) {
                int key = (int) iter.next();
                int value = (int) map.get(key);
                if (value >= k) {
                    score += key * value;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        int n, m, k;
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] temp = command.split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);
        Toys A = new Toys(k);
        Toys B = new Toys(k);
        for (int i = 0; i < n; i++) {
            command = in.nextLine();
            temp = command.split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            A.add(x, y);
        }
        for (int j = 0; j < m; j++) {
            command = in.nextLine();
            temp = command.split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            B.add(x, y);
        }
        int aScore = A.getScore();
        int bScore = B.getScore();
        System.out.println(aScore+" "+bScore);
        System.out.println(aScore>bScore? "A" : "B");
    }
}
