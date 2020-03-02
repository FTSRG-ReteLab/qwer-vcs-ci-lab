package hu.bme.mit.train.sensor;

import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl tsi;
    @Before
    public void before() {
        // TODO Add initializations
        tsi = new TrainSensorImpl(null, new TrainUserImpl(null));
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
        tsi.overrideSpeedLimit(10);
        Assert.assertEquals(tsi.getSpeedLimit(), 10);
    }
}
