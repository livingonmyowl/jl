import DZ3pkg.*;

public class Main2 {

    public static final int[] speeds = {1,3,2,1};
    public static final int liveTime = 20;
    public Cash[] cashList;

    private static Customer customer;


    public static void main(String[] args) throws InterruptedException{
        System.out.println("--Условные обозначения--");
        System.out.println("Мужчина:");
        System.out.println("\uD83D\uDC66 - новый");
        System.out.println("\uD83D\uDC68 - старый");

        System.out.println("Женщина:");
        System.out.println("\uD83D\uDC67 - новый");
        System.out.println("\uD83D\uDC69 - старый");

        System.out.println("Ребёнок:");
        System.out.println("\uD83D\uDC7C - новый");
        System.out.println("\uD83D\uDC76 - старый");

        System.out.println("--Начало процесса--");





        Cash[] cashList = new Cash[4];
        for(int i = 0; i < 4; i++) {
            cashList[i] = new Cash(speeds[i]);
        }

        for (int i=0; i<=liveTime; i++) {
            System.out.println ("");
            System.out.println ("Цикл: " + i);
            switch ((int) (Math.random() * 3)) {
                case 0: customer = new Child(); break;
                case 1: customer = new Woman(); break;
                case 2: customer = new Man(); break;
            }
            int currentChoose = customer.choose(cashList);
            cashList[currentChoose].appendQueue(customer);


            for (int j=0; j<4; j++) {
                cashList[j].cashWork();
                cashList[j].show();
            }
            Thread.sleep (4000);
        }



    }
}
