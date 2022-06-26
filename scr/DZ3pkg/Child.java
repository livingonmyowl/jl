package DZ3pkg;

public class Child extends Customer{
    @Override
    public int choose(Cash[] cashList){
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
