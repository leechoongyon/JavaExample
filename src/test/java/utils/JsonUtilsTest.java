package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.Matchers.is;

public class JsonUtilsTest {

    private JSONObject jsonObject;

    private JSONArray jsonArray;

    @Before
    public void setUp() throws Exception {
        jsonObject = new JSONObject();
        jsonObject.put("key", "key test");
        jsonObject.put("value", "value test");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("key", "key test");
        jsonObject2.put("value", "value test");

        jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject2);
    }

    @Test
    public void getMapFromJsonObject_string_입력값_테스트() throws Exception {
        Map<String, Object> map = JsonUtils.getMapFromJSONObject(jsonObject.toString());
        Assert.assertThat(map.get("key"), is("key test"));
        Assert.assertThat(map.get("value"), is("value test"));
    }

    @Test
    public void getListMapFromJsonArray_테스트() throws Exception {
        List<Map<String, Object>> list = JsonUtils.getListMapFromJsonArray(jsonArray);
        Assert.assertThat(list.size(), is(2));
        Assert.assertThat(list.get(0).get("key"), is("key test"));
        Assert.assertThat(list.get(0).get("value"), is("value test"));
    }
}