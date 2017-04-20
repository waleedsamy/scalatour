package io.github.waleedsamy.scalatour;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Annotations {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SourceURL {
        public String url();

        public String mail();
    }


    @SourceURL(mail = "mail@example.com", url = "example.com")
    class Test {
        private String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {

        for (Annotation annotation : Test.class.getAnnotations()) {
            Class<? extends Annotation> type = annotation.annotationType();
            System.out.println("Values of " + type.getName());

            for (Method method : type.getDeclaredMethods()) {
                Object value = method.invoke(annotation, (Object[]) null);
                System.out.println(" " + method.getName() + ": " + value);
            }
        }
    }
}
