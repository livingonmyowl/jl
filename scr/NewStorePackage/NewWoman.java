package NewStorePackage;
public class NewWoman extends NewCustomer {

    private int minCustomers;
    //private NewCash cash;

    {
        minCustomers = 0;
    }
    @Override
    public int choose(NewCash[] cashList){

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
