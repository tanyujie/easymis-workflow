package org.easymis.workflow.elasticsearch.sort;
/**
法五：插入排序
 */
public class SortV5 {

	public static void main(String[] args) {
		int []arr5={23,12,48,56,45};
		for (int i = 1; i < arr5.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr5[j - 1] > arr5[j]) {//大的放后面
					int tmp = arr5[j - 1];
					arr5[j - 1] = arr5[j];
					arr5[j] = tmp;
				}
			}
		}

			for (int i = 0; i < arr5.length; i++)
				System.out.print(arr5[i]+",");
	}

}
