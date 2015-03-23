package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Pascal2 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		
		if(rowIndex < 0) return list;
		
		for(int i=0; i<rowIndex+1; i++) {
			list.add(0, 1);
			System.out.println(list);
			for(int j=1; j<list.size()-1; j++) {	
				list.set(j, list.get(j) + list.get(j+1));
				System.out.println(list);
			}
		}
		System.out.println(list);
		return list;
	}
	
	public static void main(String[] args) {
		Pascal2 p = new Pascal2();
		int rowIndex = 3;
		System.out.println(p.getRow(rowIndex));
	}
}
