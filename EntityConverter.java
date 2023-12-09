public interface EntityConverter <T extends entity>{
    String toString(T object);
    T fromString(String line);
}
