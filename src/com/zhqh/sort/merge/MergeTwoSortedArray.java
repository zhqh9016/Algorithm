package com.zhqh.sort.merge;

import org.junit.Test;

/**
 * 将两个有序的数组合并为一个有序的数组 该方法是为后续使用归并算法进行排序做准备的
 * 
 * @author zhqh
 *
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] sourceA = { 1, 3, 5, 7, 9 };
		int[] sourceB = { 2, 4, 6, 8, 10, 11 };
		int[] merge = merge(sourceA, sourceB);
		for (int i : merge) {
			System.out.println(i);
		}
	}

	/**
	 * 将两个有序的数组合并后返回一个有序的数组
	 * 
	 * @param sourceA
	 * @param sourceB
	 * @return
	 */
	public static int[] merge(int[] sourceA, int[] sourceB) {

		// 创建一个新的数组,容量为刚好装下sourceA和sourceB的所有结果
		int lenA = sourceA.length;
		int lenB = sourceB.length;
		int[] result = new int[lenA + lenB];

		// 定义两个变量分别标识两个源数组当前遍历的位置
		int a = 0;
		int b = 0;
		// 同时遍历两个源数组,将当前遍历到的数进行对比,较小的放入result数组中
		for (int k = 0; k < result.length; k++) {
			if (a < lenA && b < lenB) {
				if (sourceA[a] < sourceB[b]) {
					result[k] = sourceA[a];
					a++;
				} else {
					result[k] = sourceB[b];
					b++;
				}
			} else {
				if (a < lenA) {
					result[k] = sourceA[a];
					a++;
				} else {
					result[k] = sourceB[b];
					b++;
				}
			}
		}
		return result;
	}

	@Test
	public void testMergeCopyFromInternet() {
		int[] sourceA = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11 };
		mergeCopyFromInternet(sourceA, 2, 4, 7);
		for (int i : sourceA) {
			System.out.println(i);
		}
	}

	/**
	 * 从网上查找的实现将两个有序数组合并为一个有序数组
	 * 
	 * @param source
	 * @param begin
	 * @param middle
	 * @param end
	 */
	public static void mergeCopyFromInternet(int[] source, int begin, int middle, int end) {

		// 计算两个数组的长度
		int len1 = middle - begin + 1;
		int len2 = end - middle;

		// 声明两个临时数组用于存放需要被整合的源数组
		//为了避免对角标越界的判断,这里分配空间时多分配一个标识边界的元素
		int[] temp1 = new int[len1 + 1];
		temp1[len1] = Integer.MAX_VALUE;
		int[] temp2 = new int[len2 + 1];
		temp2[len2] = Integer.MAX_VALUE;
		

		for (int i = 0; i < len1; i++) {
			temp1[i] = source[begin + i];
		}

		for (int i = 0; i < len2; i++) {
			temp2[i] = source[middle + i + 1];
		}

		int a = 0;
		int b = 0;
		// 将两个有序数组合并为一个有序数组
		for (int k = begin; k <= end; k++) {
			if (temp1[a] < temp2[b]) {
				source[k] = temp1[a];
				a++;
			} else {
				source[k] = temp2[b];
				b++;
			}
		}

	}

}
