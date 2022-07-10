package NewStorePackage;
public class NewChild extends NewCustomer {
    @Override
    public int choose(NewCash[] cashList){
        return (int) (Math.random() * cashList.length);

    }

    @Override
    protected String getSymbol(){
        if (this.isJustComeIn){
            return childNewSymbol;
        }
        else {
            return childSymbol;
        }


    }






}
