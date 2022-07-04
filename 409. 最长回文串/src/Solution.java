import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author yw
 * @since 2022/02/20
 *
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 */

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.longestPalindrome("ccc");
        System.out.println(s);

    }

    public int longestPalindrome(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                Integer num = map.get(c);
                map.put(c, num + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        // 结果
        int res = 0;
        boolean flag = false;
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() % 2 == 0) {
                // 偶数全加起来
                res += next.getValue();
            }
            if (next.getValue() % 2 == 1) {
                // 奇数
                res += next.getValue() - 1;
                flag = true;
            }
        }
        if (flag) {
            res += 1;
        }
        return res;
    }
}
