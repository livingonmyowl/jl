package DZ2pkg;

public class Polimorf {
    static private final int[] N = {1,2,5};
    static protected int sum;
    static {
        sum = N[0]+N[2]-N[1];
    }

    public Polimorf (){
        int itog = sum;
        System.out.println("0 аргументов, итог: "+itog);
    }
    public Polimorf (int n1){
        int itog = sum * N[0] + n1;
        System.out.println("1 аргумент, итог: "+itog);
    }
    public Polimorf (int n1, int n2){
        int itog = sum * N[0] + n1 + N[1]*n2;
        System.out.println("2 аргумента, итог: "+itog);
    }
    public Polimorf (int n1, int n2, int n3){
        int itog = sum * N[0]*n1 + N[1]*2*n2 + N[2] - n3;
        System.out.println("3 аргумента, итог: "+itog);
    }
}
