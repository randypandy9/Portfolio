/* 
 * File:   main.c
 * Author: ysj13kxu
 *
 * Created on 12 March 2015, 19:27
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

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
    int j;
    for (j = 1;j<firstval+1;j++) 
    {
        sum = sum + dataset[j];
    }
    return sum/firstval;
}

double getMode(double *dataset, int firstval) 
{
    // Allocate an int array of the same size to hold the
    // repetition count
    int ipRepetition [firstval];
    int *point;
    int i;
    point = ipRepetition;
    for (i = 0; i < firstval; ++i) {
        ipRepetition[i] = 0;
        int j = 0;
        while ((j < i) && (dataset[i] != dataset[j])) {
            if (dataset[i] != dataset[j]) {
                ++j;
            }
        }
        ++(ipRepetition[j]);
    }
    int iMaxRepeat = 0;
    int l;
    for (l = 1; l < firstval; ++l) {
        if (ipRepetition[l] > ipRepetition[iMaxRepeat]) {
            iMaxRepeat = l;
        }
    }
    return dataset[iMaxRepeat];
}

double getMedian(double *dataset, int firstval)
{
    // Allocate an array of the same size and sort it.
    double dpSorted [firstval];
    double *pointer;
    pointer = dpSorted;
    int i;
    for (i = 0; i < firstval; ++i) 
    {
        dpSorted[i] = dataset[i];
    }
    
    int j;
    
    for (j = firstval; j > 0; --j) 
    {
        int k;
        for (k = 0; k < j; ++k) 
        {
            if (dpSorted[k] > dpSorted[k+1]) 
            {
                double dTemp = dpSorted[k];
                dpSorted[k] = dpSorted[k+1];
                dpSorted[k+1] = dTemp;
            }
        }
    }

    // Middle or average of middle values in the sorted array.
    double dMedian = 0.0;
    if ((firstval % 2) == 0) {
        dMedian = (dpSorted[firstval/2] + 
                dpSorted[(firstval/2) - 1])/2;
    } else {
        dMedian = dpSorted[firstval/2];
    }
    return dMedian;
}

double stdDeviation(double *dataset, int firstval, double mean)
{
    double sum_deviation=0.0, current = 0.0; 
    int i;
    for(i = 1; i<firstval+1; i++)
    {
        current = (dataset[i]-mean)*(dataset[i]-mean);
        sum_deviation = sum_deviation + current;
    }
    return sqrt(sum_deviation/firstval);
}

void histogram(double *dataset, int firstval)
{
    FILE *fp;
    fp = fopen("report.txt", "a+");
    int i;
    fprintf(fp, "\n\nHistogram:\n");
    for(i = 1; i<11; i++)
    {
        printf("\n%d : ",i);
        fprintf(fp, "\n%d : ",i);
        int j;
        for(j = 1; j<=firstval+1; j++)
        {
            if(dataset[j] == i)
            {
                printf("*");
                fprintf(fp, "*");
            }
        }
    }
    fclose(fp);
}

void saveToFile(double mean, int mode, double median, double stdDev) {
    FILE *fp;
    char ch;
    fp = fopen("file.txt", "w");
    
    fprintf(fp, "Statistical Report\n");
    fprintf(fp, "==================\n");
    fprintf(fp, "\nMean : %lf",mean);
    fprintf(fp, "\nMode : %d",mode);
    fprintf(fp, "\nMedian : %lf",median);
    fprintf(fp, "\nstdev : %lf",stdDev);
    
    fclose(fp);

}

int main(int argc, char** argv) {

    char *textFile = "dataset2.txt";
    double dataset[256];
    
    fileRead(textFile, dataset);

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
    saveToFile(mean, mode, median, stdDev);
    printf("\n\nHistogram:\n");
    histogram(dataset, dataset[0]);
    
    return 0;
}

