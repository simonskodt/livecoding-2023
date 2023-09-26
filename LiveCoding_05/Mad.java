import java.util.*;

public class Mad {
    private String navn;
    private double pris;
    private boolean grøntsager;
    private boolean kød;
    private int vindStyrke, vandIndhold;
    private List<String> allergener;
    
    public Mad(String navn, double pris, boolean grøntsager,
               boolean kød, int vindStyrke, int vandIndhold) {
        this.navn = navn;
        this.pris = pris;
        this.grøntsager = grøntsager;
        this.kød = kød;
        this.vindStyrke = vindStyrke;
        this.vandIndhold = vandIndhold;
        this.allergener = new ArrayList<>();
    }
    
    public String getNavn() {
        return navn;
    }
    
    public double getPris() {
        return pris;
    }
    
    public boolean getGrøntsager() {
        return grøntsager;
    }
    
    public boolean getKød() {
        return kød;
    }
    
    public int getVindStyrke() {
        return vindStyrke;
    }
    
    public int getVandInhold() {
        return vandIndhold;
    }
}