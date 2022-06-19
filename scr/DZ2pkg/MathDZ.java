package DZ2pkg;

public class MathDZ extends AbstractDZ{
    @Override
    public void makeDZ(){
        System.out.println("Делаю домашку по математике");

    }

    @Override
    public void checkDZ(){
        this.score = 95;
        this.check();
        System.out.println(this.ocenka);
    }

}
