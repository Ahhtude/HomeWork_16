public interface ICodeAnalyzer {
    void analyzeClass(Class<?> clazz) throws NoSuchMethodException;
}
