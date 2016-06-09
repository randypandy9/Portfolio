/* 
 * File:   Borrower.h
 * Author: ysj13kxu
 *
 * Created on 15 March 2015, 23:17
 */

#ifndef BORROWER_H
#define	BORROWER_H
#include <stdio.h>
#include "LibraryBook.h"
#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Borrower {
private:
    int id; 
    int noOfBooks;
    string name, address;
    vector<LibraryBook> currentBooks;
    vector<LibraryBook> transactions;
public:
    Borrower();
    Borrower(int id, string name, string address);
    Borrower(const Borrower& orig);
    virtual ~Borrower();

    int getID();
    string getName();
    string getAddress();
    int getTaken();
    void setID(int id);
    void setName(string name);
    void setAddress(string address);
    
    void addBook(LibraryBook book);
    void removeBook(LibraryBook book);
    int countPages();
    int mostLoans();
    friend ostream &operator<<(ostream &output, Borrower& b);
    friend istream &operator>>(istream &input, Borrower &b);  
};
#endif	/* BORROWER_H */

