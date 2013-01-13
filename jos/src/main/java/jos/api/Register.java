package jos.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface Register {

    String name() default "";

    boolean isWrapper() default false;
}
