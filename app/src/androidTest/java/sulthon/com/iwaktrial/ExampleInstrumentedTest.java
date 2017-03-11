package sulthon.com.iwaktrial;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation layout_item_kolam, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under layout_item_kolam.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("sulthon.com.iwaktrial", appContext.getPackageName());
    }
}
