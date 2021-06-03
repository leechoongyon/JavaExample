package utils;

public class StringUtils {

    /**
     * 반각문자 --> 전각문자 변환
     *
     * @param s
     * @return
     */
    public static String toFullWidthCharacter(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s is null");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 영문 알파벳 or 특수 문자
            if (c >= 0x21 && c <= 0x7e) {
                c += 0xfee0;
            }
            // 공백 (=space)
            else if (c == 0x20) {
                c = 0x3000;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 전각문자를 반각문자로 변환
     * @param s
     * @return
     */
    public static String toHalfWidthCharacter(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s is null");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 영문 알파벳 or 특수 문자
            if (c >= '！' && c <= '～') {
                c -= 0xfee0;
            }
            // 공백 (=space)
            else if (c == '　') {
                c = 0x20;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
