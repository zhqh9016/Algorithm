package com.zhqh.sort.merge;

/**
 * 使用递归方式实现归并算法排序
 * 
 * @author zhqh
 *
 */
public class RecursionMergeSort {
	
	public static void main(String[] args) {
		
		int[] source = {8,9,37,40,8,12,83,6,48,7,26,34,72,3,48,7};
		int[] mergeSort = mergeSort(source);
		for (int i : mergeSort) {
			System.out.println(i);
		}
		
	}

	/**
	 * 归并排序实现
	 * @param source
	 * @return
	 */
	public static int[] mergeSort(int[] source) {

		//如果当前数组只有一个元素,那么不需要进行排序直接将数组返回
		int sourceLen = source.length;
		if (sourceLen <= 1) {
			return source;
		}
		//将源数组从中间拆分成两个数组
		int mid = sourceLen / 2;
		int[] sourceA = new int[mid];
		int[] sourceB = new int[sourceLen - mid];

		for (int i = 0; i < mid; i++) {
			sourceA[i] = source[i];
		}
		for (int j = 0; j < sourceLen - mid; j++) {
			sourceB[j] = source[mid + j];
		}
		
		//递归调用对拆分后的两个数组进行归并排序
		int[] mergeSortLeft = mergeSort(sourceA);
		int[] mergeSortRigth = mergeSort(sourceB);
		//拆分后的数组排序完成后合并为一个有序数组
		int[] merge = MergeTwoSortedArray.merge(mergeSortLeft, mergeSortRigth);

		return merge;
	}

}
