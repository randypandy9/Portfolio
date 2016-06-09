package librarysimulation;

public class LibraryBook 
{
    enum status //setting enum possibilities
    {
        REFERENCE_ONLY, 
        ON_LOAN, 
        AVAILABLE_FOR_LENDING
    }
    
    //setting individual fields
    private String author;
    private String title;
    private int pages;
    private String libclass;
    private int timesborrowed;
    private int reservations;
    public status bookStatus;
    public static int totalbooks;

public LibraryBook (String bookauthor, String booktitle, int bookpages)
    {
    author = bookauthor;
    title = booktitle;
    pages = bookpages;
    }

    public String getAuthor() //returns author
    {
        return author;
    }
    public String getTitle() //returns title
    {
        return title;
    }
    public int getPages() //returns pages
    {
        return pages;
    }
    public String getLibclass() 
    //returns library classification code
    {
        return libclass;
    }
    public status getState() //returns enum state
    {
        return bookStatus;
    }
    public int getTimesborrowed() 
    //returns times individual book has been borrowed
    {
        return timesborrowed;
    }
    public int getTotalTimesborrowed() 
    //increments the total times borrowed on a book
    {
        timesborrowed = timesborrowed + 1;
        return timesborrowed;
    }
    public String settingClassificaton(String bookLibclass)
    {
        libclass = bookLibclass;
        return libclass;
    }
    public boolean setClassification(String bookLibclass) 
    /**checks length of classification, 
            if 3 or less, then it can be classified*/
    {
        boolean Classification = false;
        if (bookLibclass.length()>3)
        {
            Classification = true;
        }
        return Classification;
    }
    public void setAsReferenceOnly() //sets the book as reference only
    {
        if (bookStatus != status.AVAILABLE_FOR_LENDING || 
                bookStatus != status.REFERENCE_ONLY)
        {
            bookStatus = status.REFERENCE_ONLY;
        }
    }
    public void setAsForLending() //sets the book as for lending only
    {
        if (bookStatus != status.AVAILABLE_FOR_LENDING || 
                bookStatus != status.REFERENCE_ONLY)
        {
            bookStatus = status.AVAILABLE_FOR_LENDING;
        }
    }
    public boolean isAvailable() //checks if book is available to lend
    {
        if (bookStatus == status.ON_LOAN)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void reserveBook(int resres)
    {
        reservations = reservations + resres;
    }
    public boolean reserveBook() 
    // attempt to reserve a book if there's less than 3 already made on it
    {
        reservations = reservations + 1;
        if (reservations < 4 && reservations > 0 
                && bookStatus == status.ON_LOAN)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void borrowBook()
    /**sets status as on loan and increments times taken out 
       individually and altogether  */
        {
            bookStatus = status.ON_LOAN;
            timesborrowed = timesborrowed + 1;
            totalbooks = totalbooks + 1;

        }

    public void returnBook() 
    /**sets book as available for lending and allows number of books at 
       library to increment, library has a book back.*/
        {
            bookStatus = status.AVAILABLE_FOR_LENDING;
            totalbooks = totalbooks - 1;
        }

    @Override
    public String toString() //takes book details and outputs them to user
        {
            String bookDetails = "\t \n Title: " + title +
                    "\t \n Author(s): " + author + "\t \n Pages: " +
                    pages + "\t \n Classification: " + libclass; 
            return bookDetails;
        }
    }
