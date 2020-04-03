package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainUser user;
    TrainSensor sensor;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void MinimumSpeedLimit() {
        sensor.overrideSpeedLimit(-1);
        verify(user, times(1)).setAlarmState(true);
        verify(user, times(0)).setAlarmState(false);
    }

    @Test
    public void MaximumSpeedLimit() {
        sensor.overrideSpeedLimit(501);
        verify(user, times(1)).setAlarmState(true);
        verify(user, times(0)).setAlarmState(false);
    }

    @Test
    public void RelativeMargin() {
        when(controller.getReferenceSpeed()).thenReturn(200);
        sensor.overrideSpeedLimit(50);
        verify(user, times(1)).setAlarmState(true);
        verify(user, times(0)).setAlarmState(false);
    }

    @Test
    public void LegalSpeedLimit() {
        when(controller.getReferenceSpeed()).thenReturn(200);
        sensor.overrideSpeedLimit(150);
        verify(user, times(0)).setAlarmState(true);
        verify(user, times(1)).setAlarmState(false);
    }

    @Test
    public void GetSpeedLimit() {
        when(controller.getReferenceSpeed()).thenReturn(200);
        sensor.overrideSpeedLimit(150);
        Assert.assertEquals(150, sensor.getSpeedLimit());
    }
}
