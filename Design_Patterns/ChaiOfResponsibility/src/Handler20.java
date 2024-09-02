public class Handler20 extends ATMHandler {
    public Handler20(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=20){
            while(amount>=20) {
                amount -= 20;
                c += 1;
            }
        }
        System.out.println("Total 20rs notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
