package BoxPackage;

public class Producer implements Runnable{
    Box box;

    public Producer(Box box){
        this.box=box;
    }
    public void run(){
        for (int i = 0; i < box.getNumDigits(); i++) {
            box.put((int) (Math.random() * 20) + 1);
        }
    }
}
