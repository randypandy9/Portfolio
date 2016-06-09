package linearperceptron;

import java.util.ArrayList;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
/**
 *
 * @author ysj13kxu
 */
public class RandomLinearPerceptron implements Classifier{
    public LinearPerceptron [] ensemble = new LinearPerceptron [500];
    
    int [] attindx;
    @Override
    public void buildClassifier(Instances i) throws Exception {
        //find the size of random attribute set
        int sqrsizeAtts = (int) Math.round(Math.sqrt(i.numAttributes()));
        attindx = new int [sqrsizeAtts];
        //Create a blank attribute array
        ArrayList<Attribute> aList = new ArrayList<>();
            for (int l = 0; l < i.numAttributes();l++){
                Attribute tempatt = new Attribute(Integer.toString(l));
                aList.add(tempatt);
            }
        //create the ensemble full of LiearPerceptrons
        for (int s = 0; s < ensemble.length ;s++){
            LinearPerceptron tempatt = new LinearPerceptron();
            ensemble[s] = tempatt;
        }
        //Go through the ensemble
        Random random = new Random();
        for (int t = 0 ; t < ensemble.length;t++){
             attindx = new int [sqrsizeAtts];

            //create a blank instance
            Instances anotherInst = new Instances 
            ("hold",aList,i.numAttributes());
            for (int instance = 0; instance < i.numInstances();
                    instance++){
                anotherInst.add(i.get(instance));
            }
                
                int chosen = 0;
                int currAtt = 0;
                boolean inside = true;
                //fill the attribute set withvalues
                for(int w = 0 ; w < sqrsizeAtts; w++){
                    currAtt = i.numAttributes()-1;
                    inside = false;
                    int inVal = 0;
                    while(!inside){
                        inside = true;
                        chosen = random.nextInt(currAtt);
                        for (int R = 0; R < attindx.length;R++){
                            if (attindx[R] == chosen){
                                inside = false;
                            }
                        }
                        if (inside){
                            inVal = chosen;
                        }
                    }
                    attindx[w] = chosen;  
                }
                boolean done = true;
                while(done == true){
                    done = false;
                    for (int c = 0;c <attindx.length-1;c++){
                        if (attindx[c] > attindx[c+1]){
                            int tempatt = attindx[c];
                            attindx[c] = attindx[c+1];
                            attindx[c+1] = tempatt;
                            done = true;
                        }
                    }
                }
                ensemble[t].setAttIndexes(attindx.clone());

                int thisTotal = anotherInst.numAttributes()-1;
                
                    for (int m = 0; m < thisTotal; m++){
                        //go through each attribute
                        boolean del = true;
                        for(int u = 0 ; u < sqrsizeAtts;u++){ 
                            //set del to false
                            int lowestone = 1000;
                            for (int c = 0 ; c < sqrsizeAtts; c++){
                                if ( attindx[u] < lowestone){
                                    lowestone = u;
                                }
                            }
                            if (m == attindx[lowestone]){
                                del = false;
                            }
                        }
                        
                        
                        if (del == true){

                            anotherInst.deleteAttributeAt(m);
                            m--;
                            thisTotal--;
                            for(int u = 0 ; u < sqrsizeAtts;u++){ 
                                if (attindx[u] > m){
                                    attindx[u] --;
                                }
                            }
                        
                    }
                }

            System.out.println("current ensemble no: "+t);
            ensemble[t].buildClassifier(anotherInst);

        }
        
    }

    @Override
    public double classifyInstance(Instance instnc) throws Exception {
        //create blank Instance
       ArrayList<ArrayList<Integer>> classvalues = new ArrayList<>(); 
        for(int i = 0; i < ensemble.length;i++){
            int [] Attindex = ensemble[i].getAttIndexes();
            Instance anotherInst = new DenseInstance(Attindex.length +1);

            for (int t = 0 ; t < Attindex.length;t++){

                anotherInst.setValue(t, instnc.value(Attindex[t]));
            }
            anotherInst.setValue(Attindex.length, instnc.value(
                    instnc.numAttributes()-1));
            double tempVal = ensemble[i].classifyInstance(anotherInst);
            boolean contains = false;
            // ClassValue returned and then below it is
            // accounted for in the classvalues array
            ArrayList<Integer> addThis = new ArrayList<Integer>();
            for ( int o = 0; o <classvalues.size(); o ++){
                if (classvalues.get(o).get(0) == tempVal){
                    addThis.add(((int)tempVal));
                    addThis.add(classvalues.get(o).get(1)+1);
                    classvalues.remove(o);
                    contains = true;
                }
            }
           if (contains == false){
                
                addThis.add(((int)tempVal));
                addThis.add(1);
            }
            classvalues.add(addThis);
        }
    
        int currHighest = 0;
        for (int i = 0; i < classvalues.size(); i++){
            if (classvalues.get(i).get(1) > classvalues.get(
                    currHighest).get(i)){
                currHighest = i;
            }
    }
       return classvalues.get(currHighest).get(0);
    
    }
    public double getHowAccurate(Instances i) throws Exception
    {
        //go through each instance in i as if it is part of test data
        double predicted = 0;
        for (int f = 0; f < i.size(); f++) 
        {   
            double estimation = classifyInstance(i.get(f));
            double actual = i.instance(f).classValue();
            if(estimation == actual)
            {
                predicted++;
            }
        }
        //work out % of accurate value
        double accuracy = (double) predicted/i.size()*100;
        return accuracy;
    }

    @Override
    public double[] distributionForInstance(Instance instnc) throws 
            Exception {
        //create blank Instance
        ArrayList<ArrayList<Integer>> classvalues =
                new ArrayList<ArrayList<Integer>>(); 
       
        for(int i = 0; i < ensemble.length;i++){
           // System.out.println("att "+attindx.length);
            int [] Attindex = ensemble[i].getAttIndexes();


        Instance anotherInst = new DenseInstance(Attindex.length +1);

            for (int l = 0 ; l < Attindex.length;l++){

                anotherInst.setValue(l, instnc.value(Attindex[l]));
            }
            anotherInst.setValue(Attindex.length, instnc.value(
                    instnc.numAttributes()-1));

            double tempVal = ensemble[i].classifyInstance(anotherInst);

            boolean contains = false;
            // ClassValue returned and then below it is
            
            // accounted for in the classvalues array
            ArrayList<Integer> addThis = new ArrayList<Integer>();
            for ( int o = 0; o <classvalues.size(); o ++){
                if (classvalues.get(o).get(0) == tempVal){
                    addThis.add(((int)tempVal));
                    addThis.add(classvalues.get(o).get(1)+1);
                    classvalues.remove(o);
                    contains = true;
                }
            }
           if (contains == false){
                
                addThis.add(((int)tempVal));
                addThis.add(1);
            }
            classvalues.add(addThis);
        }
    
        int currHighest = 0;
        for (int i = 0; i < classvalues.size(); i++){
            if (classvalues.get(i).get(1) > classvalues.get(
                    currHighest).get(i)){
                currHighest = i;
            }
        }
        //create an array with every 1st val being the classValue and 
        //every 2nd being the count of times that value was returned
        double [] aryVals = new double[classvalues.size()*2]; 
        for (int t = 0 ; t < classvalues.size();t+=2){
            aryVals[t] = classvalues.get(t).get(0);
            aryVals[t+1] = classvalues.get(t).get(1);
        }
        System.out.println(aryVals);
        return aryVals;
    }

    @Override
    public Capabilities getCapabilities() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
    
}

