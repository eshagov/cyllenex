package eu.shagov;

import eu.shagov.extensions.TimingExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
public class ApplicationIT {

    @Test
    void someSimpleMethod() {

    }

    @Test
    void someSimpleMethodSecond() {
        System.out.println(34);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
