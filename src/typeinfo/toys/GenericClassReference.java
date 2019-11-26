package typeinfo.toys;

class Shape{}
class Cicle extends Shape{}

public class GenericClassReference {
    public static void main(String[] args) {
        Cicle c=new Cicle();
        Shape s=new Shape();
        if (c instanceof Shape){
            System.out.println("是");
        }else {
            System.out.println("否");
        }

       Class<FancyToy> ftClass=FancyToy.class;
        try {
            FancyToy fancyToy=ftClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Class<? super FancyToy> up=ftClass.getSuperclass();
        try {
            Object obj=up.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
