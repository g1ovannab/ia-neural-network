public class CommonFunction {
    
    public static int SetOut(double sigmoid){
        if (sigmoid > 0 && sigmoid < 0.1){
            return 0;
        } else if (sigmoid < 0.2){
            return 1;
        } else if (sigmoid < 0.3){
            return 2;
        } else if (sigmoid < 0.4){
            return 3;
        } else if (sigmoid < 0.5){
            return 4;
        } else if (sigmoid < 0.6){
            return 5;
        } else if (sigmoid < 0.7){
            return 6;
        } else if (sigmoid < 0.8){
            return 7;
        } else if (sigmoid < 0.9){
            return 8;
        } else if (sigmoid < 1){
            return 9;
        } else {
            return 0;
        }
    }
}
