package utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;

public class DateUtilsTest {

    @Test
    public void getCurrentTimeStampTest() {
        Assert.assertNotNull(DateUtils.getCurrentTimeStamp());
    }
}
