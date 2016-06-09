package librarysimulation;
import java.util.Scanner; //import to use for inputting
import java.util.Random; //used to create random numbers
public class LibrarySimulation 
{
    public static void main(String[] args) 
    {
        LibraryBook[] bookStock = generateBookStock(); 
        //genereate a book to be chosen
        Scanner scan = new Scanner(System.in); //input
        System.out.println("Set number of events:"); 
        //user info - set events
        int nOe = scan.nextInt(); //scan and set number to nOe
        int numberOFevents = nOe; //sets nOe to numberOFevents
        
        String[] outputarray = runSimulation(bookStock, numberOFevents); 
        /**takes output from runSimulation and output to a new array 
         (outputarray)*/
      
        for(int i = 0; i < numberOFevents; i++)
        {
            System.out.println(outputarray[i]);  
        }
    }
    
    
    public static LibraryBook [] generateBookStock() 
            //generate book details from given list
    {
        String [] authorsList = {"Lewis and Loftus", "Mitrani", "Goodrich",
        "Lippman", "Gross", "Baase", "Maclane", "Dahlquist",
        "Stimson", "Knuth", "Hahn", "Cormen and Leiserson",
        "Menzes", "Garey and Johnson"};
        String [] titlesList = {"Java Software Solutions", "Simulation",
        "Data Structures", "C++ Primer", "Graph Theory",
        "Computer Algorithms", "Algebra", "Numerical Methods",
        "Cryptography","Semi-Numerical Algorithms",
        "Essential MATLAB", "Introduction to Algorithms",
        "Handbook of Applied Cryptography",
        "Computers and Intractability"};
        int [] pagesList = {832, 185, 695, 614, 586, 685, 590, 573, 475, 685, 
            301, 1175, 820, 338};
        int n = authorsList.length;
        LibraryBook [] bookStock = new LibraryBook[n];
        
        for(int i = 0; i < n; i++)
        {
            bookStock[i] = new LibraryBook(authorsList[i],titlesList[i], 
                    pagesList[i]);
        }
        // set library classification for half of the LIbraryBooks
        for(int i = 0; i < n; i=i+2)
        {
            bookStock[i].setClassification("QA" + (99 - i));
        }
        // set approx. two thirds of LIbraryBooks in test data as
        // lending books
        for(int i = 0; i < 2*n/3; i++)
        {
            bookStock[i].setAsForLending();
        }
        // set approx. one third of LibraryBooks in test data as
        // reference-only
        for(int i = 2*n/3; i < n; i++)
        {
            bookStock[i].setAsReferenceOnly();
        }

        return bookStock; //return bookStock
    }
    
    public static String[] runSimulation(LibraryBook [] bookStock, 
            int numberOFevents) //run simulation
    {
        Random random = new Random(); //creates a new random number
        
        String[] eventsList = new String[numberOFevents]; 
        /**set eventList array
        size to number of events entered earlier*/
        
        String eventString = null; // output string set to null
        for(int i = 0; i < numberOFevents; i++)
        /**loop to set books chosen to different types 
          depending on circumstances*/
        {
            int randomNumber = random.nextInt(bookStock.length -1);
            LibraryBook currentBook = bookStock[randomNumber];
            
            if(currentBook.getLibclass()== null) 
                //book gets classified here
            {
                currentBook.settingClassificaton("QA" + (99-i));
                currentBook.setClassification("QA"+(99-i));
                eventString = "BOOK IS CLASSIFIED";
            }
            
            else if ((currentBook.getLibclass() != null)
                    && (currentBook.getState()
                    == LibraryBook.status.REFERENCE_ONLY))
                    //sets as reference only
            {
                eventString = "REFERENCE BOOK ONLY";
            }
            else if((currentBook.getLibclass() != null)
                    && (currentBook.getState()
                    == LibraryBook.status.AVAILABLE_FOR_LENDING))
                    //says that books been loaned out
            {
                currentBook.bookStatus = LibraryBook.status.ON_LOAN;
                eventString = "BOOK IS LOANED OUT";
                currentBook.borrowBook();
                Random randompicker2 = new Random(2); 
                //creates a new random number
                int randomNumber2 = randompicker2.nextInt();
                if ((randomNumber2 == 0 && currentBook.getState()
                        == LibraryBook.status.ON_LOAN))
                {
                    //0
                currentBook.returnBook();
                eventString = "BOOK IS RETURNED";
                currentBook.bookStatus = 
                        LibraryBook.status.AVAILABLE_FOR_LENDING;
                }
                if ((randomNumber2 == 1) && (currentBook.getState() 
                        == LibraryBook.status.ON_LOAN))
                {
                    //1
                    if(currentBook.reserveBook() == false) 
                        //trying alternative to make reservations work
                    {
                    eventString = "RESERVATION PLACED FOR ON-LOAN BOOK";
                    currentBook.reserveBook(1);
                    currentBook.reserveBook();
                    }
                    else
                    {
                     eventString = "BOOK IS ON-LOAN BUT CANNOT BE RESERVED";  
                    }
                }
                
            }
            else if(currentBook.getState() == LibraryBook.status.ON_LOAN) 
                //here 0
            //when book is being returned
            {
                currentBook.returnBook();
                eventString = "BOOK IS RETURNED";
                currentBook.bookStatus = 
                        LibraryBook.status.AVAILABLE_FOR_LENDING;
            }
            else if((currentBook.getState() == LibraryBook.status.ON_LOAN)
                    && (currentBook.reserveBook() == true)) //here 1
                    //attempting to place reservation on book
            {
                eventString = "RESERVATION PLACED FOR ON-LOAN BOOK";
                currentBook.reserveBook();
            }
            else if((currentBook.getState() == LibraryBook.status.ON_LOAN)
                    && (currentBook.reserveBook() == false))
                    //unable to place reservation on book
            {
                eventString = "BOOK IS ON-LOAN BUT CANNOT BE RESERVED";
            }
            
            eventsList[i] = (i+1) + " " + LibraryBook.totalbooks + " " + 
                    currentBook.getLibclass() + " " + eventString ;
            //final string output format
            
        }
        return eventsList; //return the string after the loop
    }
}
