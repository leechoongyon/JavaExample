package utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
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

    /**
     * dateformat 을 변경.
     * @param strDate       ex) 20200101
     * @param beforeFormat  ex) yyyyMMdd
     * @param afterFormat   ex) yyyy-MM-dd
     * @return              ex) 2020-01-01
     */
    public static String convertDateFormat(String strDate, String beforeFormat,
                                           String afterFormat) {
        try {
            SimpleDateFormat beforeDf = new SimpleDateFormat(beforeFormat);
            SimpleDateFormat afterDf = new SimpleDateFormat(afterFormat);
            Date date = beforeDf.parse(strDate);
            return afterDf.format(date);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
