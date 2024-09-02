public class Handler1h extends ATMHandler{
    public Handler1h(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=100){
            while(amount>=100) {
                amount -= 100;
                c += 1;
            }
        }
        System.out.println("Total 1h notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
