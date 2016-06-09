/* 
 * File:   LibraryBook.h
 * Author: ysj13kxu
 *
 * Created on 15 March 2015, 16:23
 */

#ifndef LIBRARYBOOK_H
#define	LIBRARYBOOK_H
#include <stdio.h>
#include <iostream>
#include <string>
#include "Book.h"
#include "string.h"
using namespace std;

class LibraryBook : public Book{
private:
    string ref,status;

public:
    LibraryBook();
    
    
    LibraryBook(const LibraryBook& orig);
    virtual ~LibraryBook();
    
    LibraryBook(Book& book, string ref, string status): 
    Book(book.getAuthor(), book.getName(), book.getPP())
    {
        this->ref = ref;
        this->status = status;
    };
    
    friend ostream &operator<<(ostream&, LibraryBook&);
    friend istream &operator>>(istream&, LibraryBook&);
    
    string getRef();
    string getStatus();

    void setRef(string ref);
    void setStatus(string status);

};

#endif	/* LIBRARYBOOK_H */

