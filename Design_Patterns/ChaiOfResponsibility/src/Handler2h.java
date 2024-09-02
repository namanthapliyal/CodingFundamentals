public class Handler2h extends ATMHandler{
    public Handler2h(ATMHandler nextHandler){
        super(nextHandler);
    }

    public int notesDispenser(int amount){
        int c=0;
        if(amount>=200){
            while(amount>=200) {
                amount -= 200;
                c += 1;
            }
        }
        System.out.println("Total 2h notes dispensed: "+ c);
        if(amount<=0){
            return 0;
        }
        return super.nextHandler.notesDispenser(amount);
    }
}
