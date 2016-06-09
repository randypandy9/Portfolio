/* 
 * File:   Book.h
 * Author: ysj13kxu
 *
 * Created on 13 March 2015, 20:30
 */

#ifndef BOOK_H
#define	BOOK_H
#include <string>
#include <stdio.h>
#include <iostream>
#include "string.h"
using namespace std;
class Book{
protected:
    
    //book variables
    string author,name;
    int pp;
    
public:
    Book();
    //book constructor
    Book(string author, string name, int pp);
    Book(const Book& orig);
    
    virtual ~Book(); 
    //overloading operators
    friend ostream &operator<<(ostream &output, Book& b);
    friend istream &operator>>(istream &input, Book &b);
    
    bool operator==(Book &B);
    bool operator>(Book &B);
    
    //gets and sets
    string getAuthor();
    string getName();
    int getPP();
    void setAuthor(string author);
    void setName(string name);
    void setPP(int pp);
};
#endif	/* BOOK_H */

