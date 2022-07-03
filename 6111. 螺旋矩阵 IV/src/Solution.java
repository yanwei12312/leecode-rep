


/**
 * @author yw
 * @since 2022/02/20
 *
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 *
 * 另给你一个整数链表的头节点 head 。
 *
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 *
 * 返回生成的矩阵。
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3,0,2,6,8,1,7,9,4,2,5,5,0
        ListNode node = new ListNode(3,new ListNode(0,new ListNode(2,new ListNode(6,new ListNode(8,new ListNode(1,new ListNode(7,new ListNode(9,new ListNode(4,new ListNode(2,new ListNode(5,new ListNode(5,new ListNode(0)))))))))))));
        int[][] matrix = s.spiralMatrix(3, 5, node);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int x = 0;
        int y = 0;
        int left = 0;
        int top = 0;
        int right = n-1;
        int bottom = m-1;
        int[][] res = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        // 螺旋
        while (head != null) {
            res[x][y] = head.val;
            if (x == top && y < right) y++;
            else if (y == right && x < bottom) x++;
            else if (x == bottom && y > left) y--;
            else if (y == left && x > top) x--;
            if (n > 1 && x == top + 1 && y == left) {
                left += 1;
                top += 1;
                right -= 1;
                bottom -= 1;
            }
            head = head.next;
        }

        return res;
    }
}
