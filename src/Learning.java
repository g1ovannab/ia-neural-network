public class Learning {
    private double sum;
    private double sigmoid;
    private int out;
    private int error;


    private double[] previousW;
    private double previousBias;
    private double[] newW;
    private double newBias;

    private int era;

    public int GetEra() { return this.era; }

    public Learning(int e){
        era = e;
        newW = new double[784];
    }

    public void SetConfigs(double[] w, double bias, Digit digit, double rate){
        previousW = w;
        previousBias = bias;
        
        double[] pixels = digit.GetNormalizedPixels();
        for (int i = 0; i < pixels.length; i++) {
            sum += pixels[i]*previousW[i]+previousBias;
        }
        sigmoid = 1 / (1 + Math.exp(sum));
        out = CommonFunction.SetOut(sigmoid);
        error = digit.GetNumber() - out;

        for (int i = 0; i < newW.length; i++) {
            newW[i] = previousW[i] + error * rate * pixels[i];
        }

        newBias = previousBias + error * rate;
    }
}
