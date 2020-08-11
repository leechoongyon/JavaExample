package utils;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class MaskingUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void maskingVersion4IpNotMatchingTest() {
        String ip = "127.0.0";
        MaskingUtils.maskingVersion4Ip(ip);
    }

    @Test
    public void maskingVersion4IpMatchingTest() {
        String ip = "127.0.0.1";
        Assert.assertThat(MaskingUtils.maskingVersion4Ip(ip), is("127.0.*.1"));
    }
}
