package examples.test;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class ServiceBaseTestCase {

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
