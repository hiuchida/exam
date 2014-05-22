import java.lang.instrument.Instrumentation;

public class Agent {
    private static volatile Instrumentation instrumentation;
    
    public static void premain(String args, Instrumentation instr) {
        instrumentation = instr;
    }

    public static Instrumentation getInstrumentation() {
        if (instrumentation == null) {
            throw new IllegalStateException("instrumentation == not");
        }
        return instrumentation;
    }
}
