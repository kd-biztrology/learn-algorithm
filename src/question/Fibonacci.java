package question;

/**
 * 查找斐波纳契数列中第 N 个数。
 *
 * 所谓的斐波纳契数列是指：
 *
 * 前2个数是 0 和 1 。
 * 第 i 个数是第 i-1 个数和第i-2 个数的和。
 * 斐波纳契数列的前10个数字是：
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * Created by kevin on 17-2-13.
 */
public class Fibonacci {
  int fibonacci(int n) {
    if (n == 1) {
      return 0;
    } else if (n == 2 || n == 3) {
      return 1;
    }
    int s1 = 1;
    int s2 = 1;
    int i = 4;
    int sum = 0;
    while (i <= n) {
      sum = s1 + s2;
      s1 = s2;
      s2 = sum;
      i++;
    }
    return sum;
  }
}
