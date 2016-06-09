/* 
 * File:   Library.h
 * Author: ysj13kxu
 *
 * Created on 15 March 2015, 23:17
 */

#ifndef LIBRARY_H
#define	LIBRARY_H
#include "Borrower.h"
#include <vector>
#include "LibraryBook.h"
#include <string>
#include <stdio.h>
#include <iostream>
#include <cstdlib>
#include<fstream>
class Library {
protected:
    vector<Borrower> borrowedBooks;
    vector<LibraryBook> allBooks;
public:
    Library();
    Library(const Library& orig);
    bool hasMoreThan3(Borrower borrower);
    vector<Borrower> getBorrowed();
    vector<LibraryBook> getBooks();
    void testreadbooks();
    void testreadborrow();
    bool isInAllBooks(string book);
    void readInTransactions();
    void readInBooks();
    void readInUsers();
    void makeAvailable(string bookname);
    void makeOnLoan(string bookname);  
    Borrower mostPagesRead();
    Borrower nameToBorrower(string name);
    LibraryBook nameToBook(string name);
    void borrowBook(Borrower user,LibraryBook book);
    void returnBook(Borrower user,LibraryBook book);
};
#endif	/* LIBRARY_H */

