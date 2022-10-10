import java.util.*;

public class Digit {
    private int number;
    private int[] pixels;
    private static double[] normalizedPixels;


    private static double sum;
    private double sigmoid;
    private int out;
    private int error;

    private List<Learning> learnings;


    public void SetNormalizedPixels() { 
        normalizedPixels = new double[pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            normalizedPixels[i] = pixels[i] / 255.0;
        }
    }

    public int GetNumber() { return this.number; }
    public int[] GetPixels() { return this.pixels; }
    public double[] GetNormalizedPixels() { return Digit.normalizedPixels; }

    public Digit(int n, int[] p){
        number = n;
        pixels = p;
    }


    public void SetFirstConfigs(double[] w, double bias){
        for (int i = 0; i < 784; i++) {
            sum += normalizedPixels[i]*w[i]+bias;
        }

        sigmoid = 1 / (1 + Math.exp(sum));

        out = CommonFunction.SetOut(sigmoid);

        error = number - out;

    }
}
