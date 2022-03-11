


/**
 * @author yw
 * @since 2022/02/20
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int[] res = new int[2];
        while(start<end) {
            int sum = numbers[start] + numbers[end];
            if(sum < target) {
                start++;
            } else if(sum>target) {
                end--;
            } else {
                res[0] = start+1;
                res[1] = end+1;
                return res;
            }
        }
        return res;
    }
}
