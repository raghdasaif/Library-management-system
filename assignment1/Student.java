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
public class Student extends Person{
    private int batch;
    private int rollno;
    private Loan [] b;
    private int balance;
    private Book [] hold; 
    private String number;
    public Student() {
    }

    public Student(int pid, String name, String address, int uid, String pswd,int batch, int rollno, int balance,String no) {
        super(pid, name, address, uid, pswd);
        this.batch = batch;
        this.rollno = rollno;
        this.b = null;
        this.balance = balance;
    this.hold = null;
    number = no;
    }

   
    public Student(int batch, int rollno, Loan[] b, int balance) {
        this.batch = batch;
        this.rollno = rollno;
        this.b = b;
        this.balance = balance;
    }

    public int getBatch() {
        return batch;
    }

    public Book[] getHold() {
        return hold;
    }

    public void setHold(Book[] hold) {
        this.hold = hold;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public Loan[] getB() {
        return b;
    }

    public void setB(Loan b) {
        Loan [] temp = new Loan[(this.b.length)+1];
        for (int i=0 ;i < this.b.length ;i++ )
              temp[i] = this.b[i];
            temp[this.b.length] = b;
    this.b=temp;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

public void print()    
{
System.out.println(this.rollno + " " + this.name + " " + this.address +" " +  this.number);
}
    public void OnLoanBooks()
    {
    if ( b != null)
    {
        for (int i=0; i < b.length ; i++)
    {
    b[i].printloanDetails();
    }
    }
    else
        System.out.println("No books are on loan");
    }
    public void PlaceonHold(Book bk)
    {
if (hold != null)
{
    Book [] temp= new Book[hold.length+1] ;
for (int i=0;i<hold.length;i++)
{
temp[i]= hold[i];
}
temp[hold.length] = bk;
hold=temp;
    }
else
{
hold = new Book[1];
hold[0] = bk;
}

}
   public Loan SearchLoanByTitle(String t)
   {
   Loan l=null;
   int f=0;
   if (b != null)
   {
       for (int  i=0 ;i < b.length && f == 0; i++)
   {
   Book bb = b[i].getB();
   if (bb.getTitle().equals(t))
   {
   l = b[i];
   f=1;
   }
   
   }
   }
   return l;
   }
public void deleteReturnedBook(Book b1)
{
   Loan [] temp= new Loan[b.length-1] ;
    int x=0;
    int y=0;
    for (int i=0;i<b.length;i++)
   {

       Book b2 = b[i].getB();
    if((b2.getTitle()).equals(b1.getTitle()))
    {
        for(int j=0;j<b.length;j++)
        {
            if(!(b2.getTitle()).equals(b1.getTitle()))
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
public void printStudent()
{
System.out.println("name " + this.name);
System.out.println("roll no is" + this.rollno);
for (int i=0;i< b.length ;i++)
System.out.println("Loan is " + b[i]);
}
public void addLoan(Loan ll)
  {
      if (b != null)
      {
          Loan [] temp= new Loan[b.length+1] ;
      
for (int i=0;i<b.length;i++)
{
temp[i]= b[i];
}
temp[b.length] = ll;
b=temp;
      }
      
      else
      {
      b = new Loan[1];
      this.b[0] = ll;
      
      
      }
//this.  
  }

}
