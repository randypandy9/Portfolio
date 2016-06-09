/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekalab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author ysj13kxu
 */
public class WekaLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Instances train = ArsenalReader("\\\\ueahome4\\stusci4\\ysj13kxu\\data\\Documents\\NetBeansProjects\\WekaLab/arsenalTrain.arff");
        Instances test = ArsenalReader("\\\\ueahome4\\stusci4\\ysj13kxu\\data\\Documents\\NetBeansProjects\\WekaLab/arsenalTest.arff");
    
        Instance single = train.instance(2);
        System.out.println(single);
    
    }
    
    public static Instances ArsenalReader(String url)
    {
        Instances read = null;
        String str1 = url;
        FileReader r;
        try {
            r = new FileReader(str1);
            read = new Instances(r);

        } catch (Exception e) {
            System.out.println(" Exception caught =" + e);
        }
        return read;
    }
}
