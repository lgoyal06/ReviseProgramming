package com.lalit.java8.collections.newfeatures.concurrency.executor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

class SortTask extends RecursiveAction {
   final long[] array; final int lo, hi;
   SortTask(long[] array, int lo, int hi) {
     this.array = array; this.lo = lo; this.hi = hi;
   }
   SortTask(long[] array) { this(array, 0, array.length); }
   protected void compute() {
     if (hi - lo < THRESHOLD)
       sortSequentially(lo, hi);
     else {
       int mid = (lo + hi) >>> 1;
       invokeAll(new SortTask(array, lo, mid),
                 new SortTask(array, mid, hi));
       merge(lo, mid, hi);
     }
   }
   // implementation details follow:
   static final int THRESHOLD = 5;
   void sortSequentially(int lo, int hi) {
     Arrays.sort(array, lo, hi);
   }
   void merge(int lo, int mid, int hi) {
     long[] buf = Arrays.copyOfRange(array, lo, mid);
     for (int i = 0, j = lo, k = mid; i < buf.length; j++)
       array[j] = (k == hi || buf[i] < array[k]) ?
         buf[i++] : array[k++];
   }

   public static void main(String ...s) {
       int processors = Runtime.getRuntime().availableProcessors();
       System.out.println(Integer.toString(processors) + " processor"
               + (processors != 1 ? "s are " : " is ")
               + "available");
       long[] array = new long[10];
       for(int i=0; i<10 ; ++i) {
           long leftLimit = 1L;
           long rightLimit = 100L;
           long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
           array[i]= generatedLong;
       }
      for(long a:array){
          System.out.println(a);
      }
      System.out.println("-------------------------------");
       SortTask st = new SortTask(array, 0,array.length);
       ForkJoinPool pool = new ForkJoinPool();
       long startTime = System.currentTimeMillis();
       pool.invoke(st);
       long endTime = System.currentTimeMillis();
       for(long a:array){
           System.out.println(a);
       }
   }
 }