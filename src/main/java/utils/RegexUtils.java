package utils;


public class RegexUtils {
    /**
     * 숫자인지 판단
     * 빈 값도 숫자로 처리. 빈 값을 숫자가 아닌 값으로 처리할 시 '*' —> '+' 변경
     *
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        String regex = "^[0-9]*$";
        return s.matches(regex);
    }
}
