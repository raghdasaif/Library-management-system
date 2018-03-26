/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.text.ParseException;

/**
 *
 * @author hp
 */
public class LMS {
    private Book [] b;
    private Person [] p;

    public LMS() {
    }

    public LMS(Book[] b, Person[] p) {
        this.b = b;
        this.p = p;
        
    }
public Person getpbyindex(int i)
{
return p[i];
}
 
    public int getCb() {
        return b.length;
    }

    public int getCp() {
        return p.length;
    }


public Book SearchbyTitle(String t)
{
for (int i=0;i < b.length;i++)
    if (b[i].getTitle().equals(t))
    {
 return b[i];
    }
return null;
}

public Book[] SearchBySubject(String t)
{
    int counter=0;
    for(int i=0;i<b.length;i++)
    {
        if(b[i].getType().equals(t))
        {
            counter++;
        }
        
    }
    
    Book[] temp=new Book[counter];
   int a=0;
    for(int i=0;i<b.length;i++)
    {
        if(b[i].getType().equals(t))
        {
            temp[a]=b[i];
            a++;
        }
        
    }
    return temp;
}

public Book[] SearchByAuthor(String a)
{
    int counter=0;
    for(int i=0;i<b.length;i++)
    {
        if(b[i].getAuthor().equals(a))
        {
            counter++;
        }
        
    }
    
    Book[] temp=new Book[counter];
   int aa=0;
    for(int i=0;i<b.length;i++)
    {
        if(b[i].getAuthor().equals(a))
        {
            temp[aa]=b[i];
            aa++;
        }
        
    }
    return temp;
}

// book


public void addBook(int ISBN ,String t, String a,String type, int price)
{
    //int ISBN, String author, String title, int price, String type
   Book bb = new Book(ISBN,a,t,price,type );
Book [] temp= new Book[b.length+1] ;
for (int i=0;i<b.length;i++)
{
temp[i]= b[i];
}
temp[b.length] = bb;
b=temp;
}

public void removeBookbyTitle(String t)
{
    Book [] temp= new Book[b.length-1] ;
    int x=0;
    int y=0;
    for (int i=0;i<b.length;i++)
   {
    if(b[i].getTitle().equals(t))
    {
        for(int j=0;j<b.length;j++)
        {
            if(!b[j].getTitle().equals(t))
            {
                temp[x]=b[y];
                x++;
                y++;
            }
            else
            {
                y++;
            }
            
        }
        b=temp;
    }
   }
}


public void removeBookbyISBN(int ISBN)
{
    Book [] temp= new Book[b.length-1] ;
    int x=0;
    int y=0;
    for (int i=0;i<b.length;i++)
   {
    if(b[i].getISBN()==ISBN)
    {
        for(int j=0;j<b.length;j++)
        {
            if(b[j].getISBN()!=ISBN)
            {
                temp[x]=b[y];
                x++;
                y++;
            }
            else
            {
                y++;
            }
            
        }
        b=temp;
    }
   }
}

public int Noofperson()
{
return p.length;
}

public int Noofbooks()
{
return b.length;
}

// EDIT Person

public void editPersonAddress(int rollno,String address)
{
int f=0;
for (int i=0 ;i < p.length && f == 0 ; i++)
{
    if (p[i] instanceof Student)
    {
        Student temp = ((Student)p[i]);
    if (temp.getRollno() == rollno)
    {
    f=1;
    temp.setAddress(address);
    System.out.println("Address updated ");
    }
        
        
    }
}
    if (f == 0)
    {
    System.out.println("Student not found ");
    
    }
}

public void editPersonNumber(int rollno,String no)
{
int f=0;
for (int i=0 ;i < p.length && f == 0 ; i++)
{
    if (p[i] instanceof Student)
    {
        Student temp = ((Student)p[i]);
    if (temp.getRollno() == rollno)
    {
    f=1;
    temp.setNumber(no);
    System.out.println("Number updated ");
    }
        
        
    }
}
    if (f == 0)
    {
    System.out.println("Student not found ");
    
    }
}
// edit book functions

public void editBookTitle(String t1,String t2)
{
int f=0;
for (int i=0 ;i < b.length && f == 0 ; i++)
{

       //Book temp;
    if (b[i].getTitle().equals(t1))
    {
    f=1;
    b[i].setTitle(t2);
    System.out.println("Title updated ");
    }
        
        
    }
    if (f == 0)
    {
    System.out.println("Book not found ");
    
    }
}
public void editBookAuthor(String t1,String t2)
{
       //Book temp;
    Book temp = this.SearchbyTitle(t1);
   if (temp != null)
   {
       temp.setAuthor(t2);
    System.out.println("Author's name updated ");
    }
   else
    {
    System.out.println("Book not found ");
    
    }
}
public void editBookPrice(String t1,int t2)
{   Book temp = this.SearchbyTitle(t1);
   if (temp != null)
   {
       temp.setPrice(t2);
    System.out.println("Price updated ");
    }
   else
    {
    System.out.println("Book not found ");
    
    }

}
public void editBookISBN(String t1,int t2)
{   Book temp = this.SearchbyTitle(t1);
   if (temp != null)
   {
       temp.setISBN(t2);
    System.out.println("ISBN updated ");
    }
   else
    {
    System.out.println("Book not found ");
    
    }

}
 public Student Searchbyrollno(int r)
    {
    Student s= null;
    int f=0;
for (int i=0 ;i < p.length && f == 0 ; i++)
{
    if (p[i] instanceof Student)
    {
        Student temp = ((Student)p[i]);
    if (temp.getRollno() == r)
    {
    f=1;
s = temp;
    }
        
        
    }
}
    if (f == 0)
    {
    System.out.println("Student not found ");
    
    }
    
    return s;
    }
 
 public int total_fine_paid(int rollno) throws ParseException
 {
 int sum=0;
 //for (int i=0 ;i < b.length ; i++)
 //{
 Student s = this.Searchbyrollno(rollno);
 Loan l[] = s.getB();
 if (l != null)
 {
     for (int j=0;j < l.length ;j++)
     {
     if (l[j].getReturnDate() != null)
     {
     sum = sum + l[j].total_fine();
     
     }
     }
 }
 return sum;
 }
 
}
