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

    @Test
    public void convertDateFormatTest() {
        Assert.assertThat(DateUtils.convertDateFormat("2021-01-01", "yyyy-MM-dd", "yyyyMMdd"), is("20210101"));
        Assert.assertThat(DateUtils.convertDateFormat("20210101", "yyyyMMdd", "yyyy-MM-dd"), is("2021-01-01"));
    }

}
