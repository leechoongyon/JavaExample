package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 오늘일자 timestamp 를 가져온다.
     * @return
     * @TODO 멀티 스레드에 적합하게 변경해주기. SimpleDateFormat 말고 스레드-safe 한 것
     */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(new Date());
    }
}
