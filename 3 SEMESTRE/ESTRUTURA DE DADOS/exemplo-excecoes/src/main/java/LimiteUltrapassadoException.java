import java.time.LocalDateTime;

public class LimiteUltrapassadoException extends Exception {
    LocalDateTime data;

    public LimiteUltrapassadoException (String s) {
        super(s);
        data = LocalDateTime.now();
    }
}
