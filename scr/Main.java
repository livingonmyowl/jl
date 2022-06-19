class Stack1 {
    int first;
    Stack1 second = null;
    int counter = 0;
    int temp;
    public void push (int _toPush) {
        if (this.counter==2){
            this.second.push(_toPush);
        }
        if (this.counter==1){
            this.counter+=1;
            this.second = new Stack1(_toPush);
        }
        if (this.counter==0){
            this.counter+=1;
            this.first=_toPush;
        }


    }
    public int pop () {
        if (this.counter==1) {
            this.counter-=1;
            temp = this.first;
        }
        if (this.counter==2) {
            temp = this.second.pop();
            if (this.second.counter==0) {
                this.counter-=1;
            }
        }
        return temp;
    }

    public void show (){
        if (this.counter==0){
            //System.out.println("Стэк пустой");
        }
        if (this.counter==1){
            System.out.println(this.first);
        }
        if (this.counter==2){
            System.out.println(this.first);
            this.second.show();
        }

    }
    public Stack1 (int _x) {
        this.counter=0;
        this.push(_x);
    }
}

public class Main {
    static int temp2;
    public static void main(String[] args) {
        System.out.println("Создаём стек, пихаем 1");
        Stack1 ss = new Stack1(1);
        System.out.println("Пихаем 2");
        ss.push(2);
        ss.show();
        System.out.println("Пушим 3");
        ss.push(3);
        ss.show();
        System.out.println("Попаем");
        temp2=ss.pop();
        System.out.println(temp2);
        System.out.println("Что осталось:");
        ss.show();
        System.out.println("Хитрые манипуляции: +3+2-+1+7--+5");
        ss.push(3);
        ss.push(2);
        ss.pop();
        ss.push(1);
        ss.push(7);
        ss.pop();
        ss.pop();
        ss.push(5);
        ss.show();
    }
}