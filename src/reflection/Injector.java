package reflection;

/*
класс Injector   в котором метод инъектор, к
оторый принимает объект, залезает в его поля,
находит все поля помеченные @аннотацией определяет
их принадлежность к интерфейсам и из файла настроек
выбирает нужную реализацию интерфейса.
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector<T> {

    public T injector(T object) {
        FileInputStream fis;
        Class<?> acClass = object.getClass();
        Field[] classFields = acClass.getDeclaredFields();

        try {
            Properties properties = new Properties();
            fis = new FileInputStream("src/reflection/inj.properties");
            properties.load(fis);

            for (Field field : classFields) {
                Class cs = Class.forName(properties.getProperty(field.getType().getName().toString()));
                field.setAccessible(true);
                field.set(object,cs.newInstance());
            }


        } catch (IOException e) {
            System.err.println("File properties not exist!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    return object;
    }
}

