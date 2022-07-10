package NewStorePackage;

public class CashFabric {
    private static NewCash[] cashList;
    private static final int[] speeds = {1,3,2,5};      // скорости касс

    static {
        cashList = new NewCash[4];
        for(int i = 0; i < 4; i++) {
            cashList[i] = new NewCash(speeds[i]);
            cashList[i].setDaemon(true);
            cashList[i].start();
        }
    }

    public static NewCash[] getCashList() {
        return cashList;
    }
}
