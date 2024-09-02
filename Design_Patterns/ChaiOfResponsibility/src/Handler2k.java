public class Handler2k extends ATMHandler{
    public Handler2k(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=2000){
            while(amount>=2000) {
                amount -= 2000;
                c += 1;
            }
        }
        System.out.println("Total 2k notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
