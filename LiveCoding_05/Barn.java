enum Præferencer {
    ELSKER,
    GLAD,
    LIGEGLAD,
    HADER
}

public class Barn {
    private Præferencer præferencer;
    
    public Barn() {
        præferencer = Præferencer.LIGEGLAD;
    }
    
    public void smag(Mad mad) {
        if(mad.getGrøntsager() && mad.getVindStyrke() < 3) {
            præferencer = Præferencer.GLAD;
        } else if (mad.getVandInhold() > 70) {
            præferencer = Præferencer.ELSKER;
        } else {
            præferencer = Præferencer.HADER;
        }
        
        System.out.println(præferencer);
    }
    
    static void test0() {
        System.out.println(Præferencer.GLAD);
    }
    
    public Præferencer getPræferencer() {
        return præferencer;
    }
}