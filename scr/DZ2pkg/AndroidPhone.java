package DZ2pkg;

public class AndroidPhone implements Telephone, Device{
    public AndroidPhone (){
        this.getApp();
        this.charge();
    }
    @Override
    public void getApp() {
        System.out.println("- ставить через плеймаркет");
    }
    @Override
    public void charge() {
        System.out.println("- заряжать через Type-C");
    }
}
