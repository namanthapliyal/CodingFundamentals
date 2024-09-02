public class Handler5  extends  ATMHandler{
    public Handler5(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=5){
            while(amount>=5) {
                amount -= 5;
                c += 1;
            }
        }
        System.out.println("Total 5rs notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        if(super.nextHandler==null){
            System.out.println("Next handler needed.");
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
