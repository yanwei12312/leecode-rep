import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yw
 * @since 2022/02/20
 *
 * 在第 1 天，有一个人发现了一个秘密。
 *
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 *
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 109 + 7 取余 后返回。
 *
 *
 */

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.peopleAwareOfSecret(684,18,496);
        System.out.println(s);

    }


    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = (int) 1e9 + 7;
        long res = 1;
        int num = 1;
        long[] temp = new long[n];
        // 第一天有一个人
        temp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[j] != 0) {
                    // 忘记密码
                    if (j + 1 + forget == i) {
                        res = (res - temp[j] + mod) % mod;
                        temp[j] = 0;
                        continue;
                    }
                    // 分享密码
                    if (j + 1 + delay <= i) {
                        temp[i - 1] = (temp[i - 1] + temp[j] + mod) % mod;
                        res = (res + temp[j] + mod) % mod;
                        System.out.println(res);
                    }
                }
            }
        }
        return (int) (res + mod) % mod;
    }



//    public int peopleAwareOfSecret(int n, int delay, int forget) {
//        Queue<Integer> queue = new LinkedBlockingQueue<>();
//        Map<Integer, Person> map = new HashMap<>();
//        int m = 1;
//        int i = 1;
//        queue.add(i);
//        map.put(i, new Person(m, 1, delay, forget));
//        while (m <= n) {
//            Map<Integer, Person> newMap = new HashMap<>();
//            Set<Map.Entry<Integer, Person>> entries = map.entrySet();
//            Iterator<Map.Entry<Integer, Person>> iterator = entries.iterator();
//            while (iterator.hasNext()) {
//                Map.Entry<Integer, Person> next = iterator.next();
//                Person person = next.getValue();
//                System.out.println("遍历第" + person.getDate() + "天" + ",delay:" + person.getDelay() + ",forget:" + person.getForget());
//                if (person.getForget() == 0) {
//                    // 已忘记密码，删除这些人
//                    iterator.remove();
//                    // 出队人数
//                    for (int j = 0; j < person.getNum(); j++) {
//                        queue.poll();
//                    }
//                    System.out.println("第" + m + "天，出队,第"+ person.getDate()+"天，人数：" + person.getNum() + "人");
//                    continue;
//                } else {
//                    // 过一天
//                    person.setForget(person.getForget() - 1);
//                    map.put(person.getDate(), person);
//                }
//                if (person.getDelay() == 0) {
//                    // 入队n个人
//                    for (int j = 0; j < person.getNum(); j++) {
//                        queue.add(i++);
//                    }
//                    // 存储弟n天人数，并倒计时
//                    if (newMap.get(m) == null) {
//                        newMap.put(m, new Person(m, person.getNum(), delay - 1, forget - 1));
//                    } else {
//                        newMap.put(m, new Person(m, newMap.get(m).getNum() + person.getNum(), delay - 1, forget - 1));
//                        System.out.println("第" + m + "天，总入队" + newMap.get(m).getNum() + "人");
//                    }
//                } else {
//                    // 过一天
//                    person.setDelay(person.getDelay() - 1);
//                    map.put(person.getDate(), person);
//                }
//            }
//            newMap.putAll(map);
//            map = newMap;
//            System.out.println("第" + m + "天有" + queue.size() + "人");
//            m++;
//        }
//        return queue.size() % MAX_COUNT;
//    }
}

class Person{

    private Integer date;
    private Integer num;
    private Integer delay;
    private Integer forget;

    public Person(Integer date, Integer num, Integer delay, Integer forget) {
        this.date = date;
        this.num = num;
        this.delay = delay;
        this.forget = forget;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getForget() {
        return forget;
    }

    public void setForget(Integer forget) {
        this.forget = forget;
    }
}
