package NewStorePackage;

import java.util.LinkedList;

public class NewCash extends Thread{

    private int speed;
    //private NewCustomer[] queue;

    private LinkedList<NewCustomer> queue;                          // Замена массива на список (очередь)
    private static final String cashSymbol = "\uD83D\uDE4B";

    {
        speed = 1;
        queue = new LinkedList<>();
    }

    public NewCash(int speed) {
        this.speed = speed;
    }

    @Override
    public void run ()
    {
        while (true) {

            this.cashWork();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public float getQueueProceedTime() {                    // Вынос характеристики скорости очереди отдельно
        int currentNum = 0;
        for (NewCustomer newCustomer : queue) {             // Замена стандартного for
            currentNum += newCustomer.purchaseCount;
        }
        return (float) currentNum / (float) speed;
    }

    public void show(){
        StringBuilder cashString = new StringBuilder();
        cashString.append(speed);
        cashString.append(cashSymbol);
        cashString.append(": ");
        for (int i = 0; i<this.getLength(); i++){
            cashString.append(queue.get(i).getSymbol());
            cashString.append(queue.get(i).purchaseCount);
            cashString.append(" ");
            queue.get(i).isJustComeIn=false;
        }

        System.out.println(cashString);

    }

    //public NewCustomer[] getQueue() {
    //    return queue;
    //}

    public int getLength (){
        int queueLength;
        if (queue==null) {                                      // Замена обработки исключений на if
            queueLength = 0;
        } else {
            queueLength = queue.size();
        }
        return queueLength;
    }

    public void appendQueue(NewCustomer customer) {
//        int lengthQueue = this.getLength();
//        NewCustomer[] newQueue = new NewCustomer[lengthQueue+1];
//
//        if (lengthQueue!=0) {
//            System.arraycopy(queue, 0, newQueue, 0, lengthQueue);
//        }
//        queue = newQueue;
//        queue[queue.length-1] = customer;
        queue.addLast(customer);


    }

    public void cashWork(){
        int lengthQueue = this.getLength();
        if (lengthQueue!=0){
            if (!queue.element().isJustComeIn){
                for (int i=speed; i>0; i--){
                    if (!queue.isEmpty()){
                        queue.element().purchaseCount--;
                        if (queue.element().purchaseCount==0){
                            moveQueue();
                        }
                    }

//                    try {                                                               //УБРАТЬ TRY
//                        queue.element().purchaseCount--;
//                        if (queue.element().purchaseCount==0){
//                            moveQueue();
//                        }
//                    }
//                    catch (ArrayIndexOutOfBoundsException e) {
//
//                    }


                }
            }
        }


    }

    public void moveQueue(){
//        int lengthQueue = this.getLength();
//
//        if (lengthQueue!=0) {
//            NewCustomer[] newQueue = new NewCustomer[lengthQueue-1];
//            System.arraycopy(queue, 1, newQueue, 0, lengthQueue-1);
//            queue = newQueue;
//        }
//        else {
//            queue = null;
//        }
        queue.remove();

    }
}
