public class Handler5h extends ATMHandler{
    public Handler5h(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=500){
            while(amount>=500) {
                amount -= 500;
                c += 1;
            }
        }
        System.out.println("Total 5h notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
