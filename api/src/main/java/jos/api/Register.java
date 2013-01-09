package jos.api;

public @interface Register {
    
    String name() default "";
    
    boolean isWrapper() default false;
}
