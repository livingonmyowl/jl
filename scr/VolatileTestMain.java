import VolatilePackage.VolatileListenBreak;

import java.io.IOException;

public class VolatileTestMain {
    public static void main (String[] args) {
        VolatileListenBreak listenBreakProcess = new VolatileListenBreak();
        listenBreakProcess.start();
        while (!listenBreakProcess.isNeedBreak()) {

        }
        System.out.println("Конец");
    }
}
