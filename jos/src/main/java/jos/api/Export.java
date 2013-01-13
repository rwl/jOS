package jos.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface Export {

    String selector() default "";

    StorageSemantic semantic() default StorageSemantic.NONE;
}
