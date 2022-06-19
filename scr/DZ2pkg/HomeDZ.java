package DZ2pkg;

public class HomeDZ extends AbstractDZ{
    @Override
    public void makeDZ(){
        System.out.println("Делаю домашку по математике");

    }

    @Override
    public void checkDZ(){
        this.score = 110;
        this.check();
        System.out.println("Домашние дела делать труднее");
        System.out.println(this.ocenka);
    }

    public void washFloor(){
        System.out.println("Мою полы");
    }

    public void washDishes(){
        System.out.println("Мою посуду");
    }

    public HomeDZ (){
        this.washDishes();
        this.washFloor();
    }
}
