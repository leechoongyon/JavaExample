package utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;

public class ConvertUtilsTest {

    @Test
    public void convertInputStreamToStringTest() {
        String text = "test";
        InputStream is = new ByteArrayInputStream(text.getBytes(Charset.defaultCharset()));

        Assert.assertThat(ConvertUtils.convertInputStreamToString(is), is(text));
    }

    @Test
    public void stringToMapTest() {
        String str = "kkk=qqq,aaa=bbb";
        Assert.assertThat(ConvertUtils.stringToMap(str, ",").get().size(), is(2));
        Assert.assertThat(ConvertUtils.stringToMap(str, ",").get().get("kkk"), is("qqq"));
    }
}
