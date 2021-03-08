package com.group10b.blueka;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.group10b.blueka.Sound.SntpClient;
import com.group10b.blueka.Sound.TimeOffset;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TimeOffsetTest {

    private TimeOffset time;

    @Before
    public void beforeTest()
    {
        SntpClient client = new SntpClient();
        time = new TimeOffset();
        MainActivity.offset = client.getOffsetString();
    }

    @Test
    public void getOffsetValueTest()
    {

        long output = time.getOffsetValue();
        assertEquals(0, output);
    }

    @Test
    public void getOffsetSignTest()
    {
        boolean output = time.getOffsetSign();
        assertFalse(output);
    }
}