package DZ3pkg;

public class Man extends Customer{

    private int minTime;
    private float minK;

    {
        minTime = 0;
    }
    @Override
    public int choose(Cash[] cashList){

        float currentK = 0.0f;



        for (int i=0; i<cashList.length; i++) {
            int currentNum = 0;
            for (int j=0; j<cashList[i].getLength(); j++){
                currentNum+=cashList[i].getQueue()[j].purchaseCount;
            }
            currentK = (float) currentNum / cashList[i].getSpeed();
            if (i == 0){
                this.minK = currentK;
            } else if (currentK<this.minK) {
                this.minK = currentK;
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
