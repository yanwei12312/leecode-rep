import java.util.HashMap;
import java.util.Map;

/**
 * @author yw
 * @since 2022/02/20
 *
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 *
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 */

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb");
        System.out.println(s);

    }

    private final char[] zm = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int length = key.length();
        int m = 0;
        for (int i = 0; i < length; i++) {
            if (key.charAt(i) != ' ' && map.get(key.charAt(i)) == null) {
                map.put(key.charAt(i), zm[m]);
                m++;
            }
        }

        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ') {
                chars[i] = map.get(c);
            }
        }
        return String.valueOf(chars);
    }
}
