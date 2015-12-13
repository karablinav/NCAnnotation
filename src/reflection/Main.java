package reflection;

public class Main {
    public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalArgumentException, IllegalAccessException {
/*        SomeBean sb = (new Injector().inject(new SomeBean()));
        sb.doSome();
*/

        Injector injector = new Injector();
        Object sb = injector.injector(new SomeBean());
    }
}
