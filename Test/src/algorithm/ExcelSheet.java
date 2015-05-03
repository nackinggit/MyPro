package algorithm;

public class ExcelSheet {
	public String convertToTitle(int n) {
		if (n == 0) {
			return "";
		}
		return convertToTitle((n - 1) / 26) + (char) ('A' + (--n % 26));
	}

	public static void main(String[] args) {
		ExcelSheet es = new ExcelSheet();
		System.out.println(es.convertToTitle(27));
	}
}
