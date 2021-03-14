package Stack;

import java.util.ArrayList;
import java.util.List;

public class Problem_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int j = 1;
        for(int i=0; i<target.length; i++){
            while(target[i] != j){
                list.add("Push");
                list.add("Pop");
                j++;
            }
            list.add("Push");
            j++;
        }
        return list;
    }
}
