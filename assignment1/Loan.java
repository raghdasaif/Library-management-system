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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
public class Loan {
    private int id;
    private Book b;
    private String issueDate;
    private Student s;
    private String returnDate;
    private String dueDate;
    private boolean status; // for loan
    private int finePerDay;
    private boolean paid;
    public Loan() {
    }

    public Loan(int id, Book b, String issueDate, Student s) {
        this.id = id;
        this.b = b;
        this.issueDate = issueDate;
        this.s = s;
        this.returnDate = null;
        this.dueDate = CalculateDueDate();
        this.status = false;
        this.finePerDay = 20;
        this.paid = false;
        b.setStatus(false);
    
    }
    public Book getB() {
        return b;
    }

    public void setB(Book b) {
        this.b = b;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(int finePerDay) {
        this.finePerDay = finePerDay;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    
    // functions
    
    public int total_fine() throws ParseException
    {
        
  int f=0;
try
{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 Date r = sdf.parse(returnDate);
Date s= sdf.parse(issueDate);
 long diff = r.getTime()- s.getTime();
diff=diff / (1000 * 60 * 60 * 24);
f=(int)diff*finePerDay;    
    }
    catch(ParseException e)
    {
        System.out.println("Error!");
    }


return f;
    
    }
   
    
    //book renew
    
    public void renewBook(int days)
    {
     dueDate= LocalDate.parse(dueDate).plusDays(days).toString();    }
    //due date
    
    public String CalculateDueDate()
    {
     String n= LocalDate.parse(issueDate).plusDays(15).toString();
    dueDate=n;
    return dueDate;
    }
    
    
    public void changestatuses()
    {
    b.setStatus(false);
    
    
    
    }
    
    public void printloanDetails()
    {
    System.out.println(" Book name " + b.getTitle());
    System.out.println(" issueDate " + this.issueDate);
    System.out.println(" Due Date " + this.dueDate);    
    }
    
public void ReturnBook(String Date)
{

status = true;
returnDate = Date;
b.setStatus(true); // avaiable for other member
s.deleteReturnedBook(b);
}
    
}
