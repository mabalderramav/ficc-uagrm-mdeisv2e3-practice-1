package bo.edu.uagrm.soe.webdrivers;

/**
 * Functional interface to get values.
 *
 * @param <T> as generic type.
 */
public interface StrategyGetter<T> {
    /**
     * Performs step and return generic value.
     *
     * @return generic type.
     */
    T performStep();
}
