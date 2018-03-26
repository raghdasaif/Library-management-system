/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author hp
 */
public class Book {
    private int ISBN;
    private String author; 
    private String title;
    private boolean status;
    private int price;
    private String type;
    private Loan[] l;

    public Book() {
    
    }
    
    public Book(int ISBN, String author, String title, int price, String type) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.status = true;
        this.price = price;
        //this.noofcopies = noofcopies;
    this.type = type;   
    }

    // getters and setters

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Loan[] getL() {
        return l;
    }

    public void setL(Loan[] l) {
        this.l = l;
    }

  public void printdetails()
  {
  System.out.println("Title is " + this.title);
  System.out.println("Author is " + this.author);  
    System.out.println("Subject is " + this.type);
    System.out.println("ISBN is " + this.ISBN);
    System.out.println("Price is " + this.price);
  System.out.println("Available is " + this.status);
  }
    
  public void addLoan(Loan ll)
  {
      if (l != null)
      {
          Loan [] temp= new Loan[l.length+1] ;
      
for (int i=0;i<l.length;i++)
{
temp[i]= l[i];
}
temp[l.length] = ll;
l=temp;
      }
      
      else
      {
      l = new Loan[1];
      this.l[0] = ll;
      
      
      }
}
}
