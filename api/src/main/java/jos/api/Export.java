package jos.api;

public @interface Export {

    String selector() default "";
    
    StorageSemantic semantic() default StorageSemantic.NONE;
}
