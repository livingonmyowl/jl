import DZ1pkg.StackA;
import DZ1pkg.StackB;
import DZ2pkg.*;

public class Main {
    public static void main(String[] args) {

        StackA stack = new StackA();
        stack.push("Элемент1");
        stack.push(3);
        stack.push(3.4);
        System.out.println("\uD83D\uDEC8 Размер стека: "+stack.stackLength);
        for(int i = 0; i < 15; i++) {
            stack.push(i);
        }
        for(int i = 0; i < 11; i++) {
            stack.pop();
        }
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("\uD83D\uDEC8 Размер стека: "+stack.stackLength);
        stack.pop();
        stack.pop();
        stack.push("Элемент1");
        System.out.println("\uD83D\uDEC8 Кол-во обращений к классу: "+StackA.stackCntr+" (доступ к статическому полю)");
        System.out.println("\uD83D\uDEC8 Обнулили стек");
        StackA.PrintCnt();

        StackA stack2 = new StackA();
        System.out.println("****Создаём второй стек****");
        System.out.println("\uD83D\uDEC8 Размер стека2: "+stack2.stackLength);
        StackA.PrintCnt();

        StackB stack3 = new StackB();
        System.out.println("****Создали стек от дочернего класса****");
        System.out.println("****Пробуем вызвать статический метод объявленный и в дочернем классе****");
        System.out.println("****Сначала вызовем непосредственно из дочернего класса****");
        StackB.PrintCnt();
        System.out.println("****Теперь вызовем через переменную дочернего класса****");
        stack3.PrintCnt();
        System.out.println();
        System.out.println("\uD83D\uDEC8\uD83D\uDEC8 Получается фигня какая то. Метод всё равно наследника(((");
        System.out.println();
        System.out.println("****А так сработало как надо: StackA stack4 = new StackB(); A - родитель, B - наследник ****");
        StackA stack4 = new StackB();
        stack4.PrintCnt();
        System.out.println("****Проверяем вызов приватного медота****");
        stack3.CheckPrivateClass();
        stack = null;
        stack2 = null;
        stack3 = null;

        System.out.println();
        System.out.println("****Проверяем интерфейс****");
        System.out.println("Телефон XIAOMI:");
        Telephone phone1 = new AndroidPhone();
        System.out.println("Телефон Iphone:");
        Telephone phone2 = new ApplePhone();

        System.out.println();
        System.out.println("****Проверяем полиморф и статический инициализатор****");
        Polimorf morf1 = new Polimorf(3);
        Polimorf morf2 = new Polimorf(3,5);
        Polimorf morf3 = new Polimorf(8,7,1);
        Polimorf2 morf4 = new Polimorf2();

        System.out.println();
        System.out.println("****Проверяем абстрактные классы****");
        AbstractDZ dz1 = new MathDZ();
        dz1.makeDZ();
        dz1.checkDZ();
        System.out.println("Оценка по математике: " + dz1.ocenka);
        AbstractDZ dz2 = new HomeDZ();
        dz2.makeDZ();
        dz2.checkDZ();
        System.out.println("Оценка по делам по дому: " + dz2.ocenka);
    }
}