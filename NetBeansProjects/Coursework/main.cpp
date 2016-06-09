/* 
 * File:   main.cpp
 * Author: ysj13kxu
 *
 * Created on 12 March 2015, 19:27
 */

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

int size;


/*
 * 
 */
void fileRead(char* filename, double* dataSets)
{
    FILE *fileToRead = fopen(filename, "r");
    fscanf(fileToRead, "%lf", &dataSets[0]);
    size = dataSets[0];
   
   
   if(fileToRead == NULL)
   {
       printf("ERROR: No file exists.");
       exit(EXIT_FAILURE);
   }
  
    
   int i;
   for (i=1; i < size+1; i++)
   {
       fscanf(fileToRead, "%lf",&dataSets[i]);
       printf("\n%lf",dataSets[i]);
   }
   fclose(fileToRead);
}

double getMean(double *dataset, int firstval) 
{
    double sum = 0;
    for (int j = 1;j<firstval+1;j++) 
    {
        sum = sum + dataset[j];
    }
    return sum/firstval;
}

double getMode(double *dataset, int firstval) 
{
    // Allocate an int array of the same size to hold the
    // repetition count
    int* ipRepetition = new int[firstval];
    for (int i = 0; i < firstval; ++i) {
        ipRepetition[i] = 0;
        int j = 0;
        bool bFound = false;
        while ((j < i) && (dataset[i] != dataset[j])) {
            if (dataset[i] != dataset[j]) {
                ++j;
            }
        }
        ++(ipRepetition[j]);
    }
    int iMaxRepeat = 0;
    for (int i = 1; i < firstval; ++i) {
        if (ipRepetition[i] > ipRepetition[iMaxRepeat]) {
            iMaxRepeat = i;
        }
    }
    delete [] ipRepetition;
    return dataset[iMaxRepeat];
}

double getMedian(double *dataset, int firstval)
{
    // Allocate an array of the same size and sort it.
    double* dpSorted = new double[firstval];
    
    for (int i = 0; i < firstval; ++i) 
    {
        dpSorted[i] = dataset[i];
    }
    
    
    for (int i = firstval; i > 0; --i) 
    {
        for (int j = 0; j < i; ++j) 
        {
            if (dpSorted[j] > dpSorted[j+1]) 
            {
                double dTemp = dpSorted[j];
                dpSorted[j] = dpSorted[j+1];
                dpSorted[j+1] = dTemp;
            }
        }
    }

    // Middle or average of middle values in the sorted array.
    double dMedian = 0.0;
    if ((firstval % 2) == 0) {
        dMedian = (dpSorted[firstval/2] + dpSorted[(firstval/2) - 1])/2;
    } else {
        dMedian = dpSorted[firstval/2];
    }
    delete [] dpSorted;
    return dMedian;
}

double stdDeviation(double *dataset, int firstval, double mean)
{
    double sum_deviation=0.0, current = 0.0; 
    for(int i = 1; i<firstval+1; i++)
    {
        current = (dataset[i]-mean)*(dataset[i]-mean);
        sum_deviation = sum_deviation + current;
    }
    return sqrt(sum_deviation/firstval);
}

void histogram(double *dataset, int firstval)
{
    for(int i = 1; i<11; i++)
    {
        printf("\n%d : ",i);
        for(int j = 1; j<=firstval+1; j++)
        {
            if(dataset[j] == i)
            {
                printf("*");
            }
        }
    }
}

int main(int argc, char** argv) {

    char *textFile = "dataset2.txt";
    double dataset[256];
    //-----------------------
    fileRead(textFile, dataset);
    //-----------------------
    printf("\n\n");

    double mean = getMean(dataset, dataset[0]);
    int mode = getMode(dataset, dataset[0]);
    double median = getMedian(dataset, dataset[0]);
    double stdDev = stdDeviation(dataset, dataset[0], mean);
    
    printf("Statistical Report\n");
    printf("==================\n");
    printf("\nMean : %lf",mean);
    printf("\nMode : %d",mode);
    printf("\nMedian : %lf",median);
    printf("\nstdev : %lf",stdDev);
    
    printf("\n\nHistogram:\n");
    histogram(dataset, dataset[0]);
    
    
    return 0;
}

