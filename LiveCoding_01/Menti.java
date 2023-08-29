class Menti{
    static double number;

    public static void main(String[] args){
        System.out.println("Hello World");
    }

    static void isFunny(){
        int num = (4 + 3 * 2);
        boolean isFunny = num == 12;   
        
        if (isFunny) {
            System.out.println("I'm fun");
        } else {
            System.out.println("I'm John");
        }    
    }

    static void lastPrint(){
        int j = 10;
        int i = 0;

        for (i = j; i <= 20; i = i + 4){
            System.out.println(i);
        }
    }

    static void sum(){
        int sum = 0;
        int i = 0;

        while (i < 7){
            sum = sum + i;
            i = i + 2;
        }

        System.out.println(sum);
    }
}