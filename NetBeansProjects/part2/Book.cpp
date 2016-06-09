/* 
 * File:   Book.cpp
 * Author: ysj13kxu
 * 
 * Created on 13 March 2015, 20:30
 */
#include "Book.h"
#include <string>
#include <stdio.h>
#include <iostream>
#include "string.h"
#include <sstream>
using namespace std;
Book::Book() {
    
}
//constructor
Book::Book(string author, string name, int pp) 
{
    this->author = author;
    this->name = name;
    this->pp = pp;
}

Book::Book(const Book& orig) 
{
    author = orig.author;
    name = orig.name;
    pp = orig.pp;
}

Book::~Book() {
}

//overloading operators
ostream &operator<<(ostream &output, Book &b) {
    output << "Author : " << b.author << " Title : " 
            << b.name << " Pages : " << b.pp <<endl;
    return output;
}
istream &operator>>(istream &input, Book &b) 
{
    string temp;
    
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
    
    return input;
}

bool Book::operator==(Book &b){
    return b.getAuthor() == getAuthor();
}

bool Book::operator>(Book &b)
{
        //if author same then sort by name
        //else sort by author
        if(b.author == author)
        {
            int first,second;
            for(int i =0;i<b.name.length();i++)
            {
                if(b.name.at(i) != name.at(i))
                {
                    first = (int) b.getName().at(i);
                    second = (int) name.at(i);
                    return first>second;
                }
            }
        }
        else
        {
            int first,second;
            for(int i =0;i<b.author.length();i++){
            if(b.author.at(i) != author.at(i))
            {
                first = (int) b.getName().at(i);
                second = (int) author.at(i);
                return first>second;
            }
        }
    }
    return false;    
}

string Book::getAuthor() {
    return this->author;
}

string Book::getName() {
    return this->name;
}

int Book::getPP() {
    return this->pp;
}

void Book::setAuthor(string author) {
    this->author = author;
}

void Book::setName(string name) {
    this->name = name;
}

void Book::setPP(int pp) {
    this->pp = pp;
}

