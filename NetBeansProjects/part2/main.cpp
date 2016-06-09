/* 
 * File:   main.cpp
 * Author: ysj13kxu
 *
 * Created on 13 March 2015, 19:47
 */
#include <stdio.h>
#include <string>
#include <iostream>
#include <cstdlib>
#include <vector>
#include <fstream>
#include <string>
#include "Book.h"
#include "LibraryBook.h"
#include "string.h"
#include "Library.h"

using namespace std;

/*
 * 
 */
Library lib;

int main(int argc, char** argv) 
{
    cout << "READ BOOKS:\n" << endl;
    lib.readInBooks();
    //books are read now in the library constructor
    cout << "READ BORROWERS:\n" << endl;
    lib.readInUsers();
    
    //testing if files read successfully
    lib.testreadbooks();
    lib.testreadborrow();
    
    //NOTE: TRANSACTIONS DONT READ PROPERLY
    //SO EVERYTHING AFTER DOESNT WORK EITHER
    
    //I have no errorLog too
    cout << "PROCESS TRANSACTIONS\n" << endl;
    lib.readInTransactions();
    
    //returning books works but borrowing books crashes program
    
    
    Borrower readmostpages = lib.mostPagesRead();
    cout << "MOST PAGES READ" << endl;
    cout << readmostpages << endl;
    //if it can't then record the error in 
    //errorlog.txt via 'cerr' 
    
    //then theres extra 3 things...
    return 0;
}

