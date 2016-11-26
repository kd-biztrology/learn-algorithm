package question.字符串处理;

/**
 * Created by kevin on 16/4/12.
 * 写出一个函数 anagram(a, b) 去判断两个字符串是否是颠倒字母顺序构成的
 * <p>
 * anagram, 就是两个词所用的字母及其个数都是一样
 * 字母的位置不一样。比如 abcd 和 dcab 就是 anagram.
 * 判断的方法比较简单，先把单个字母（字符）转成整数，然后利用了hashtable+计数器的原理进行判断。
 * </p>
 */
public class Solution {
  private static final String a = "abcd";
  private static final String b = "dcab";

  public static void main(String[] args) {
    anagram(a, b);
  }

  /**
   * @param a: The first string
   * @param b: The second string
   * @return true or false
   */
  private static boolean anagram(String a, String b) {
    // write your code here

    if (a.length() != b.length()) return false;
    int letters[] = new int[256];

    //initialization
    for (int i = 0; i < letters.length; i++) {
      letters[i] = 0;
    }

    //process the string a
    for (char c : a.toCharArray()) {
      ++letters[c];
    }

    //if the char appears in string b, decrease the corresponding number of counts.
    for (char c : b.toCharArray()) {
      if (letters[c] == 0) {
        return false;
      }
      //  System.out.println(--letters[c]);
      --letters[c];
    }

    //if string a and b are anagrams, all the values in array letters should be 0
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] != 0) {
        return false;
      }
    }

    return true;
  }
}