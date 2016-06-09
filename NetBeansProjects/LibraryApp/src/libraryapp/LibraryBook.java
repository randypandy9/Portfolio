package libraryapp;

public class LibraryBook 
{
    private String author;
    private String title;
    private int pages;
    private String libclass;
    private int timesBorrowed;
    enum status {REFERENCE_ONLY, ON_LOAN, AVAILABLE_FOR_LENDING}
    private int reservations;
}
