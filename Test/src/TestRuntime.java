public class TestRuntime {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// getRuntime
		Runtime rt = Runtime.getRuntime();
		// rt.exec("notepad.exe");
		System.out.println("����������: " + rt.availableProcessors());
		System.out.println("�����ڴ���: " + rt.freeMemory());
		System.out.println("���ڴ���: " + rt.totalMemory());
		System.out.println("��������ڴ���: " + rt.maxMemory());
	}

}
