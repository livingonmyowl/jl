package DZ3pkg;

public abstract class Customer {
    public int purchaseCount;
    public boolean isJustComeIn;


    protected static final String manSymbol = "\uD83D\uDC68";
    protected static final String manNewSymbol = "\uD83D\uDC66";
    protected static final String womanSymbol = "\uD83D\uDC69";
    protected static final String womanNewSymbol = "\uD83D\uDC67";
    protected static final String childSymbol = "\uD83D\uDC76";
    protected static final String childNewSymbol = "\uD83D\uDC7C";

    {
        isJustComeIn = true;
        purchaseCount = (int) (Math.random() * 5) + 1;
    }

    protected abstract String getSymbol();
    public abstract int choose(Cash[] cashList);

}
