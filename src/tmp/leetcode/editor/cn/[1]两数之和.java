//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10891 👎 0

package tmp.leetcode.editor.cn;

import java.util.HashMap;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int differenceNum = target - nums[i];
            if (!hashMap.containsKey(differenceNum)){
                hashMap.put(nums[i], i);
            }
            else{
                return new int[]{hashMap.get(differenceNum), i};
            }
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
* 解题思路：
*     1、利用HashMap；
*     2、遍历数组nums，differenceNum = target - nums[i]是我们需要查找的值；
*        如果Map中不存在differenceNum，即将nums[i] 和索引i存入Map；若存在，
*        则直接取出differenceNum的索引j，返回[j, i]。
*     3、举例说明：
*       [2,7,11,15] target：9
*       循环第一次：
*           7 = 9 - 2，7不在map中，存入（2，0）。
*       循环第二次：
*           2 = 9 - 7，此时发现2在map中，则直接取出2的索引0，并将本次循环数字7的索引1一并返回[0,1]。
*       可发现，如此第二次循环便找到目标值，程序结束
*      （注意：返回索引的数组中，第一个元素是已经存入Map中的数字对应的索引。因为按照循环先后的原则，这个数是先遍历存入数组的。）
*/
