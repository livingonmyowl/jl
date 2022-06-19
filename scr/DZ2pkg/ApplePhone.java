package DZ2pkg;

public class ApplePhone implements Telephone, Device{
    public ApplePhone (){
        this.getApp();
        this.charge();
    }
    @Override
    public void getApp() {
        System.out.println("- ставить через AppleStore");
    }

    @Override
    public void charge() {
        System.out.println("- заряжать через apple-разъём");
    }
}
