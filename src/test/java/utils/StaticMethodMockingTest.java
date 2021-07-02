package utils;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;

public class StaticMethodMockingTest {

    @Test
    public void staticMethodMockingTest() throws Exception {
        try (MockedStatic<StringUtils> theMock = Mockito.mockStatic(StringUtils.class)) {
            theMock.when(() -> StringUtils.helloWorld())
                    .thenReturn("MockedStatic Hello World...");

            Assert.assertThat(StringUtils.helloWorld(), is("MockedStatic Hello World..."));
        }
        Assert.assertThat(StringUtils.helloWorld(), is("Hello World..."));
    }
}
