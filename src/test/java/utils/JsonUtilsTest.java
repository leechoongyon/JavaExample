package utils;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;

public class JsonUtilsTest {

    private JSONObject jsonObject;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JSONObject();
        jsonObject.put("key", "key test");
        jsonObject.put("value", "value test");
    }

    @Test
    public void getMapFromJsonObject_string_입력값_테스트() throws Exception {
        Map<String, Object> map = JsonUtils.getMapFromJSONObject(jsonObject.toString());
        Assert.assertThat(map.get("key"), is("key test"));
        Assert.assertThat(map.get("value"), is("value test"));
    }
}