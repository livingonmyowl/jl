package NewStorePackage;

public class NewMan extends NewCustomer {
    private int minTime;
    private float minQueueProceedTime;      // Исправленное название переменной

    {
        minTime = 0;
    }
    @Override
    public int choose(NewCash[] cashList){

        for (int i=0; i<cashList.length; i++) {
            if (i == 0){
                this.minQueueProceedTime = cashList[i].getQueueProceedTime();
            } else if (cashList[i].getQueueProceedTime()<this.minQueueProceedTime) {
                this.minQueueProceedTime = cashList[i].getQueueProceedTime();
                this.minTime = i;
            }
        }
        return minTime;
    }

    @Override
    protected String getSymbol(){
        if (isJustComeIn){
            return manNewSymbol;
        }
        else {
            return manSymbol;
        }

    }
}
