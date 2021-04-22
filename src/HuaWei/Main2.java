package HuaWei;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class Main2 {

    static class Module{
        int index;
        HashSet<Integer> modules;

        public Module(int index){
            this.index = index;
            modules = new HashSet<>();
        }

        public void depend(Module module){
            modules.add(module.index);
            modules.addAll(module.modules);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int score = 10;
        boolean[] single = new boolean[M];
        HashMap<Integer,Module> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            map.put(i,new Module(i));
        }
        for (int j = 0; j < N; j++) {
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            Module temp = map.get(index2);
            temp.depend(map.get(index1));
            map.put(index2,temp);
            single[index1] = true;
            single[index2] = true;
        }
        for(Integer index : map.keySet()){
            Module m = map.get(index);
            Iterator<Integer> iter = m.modules.iterator();
            HashSet<Integer> tempSet = new HashSet<>();
            while(iter.hasNext()){
                int i = iter.next();
                tempSet.add(i);
                tempSet.addAll(map.get(i).modules);
            }
            m.modules = tempSet;
            if(m.modules.contains(index)){
                score -= 2;
            }
        }
        for (boolean s : single) {
            if (!s) {
                score -= 1;
            }
        }
        System.out.println(score<0 ? 0 : score);
    }
}
