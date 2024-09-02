public class ATMHandler {
    ATMHandler nextHandler;

    ATMHandler(ATMHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public int notesDispenser(int amount){
        if(amount==0){
            return 0;
        }
        return this.nextHandler.notesDispenser(amount);
    }
}
