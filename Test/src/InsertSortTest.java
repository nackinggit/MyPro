public class InsertSortTest {
	public static void main(String[] args) {
		int[] src = new int[] { 1, 2, 3, 5, 8, 9, 62, 4, 7, 44 };

		System.out.println("排序之前：");

		for (int i = 0; i < src.length; i++) {
			System.out.println(src[i]);
		}

		int key;
		for (int j = 1; j < 10; j++) {
			key = src[j];
			int i = j - 1;
			while (i >= 0 && src[i] > key) {
				src[i + 1] = src[i];
				i = i - 1;
			}
			src[i + 1] = key;
		}

		System.out.println("排序之后：");

		for (int i = 0; i < src.length; i++) {
			System.out.println(src[i]);
		}
	}
}
