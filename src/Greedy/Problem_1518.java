package Greedy;

public class Problem_1518 {
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int drink = numBottles;
            int bottle = numBottles;
            while(bottle >= numExchange){
                int newDrink = bottle/numExchange;
                drink += newDrink;
                bottle = newDrink + bottle%numExchange;
            }
            return drink;
        }
    }
}
