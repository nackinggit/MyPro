public class QuickSort {
	public static void quickSort(int[] arr, int s, int e) {
		if (s < e) {
			int pIndex = part(arr, s, e);

			quickSort(arr, s, pIndex - 1);
			quickSort(arr, pIndex + 1, e);
		}
	}

	private static int part(int[] arr, int s, int e) {
		int start = s;
		int end = e;
		int key = arr[s];

		while (start < end) {
			while (start < end && arr[end] >= key) {
				end--;
			}
			arr[start] = arr[end];
			
			while (start < end && arr[start] <= key) {
				start++;
			}
			arr[end] = arr[start];

		}
		arr[start] = key;
		return start;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 7, 9, 6, 6, 3, 4 };

		quickSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.println(i);
	}
}
