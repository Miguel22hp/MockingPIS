package es.grise.upm.profundizacion.mocking.exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EngineControllerTest {

    private Logger logger;
    private Speedometer speedometer;
    private Gearbox gearbox;
    private Time time;
    private EngineController engineController;

    @BeforeEach
    public void setup() {
        this.logger = mock(Logger.class);
        this.speedometer = mock(Speedometer.class);
        this.gearbox = mock(Gearbox.class);
        this.time = mock(Time.class);
        this.engineController = new EngineController(logger, speedometer, gearbox, time);
    }

    @Test
    public void instantaneousSpeedTest() {

        when(speedometer.getSpeed()).thenReturn(10.0);

        double result = engineController.getInstantaneousSpeed();

        //verificamos que se ha llamado 3 veces al método getSpeed
        verify(speedometer, times(3)).getSpeed();

        //verificamos que el resultado es el esperado
        assertEquals(10.0, result, "Compara resultado esperado y el obtenido" );
    }
    
}
