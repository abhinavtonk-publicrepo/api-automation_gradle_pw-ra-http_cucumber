package framework.interfaces;

public interface IAssertion {
    void assertTrue(boolean expr);
    void assertFalse(boolean expr);
    void assertTrue(String expected, String actual);
}
