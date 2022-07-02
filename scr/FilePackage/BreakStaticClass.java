package FilePackage;

public class BreakStaticClass {
    private static volatile boolean needBreak = false;

    public synchronized static boolean isNeedBreak() {
        return needBreak;
    }

    public synchronized static void setNeedBreak(boolean needBreak) {
        BreakStaticClass.needBreak = needBreak;
    }
}
