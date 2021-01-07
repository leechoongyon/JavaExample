package stream;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

public class StreamListMaxTest {

    private List<TestIO> list = new ArrayList<>();

    @Before
    public void setUp() {
        TestIO io = new TestIO("test1", 1000L);
        TestIO io2 = new TestIO("test2", 2000L);

        list.add(io);
        list.add(io2);
    }

    @Test
    public void LIST_값_중_가장큰객체출력_테스트 () throws Exception {
        TestIO testIO = list.stream()
                .filter(io -> StringUtils.hasText(io.getName()))
                .max(Comparator.comparing(TestIO::getAmount))
                .orElseThrow(NoSuchElementException::new);
                ;
        Assert.assertThat(testIO.getAmount(), is(2000));
    }

    public static class TestIO {
        private String name;
        private Long amount;

        public String getName() {
            return name;
        }

        public Long getAmount() {
            return amount;
        }

        public TestIO(String name, Long amount) {
            this.name = name;
            this.amount = amount;
        }
    }



}
