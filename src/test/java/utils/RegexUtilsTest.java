package utils;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class RegexUtilsTest {

    @Test
    public void isNumberTest () throws Exception {
        String s = "12345";
        Assert.assertThat(true, is(RegexUtils.isNumber(s)));

        s = "1234567a";
        Assert.assertThat(false, is(RegexUtils.isNumber(s)));
    }
}