package Util;

import java.io.IOException;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import entity.Medicine;

public class JsonUtil {
	public static String object2Json(Medicine m) {
		String json = null;
		
		try {
			XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
			jsonBuilder.startObject().field("id", m.getId()).field("name", m.getName()).field("function", m.getFunction()).endObject();
			json = jsonBuilder.string();
			System.out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static void main(String[] ars ) {
		JsonUtil.object2Json(new Medicine(1,"银花 感冒 颗粒","功能主治：银花感冒颗粒 ，头痛,清热，解表，利咽。"));
	}
}
