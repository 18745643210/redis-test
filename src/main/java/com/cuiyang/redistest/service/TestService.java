package com.cuiyang.redistest.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String getName() {
        return "cuiyang";
    }

    public int[] merge(int a[], int m, int b[], int n) {
        int c[] = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                c[k++] = a[i];
            } else {
                c[k++] = b[j];
            }
        }
        while (i < m) {
            c[k++] = a[i++];
        }
        while (j < n) {
            c[k++] = b[j++];
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("devtest");
    }
}
