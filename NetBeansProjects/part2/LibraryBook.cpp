/* 
 * File:   LibraryBook.cpp
 * Author: ysj13kxu
 * 
 * Created on 15 March 2015, 16:23
 */
#include <stdio.h>
#include <iostream>
#include "LibraryBook.h"
#include <string>
#include "string.h"
#include <sstream>
using namespace std;

LibraryBook::LibraryBook() {
}

LibraryBook::LibraryBook(const LibraryBook& orig) {
    author = orig.author;
    name = orig.name;
    pp = orig.pp;
    ref = orig.ref;
    status = orig.status;
}

LibraryBook::~LibraryBook() {
}

ostream &operator<<(ostream &output, LibraryBook &b) {
    output << b.getAuthor() << ", \"" << b.getName() << "\" (" 
            << b.getPP() << " pp.) [" << b.getRef() << " " 
            << b.getStatus() << "]" <<endl;
    return output;
}
istream &operator>>(istream &input, LibraryBook &b) {
    string temp, ref, status;
    
    getline(input, temp, ',');
    b.setAuthor(temp);
    
    getline(input, temp, '"');
    getline(input, temp, '"');
    b.setName(temp);
    
    getline(input, temp, '(');
    getline(input, temp, ')');
    stringstream st(temp);
    int pages;
    st >> pages;
    b.setPP(pages);
    
    getline(input, temp, '[');
    getline(input, temp, ' ');
    b.setRef(temp);

    getline(input, temp, ']');
    b.setStatus(temp);
    
    return input;
}

string LibraryBook::getRef() {
    return this->ref;
}

string LibraryBook::getStatus() {
    return this->status;
}

void LibraryBook::setRef(string ref) {
    this->ref = ref;
}

void LibraryBook::setStatus(string status) {
    this->status = status;
}

