package com.rh.utilities.io;

import com.rh.utilities.logging.Loggable;
import com.rh.utilities.logging.Logging;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * Created by robert.hanaway on 24/01/2018.
 */

public class TestIoUtils {
    final static int STREAM_SIZE = 123;

    Logging logging;
    IoUtils ioUtils;

    @Before
    public void setup() {
        logging = mock(Logging.class);
        doCallRealMethod().when(logging).setEnabled(anyBoolean());
        logging.setEnabled(true);

        ioUtils = new IoUtils(logging);
    }

    @Test
    public void testRead() throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(new byte[STREAM_SIZE]);
        byte[] buffer = new byte[STREAM_SIZE * 2];

        int read = ioUtils.read(stream, buffer);
        Assert.assertEquals(STREAM_SIZE, read);
        Assert.assertEquals(STREAM_SIZE, ioUtils.getBytesRead());

        stream.reset();
        read = ioUtils.read(stream, buffer);
        Assert.assertEquals(STREAM_SIZE, read);
        Assert.assertEquals(STREAM_SIZE*2, ioUtils.getBytesRead());

        ioUtils.reset();
        Assert.assertEquals(0, ioUtils.getBytesRead());
    }

    @Test
    public void testLogging() {
        doCallRealMethod().when(logging).log(anyString(), any(Loggable.class));
        when(logging.format(anyString(), Matchers.<Object>anyVararg())).thenCallRealMethod();
        logging.log("", ioUtils);
        verify(logging, times(1)).i(anyString(), anyString(),
                Matchers.anyObject(),Matchers.anyObject(),Matchers.anyObject());
    }

    @Test
    public void testWrite() throws IOException {
        byte[] buffer = new byte[STREAM_SIZE];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ioUtils.write(outputStream, buffer);
        Assert.assertEquals(STREAM_SIZE, ioUtils.getBytesWritten());
        ioUtils.write(outputStream, buffer);
        Assert.assertEquals(STREAM_SIZE*2, ioUtils.getBytesWritten());
        Assert.assertEquals(STREAM_SIZE*2, outputStream.toByteArray().length);
    }
}
