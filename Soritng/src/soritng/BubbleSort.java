/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soritng;

import java.util.Random;

/**
 *
 * @author eliot
 */
public class BubbleSort {
 
    public static long startTime;
    public static long endTime;
    public static long timeElapsed;
    
    public static void starter() {
        int[] list= numberMaker();
        System.out.println("Sorted List");
        bubbleSort(list);
        for (int i=0; i<list.length; i++)
        System.out.println(list[i]);
        measureTime();
    }// cloes main
    
    
    public static void bubbleSort(int[] list) {
        boolean needNextPass=true;
        for(int k=1; k<list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i=0; i< list.length -k; i++) 
                if (list[i] > list[i+1]) {
                    int temp =list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    
                    
                    needNextPass =true;
                }// close if
            }//close for
        endTime=System.currentTimeMillis();
    }// close bubble sort
    

    
    public static int[] numberMaker() {
        Random r = new Random();
        int sortList[] = new int[10000];
        startTime= System.currentTimeMillis();
        for (int i=0; i<sortList.length; i++) {
            sortList[i]= r.nextInt(100000);
        }// close for
        return sortList;
    }// close numberMaker
    
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
