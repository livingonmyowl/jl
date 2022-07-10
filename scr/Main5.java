import NewStorePackage.CashFabric;
import NewStorePackage.Fabric;
import NewStorePackage.NewCash;

public class Main5 {
/* Многопоточная касса:
 * 1. Для каждой кассы свой поток.
 *    Если скорость 2 покупки, то значит за одну секунду она обрабатывает 2 покупки.
 *    В цикле мы засыпаем на секунду, а когда просыпаемся, то вычитаем у первого покупателя в очереди количество покупок,
 *    равных скорости работы кассы.
 * 2. Появляется новый поток для фабрики покупателей.
 *    В этом потоке раз в секунду генерируется новый покупатель, покупатель выбирает кассу и печатается текущая очередь для каждой кассы.
 */

   private static final int lifeTime = 100;            // время жизни программы

    public static void main(String[] args){
        //Вывод пояснительного текста
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

        //Начало процесса
        CashFabric cashFabric = new CashFabric();
        Fabric fabric = new Fabric();
        fabric.setDaemon(true);
        fabric.start();
        //System.out.println("--Конец создания потоков--");
        //System.out.println("--Начало ожидания конца--");
        try {
            Thread.sleep(lifeTime * 1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        //
        // System.out.println("--Конец основного потока--");







    }
}