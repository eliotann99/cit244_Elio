/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soritng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class BucketSort {
    
    public static long startTime;
    public static long endTime;
    public static long timeElapsed;
    
    
    public static void starter2(){
        int[] list = numberMaker();
        bucketSort(list);
        for (int i=0; i<list.length; i++) {
        System.out.println(list[i]);
        }//close for
        measureTime();
    }// close main method

    public static int[] numberMaker() {
        Random r = new Random();
        int sortList[] = new int[10000];
        startTime= System.currentTimeMillis();
        for (int i=0; i<sortList.length; i++) {
            sortList[i]= r.nextInt(100000);
        }// close for
        return sortList;
    }// close numberMaker


    public static void bucketSort(int[] input) {
        final int[] code = hash(input);

        List[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
          buckets[i] = new ArrayList();
        }//close for

        for (int i : input) {
          buckets[hash(i, code)].add(i);
        }// close for

        for (List bucket : buckets) {
          Collections.sort(bucket);
        }// close for

        int ndx = 0;
        for (int b = 0; b < buckets.length; b++) {
            for (Iterator it = buckets[b].iterator(); it.hasNext();) {
                int v = (int) it.next();
                input[ndx++] = v;
            }// close inner for
        }// close outer for
        endTime=System.currentTimeMillis();
    }// close method

    private static int[] hash(int[] input) {
      int m = input[0];
      for (int i = 1; i < input.length; i++) {
        if (m < input[i]) {
          m = input[i];
        }//close if
      }// close for
      return new int[] { m, (int) Math.sqrt(input.length) };
    } // close method

    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }// close hash method
    
    public static void measureTime() {
        timeElapsed = (endTime - startTime);
        if (timeElapsed < 1000) {
            System.out.println("Time Taken " + timeElapsed + " Milliseconds");
        } else if (timeElapsed < 60000) {
            timeElapsed= timeElapsed/1000;
            System.out.println("Time Taken " + timeElapsed + "Seconds");
        }else if (timeElapsed < 3600000) {
            timeElapsed = timeElapsed /1000 /60;
            System.out.println("Time Taken " + timeElapsed + "Minutes ");
        }// close if
    }// close measure 
}// close class
