package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class JsonUtils {

    /**
     * jsonObject --> map 으로 변경
     * JSONObject 에 JSONArray 없어야 햠.
     * @param obj
     * @return
     */
    public static Map<String, Object> getMapFromJSONObject(JSONObject obj) {
        if (ObjectUtils.isEmpty(obj)) {
            log.error("BAD REQUEST obj : {}", obj);
            throw new IllegalArgumentException(String.format("BAD REQUEST obj %s", obj));
        }
        
        try {
            return new ObjectMapper().readValue(obj.toJSONString(), Map.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * jsonStr --> map 으로 변경
     * JSONObject 에 JSONArray 없어 햠.
     * @param str
     * @return
     */
    public static Map<String, Object> getMapFromJsonString(String str) {
        if (StringUtils.isEmpty(str)) {
            log.error("BAD REQUEST obj : {}", str);
            throw new IllegalArgumentException(String.format("BAD REQUEST obj %s", str));
        }
        try {
            return new ObjectMapper().readValue(str, Map.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * json array 를 list map 으로 변경.
     *
     * @param jsonArray
     * @return 값이 있으면 list map, 없으면 list 빈 값 return
     */
    public static List<Map<String, Object>> getListMapFromJsonArray(JSONArray jsonArray) {
        if (ObjectUtils.isEmpty(jsonArray)) {
            log.error("jsonArray is null.");
            throw new IllegalArgumentException("jsonArray is null");
        }
        List<Map<String, Object>> list = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            list.add(getMapFromJSONObject((JSONObject) jsonObject));
        }
        return list;
    }


    /**
     * java object --> jsonObject string
     * 객체안의 객체도 표현 가능
     * @warnings 주의사항으로는 java object getter 가 구현되있어야 함.
     * @param object
     * @return
     */
    public static String getJsonStringFromJavaObj(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            log.error("object is empty. object : {}", object);
            throw new IllegalArgumentException(String.format("object is empty. object : %s", object));
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Throwable th) {
            log.error(th.getMessage(), th);
            throw new RuntimeException(th);
        }
    }

    /**
     * json string --> JSONObject 변환
     * @param jsonString
     * @return
     */
    public static JSONObject getJSONObjectFromJsonString(String jsonString) {
        if (StringUtils.isEmpty(jsonString)) {
            log.error("jsonString is empty");
            throw new IllegalArgumentException("jsonString is empty.");
        }
        try {
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(jsonString);
        } catch (Throwable th) {
            log.error(th.getMessage(), th);
            throw new RuntimeException(th);
        }
    }
}
