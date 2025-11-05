public class IllegalReleaseAttempt extends IllegalMonitorStateException {
    /**
     * Constructs an IllegalReleaseAttempt with no detail message.
     */
    public IllegalReleaseAttempt() {
        super();
    }

    /**
     * Constructs an IllegalMonitorStateException with the specified detail message.
     * @param s - The detail message.
     */
    public IllegalReleaseAttempt(String s) {
        super(s);
    }
}