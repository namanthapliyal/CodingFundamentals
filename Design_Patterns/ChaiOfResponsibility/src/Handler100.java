public class Handler100 extends ATMHandler{
    public Handler100(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        if(amount==0){
            return 0;
        }
        int c=0;
        if(amount>=100){
            while(amount>=100) {
                amount -= 100;
                c += 1;
            }
        }
        System.out.println("Total 100rs notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
