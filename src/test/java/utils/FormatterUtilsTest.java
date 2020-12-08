package utils;


import org.junit.Assert;
import org.junit.Test;
import java.util.Date;
import static org.hamcrest.Matchers.is;

public class FormatterUtilsTest {

    /**
     * 20200813 에 대한 검증
     */
    @Test
    public void dateToStrTest() {
        Date date = new Date(1597319590629L);   // 20200813
        String str = FormatterUtils.dateToStr("yyyyMMdd", date);
        Assert.assertThat(str, is("20200813"));
    }
}
