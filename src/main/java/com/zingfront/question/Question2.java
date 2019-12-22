package com.zingfront.question;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目2、
 * 某些整数能分解成若干个连续整数的和的形式，例如
 * 15 = 1 + 2+3+4+5
 * 15 = 4 + 5 + 6
 * 15 = 7 + 8
 * 某些整数不能分解为连续整数的和，例如:16
 * 输入: 一个整数N(N <= 10000)
 * 输出:整数N对应的所有分解组合，按照每个分解中的最小整数
 * 从小到大输出，每个分解占一行 ，每个数字之间有一个空格(每
 * 行最后保留一个空格);如果没有任何分解组合，则输出NONE
 *
 *
 * 算法描述：
 * 1、假定整数为n，1~n的中间两个连续整数和一定是大于等于n的，所以只要从1~中间的整数（mid）开始遍历查找就可以了。
 * 2、第一层循环（1~mid）确定起始位置i
 * 3、第二层循环从起始位置j=i开始累加，累加结果大于n，说明没找到结束当前循环即可，累加结果等于指定整数说明找到了，找到后输出i~当前位置j之间的所有整数;
 *
 * 时间复杂度: O(n^2)
 * 空间复杂度：O(1)
 */
public class Question2 {
    public static void calculate(int num){
        if (num == 0){
            System.out.println("NONE");
        }
        //统计结果数
        int count = 0;
        //找中间的整数。
        int n = (int)Math.ceil((double)num/2);
        //遍历，从1开始到中间的整数n。
        int sum = 0;
        for (int i = 1; i <= n; i++){
            //存放累加结果
            sum = 0;
            for (int j = i;j <= n; j++){
                sum += j;
                //累加结果等于num，说明找到了结果
                if (sum == num){
                    //输出从i-j的所有整数。
                    for (int k=i;k<=j;k++){
                        System.out.print(k+" ");
                    }
                    //换行
                    System.out.println();
                    //结果数+1
                    count++;
                    break;
                }
                //如果累加结果大于num，继续累加也一定是大于num的，所以中断当前循环就可以了
                if (sum > num){
                    break;
                }
            }
        }
        //结果数==0说明没有找到，输出NONE
        if (count==0){
            System.out.println("NONE");
        }
    }
    public static void main(String[] args) {
        calculate(10000);
    }
}

