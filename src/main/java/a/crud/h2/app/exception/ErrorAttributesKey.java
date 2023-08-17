package a.crud.h2.app.exception;

public enum ErrorAttributesKey {
    CODE("code"),
    MESSAGE("message"),
    TIME("timestamp");

    private final String key;

    ErrorAttributesKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
