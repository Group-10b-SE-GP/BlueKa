package com.group10b.blueka;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.group10b.blueka.Sound.SntpClient;
import com.group10b.blueka.Sound.TimeOffset;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Sound Service test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SoundServiceTest {

    /*@Before
    public void beforeTest()
    {
        MainActivity.getInstance().playMusic(System.currentTimeMillis());
    }*/

    @Test
    public void test_ServiceDestroyed() throws TimeoutException {
        new MainActivity().playMusic(System.currentTimeMillis());
        new SoundService().onDestroy();
        assertTrue(SoundService.destroyed);

    }


    @Test
    public void test_ServiceStarted() throws TimeoutException {
        MainActivity.getInstance().playMusic(System.currentTimeMillis());
        assertTrue(SoundService.started);
    }

    public void test_playMusic()
    {
        MainActivity.getInstance().playMusic(System.currentTimeMillis());
        assertTrue(MainActivity.musicPlayed);
    }

    public void test_mp3_raw_file() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        ///assertEquals("merdeka",appContext.);
    }

}