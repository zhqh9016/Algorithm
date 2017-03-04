package com.zhqh.sort.merge;

import java.util.Random;

/**
 * 使用循环方式实现归并排序
 * 
 * @author zhqh
 *
 */
public class LoopMergeSort {

	public static void main(String[] args) {

		int seed = 20000001;

		// int[] source = {8,9,37,40,8,12,83,6,48,7,26,34,72,3,48,7};
		int[] source = new int[seed];
		Random random = new Random();
		for (int i = 0; i < seed; i++) {
			int nextInt = random.nextInt(seed);
			source[i] = nextInt;
		}
		
		long start = System.currentTimeMillis();
		int[] mergeSort = mergeSort(source);
		long end = System.currentTimeMillis();
		
		for(int j=1;j<mergeSort.length;j++){
			if(mergeSort[j-1]>mergeSort[j]){
				System.out.println("排序结果不正确");
				return;
			}
		}
		System.out.println("对" + seed + "个数进行排序用时" + (end - start) / 1000 + "s");

	}

	/*
	 * 思路: 一个一个的merge
	 */
	public static int[] mergeSort(int[] source) {

		for (int k = 2; k/2 < source.length; k *= 2) {
			for (int i = 0; i < source.length; i += k) {
				// 声明两个数组用于存放截取出来的子数组
				int middle = k / 2;
				int[] left;
				int[] right;
				if (i + k < source.length) {
					left = new int[middle];
					right = new int[middle];
				} else if (i + middle < source.length) {
					left = new int[middle];
					right = new int[source.length - i - middle];
				} else {
					continue;
				}
				// 截取k区间内的前半段到临时数组
				for (int j = 0; j < left.length; j++) {
					left[j] = source[i + j];
				}
				// 截取k区间内的后半段到临时数组
				for (int j = 0; j < right.length; j++) {
					right[j] = source[i + middle + j];
				}
				int[] merge = MergeTwoSortedArray.merge(left, right);
				for (int j = 0; j < merge.length; j++) {
					source[i + j] = merge[j];
				}
			}
		}

		return source;
	}

}
