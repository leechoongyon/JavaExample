package utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class MaskingUtils {

    /** 각 그룹씩 0-9 가 1~3개 올 수 있음. */
    private final static String VERSION4_IP_PATTERN = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";

    /**
     * ip 를 마스킹.
     * ip 3번째 자리를 마스킹 한다.
     * @Todo 추후 version6 ip 마스킹도 만들
     * @param ip
     * @return
     */
    public static String maskingVersion4Ip(String ip) {
        if (StringUtils.isEmpty(ip)) {
            log.error("invalid argument : {}", ip);
            throw new IllegalArgumentException(String.format("Invalid argument. %s ", ip));
        }
        Matcher matcher = Pattern.compile(VERSION4_IP_PATTERN).matcher(ip);
        if (matcher.matches()) {
            String maskedIp = "";
            for (int i = 1; i <= matcher.groupCount(); i++) {
                String replace = matcher.group(i);
                /** 3번째 자리일 경우 '*' 로 채운다. */
                if (i == 3) {
                    char[] c = new char[replace.length()];
                    Arrays.fill(c, '*');
                    maskedIp = maskedIp + String.valueOf(c);
                } else {
                    maskedIp = maskedIp + replace;
                }
                /** 마지막 그룹이 될 때까지 '.' 을 붙여준다. */
                if (i < matcher.groupCount()) {
                    maskedIp = maskedIp + ".";
                }
            }
            return maskedIp;
        } else {
            log.error("Not matching... ip : {}", ip);
            throw new IllegalArgumentException(String.format("Not matching... ip", ip));
        }
    }
}
