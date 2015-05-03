import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 测试，java博大精深
 * 
 * @author Nacking，2014年5月23日17:10:48
 * 
 */
public class ObjectPoolFactory {
	private Map<String, Object> objectPool = new HashMap<String, Object>();

	/**
	 * 一个创建对象的方法，根据输入的java类名创建一个java对象
	 * 
	 * @param clazzName
	 *            输入的java类名
	 * @return 一个与输入类名对应的object
	 * @throws ClassNotFoundException
	 *             你大爷
	 * @throws IllegalAccessException
	 *             小错误
	 * @throws InstantiationException
	 *             不管不会死
	 */
	private Object creatObject(String clazzName) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}

	/**
	 * 根据指定文件初始化对象池
	 * 
	 * @param fileName
	 *            指定文件名
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void initPool(String fileName) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(fileName);
			Properties props = new Properties();
			props.load(fis);

			for (String name : props.stringPropertyNames()) {
				objectPool.put(name, creatObject(props.getProperty(name)));
			}
		} catch (IOException e) {
			System.out.println("读取" + fileName + "文件异常.");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获得对象池里的指定对象
	 * 
	 * @param name
	 *            指定对象的名字
	 * @return
	 */
	public Object getObject(String name) {
		return objectPool.get(name);
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		ObjectPoolFactory opf = new ObjectPoolFactory();
		opf.initPool("obj.txt");
		System.out.println(opf.getObject("a"));
		System.out.println(new Date());
	}

}
