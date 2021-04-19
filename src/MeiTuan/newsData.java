package MeiTuan;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class newsData {
    private int[] news;
    private int count;
    private HashMap<Integer, Integer> map;

    public newsData() {
        this.news = new int[1000];
        this.map = new HashMap<>();
        this.count = 0;
    }

    /**
     * 向新闻数据库中添加新闻或者添加热度
     *
     * @param x 新闻编号
     * @param y 热度
     */
    public void append(int x, int y) {
        // 如果是新的新闻
        if (!map.containsKey(x)) {
            map.put(x, y);
            // 在排行榜末尾添加新闻
            news[count] = x;
            count++;
            for (int i = count - 2; i >= 0; i--) {
                if (map.get(news[i]) < map.get(news[i + 1])) {
                    // 向前搜索排行榜，如果热度高于前者则交换
                    int temp = news[i];
                    news[i] = news[i + 1];
                    news[i + 1] = temp;
                } else if (map.get(news[i]).equals(map.get(news[i + 1])) && news[i] > news[i + 1]) {
                    // 如果两个热度相同，则编号小的在前
                    int temp = news[i];
                    news[i] = news[i + 1];
                    news[i + 1] = temp;
                } else {
                    // 如果以及满足顺序，则返回
                    break;
                }
            }
        } else {
            // 如果是现有新闻
            int newValue = map.get(x) + y;
            map.put(x, newValue);
            int index = 0;
            for (int i = 0; i < count; i++) {
                if (news[i] == x) {
                    index = i;
                    break;
                }
            }
            if (index == 0) {
                return;
            }
            for (int i = index - 1; i >= 0; i--) {
                if (map.get(news[i]) < map.get(news[i + 1])) {
                    // 向前搜索排行榜，如果热度高于前者则交换
                    int temp = news[i];
                    news[i] = news[i + 1];
                    news[i + 1] = temp;
                } else if (map.get(news[i]).equals(map.get(news[i + 1])) && news[i] > news[i + 1]) {
                    // 如果两个热度相同，则编号小的在前
                    int temp = news[i];
                    news[i] = news[i + 1];
                    news[i + 1] = temp;
                } else {
                    // 如果以及满足顺序，则返回
                    break;
                }
            }

        }
    }

    /**
     * 获取新闻数据库中排行榜数据
     *
     * @return 数据小于10条则返回全部新闻编号，否则返回前10新闻编号
     */
    public String query() {
        StringBuilder sb = new StringBuilder();
        if (count == 0) {
            return null;
        } else if (count <= 10) {
            for (int i = 0; i < count; i++) {
                sb.append(news[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } else {
            for (int i = 0; i < 10; i++) {
                sb.append(news[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        newsData data = new newsData();
        Scanner in = new Scanner(System.in);
        int commandNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i < commandNum; i++) {
            String command = in.nextLine();
            if("query".equals(command)){
                System.out.println(data.query());
            }else{
                String[] temp = command.split(" ");
                data.append(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
            }
        }
    }
}


