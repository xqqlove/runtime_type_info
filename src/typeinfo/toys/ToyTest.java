package typeinfo.toys;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
    Toy(){}
    Toy(int i){}
    public void display(){
        System.out.println("upup");
    }
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
/**
 * 初始化有效地实现了尽可能的“惰性”，从对 initable 引用的创建中可以看到，仅使用 .class 语法来获得对类对象的引用不会引发初始化。但与此相反，使用 Class.forName() 来产生 Class 引用会立即就进行初始化，如 initable3。
 *
 * 如果一个 static final 值是“编译期常量”（如 Initable.staticFinal），那么这个值不需要对 Initable 类进行初始化就可以被读取。但是，如果只是将一个字段设置成为 static 和 final，还不足以确保这种行为。例如，对 Initable.staticFinal2 的访问将强制进行类的初始化，因为它不是一个编译期常量。
 *
 * 如果一个 static 字段不是 final 的，那么在对它访问时，总是要求在它被读取之前，要先进行链接（为这个字段分配存储空间）和初始化（初始化该存储空间），就像在对 Initable2.staticNonFinal 的访问中所看到的那样。
 */