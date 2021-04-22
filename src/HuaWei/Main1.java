package HuaWei;

import java.util.Scanner;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class Main1 {
    static class CardHouse {
        int[] orders = new int[24];
        int maxPeople;

        public CardHouse(int M) {
            maxPeople = M;
        }

        public void addOrder(int startTime, int endTime, int number) {
            int[] temp = orders.clone();
            for (int i = startTime; i < endTime; i++) {
                int value = temp[i] + number;
                if (value > maxPeople) {
                    return;
                }
                temp[i] = value;
            }
            orders = temp;
        }

        public String getOrder() {
            StringBuilder sb = new StringBuilder();
            for (int number : orders) {
                sb.append(number);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int N, M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        CardHouse cardHouse = new CardHouse(M);
        for (int i = 0; i < N; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            int number = sc.nextInt();
            cardHouse.addOrder(startTime, endTime, number);
        }
        System.out.println(cardHouse.getOrder());
    }
}
