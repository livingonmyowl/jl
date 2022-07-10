package NewStorePackage;

public class Fabric extends Thread{
    private static NewCustomer customer;

    @Override
    public void run ()
    {
        while (true) {

            switch ((int) (Math.random() * 3)) {
                case 0: customer = new NewChild(); break;
                case 1: customer = new NewWoman(); break;
                case 2: customer = new NewMan(); break;
            }
            int currentChoose = customer.choose(CashFabric.getCashList());
            CashFabric.getCashList()[currentChoose].appendQueue(customer);
            for (NewCash newCash : CashFabric.getCashList()) {             // Замена стандартного for
                newCash.show();
            }
            System.out.println("----------------------------");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
