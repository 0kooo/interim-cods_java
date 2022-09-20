package com.itheima.text;

import java.util.Random;

public class text1 {
    public static void main(String[] args) {
        //1.定义一个一位数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //3.创立一个二维数组
        int[][] data = new int[4][4];
        //4.给二维数组添加数据
        //方法一
/*      for (int i = 0; i < tempArr.length; i++) {
            data[i % 4][i / 4] = tempArr[i];
        }*/
        //方法二
        int index = 0;
        for (int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                data[j][i] = tempArr[index];
                index++;
            }
        }
        //5.遍历二维数组
        for (int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                System.out.print(data[j][i] + " ");
            }
        }
    }
}
