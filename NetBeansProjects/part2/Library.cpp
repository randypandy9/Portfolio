/* 
 * File:   Library.cpp
 * Author: ysj13kxu
 * 
 * Created on 15 March 2015, 23:17
 */

#include "Library.h"
#include "LibraryBook.h"
#include "Borrower.h"
#include <vector>
#include <string>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <cstdlib>
using namespace std;

Library::Library() {
}

Library::Library(const Library& orig) {
    allBooks = orig.allBooks;
    borrowedBooks = orig.borrowedBooks;
}

bool Library::hasMoreThan3(Borrower borrower) {
    return borrower.getTaken() > 3;
}

vector<Borrower> Library::getBorrowed() {
    return borrowedBooks;
}

void Library::testreadbooks() {
    for (int i = 0; i < allBooks.size(); i++) {
        cout << allBooks.at(i) << endl;
    }
}

void Library::testreadborrow() {
    for (int i = 0; i < borrowedBooks.size(); i++) {
        cout << borrowedBooks.at(i) << endl;
    }
}

vector<LibraryBook> Library::getBooks() {
    return allBooks;
}

bool Library::isInAllBooks(string book) {
    for (int i = 0; i < allBooks.size(); i++) {
        if (allBooks.at(i).getName() == book) {
            return true;
        }
    }
    return false;
}

LibraryBook Library::nameToBook(string name) {
    try {
        vector<LibraryBook>::iterator it;
        for (it = allBooks.begin(); it < allBooks.end(); it++) {
            if ((it)->getName() == name) {
                return (*it);
            }
        }
    }    catch (int a) {
        LibraryBook caught;
        return caught;
    }
}

Borrower Library::mostPagesRead()
{
    int current;
    Borrower borrower;
    for(int i=0;i<borrowedBooks.size();i++)
    {
        int comp = borrowedBooks.at(i).countPages();
        if(comp>current)
        {
            current = comp;
        }
    }
    for(int j=0;j<borrowedBooks.size();j++)
    {
        
        if(borrowedBooks.at(j).countPages() == current)
        {
            borrower = borrowedBooks.at(j);
        }
    }
    return borrower;
}

Borrower Library::nameToBorrower(string name) {
    try {
        vector<Borrower>::iterator it;
        for (it = borrowedBooks.begin(); it < borrowedBooks.end(); it++) {
            if ((it)->getName().find(name) == 0) {
                return (*it);
            }
        }
    }    catch (int a) {
        Borrower caught;
        return caught;
    }
}

void Library::makeAvailable(string bookname) {
    for (int i = 0; i < allBooks.size(); i++) {
        if (allBooks.at(i).getName() == bookname) {
            allBooks.at(i).setStatus("AVAILABLE FOR LENDING");
        }
    }
}

void Library::makeOnLoan(string bookname) {
    for (int i = 0; i < allBooks.size(); i++) {
        if (allBooks.at(i).getName() == bookname) {
            allBooks.at(i).setStatus("ON LOAN");
        }
    }
}

//borrowbook doesn't work
void Library::borrowBook(Borrower user,LibraryBook book) {
    try {
        if (book.getStatus() == "AVAILABLE FOR LENDING") {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                if (borrowedBooks[i].getName() == user.getName()) {
                    borrowedBooks[i].addBook(book);
                }
            }
            for (int i = 0; i < allBooks.size(); i++) {
                if (allBooks.at(i).getName() == book.getName()) {
                    allBooks.at(i).setStatus("ON LOAN");
                }
            }
        }
        else {
            throw string("Can't take this book out.");
        }
    }    catch (int a) {
        cout << "cant complete request" << endl;
    }
}

//returnbook works
void Library::returnBook(Borrower user,LibraryBook book){
    
    for (int i = 0; i < borrowedBooks.size();i++){
        if (borrowedBooks[i].getID() == user.getID()){
            borrowedBooks[i].removeBook(book);
        }
    }
    for (int i = 0; i < borrowedBooks.size();i++){
        if (allBooks[i].getRef() == book.getRef()){
            allBooks[i].setRef("AVAILABLE FOR LENDING");
        }
    }
}
void Library::readInBooks() {
    fstream bfile;
    bfile.open("librarybooks.txt");
    LibraryBook abooky;
    while (!bfile.eof()) {
        bfile >> abooky;
        allBooks.push_back(abooky);
        cout << abooky << endl;
    }
    bfile.close();
}

void Library::readInUsers() {
    fstream ufile;
    ufile.open("users.txt");
    Borrower bor;
    while (!ufile.eof()) {
        ufile >> bor;
        borrowedBooks.push_back(bor);
        cout << bor;
    }
    ufile.close();
}

void Library::readInTransactions() {

    //RET/REQ.. BORROWER: AUTHOR,NAMEOFBOOK
    int errors;
    fstream file;
    file.open("transactions.txt");
    LibraryBook libbooktemp;
    Borrower borrower;
    string temp;
    string retORreq, borrowername, author, booktitle;
    if (file.is_open()){
        while (!file.eof()) {
            getline(file, temp, ':');
            retORreq = temp;
            getline(file, temp, ':');
            borrowername = temp.substr(1,borrowername.length()-1);
            getline(file, temp, ',');
            author = temp;
            getline(file, temp, '"');
            getline(file, temp, '"');
            booktitle = temp;
            if (retORreq.find("request")) {
                try {
                    libbooktemp = nameToBook(booktitle);
                    borrower = nameToBorrower(borrowername);
                    borrowBook(borrower,libbooktemp);
                }
                catch (int a) 
                {
                    cout << "COUDLN'T MAKE A LIBRARY BOOK" << endl;
                }
            }
            if (retORreq.find("return")) 
            {
                libbooktemp = nameToBook(booktitle);
                borrower = nameToBorrower(borrowername);
                returnBook(borrower, libbooktemp);
            }
        }

    }
}
