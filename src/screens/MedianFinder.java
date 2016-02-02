package screens;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Le on 2016/2/1.
 */
public class MedianFinder {
    Integer sum = 0;
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());

    // Adds a number into the data structure. O(logn)
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }

        sum += num;
    }

    // Returns the median of current data stream (O(1))
    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double) (maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }

    public int getSize() {
        return maxheap.size() + minheap.size();
    }

    public double getMean() {
        return sum / getSize();
    }

}
