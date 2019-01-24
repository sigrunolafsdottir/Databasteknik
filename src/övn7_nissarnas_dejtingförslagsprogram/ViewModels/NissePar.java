package övn7_nissarnas_dejtingförslagsprogram.ViewModels;


public class NissePar {
    
    private Nisse nisse1;
    private Nisse nisse2;
            
    public NissePar (Nisse nisse1, Nisse nisse2){
        this.nisse1 = nisse1;
        this.nisse2 = nisse2;
    }
    
    public void printPar(){
        System.out.println( nisse1.getPartyAlias() + " " + nisse2.getPartyAlias());
    }
}
