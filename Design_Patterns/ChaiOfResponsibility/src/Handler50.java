public class Handler50 extends ATMHandler{
    public Handler50(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=50){
            while(amount>=50) {
                amount -= 50;
                c += 1;
            }
        }
        System.out.println("Total 50rs notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
