package leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianInLargeFile {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public FindMedianInLargeFile() {
        minHeap = new PriorityQueue<Integer>();
        /* By default Java provides min heap. For max heap, we need to pass in a appropriate comparator */
        maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int number) {
        maxHeap.add(number);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (maxHeap.poll() + minHeap.poll()) * 0.5;
        }
        else
            return (double) maxHeap.poll();
    }

    public static double findMedianInArray(int[] nums) {

        int len = 0;
        // Need to know whether this nums is odd or not
        for (int num : nums) {
            len++;
        }

        if (len % 2 == 1) {
            return (double) search(nums, len/2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            return (double) (search(nums, len / 2, Integer.MIN_VALUE, Integer.MAX_VALUE) + search(nums, len/2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE)) * 0.5;
        }
    }

    public static double search(int[] nums, int k, long left, long right) {
        if (left >= right) {
            return left;
        }
        long res = left;
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        long guess = left + (right - left)/2;
        System.out.println("guess = " + guess);
        int count = 0;
        for (int num : nums) {
            if (num <= guess) {
                count++;
                res = Math.max(res, num);
                System.out.println("count = " + count);
                System.out.println("num = " + num);
                System.out.println("res = " + res);
            }
        }
        if (count == k) {
            return res;
        } else if (count < k) {
            return search(nums, k, Math.max(res + 1, guess), right);
        } else {
            return search(nums, k, left, res);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5};

        System.out.println(findMedianInArray(arr));
    }

}
