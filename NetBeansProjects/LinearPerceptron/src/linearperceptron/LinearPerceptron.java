package linearperceptron;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.functions.SMO;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.supervised.instance.Resample;

/**
 *
 * @author ysj13kxu
 */
public class LinearPerceptron implements Classifier{


    Random r = new Random(10);
    double lr = 1;
    double[] w;
    double[] wOff;
    
    double means[];
    double sd[]={};
    double totals= 0;
    double temp = 0;
    double sum = 0;
    double deviation = 0;
    double updateWeight[];
    int [] attInd;
    
    int folds = 10;
    
    boolean standardizeflag = false;
    boolean offFlag = true;
    boolean modelSelection = true;
    boolean OffFlagMS;
    
    int maxiterations = 0;
    double bias = 0;
    int notconvergingval = 1000000;
    
    double errorcount;
    static Logistic M = new Logistic();
    static SMO smo = new SMO();
  
    
    
    public static void main(String[] args) throws Exception {
        Instances read = null;
        Instances other = null;
        String str = "U:\\Documents\\tests\\letter.arff";
        FileReader r;
        try 
        {
            r = new FileReader(str);
            read = new Instances(r);
            other = read;
            read.setClassIndex(read.numAttributes()-1);
            other.setClassIndex(read.numAttributes()-1);
        } 
        catch (IOException e) 
        {
            System.out.println(" Exception caught =" + e);
        }
        LinearPerceptron p = new LinearPerceptron();
        

        //offline
        System.out.println("\n\n\n-----OFFLINE-----");
        p.standardizeflag = false;
        p.offFlag = true;
        p.modelSelection = false;
        long start = System.currentTimeMillis();
        p.buildClassifier(read);
        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println("Accuracy: " + p.getAccuracy(read) + 
                " Time Taken: "+ timeTaken);
        
        
        //online
        System.out.println("\n\n\n-----ONLINE-----");
        p.standardizeflag = false;
        p.offFlag = false;
        p.modelSelection = false;
        long start2 = System.currentTimeMillis();
        p.buildClassifier(read);
        long end2 = System.currentTimeMillis();
        long timeTaken2 = end2 - start2;
        System.out.println("Accuracy: " + p.getAccuracy(read) + 
                " Time Taken: "+ timeTaken2);
        
        
        //standardized offline
        System.out.println("\n\n\n-----STD OFFLINE-----");
        p.standardizeflag = true;
        p.offFlag = true;
        p.modelSelection = false;
        long start3 = System.currentTimeMillis();
        p.buildClassifier(read);
        long end3 = System.currentTimeMillis();
        long timeTaken3 = end3 - start3;
        System.out.println("Accuracy: " + p.getAccuracy(read) + " "
                + "Time Taken: "+ timeTaken3);
        
        
        //standardized online
        System.out.println("\n\n\n-----STD ONLINE-----");
        p.standardizeflag = true;
        p.offFlag = false;
        p.modelSelection = false;
        long start4 = System.currentTimeMillis();
        p.buildClassifier(read);
        long end4 = System.currentTimeMillis();
        long timeTaken4 = end4 - start4;
        System.out.println("Accuracy: " + p.getAccuracy(read) + " "
                + "Time Taken: "+ timeTaken4);
        
        
        //Model Selection
        System.out.println("\n\n\n-----MODEL SELECTION-----");
        p.standardizeflag = false;
        p.offFlag = false;
        p.modelSelection = true;
        long start5 = System.currentTimeMillis();
        p.buildClassifier(read);
        long end5 = System.currentTimeMillis();
        long timeTaken5 = end5 - start5;
        System.out.println("Accuracy: " + p.getAccuracy(read) + " "
                + "Time Taken: "+ timeTaken5);
        
        //standardized Model Selection
        System.out.println("\n\n\n-----STD MODEL SELECTION-----");
        p.standardizeflag = true;
        p.offFlag = false;
        p.modelSelection = true;
        long start6 = System.currentTimeMillis();
        p.buildClassifier(read);
        long end6 = System.currentTimeMillis();
        long timeTaken6 = end6 - start6;
        System.out.println("Accuracy: " + p.getAccuracy(read) + 
                " Time Taken: "+ timeTaken6);


        System.out.println("\n\n\n-----Logistic-----");
        long start8 = System.currentTimeMillis();
        M.buildClassifier(other);
        long end8 = System.currentTimeMillis();
        long timeTaken8 = end8 - start8;
        getAccuracyWeka(M,read);
        System.out.println("Time Taken: "+ timeTaken8);

        System.out.println("\n\n\n-----SMO-----");
        long start9 = System.currentTimeMillis();
        smo.buildClassifier(read);
        long end9 = System.currentTimeMillis();
        long timeTaken9 = end9 - start9;
        getAccuracyWeka(smo,read);
        System.out.println("Time Taken: "+ timeTaken9);
                    Resample resampler = new Resample();
                    resampler.setNoReplacement(true);
                    resampler.setSampleSizePercent(20);
                       
                    double [] Resampled = new double [3];
                    Resample re = new Resample();
                    re.setInputFormat(read);
                    re.setSampleSizePercent(20);
                    re.setNoReplacement(true);
                    Random ran = new Random();
                    
            ArrayList<Double> forHoldingAccuracyLog = new ArrayList();
            ArrayList<Double> forHoldingAccuracySmo= new ArrayList();

            for ( int instancesRes = 0 ; instancesRes < 3;
                    instancesRes++){
                read.randomize(ran);
                read.resample(ran);


                Logistic log = new Logistic();
                log.buildClassifier(read);
                SMO smo = new SMO();
                smo.buildClassifier(read);
                forHoldingAccuracyLog.add(getAccuracyWeka(log, read));
                forHoldingAccuracySmo.add(getAccuracyWeka(smo, read));
                    
                    
ArrayList<Double> forHoldingAccuracyRand = new ArrayList();
                    
for (int res = 0 ; res < 3;res++)
{
    read.randomize(ran);
    read.resample(ran);

    RandomLinearPerceptron forLoop = new RandomLinearPerceptron();
    forLoop.buildClassifier(read);
    forHoldingAccuracyRand.add(forLoop.getHowAccurate(read));
}
int total = 0;
for (int meaningAccuracy = 0;meaningAccuracy < 
        forHoldingAccuracyRand.size();
        meaningAccuracy++){
    total += forHoldingAccuracyRand.get(meaningAccuracy);
}
double accuracyMeanRand = total / forHoldingAccuracyRand.size();
total = 0;
Resampled[0] = accuracyMeanRand;

double toto = 0;
for(int f=0;f<forHoldingAccuracyLog.size();f++)
{
    toto = toto + forHoldingAccuracyLog.get(f);
}
System.out.println("logistic:" + (double)toto/forHoldingAccuracyLog.
        size());

double totwo = 0;
for(int f=0;f<forHoldingAccuracySmo.size();f++)
{
    totwo = totwo + forHoldingAccuracySmo.get(f);
}
System.out.println("smo:" + (double)totwo/forHoldingAccuracySmo.size());
double towtwo = 0;
for(int f=0;f<forHoldingAccuracyRand.size();f++)
{
    towtwo = towtwo + forHoldingAccuracyRand.get(f);
}
System.out.println("random:" + (double)towtwo/forHoldingAccuracyRand.
        size());
System.out.println("\n\n\n-----ENSEMBLE-----");
RandomLinearPerceptron rlp = new RandomLinearPerceptron();
long start7 = System.currentTimeMillis();
rlp.buildClassifier(read);
long end7 = System.currentTimeMillis();
long timeTaken7 = end7 - start7;
System.out.println("Accuracy: " + p.getAccuracy(read)+ " Time Taken: "
        + timeTaken7);
        


            }
       
    
}

public static double getAccuracyWeka(Logistic M,Instances I) throws 
        Exception 
{
    double predicts = 0;
    for(int a = 0; a < I.size(); a++)
    {
        double e = M.classifyInstance(I.get(a));
        double f = I.get(a).classValue();
        if (e == f)
        {
            predicts++;
        }
    }

    return (predicts/I.size())*100;

}
    
    public static double getAccuracyWeka(SMO M,Instances I) throws 
            Exception 
    {
        double predicts = 0;
        for(int a = 0; a < I.size(); a++)
        {
            double e = M.classifyInstance(I.get(a));
            if (e == I.get(a).classValue())
            {
                predicts++;
            }
        }
        return (predicts/I.size())*100;
    }

    @Override
    public void buildClassifier(Instances i) throws Exception {
            i.setClassIndex(i.numAttributes()-1);
            Instances ifstd = i;
            
            
            //create all weights to 1
            w = new double[i.numAttributes()-1];
            wOff = new double[i.numAttributes()-1];
            updateWeight = new double[i.numAttributes()-1];
            
            for(int r=0;r<i.numAttributes()-1;r++)
            {
                w[r]=1;
                wOff[r]=1;
                updateWeight[r]=0;
            }
            
            
            //standardized
            if(standardizeflag)
            {
                meansStddev(ifstd);
                for(int g = 0; g < ifstd.numAttributes()-1;g++)
                {
                    for(int h = 0; h < ifstd.size(); h++) 
                    {
                        double start = ifstd.instance(h).value(g);
                        double finish = (start-means[g])/sd[g];
                        ifstd.instance(h).setValue(g, finish);
                    }
                    
                }
            }
            
            
            
            if(modelSelection)
            {
                
                double totalerrorsofartoaddON = 0;
                double totalerrorsofartoaddOFF = 0;
                double predictions = 0;
                //need to hold all error rates
                double[] allpredictsInaFoldON = new double[folds];
                double[] allpredictsInaFoldOFF = new double[folds];
                
                
                for (int n = 0; n < folds; n++) 
                {
                //need to train the train values through off and online
                    OffFlagMS = false;
                    Instances train = ifstd.trainCV(folds, n);
                    Instances test = ifstd.testCV(folds, n);
                    
                //online
                    predictions = 0;
                    maxiterations = 0;
                    do
                    {
                        maxiterations = 0;
                        for(int a=0;a<train.size();a++)
                        {
                            Instance b = train.get(a);
                            changeclassvalueforMinus1value(b);
                            double d=0;
                            for(int c = 0; c < b.numAttributes()-1; c++)
                            {
                                d = d + w[c]*b.value(c);
                            }
                            int f = classify(d);
                            if(f != b.classValue())
                            {
                                for(int e = 0; e < w.length; e++)
                                {
                                    w[e] = w[e]+bias+(0.5*lr*(
                                            b.classValue()-f))*b.value(e);
                                    maxiterations = 0;
                                }
                                
                            }
                            else
                            {
                                maxiterations++;
                            }                         
                        }
                        notconvergingval--;
                    }
                    while(Stopping(train.size())||notconvergingval<0);
                    //test part on ONLINE
                    for (int y = 0; y < test.size();y++)
                    {
                        Instance current = test.get(y);
                        double result = classifyInstance(current);
                        if(result == current.classValue())
                    //if classifyInstance came out as correct
                        {
                            predictions++;
                        }
                        
                    }
    totalerrorsofartoaddON = 0;
    double predictionsoutofON = (predictions/(test.size()))*100;
    totalerrorsofartoaddON = totalerrorsofartoaddON + predictionsoutofON;
    allpredictsInaFoldON[n]=totalerrorsofartoaddON;
                    
                    

                    //offline
                    OffFlagMS = true;
                    predictions = 0;
                    for(int r=0;r<updateWeight.length;r++)
                    {  
                        updateWeight[r]=0;
                    }
                    
                    maxiterations = 0;
                    do
                    {
                        //For every weight
                        for(int u=0;u<wOff.length;u++)
                        {
                            updateWeight[u]=0;
                        }
                        maxiterations = 0;
                        for(int a=0;a<train.size();a++)
                        {
                            
                            Instance b = train.get(a);
                            changeclassvalueforMinus1value(b);
                            double d=0;
                            for(int c = 0; c < b.numAttributes()-1; c++)
                            {
                                d = d + wOff[c]*b.value(c);
                            }
                            int f = classify(d);
                            if(f != b.classValue())
                            {
                                for(int e = 0; e < updateWeight.length; 
                                        e++)
                                {
                                updateWeight[e] = updateWeight[e]+bias
                                +(0.5*lr*(b.classValue()-f))*b.value(e);
                                maxiterations = 0;
                                }
                            }
                        }
                        notconvergingval--;
                        for(int e = 0; e < wOff.length; e++)
                        {
                            wOff[e] = wOff[e]+updateWeight[e];
                            
                        }
                    }
                    while(Stopping(train.size())||notconvergingval<0);
                    
                    System.out.println("Offline done a fold.");
                    for(int r=0;r<wOff.length;r++)
                    {
                        System.out.print(wOff[r]+" | ");
                    }
                    System.out.println("\n");
                    

                    //test on OFFLINE
                    for (int y = 0; y < test.size();y++)
                    {
                        Instance current = test.get(y);
                        double result = classifyInstance(current);
                        if(result == current.classValue())

            //if classifyInstance came out as correct
                        {
                            predictions++;
                        }
                        
                        
                    }
totalerrorsofartoaddOFF = 0;
double predictionsoutofOFF = (predictions/(test.size()))*100;
totalerrorsofartoaddOFF = totalerrorsofartoaddOFF + predictionsoutofOFF;
allpredictsInaFoldOFF[n]=totalerrorsofartoaddOFF;
                
                    
                }
                
//                System.out.println("ERROR COUNT:");
//                System.out.println(errorcount);
                
                //completed each fold
                double offtotal = 0;
                double ontotal = 0;
                
                //add up error percentages
                for(int h=0; h<folds;h++)
                {                    
                    ontotal = ontotal + allpredictsInaFoldON[h];
                    offtotal = offtotal + allpredictsInaFoldOFF[h];                    
                }
                
                double ontotalfinal = (ontotal/folds);
                double offtotalfinal = (offtotal/folds);
                
                
                System.out.println("online accuracy:" + ontotalfinal);
                System.out.println("offline accuracy:" + offtotalfinal);
                //desicion
                if(ontotalfinal > offtotalfinal)
                {
                    offFlag = false;//use online rule to do all of i.

                }
                else if (ontotalfinal < offtotalfinal)
                {
                    offFlag = true;//use offline rule to do all of i.

                }
                else
                {
                    offFlag = true;
                }
                //use trainToUse to use as train
            } 
            
            
            
            
            int f=0;
            Instance b = null;
            
            //reset all weights for actual train not cross val train.
            for(int u=0;u<w.length;u++)
            {
                w[u]=1;
                wOff[u]=1;
                updateWeight[u]=0;
            }
            //do offline if flag is true else do online
            if(offFlag)
            {
                
                do
                {
                    //For every weight
                    for(int u=0;u<wOff.length;u++)
                    {
                        updateWeight[u]=0;
                    }
                    maxiterations = 0;
                    //For every instance
                    for(int a=0;a<ifstd.size();a++)
                    {
                        
                        b = ifstd.get(a);
                        changeclassvalueforMinus1value(b);
                        double d=0;
                        for(int c = 0; c < b.numAttributes()-1; c++)
                        {
                            d = d + wOff[c]*b.value(c);
                        }
                        f = classify(d);
                        if(f != b.classValue())
                        {
                            for(int e = 0; e < wOff.length; e++)
                            {                              
                                updateWeight[e] = 
                                updateWeight[e]+bias+(0.5*lr*(
                                        b.classValue()-f))*b.value(e);
                                maxiterations = 0;
                            }
                        }
                        
                    }
                    notconvergingval--;
                    for(int e = 0; e < wOff.length; e++)
                    {
                        wOff[e] = wOff[e]+updateWeight[e];
                        
                    }
                }
                while(Stopping(ifstd.size())||notconvergingval<0);
                System.out.println("OFFLINE weight:");
                for(int r=0;r<wOff.length;r++)
                {
                    System.out.print(wOff[r]+" | ");
                }
                System.out.println("\n");
            }
            else
            {
                do
                {
                    maxiterations = 0;
                    for(int a=0;a<ifstd.size();a++)
                    {
                        
                        b = ifstd.get(a);
                        changeclassvalueforMinus1value(b);
                        double d=0;
                        for(int c = 0; c < b.numAttributes()-1; c++)
                        {
                            d = d + w[c]*b.value(c);
                        }
                        f = classify(d);
                        if(f != b.classValue())
                        {
                            for(int e = 0; e < w.length; e++)
                            {
                                w[e] = w[e]+bias+(0.5*lr*(
                                        b.classValue()-f))*b.value(e);
                                maxiterations = 0;
                                
                            }
                        }
                        else
                        {
                            maxiterations++;
                        }
                        
                    }
                    notconvergingval--;
                }
                while(Stopping(ifstd.size())||notconvergingval<0);
                System.out.println("ONLINE weight:");
                for(int r=0;r<w.length;r++)
                {
                    System.out.print(w[r]+" | ");
                }
                System.out.println("\n");
            }    
    }
    
    public boolean Stopping(double accuracy, int iteration)
    {
        return accuracy == 100 || iteration == maxiterations;
    }
    public boolean Stopping(int iteration)
    {
        return iteration == maxiterations;
    }
    
    public void meansStddev(Instances i)
    {
        means = new double[i.numAttributes()-1];
        for(int g = 0;g < i.numAttributes()-1;g++)
        { 
            double mean = 0;
            for(int h = 0; h < i.size(); h++) //calculate means
            {
                mean = mean + (i.instance(h).value(g) / i.size());
            }
             //  double mean = totals/i.size();
               means[g] = mean; 
        }
        
        sd = new double[i.numAttributes()-1];
        for(int g = 0;g < i.numAttributes()-1;g++)
        {
            sum=0;
            for (int j=0; j<i.size(); j++) 
        //calculate standard deviation  
            {  
                   temp=Math.pow((i.instance(j).value(g)-means[g]),2);  
                   sum += temp;  
            }  
            double result = sum/i.size();
            deviation=Math.sqrt(result);
             
            sd[g]=deviation;
        }
    }
    
    public void changeclassvalueforMinus1value(Instance b)
    {
        if(b.value(b.numAttributes()-1) < 1)
        {
            b.setValue(b.numAttributes()-1,-1);
        }
    }

    public int classify(double a)
    {  
        //change all 0s to -1
        if(a > 0)
        {
            return 1;
        }
        else 
        {
            return -1;
        }
    }
    
    public void setAttIndexes(int [] newValue){
        attInd = newValue;
    }
    public int [] getAttIndexes(){
        return attInd;
    }
    
    @Override
    public double classifyInstance(Instance instnc) throws Exception {
        
        changeclassvalueforMinus1value(instnc);
        double d=0;
        int f = 0;
        
        //depending on off or on use that weight
        if(offFlag || OffFlagMS)
        {
            for(int c = 0; c < instnc.numAttributes()-1; c++)
            {
                d = d + wOff[c]*instnc.value(c);
            }
        }
        else
        {
            for(int c = 0; c < instnc.numAttributes()-1; c++)
            {
                d = d + w[c]*instnc.value(c);
            }
        }
               
        f = classify(d);
        return f;
    }

    public double getAccuracy(Instances i) throws Exception
    {
        //find accuracy 
        int predicts = 0;
        for(int a = 0; a < i.size(); a++)
        {
            double thinksitis = classifyInstance(i.get(a));
            double itis = i.get(a).classValue();
            if(thinksitis == itis)
            {
                predicts++;
            }
        }
        double accuracy = (double) predicts/i.size()*100;
        return accuracy;
    }

@Override
public double[] distributionForInstance(Instance instnc) throws Exception{
    throw new UnsupportedOperationException("Not supported yet.");
    //To change body of generated methods, choose Tools | Templates.
}

@Override
public Capabilities getCapabilities() {
    throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
}
    
}
