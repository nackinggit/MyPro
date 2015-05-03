import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ���ԣ�java������
 * 
 * @author Nacking��2014��5��23��17:10:48
 * 
 */
public class ObjectPoolFactory {
	private Map<String, Object> objectPool = new HashMap<String, Object>();

	/**
	 * һ����������ķ��������������java��������һ��java����
	 * 
	 * @param clazzName
	 *            �����java����
	 * @return һ��������������Ӧ��object
	 * @throws ClassNotFoundException
	 *             ���ү
	 * @throws IllegalAccessException
	 *             С����
	 * @throws InstantiationException
	 *             ���ܲ�����
	 */
	private Object creatObject(String clazzName) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}

	/**
	 * ����ָ���ļ���ʼ�������
	 * 
	 * @param fileName
	 *            ָ���ļ���
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
			System.out.println("��ȡ" + fileName + "�ļ��쳣.");
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
	 * ��ö�������ָ������
	 * 
	 * @param name
	 *            ָ�����������
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
