public class Main {
    public static void main(String[] args) {
        ATMHandler h = new Handler2k(new Handler5h(new Handler2h(new Handler1h(new Handler100(new Handler50(new Handler20(new Handler10(new Handler5(null)))))))));
        h.notesDispenser(12616);
    }
}
