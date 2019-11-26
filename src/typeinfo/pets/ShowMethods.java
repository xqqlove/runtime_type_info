package typeinfo.pets;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage:n" +
            "ShowMethods qualified.class.namen" +
            "To show all methods in class or:n" +
            "ShowMethods qualified.class.name wordn" +
            "To search for methods involving 'word'";
//    private static Pattern p = Pattern.compile("\w+\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(args);
            System.out.println(usage);
            System.exit(1);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(method.toString());
                }
                for (Constructor ct : ctors) {
                    System.out.println(ct);
                }
                lines=methods.length+ctors.length;
            }else {
                for (Method method : methods) {
                    if (method.toString().contains(args[1])) {
                        System.out.println(method.toString());
                        lines++;
                    }
                }
                for (Constructor ct : ctors) {
                    if (ct.toString().contains(args[1])) {
                        System.out.println(ct);
                        lines++;
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("not such class: " + e);
        }
    }
}
