package utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FormatterUtils {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** constructor 생성 X */
    private FormatterUtils() {}

    /**
     * date 타입을 string 으로 변환
     * 기본 타입은 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String dateToStr(Date date) {
        return dateToStr(DEFAULT_FORMAT, date);
    }

    /**
     * date 타입을 string 으로 변환
     * @param pattern
     * @param date
     * @return
     */
    public static String dateToStr(String pattern, Date date) {
        if (date == null) {
            log.error("date is null");
            throw new IllegalArgumentException(String.format("date is null"));
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
