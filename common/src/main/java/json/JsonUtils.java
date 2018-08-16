package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import sys.ServiceException;

public class JsonUtils {

	private static ObjectMapper objectMapper=new ObjectMapper();

	public static String object2json(Object object){
		try {
			return objectMapper.writeValueAsString(object);
		}catch (Exception e){
			throw new ServiceException("json解析失败");
		}
	}
}
