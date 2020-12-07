package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (Throwable th) {
            log.error(th.getMessage(), th);
            throw new RuntimeException(th);
        }
    }
}
