package utils;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;

public class StringUtilsTest {

    @Test
    public void 전각문자테스트() throws Exception {
        // 전각문자 공백 (0xA1 0xA1)
        byte[] bytes = {(byte)0xA1, (byte)0xA1};
        Assert.assertThat(bytes.length, is(2));
        String s = new String(bytes, Charset.forName("euc-kr"));
        // 2개의 바이트를 읽어서 하나의 전각문자로 만드니 길이가 1
        Assert.assertThat(s.length(), is(1));
        byte[] tmp = s.getBytes(Charset.forName("euc-kr"));
        // 전각문자를 bytes 변환하면 1개의 전각문자는 2byte
        Assert.assertThat(tmp.length, is(2));
    }

    @Test
    public void 반각문자_전각문자_변환_테스트() throws Exception {
        String s = " ";
        // 반각문자 공백이기에 1bytes
        Assert.assertThat(s.getBytes(Charset.forName("euc-kr")).length, is(1));

        String fullWidthCharacter = StringUtils.toFullWidthCharacter(s);
        // 전각문자 공백이기에 2bytes
        Assert.assertThat(fullWidthCharacter.getBytes("euc-kr").length, is(2));

        String halfWidthCharacter = StringUtils.toHalfWidthCharacter(fullWidthCharacter);
        // 반각문자 bytes 이기에 byte 길이 1
        Assert.assertThat(halfWidthCharacter.getBytes("euc-kr").length, is(1));
    }
}
