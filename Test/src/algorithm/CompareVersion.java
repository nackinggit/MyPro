package algorithm;

public class CompareVersion {
	public int compareVersion(String version1, String version2) {
		String[] subV1 = version1.split("\\.");
		String[] subV2 = version2.split("\\.");
		
		int len1 = subV1.length;
		int len2 = subV2.length;
		
		
		
		while(len1!=0 && len2!=0 && (Integer.parseInt(subV1[len1-1])==0 || Integer.parseInt(subV2[len2-1])==0)) {
			if(Integer.parseInt(subV1[len1-1])==0) {
				len1--;
			}
			
			if(Integer.parseInt(subV2[len2-1])==0) {
				len2--;
			}
		}
		System.out.println(len1 + ", " + len2);
		
		for(int i=0; i<len1; i++) {
			if(i < len2 && Integer.parseInt(subV1[i]) > Integer.parseInt(subV2[i])) {
				return 1;
			}
			
			if(i < len2 && Integer.parseInt(subV1[i]) < Integer.parseInt(subV2[i])) {
				return -1;
			}
		}
		
		if(len1 < len2) {
			return -1;
		}
		
		if(len1 > len2) return 1;
		
		return 0;
	}
	
	public static void main(String[] args) {
		CompareVersion cv = new CompareVersion();
		String version1 = "0.1";
		String version2 = "1.000.0";
		
		System.out.println(cv.compareVersion(version1, version2));
	}
}
