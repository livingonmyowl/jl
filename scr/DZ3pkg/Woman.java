package DZ3pkg;

import java.nio.channels.ScatteringByteChannel;

public class Woman extends Customer{
    private int minCustomers;
    private Cash cash;

    {
        minCustomers = 0;
    }
    @Override
    public int choose(Cash[] cashList){

        for (int i=0; i<cashList.length; i++) {

            if ( cashList[i].getLength() < cashList[minCustomers].getLength()){
                minCustomers = i;
            }
        }
        return minCustomers;
    }

    @Override
    protected String getSymbol(){
        if (isJustComeIn){
            return womanNewSymbol;
        }
        else {
            return womanSymbol;
        }

    }
}
