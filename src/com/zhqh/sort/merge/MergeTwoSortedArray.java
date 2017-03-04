package com.zhqh.sort.merge;

/**
 * 将两个有序的数组合并为一个有序的数组 该方法是为后续使用归并算法进行排序做准备的
 * 
 * @author zhqh
 *
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] sourceA = { 1, 3, 5, 7, 9 };
		int[] sourceB = { 2, 4, 6, 8, 10,11 };
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

}
