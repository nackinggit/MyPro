public class TestRuntime {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// getRuntime
		Runtime rt = Runtime.getRuntime();
		// rt.exec("notepad.exe");
		System.out.println("处理器数量: " + rt.availableProcessors());
		System.out.println("空闲内存数: " + rt.freeMemory());
		System.out.println("总内存数: " + rt.totalMemory());
		System.out.println("可用最大内存数: " + rt.maxMemory());
	}

}
