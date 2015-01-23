package entity;

import java.util.ArrayList;
import java.util.List;

import Util.JsonUtil;

public class DataFactory {
	public static DataFactory dataFactory = new DataFactory();
	
	private DataFactory() {}
	
	public DataFactory getInstance() {
		return dataFactory;
	}
	
	public static List<String> getInitJsonData() {
		List<String> list = new ArrayList<String>();
        String data1  = JsonUtil.object2Json(new Medicine(1,"银花 感冒 颗粒","功能主治：银花感冒颗粒 ，头痛,清热，解表，利咽。"));
        String data2  = JsonUtil.object2Json(new Medicine(2,"感冒  止咳糖浆","功能主治：感冒止咳糖浆,解表清热，止咳化痰。"));
        String data3  = JsonUtil.object2Json(new Medicine(3,"感冒灵颗粒","功能主治：解热镇痛。头痛 ,清热。"));
        String data4  = JsonUtil.object2Json(new Medicine(4,"感冒  灵胶囊","功能主治：银花感冒颗粒 ，头痛,清热，解表，利咽。"));
        String data5  = JsonUtil.object2Json(new Medicine(5,"仁和 感冒 颗粒","功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。"));
        
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        
        return list;
	}
}
