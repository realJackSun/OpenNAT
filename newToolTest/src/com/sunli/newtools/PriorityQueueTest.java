package com.sunli.newtools;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String [] args){
		PriorityQueue<Integer> heap = new PriorityQueue<>(5);
		heap.offer(8);
		System.out.println(heap.peek());
		heap.offer(5);
		System.out.println(heap.peek());
		heap.offer(6);
		System.out.println(heap.peek());
		heap.offer(7);
		System.out.println(heap.peek());
		heap.offer(2);
		System.out.println(heap.peek());
		heap.offer(3);
		System.out.println(heap.peek());
		int a = heap.poll();
		System.out.println(a);
		System.out.println(heap.peek());
	}
}
