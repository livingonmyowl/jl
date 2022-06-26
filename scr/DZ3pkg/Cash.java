package DZ3pkg;

public class Cash {
    private Customer[] queue;
    private int speed;

    private static final String cashSymbol = "\uD83D\uDE4B";

    {
        speed = 1;
    }

    public void show(){
        StringBuilder cashString = new StringBuilder();
        cashString.append(speed);
        cashString.append(cashSymbol);
        cashString.append(": ");
        for (int i = 0; i<this.getLength(); i++){
            cashString.append(queue[i].getSymbol());
            cashString.append(queue[i].purchaseCount);
            cashString.append(" ");
            queue[i].isJustComeIn=false;
        }

        System.out.println(cashString);

    }

    public Customer[] getQueue() {
        return queue;
    }

    public int getLength (){
        int queueLength;
        try {
            queueLength = queue.length;
        }
        catch (NullPointerException e){
            queueLength = 0;
        }
        return queueLength;
    }

    public void appendQueue(Customer customer) {
        int lengthQueue = this.getLength();
        Customer[] newQueue = new Customer[lengthQueue+1];


//        try {
//            System.arraycopy(queue, 0, newQueue, 0, lengthQueue);
//        }
//        catch (NullPointerException e){
//
//        }
//        finally {
//            queue = newQueue;
//            queue[queue.length-1] = customer;
//        }

        if (lengthQueue!=0) {
            System.arraycopy(queue, 0, newQueue, 0, lengthQueue);
        }
        queue = newQueue;
        queue[queue.length-1] = customer;


    }

    public void cashWork(){
        int lengthQueue = this.getLength();
        if (lengthQueue!=0){
            if (!queue[0].isJustComeIn){
                for (int i=speed; i>0; i--){
                    try {
                        queue[0].purchaseCount--;
                        if (queue[0].purchaseCount==0){
                            moveQueue();
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) {

                    }


                }
            }
        }


    }

    public void moveQueue(){
        int lengthQueue = this.getLength();

        if (lengthQueue!=0) {
            Customer[] newQueue = new Customer[lengthQueue-1];
            System.arraycopy(queue, 1, newQueue, 0, lengthQueue-1);
            queue = newQueue;
        }
        else {
            queue = null;
        }

    }

    public int getSpeed() {
        return speed;
    }

    public Cash(int speed) {
        this.speed = speed;
    }
}
