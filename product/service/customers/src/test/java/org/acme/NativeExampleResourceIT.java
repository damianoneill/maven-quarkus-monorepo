package org.acme;

import io.quarkus.test.junit.NativeImageTest;
import org.acme.ExampleResourceTest;

@NativeImageTest
public class NativeExampleResourceIT extends ExampleResourceTest {

    // Execute the same tests but in native mode.
}
