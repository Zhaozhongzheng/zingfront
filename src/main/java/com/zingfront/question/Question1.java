package com.zingfront.question;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目1、
 * 功能是求出字符 s 与字符串t的第二公共单词(这里，假设两个字符串均由英字母和空格字符组成);若找到这样的公共单词，
 * 函数返回该单词，否则，函数返回NULL，如果有多个满足要求，则返回第一个单词。
 * 例如:若 s=“This is C programming text”，t=“This is a text for C
 * programming”，则函数返回“this”。
 *
 *
 * 算法描述：
 * 1、把两个字符串按空格分隔出所有单词存入字符串数组sArr、tArr
 * 2、首先遍历sArr，把sArr中的单词以key为单词小写全拼，value为"单词小写全拼：单词长度：重复标志"的格式按顺序填入LinkedHashMap
 * 3、再遍历tArr，把tArr中的单词以同样的格式塞入map，利用map的特性，判断主键是否存在，存在将重复标志置为1，不存在不需要处理
 * 4、遍历数组tArr的过程中，统计出最长的重复单词长度maxLen和第二重复的单词长度secLen
 * 5、按插入map的顺序遍历map的value，按“：”拆分出value的关键信息。当遇到重复标志为1且长度为secLen的单词，即为答案
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Question1 {

    public static String getWord(String s,String t){
        //判断字符串长度是否为空
        if (s == null || s.length() == 0){
            return null;
        }
        if (t == null || t.length() == 0){
            return null;
        }

        //将两个字符串去掉首尾空格后，按空格分割出所有单词
        String[] sArr = s.trim().split(" ");
        String[] tArr = t.trim().split(" ");

        //标记单词的最大长度和第二长度
        int maxLen = 0,secLen = 0;
        //创建有序map
        Map<String,String> map = new LinkedHashMap<>();

        //遍历s中的单词,将s字符串中的单词,按顺序塞到map中，
        for (String word : sArr){
            word = word.toLowerCase();
            //key为单词小写全拼，value记录单词小写全拼:单词长度:是否重复标志
            map.put(word,word+":"+word.length()+":"+0);
        }

        //遍历t中的单词
        for (String word : tArr){
            word = word.toLowerCase();
            if (map.get(word) != null){
                //如果该单词出现过,先比较长度获取当前已知的最大长度和第二长度
                if (word.length() > maxLen){
                    secLen = maxLen;
                    maxLen = word.length();
                }else if ( word.length() > secLen){
                    secLen = word.length();
                }
                //修改value中把重复出现的标志为设为1
                map.put(word,word+":"+word.length()+":"+1);
            }
        }

        //LinkedHashMap是按插入顺序排序的，根据插入顺序遍历map的value
        for (String value : map.values()){
            String[] split = value.split(":");
            String word = split[0];//单词
            int len = Integer.valueOf(split[1]);//长度
            int flag = Integer.valueOf(split[2]);//重复标志
            //重复出现标志为1并且长度为第二长度（如果没有第二长度，secLen应该等于第一）
            if (flag == 1 && len == secLen){
                return word;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "This is C programming text";
        String t = "This is a text for C programming";
        String word = getWord(s, t);
        System.out.println(word);
    }
}

