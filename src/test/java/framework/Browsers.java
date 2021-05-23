package framework;

public enum Browsers {
    FIREFOX("firefox"),
    CHROME("chrome");

    public String value;

    /**
     * Constructor
     * @param valueToSet value
     */

    Browsers(final String valueToSet) {
        value = valueToSet;
    }

    /**
     * Returns string value
     * @return String value
     */
    public String toString() {
        return value;
    }
}
