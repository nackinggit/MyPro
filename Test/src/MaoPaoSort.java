
public class MaoPaoSort {
	
	public static void sort(int[] src) {
		for(int i=0; i<src.length; i++) {
			for(int j=i; j<src.length; j++) {
				if(src[i] > src[j]) {
					int temp = src[i];
					src[i] = src[j];
					src[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] src = new int[]{1,2,3,5,8,9,62,4,7,44};
		
		System.out.println("排序之前：");
		
		for(int i=0; i<src.length; i++) {
			System.out.println(src[i]);
		}
		
		//Sort Starting
		sort(src);
		
		System.out.println("排序之后：");
		
		for(int i=0; i<src.length; i++) {
			System.out.println(src[i]);
		}
	}

}
