package DZ1pkg;

public class StackB extends StackA{
    public static void PrintCnt(){
        stackCntr++;
        System.out.println("\uD83D\uDEC8 Кол-во обращений к классу: "+stackCntr+" (доступ из статического метода наследника)");
    }

    public void CheckPrivateClass(){
        this.PrivateClass();
    }

    private void PrivateClass(){
        System.out.println("\uD83D\uDEC8 Сработал вызов приватного метода");

    }
}
