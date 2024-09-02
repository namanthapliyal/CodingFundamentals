public class Handler10  extends  ATMHandler{
    public Handler10(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=10){
            while(amount>=10) {
                amount -= 10;
                c += 1;
            }
        }
        System.out.println("Total 10rs notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
