package com.example.demo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: smart lihao
 * @Date: 2019/7/9 14:52
 *
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时
    间区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区
    间），其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束
 */
public class ArraysDemo {


    public static void main(String[] args) {
       /* int[][] arras = {{1,5}, {4,9}, {5,8} };

        int[][] merge = merge(arras);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }


        boolean word = valid("wordasd", "word3");
        System.out.println(word);
*/
      /* int[] num = {4,2,6,1,3,5,8};
        int[] ints = leftShift(num, 1);

            System.out.println(Arrays.toString(ints));
*/
        System.out.println(Runtime.getRuntime().availableProcessors());

        /*SimpleThreadPoolExecutor executor = new SimpleThreadPoolExecutor();
        IntStream.range(0, 30).forEach(i ->
                executor.submit(() -> {
                    System.out.printf("[线程] - [%s] 开始工作...\n", Thread.currentThread().getName());
                    try {
                        Thread.sleep(2_000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("[线程] - [%s] 工作完毕...\n", Thread.currentThread().getName());
                })
        );*/


        /*int i = steal(num, 7);
        System.out.println(i);*/

        int[] num = {10,2,6,1,3,5,8};
        int[] maopao = maopao(num);
        System.out.println(Arrays.toString(maopao));


    }

    /**
     * 重叠的区间合并
     * @param intervals 需要合并的二维数组
     * @return 处理过的二维数组
     */
    static int[][] merge(int[][] intervals){
        int size = intervals.length;
        //分别获取起始和结束的数组
        int[] starts=new int[size];
        int[] ends=new int[size];
        for(int i=0;i<size;i++){
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }
        //对起始和结束时间进行排序
        Arrays.sort(starts);
        Arrays.sort(ends);
       List<int[]> res=new ArrayList();
       //如果相邻的数组起始时间大于结束时间，进行合并
        for(int i=0,j=0;i<size;i++){
            if(i==size-1||starts[i+1]>ends[i]){
                res.add(new int[]{starts[j], ends[i]});
                j=i+1;
            }
        }
        return res.toArray(new int[0][]);
    }


    /**
     * 缩写校验
     * @param word 目标字符串
     * @param abbr 缩写字符串
     * @return 校验结果
     */
   static boolean valid(String word, String abbr){
        int wsize=word.length();
        int asize=abbr.length();
        char[] abbrChars = abbr.toCharArray();
        char[] wordChars = word.toCharArray();
       //原字符串下标
       int j=0;
       //取出数字并且进行下标移动，比对结束后置0
       int count=0;
       for (int i = 0; i <asize ; i++) {
           if(abbrChars[i]>='0'&&abbrChars[i]<='9'){
               //累加数字
               count=count*10+abbrChars[i]-'0';
               //如果第一个数字为0，直接返回false
               if(count==0){
                   return false;
               }
           }else {
                //移动源字符串下标
                j=j+count;
                //判断索引是否越界，比对索引元素
                if(j>=wsize||wordChars[j]!=abbrChars[i]){
                    return false;
                }
                j++;
                //比对结束后置0
                count=0;
           }
       }
        return j+count==wsize;
    }



    static int steal1(int[] nums,int n){
       int[] opt = new int[n];
       opt[0]=nums[0];
       opt[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            int choiceA =opt[i-2]+nums[i];
            int choiceB = opt[i-1];
            opt[i]=Math.max(choiceA,choiceB);
        }
       return opt[n-1];
    }


    static int steal(int[] nums,int n){
       int startZero[]=new int[n-1];
        System.arraycopy(nums,1,startZero,0,n-1);
       int endZero[]=new int[n-1];
        System.arraycopy(nums,0,startZero,0,n-1);
        int start = steal1(startZero, n-1);
        int end =steal1(endZero,n-1);
        return Math.max(start,end);
    }



    static int[] leftShift(int[] array, int steps) {
        int n = array.length;
        int[] newArray = new int[n];
        System.arraycopy(array, steps, newArray, 0, n - steps);
        System.arraycopy(array, 0, newArray, n - steps, steps);
        return newArray;
    }


    static int[] maopao (int[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]){
                    int swap=array[j];
                    array[j]=array[j+1];
                    array[j+1]=swap;
                }
            }
        }



       return array;
    }





}
