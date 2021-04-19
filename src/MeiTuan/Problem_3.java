package MeiTuan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class Problem_3 {
    static class Train<type2> {
        HashMap<String,String> map;
        String[] order;
        int count;
        public Train(){
            this.map = new HashMap<>();
            this.order = new String[100];
            this.count = 0;
        }

        public void add(int index, String type){
            if(map.containsKey(type)){
                StringBuilder sb = new StringBuilder();
                sb.append(map.get(type));
                sb.append(" ");
                sb.append(index);
                map.put(type,sb.toString());
            }else{
                order[count] = type;
                count++;
                map.put(type,""+index);
            }
        }

        public void changeOrder(String type1, String type2){
            int index1 = 0;
            int index2 = 0;
            for(int i=0; i<count; i++){
                if(type1.equals(order[i])){
                    index1 = i;
                }else if(type2.equals(order[i])){
                    index2 = i;
                }
            }
            String temp = order[index1];
            order[index1] = order[index2];
            order[index2] = temp;
        }

        public String getString(){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<count; i++){
                sb.append(map.get(order[i]));
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Train train = new Train();
        Scanner in = new Scanner(System.in);
        int commandNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i < commandNum; i++) {
            String str = in.nextLine();
            String[] temp = str.split(" ");
            if("1".equals(temp[0])){
                train.add(Integer.parseInt(temp[1]),temp[2]);
            }else if("2".equals(temp[0])){
                train.changeOrder(temp[1],temp[2]);
            }
        }
        System.out.println(train.getString());
    }
}
