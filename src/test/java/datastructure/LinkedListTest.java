package datastructure;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class LinkedListTest {

    @Test
    public void addLastTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast("test data");

        Assert.assertThat("test data", is(linkedList.getNode(0).getItem()));
    }
}
