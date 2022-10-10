import java.io.*;
import java.util.*;

public class NeuralNetwork {

    private static double[] initialW;
    private static double initialBias;
    private static double rate;
    private static double[] finalW;
    private static double finalBias;

    private static List<Digit> dataToTrain;

    public double[] GetInitialW(){
        return NeuralNetwork.initialW;
    }
    public double GetInitialBias(){
        return NeuralNetwork.initialBias;
    }
    public double GetRate(){
        return NeuralNetwork.rate;
    }
    public double[] GetFinalW(){
        return NeuralNetwork.finalW;
    }
    public double GetFinalBias(){
        return NeuralNetwork.finalBias;
    }

    public NeuralNetwork(String path) throws FileNotFoundException, IOException{
        initialW = new double[784];
        for (int i = 0; i < initialW.length; i++) {
            initialW[i] = Math.random();
        }
        initialBias = Math.random();

        rate = 0.2;

        SetNormalizedData(path);

        Train();
    }

    public static void SetNormalizedData(String path) throws FileNotFoundException, IOException{
        List<Digit> data = new ArrayList<Digit>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Integer algaritm = Integer.parseInt(values[0]);
                int[] pixels = new int[values.length - 1];
                for(int i = 0; i < values.length - 1; i++) pixels[i] = Integer.parseInt(values[i + 1]);

                data.add(new Digit(algaritm, pixels));
            }
        }

        dataToTrain = data;
    }

    public static void Train(){
        for (int i = 0; i < dataToTrain.size(); i++) {
            Digit digit = dataToTrain.get(i);

            digit.SetNormalizedPixels();

            digit.SetFirstConfigs(initialW, initialBias);
        }

        for (int i = 1; i <= 10; i++) {

            for (int j = 0; j < dataToTrain.size(); j++) {
                Learning learning = new Learning(i);
                
                if (learning.GetEra() == 1){
                    learning.SetConfigs(initialW, initialBias, dataToTrain.get(j), rate);
                }
                

            }


            
        }
        
    }
}
