/* 
 * File:   Borrower.cpp
 * Author: ysj13kxu
 * 
 * Created on 15 March 2015, 23:17
 */

#include "Borrower.h"
#include <string>
#include <stdio.h>
#include <iostream>
#include <sstream>
using namespace std;
Borrower::Borrower() {
}
Borrower::Borrower(int id, string name, string address)
{
    this->id = id;
    this->name = name;
    this->address = address;
}

Borrower::Borrower(const Borrower& orig) 
{
    id = orig.id;
    name = orig.name;
    address = orig.address;
}

Borrower::~Borrower() {
}

int Borrower::getID()
{
    return this->id;
}
string Borrower::getName()
{
    return this->name;
}
string Borrower::getAddress()
{
    return this->address;
}
void Borrower::setID(int id)
{
    this->id = id;
}
void Borrower::setName(string name)
{
    this->name = name;
}
void Borrower::setAddress(string address)
{
    this->address = address;
}
int Borrower::getTaken()
{
    return this->noOfBooks;
}
void Borrower::addBook(LibraryBook book)
{
    currentBooks.push_back(book);
    noOfBooks++;
}

void Borrower::removeBook(LibraryBook book)
{
    for(int i = 0; i < currentBooks.size(); i++)
    {
        if(book.getName() == currentBooks.at(i).getName())
        {
            currentBooks.erase(currentBooks.begin()+i);
            noOfBooks--;
            break;
        }
    }
}

int Borrower::countPages(){
    int total;
    for(int i = 0; i < transactions.size(); i++)
    {
        total = total + transactions.at(i).getPP();
    }
    return total;
}

int Borrower::mostLoans()
{
    return transactions.size();
}

ostream &operator<<(ostream &output, Borrower &b) {
    output << "id : " << b.id << " Title : " << b.name 
            << " Pages : " << b.address <<endl;
    return output;
}
istream &operator>>(istream &input, Borrower &b) {
    string temp;
    int id;
    getline(input, temp, ' ');
    
    stringstream st(temp);
    st >> id;
    b.setID(id);

    getline(input, temp, ':');
    b.setName(temp);
    
    getline(input, temp, '\n');
    b.setAddress(temp);
    return input;
}
