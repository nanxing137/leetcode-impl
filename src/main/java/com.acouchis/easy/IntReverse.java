package com.acouchis.easy;

/**
 * Created by gaopeng09 on 2019-12-26
 */
public class IntReverse {

    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        try {
            boolean m;
            if (m = (x < 0)) {
                x *= -1;
            }

            StringBuilder stringBuilder = new StringBuilder(x + "");
            StringBuilder reverse = stringBuilder.reverse();
            String s = reverse.toString();
            if ("".equals(s)) {
                return 0;
            }
            int l = Integer.parseInt(s);
            return m ? (int) (-1 * l) : (int) l;
        } catch (Exception e) {
            return 0;
        }


    }


}
