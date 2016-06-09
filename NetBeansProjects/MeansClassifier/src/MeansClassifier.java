/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.util.ArrayList;
import weka.*;
import weka.classifiers.Classifier;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;


/**
 *
 * @author ysj13kxu
 */
public class MeansClassifier implements Classifier {

    /**
     * @param args the command line arguments
     */
    public ArrayList<Double> zeros = new ArrayList();
    public ArrayList<Double> ones = new ArrayList();
    public static void main(String[] args) throws Exception 
    {
        Instances read = null;
        String str = "\\\\ueahome4\\stusci4\\ysj13kxu\\data\\Documents\\Sheet2_Train.arff";
        FileReader r;
        try 
        {
            r = new FileReader(str);
            read = new Instances(r);
            read.setClassIndex(read.numAttributes()-1);
        } catch (Exception e) 
        {
            System.out.println(" Exception caught =" + e);
        }
        MeansClassifier m = new MeansClassifier();
        m.buildClassifier(read);
    }

    @Override
    public void buildClassifier(Instances i) throws Exception {
        
        double[][] means = new double[i.numClasses()][i.numAttributes()-1];
        
        for(int j = 0; j < i.size(); j++)
        {
            if(i.instance(j).classValue() == 0)
            {
                zeros.add(i.instance(j).value(0));
            }
            if(i.instance(j).classValue() == 1)
            {
                ones.add(i.instance(j).value(0));
            }
        }
        double zero1 = 0,one1 = 0;
        for(int k = 0; k < zeros.size(); k++)
        {
            zero1 = zero1 + zeros.get(k);
        }
        for(int l = 0; l < ones.size(); l++)
        {
            one1 = one1 + ones.get(l);
        }
        System.out.println("For class 0, mean is " + (zero1/zeros.size()));
        System.out.println("For class 1, mean is " + (one1/ones.size()));
    }

    @Override
    public double classifyInstance(Instance instnc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
