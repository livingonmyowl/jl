package DZ1pkg;

public class StackA<T> {

    private Object[] stack;
    private int pos;
    public static int stackCntr;

    public int stackLength;
    public StackA() {
        stackCntr++;
        stack = new Object[0];
        pos = 0;
        stackLength = stack.length;
        System.out.println("Создали пустой стек");
    }

    public void push(T element){
        stackCntr++;
        if (pos == stackLength){
            Object[] newStack = new Object[stackLength+10];
            System.arraycopy(stack, 0, newStack, 0, stackLength);
            System.out.println("↑↑ Увеличили размер стека на 10");
            stack = newStack;
            stackLength+=10;
        }
        stack[pos] = element;
        System.out.println("+ Добавили в стек размером "+stack.length+": ["+element.toString()+"] типа <"+element.getClass()+">");
        pos++;

    }

    public T pop(){
        stackCntr++;
        if (pos==0){
            System.out.println("☠ Попытались достать из пустого стека");
            return null;
        }
        T popElement = (T) stack[pos-1];
        stack[pos-1] = null;
        pos--;
        System.out.println("- Доcтали из стека размером "+stackLength+": ["+popElement.toString()+"] типа <"+popElement.getClass()+">");
        if (stackLength-pos==10){
            Object[] newStack = new Object[stackLength-10];
            System.arraycopy(stack, 0, newStack, 0, stackLength-10);
            stack = newStack;
            System.out.println("↓↓ Уменьшили размер стека на 10");
            stackLength-=10;
        }
        return popElement;
    }

    public static void PrintCnt(){
        stackCntr++;
        System.out.println("\uD83D\uDEC8 Кол-во обращений к классу: "+stackCntr+" (доступ из статического метода)");
    }


}
