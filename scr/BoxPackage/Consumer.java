package BoxPackage;

public class Consumer implements Runnable{

    Box box;
    public Consumer(Box box){
        this.box=box;
    }
    public void run(){
        for (int i = 0; i < box.getNumDigits(); i++) {
        box.get();
        }
    }
}
