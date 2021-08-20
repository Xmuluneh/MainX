package com.company;

import java.util.*;

public class Main<E> {

    public static void main(String[] args) {

        System.out.println(gcdm((new int[]{10, 18})));
        System.out.println(lcm(new int[]{12, 8}));
        System.out.println(Arrays.toString((eliminateDuplicates(new int[]{2, 2, 7, 7,7, 8, 8,8,8,8,}))));
        int[] c = {1, 2, 5, 3, 4, 0, -1, -4, -5, -9, -100};
        System.out.println("The original array is :" + Arrays.toString(c));
        sort(c);
        System.out.println("The sorted arrays is :" + Arrays.toString(c));
        reverse(c);
        System.out.println("The reversed arrays is :" + Arrays.toString(c));
        System.out.println("The array is sorted with constant difference:"
                + isSortedConstantInterval(new int[]{0, 2, 4, 6, 8, 10}));
        System.out.println("The cond num is :" + isRight(new int[]{1, 2, 4, 4, 4, 5, 9, 9, 9, 9}));
        System.out.println("My new array list is:" + Arrays.toString(Duplicates(new int[]{1, 1, 2, 2,7,9,9,8,8,6,6,5,5,4,3,4,})));
    }

    static int gcd(int num1, int num2) {
        int k = 2;
        int gcd = 1;
        for (; num1 >= k && num2 >= k; k++) {
            if (num1 % k == 0 && num2 % k == 0) {
                gcd = k;
            }
        }

        return gcd;
    }

    static int gcdm(int... a) {
        int g = a[0];
        for (int i = 0; i < a.length; i++) {

            g = gcd(g, a[i]);
        }

        return g;
    }

    static int lcm(int... a) {
        int lcm = 1;
        for (int i = 0; i < a.length; i++) {
            int gcd = gcd(lcm, a[i]);
            lcm = (lcm * a[i]) / gcd;
        }
        return lcm;
    }

    static int[] eliminateDuplicates(int[] list) {
        int[] temp = new int[list.length];
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            boolean flag = false;
            int num = list[i];
            for (int k = 0; k < count; k++) {
                if (num == list[k]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                temp[count++] = num;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    static void sort(int[] a) {
        int temp;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    static void reverse(int[] a) {
        int max = a.length - 1;
        int half = a.length / 2;
        for (int i = 0; i < half; i++) {
            int temp = a[i];
            a[i] = a[max - i];
            a[max - i] = temp;

        }

    }

    static boolean isSortedConstantInterval(int[] list) {
        int diff = list[0] - list[1];
        for (int i = 0; i < list.length - 1; i++) {
            if ((list[i] - list[i + 1]) != diff) {
                return false;
            }
        }
        return true;
    }

    static boolean isRight(int[] a) {
        for (int i = 0; i < a.length - 3; i++) {
            boolean isEqual = true;
            for (int j = i; j < i + 3; j++) {
                if (a[j] != a[j + 1]) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                return true;
            }
        }
        return false;
    }

    static Integer[] Duplicates(int[] a) {
        HashSet <Integer>set=new LinkedHashSet<>();
        for(int i=0;i<a.length;i++){
          set.add(a[i]);

        }
        return set.toArray(new Integer[0]);
    }

}

