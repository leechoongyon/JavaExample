package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
        Map<String, Object> map = JsonUtils.getMapFromJsonString(jsonObject.toString());
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

    @Test
    public void getJsonStringFromJavaObjectTest() throws Exception {
        String jsonStr = JsonUtils.getJsonStringFromJavaObj(new Member("test", 10, new Address("test address")));
        Assert.assertNotNull(jsonStr);
    }

    @Test
    public void getJSONObjectFromJsonStringTest() throws Exception {
        String jsonString = JsonUtils.getJsonStringFromJavaObj(new Member("test", 10, new Address("test address")));
        JSONObject jsonObject = JsonUtils.getJSONObjectFromJsonString(jsonString);
        Assert.assertThat(jsonObject.get("name"), is("test"));
        Assert.assertThat(jsonObject.get("age"), is(10L));
    }

    static class Member {
        private String name;
        private int age;
        private Address address;

        public Member(String name, int age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Address getAddress() {
            return address;
        }
    }

    static class Address {
        private String addr;

        public Address(String addr) {
            this.addr = addr;
        }

        public String getAddr() {
            return addr;
        }
    }
}