package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
    public static Map<String, Object> getMapFromJSONObject(String str) {
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
}