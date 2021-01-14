package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

@Slf4j
public class JsonUtils {

    /**
     * jsonObject --> map 으로 변경
     * JSONObject 에 JSONArray 없어야 햠.
     * @param jsonObject
     * @return
     */
    public static Map<String, Object> getMapFromJSONObject(JSONObject jsonObject) {
        if (ObjectUtils.isEmpty(jsonObject)) {
            log.error("bad request jsonObject : {}", jsonObject);
            throw new IllegalArgumentException(String.format("bad request jsonObject %s", jsonObject));
        }

        try {
            return new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * jsonStr --> map 으로 변경
     * JSONObject 에 JSONArray 없어 햠.
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> getMapFromJSONObject(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            log.error("bad request jsonObject : {}", jsonStr);
            throw new IllegalArgumentException(String.format("bad request jsonObject %s", jsonStr));
        }
        try {
            return new ObjectMapper().readValue(jsonStr, Map.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
