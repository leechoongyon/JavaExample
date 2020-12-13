package utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class ConvertUtils {

    /**
     * stream 을 string 변환
     * is 를 close 하지 않는건 파라미터로 받기 때문.
     * 입력 값을 변경하는 행위는 안하는게 좋다.
     * @param is
     * @return
     */
    public static String convertInputStreamToString(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Throwable th) {
            log.error(th.getMessage(), th);
            throw new RuntimeException(th);
        }
    }


    /**
     * delimiter 를 기준으로 str 을 map 으로 변환
     * @param str
     * @param delimiter
     * @return
     */
    public static Optional<Map<String, String>> stringToMap(String str, String delimiter) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(str)) {
            return Optional.empty();
        }

        String[] ketValues = str.split(delimiter);
        for (String keyValue : ketValues) {
            String[] tmp = keyValue.split("=");
            map.put(tmp[0], tmp[1]);
        }
        return Optional.ofNullable(map);
    }
}
