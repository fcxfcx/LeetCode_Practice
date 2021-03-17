package Greedy;

import java.util.HashSet;
import java.util.Set;

public class Problem_874 {
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int x=0;
            int y=0;
            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            int directionIndex = 0;
            int max = 0;
            Set<String> obstacleSet = new HashSet<String>();
            for (int i = 0; i < obstacles.length; i++) {
                obstacleSet.add(obstacles[i][0] + "," + obstacles[i][1]);
            }
            for(int command : commands){
                if(command == -2){
                    directionIndex = (directionIndex+3)%4;
                }else if(command == -1){
                    directionIndex = (directionIndex+1)%4;
                }else{
                    for(int i=0; i<command; i++){
                        int newX = x + directions[directionIndex][0];
                        int newY = y + directions[directionIndex][1];
                        if(obstacleSet.contains(newX+","+newY)){
                            break;
                        }else{
                            x = newX;
                            y = newY;
                            max = Math.max(max, x*x+y*y);
                        }
                    }
                }
            }
            return max;
        }
    }
}
