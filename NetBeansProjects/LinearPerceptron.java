package linearperceptron;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author ysj13kxu
 */
public class LinearPerceptron implements Classifier{
    Random r = new Random(10);
    int lr = 1;
    double[] w = {1,1};
    public static void main(String[] args) throws Exception {
        Instances read = null;
        String str = "U:\\Documents\\abalone-train.arff";
        FileReader r;
        try 
        {
            r = new FileReader(str);
            read = new Instances(r);
            read.setClassIndex(read.numAttributes()-1);
        } catch (IOException e) 
        {
            System.out.println("ERROR: Exception: " + e);
        }
        LinearPerceptron p = new LinearPerceptron();
        p.buildClassifier(read);
    }

    @Override
    public void buildClassifier(Instances i) throws Exception 
    {
        do
        {
            for(int a=0;a<i.size();a++)
            {
                Instance b = i.get(a);
                double d=0;
                for(int c = 0; c < b.numAttributes()-1; c++)
                {
                    d = d + w[c]*b.value(c);
                }
                int f = classify(d);
                
                //weight alteration
                for(int e = 0; e < w.length ; e++)
                {
                    w[e] = w[e]+(0.5*(b.value(b.numAttributes())-f))*b.value(e);
                }
                
            }
        }
        while(true);

    }

    public int classify(double a)
    {
        
        if(a > 0)
        {
            return 1;
        }
        else 
        {
            return 0;
        }
    }
        
    
    @Override
    public double classifyInstance(Instance instnc) throws Exception {
        return 0;
    }

    @Override
    public double[] distributionForInstance(Instance instnc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Capabilities getCapabilities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
