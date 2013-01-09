package jos.api;

public class Pointer<T> {
    private T value;
    
    public T dereference() {
        return value;
    }
    
    public void assign(T value) {
        this.value = value;
    }
}
