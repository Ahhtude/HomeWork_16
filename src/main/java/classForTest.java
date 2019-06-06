import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class classForTest implements ICodeAnalyzer {

    public void analyzeClass(Class<?> clazz) throws NoSuchMethodException {
        //Initials for parts of class
        Method[] methods = clazz.getClass().getMethods();
        Field[] fields = clazz.getDeclaredFields();
        Constructor[] constructors = clazz.getConstructors();

        Annotation[] classAnnotations = clazz.getAnnotations();

        //Block for checking class
        for (Annotation annotation : classAnnotations) {
            if (annotation.annotationType()==Analyzable.class){
                System.out.println("Class name with annotation - " + clazz.getName());
                for (Annotation an : classAnnotations) System.out.println("Annotation name from class - " + an.toString());
            }
        }

        //Block for checking fields
        for (Field field : fields) {
            classAnnotations = field.getAnnotations();
            for (Annotation annotation : classAnnotations){
                if (annotation.annotationType()==Analyzable.class){
                    System.out.println("Field name with annotation - " + field.getName());
                    for (Annotation ann : classAnnotations) System.out.println("Annotation name from field - " + ann.toString());
                }
            }
        }

        //Block for checking constructors
        for (Constructor constructor : constructors){
            classAnnotations = constructor.getAnnotations();
            for (Annotation annotation : classAnnotations){
                if (annotation.annotationType()==Analyzable.class){
                    System.out.println("Constructor name with annotation - " + constructor.getName());
                    for (Annotation ann : classAnnotations){
                        System.out.println("Annotation name from constructor - " + ann.toString());
                    }
                }
            }
        }

        //Block for checking methods
        for (Method method : methods){
            classAnnotations = method.getAnnotations();
            for (Annotation annotation : classAnnotations){
                if (annotation.annotationType()==Analyzable.class){
                    System.out.println("Method name with annotation - " + method.getName());
                    for (Annotation ann : classAnnotations){
                        System.out.println("Annotation name from method - " + ann.toString());
                    }
                }
            }
        }

    }





    public static void main(String[] args) throws NoSuchMethodException {

        classForTest test = new classForTest();

        testData testDataaa = new testData();

        test.analyzeClass(testDataaa.getClass());

    }
}
