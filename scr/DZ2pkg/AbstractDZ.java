package DZ2pkg;

public abstract class AbstractDZ {
    public int dayToDo;
    public int score;
    public int ocenka;
    public abstract void makeDZ();
    public abstract void checkDZ();
    public void check()
    {
        ocenka = checkScore();
    }

    private int checkScore(){
        if (score > 100){
            return 5;
        }
        else {return 2;}
    }
}
