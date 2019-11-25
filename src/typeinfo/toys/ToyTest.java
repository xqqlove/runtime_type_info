package typeinfo.toys;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){super(1);}
}
public class ToyTest {
    static void printinfo(Class cc){
        System.out.println("Class name: "+cc.getName()+" is interface? ["+cc.isInterface()+"]");
        System.out.println("simple name: "+cc.getSimpleName());
        System.out.println("Canonical name: "+cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c=null;
        try {
            c=Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can not find FancyToy");
            System.exit(1);
        }
        printinfo(c);
        for(Class face:c.getInterfaces()){
            printinfo(face);
        }
        System.out.println("=================================");
        Class up=c.getSuperclass();
        printinfo(up);

        Object obj=null;
        try {
            obj=up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("can not instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("can not access");
            System.exit(1);
        }
        printinfo(obj.getClass());
    }
}
