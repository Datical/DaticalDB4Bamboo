package ut.com.datical.integration.bamboo;

import org.junit.Test;
import com.datical.integration.bamboo.MyPluginComponent;
import com.datical.integration.bamboo.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}