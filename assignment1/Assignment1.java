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


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;  
public class Assignment1 {
  public String readFile(String filename)throws FileNotFoundException, IOException{  
        FileInputStream fin;  
        int i;  
        String s="";  
        fin = new FileInputStream(filename);  
        // read characters until EOF is encountered  
        do {  
        i = fin.read();  
        if(i != -1)  s =s+(char) i+"";  
        } while(i != -1);  
        fin.close();  
        return s;  
    }  
    public String filereading(String filename)
    { 
     String fileContent=null;
        try {  
            fileContent = new Assignment1().readFile(filename);  
         //   System.out.println(fileContent);  
        } catch (FileNotFoundException e) {  
            System.out.println("File:"+ filename+" is missing, Please check file name");  
        } catch (IOException e) {  
            System.out.println("File is not having permission to read, please check the permission");  
        }
        return fileContent;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

          
         String s = new Assignment1().filereading("student.txt");
         String lib =  new Assignment1().filereading("librarian.txt");
         String c =  new Assignment1().filereading("clerk.txt");
         String bk =  new Assignment1().filereading("book.txt"); 
    boolean flaggg = true;
    int index=0;
    String scc=null;
        for (int i=0;i<s.length() && flaggg == true ; i++)
            if (s.charAt(i) == ',')
            {
                flaggg = false;
        index = i;
            }
        scc = s.substring(0, index);
    int student_count = Integer.parseInt(scc);
  scc=null;
        for (int i=0;i<lib.length() && flaggg == true ; i++)
            if (lib.charAt(i) == ',')
            {
                flaggg = false;
        index = i;
            }
        scc = lib.substring(0, index);
   int lib_count =Integer.parseInt(scc);
   scc=null;
        for (int i=0;i<c.length() && flaggg == true ; i++)
            if (c.charAt(i) == ',')
            {
                flaggg = false;
        index = i;
            }
        scc = c.substring(0, index);
     
 int clerk_count = Integer.parseInt(scc);
 
    int total_person = student_count + lib_count + clerk_count; 
   scc=null;
        for (int i=0;i<bk.length() && flaggg == true ; i++)
            if (bk.charAt(i) == ',')
            {
                flaggg = false;
        index = i;
            }
        scc = bk.substring(0, index);
      
    int book_count =  Integer.parseInt(scc);
// calculating lenghts
Book b[] = new Book[book_count];
    Person p[] = new Person[total_person + 1];
         int idd=-1; //1
    String namee=null; //2
    String addresss=null; //3
    int uid=-1; // 4
    String password=null; //5 
    int batch=-1; // 6
    int rollno=-1; // 7
    int bb=-1; // 8
    String number=null; // 9
    int k =3;
    int count =0;
    int pp =0;
//    reading data for student
    for (int i=3;i < s.length() ; i++)
    {
        String dummy = null;
        
    if (s.charAt(i) == ',')
    {
        count++;
    dummy = s.substring(k,i);
    k = i+1;
    i++;
    
    if (count == 1 )
    {
         idd = Integer.parseInt(dummy);
      }
    else if (count == 2)
    {
    namee = dummy; 
  }
    else if (count == 3)
    {
     addresss = dummy;
    }
    else if (count == 4)
    {
   uid = Integer.parseInt(dummy);
     }
    else if (count == 5)
    {
 password = dummy; //5 
    }
    else if (count == 6)
    {
 batch = Integer.parseInt(dummy);
    }
    else if (count == 7)
    {
     rollno = Integer.parseInt(dummy);
    }
    else if (count == 8)
    {
     bb = Integer.parseInt(dummy);
    }
    else if (count == 9)
    {
 number = dummy; // 9
 p[pp] = new Student(idd,namee,addresss,uid,password,batch,rollno,bb,number);
    pp++;
   count = 0;   
    }
    } 
    }
    //    reading data for clerk

    k=3;
  count=0;
    for (int i=3;i < c.length() ; i++)
    {
        String dummy = null;
        
    if (c.charAt(i) == ',')
    {
        count++;
    dummy = c.substring(k,i);
    k = i+1;
    i++;
    
    if (count == 1 )
    {
         idd = Integer.parseInt(dummy);
     }
    else if (count == 2)
    {
    namee = dummy; 
    }
    else if (count == 3)
    {
     addresss = dummy;
     }
    else if (count == 4)
    {
   uid = Integer.parseInt(dummy);
     }
    else if (count == 5)
    {
 password = dummy; //5 
    p[pp] = new Clerk(idd,namee,addresss,uid,password);
    pp++;
   count = 0;
    }
    }
    }
    //    reading data for librarian
 k=3;
  count=0;
    for (int i=3;i < lib.length() ; i++)
    {
        String dummy = null;
        
    if (lib.charAt(i) == ',')
    {
        count++;
    dummy = lib.substring(k,i);
    k = i+1;
    i++;
    
    if (count == 1 )
    {
         idd = Integer.parseInt(dummy);
    }
    else if (count == 2)
    {
    namee = dummy; 
    }
    else if (count == 3)
    {
     addresss = dummy;
    }
    else if (count == 4)
    {
   uid = Integer.parseInt(dummy);
    }
    else if (count == 5)
    {
 password = dummy; //5 
    p[pp] = new Librarian(idd,namee,addresss,uid,password);
    pp++;
   count = 0;
    }
    }
    }   
    
    //    reading data for book
    k=3;
    count =0;
    int bbk =0;
    for (int i=3;i < bk.length() ; i++)
    {
        String dummy = null;
        
    if (bk.charAt(i) == ',')
    {
        count++;
    dummy = bk.substring(k,i);
    k = i+1;
    i++;
    if (count == 1 )
    {
         idd = Integer.parseInt(dummy);
    }
    else if (count == 2)
    {
    namee = dummy; 
    }
    else if (count == 3)
    {
     addresss = dummy;
     }
    else if (count == 4)
    {
   uid = Integer.parseInt(dummy);
     }
    else if (count == 5)
    {
 password = dummy; //5 
    b[bbk] = new Book(idd,namee,addresss,uid,password);
    bbk++;
   count = 0;
    }
    }
    
    }
    
    p[pp] = new Accounting_System(1,"Mehmood","ait",1,"kiran");
          LMS obj= new LMS(b,p);
        boolean loop = true;
        while (loop)
        {          
        System.out.println("press 1 for student");
        System.out.println("press 2 for librarian");
        System.out.println("press 3 for clerk");        
        System.out.println("press 4 for Accountant");
        //lib
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter ID");
        int id = sc.nextInt();
        System.out.println("Enter Password");
        String pswd = sc.next();
        if (n == 2)
        {
            int flag = 0;
            for (int i=0 ;i < obj.getCp() && flag == 0;i++)
            {
            if (obj.getpbyindex(i) instanceof Librarian)    
            {
                
            Librarian o = (Librarian) obj.getpbyindex(i);
           if ( o.getUid() == id && (o.getPswd()).equals(pswd))
           {
           flag =1;
           }
            }
            }
            if (flag == 1)
            { int ii=0;
            while(ii < 100)
            {        
                // id pswd matched
                System.out.println("1 for Search book by Title");
                System.out.println("2 for Search book by Author");            
                System.out.println("3 for Search book by Subject");               
                System.out.println("4 for add book"); // lib use cases
                System.out.println("5 for remove book");            
                System.out.println("6 for Edit book");            
                System.out.println("7 for renew a book");    // clerk use cases
                System.out.println("8 for View details about Loan");  
                System.out.println("9 for Issue Book");          
                System.out.println("10 for Updating Borrower info"); 
                System.out.println("11 for Returning Book"); 
                System.out.println("12 for Viewing info");            // student use case
                System.out.println("13 for list of currently borrowed");            
                System.out.println("14 for placing a book on hold");       
       
           int input = sc.nextInt();
           Book bbb =null;
           Book bbb1[] = null;
           if (input == 1) // Search by title
            {
            System.out.println("Enter Title");
            Scanner scan = new Scanner(System.in);
            String name="";

             name+=scan.nextLine();
             bbb = obj.SearchbyTitle(name);
             if (bbb != null)
             bbb.printdetails();
             else 
                System.out.println("Not found");
            }
           else  if (input == 2) //Search by author
            {
            System.out.println("Enter Author");
            String a = sc.next();
            bbb1 = obj.SearchByAuthor(a);
            if (bbb1 != null)
            for (int i=0 ;i < bbb1.length ; i++)
            {
            bbb1[i].printdetails();
            }
            else
                System.out.println("Not found");
            }
            else  if (input == 3) // Search by subject
            {
            System.out.println("Enter Subject");
            String t1 = sc.next();
            bbb1 = obj.SearchBySubject(t1);
            if (bbb1 != null)
            {
                for (int i=0 ;i < bbb1.length ; i++)
            {
            bbb1[i].printdetails();
            }
            }
            else
                System.out.println("Not found");
            }
           
           else if (input == 4) // Add book
            {
            System.out.println("Enter ISBN");
            int isbn = sc.nextInt();
            System.out.println("Enter Title");
            Scanner scan = new Scanner(System.in);
            String tt="";
            tt+=scan.nextLine();
            System.out.println("Enter Author");   
            String aa = sc.next();
            System.out.println("Enter Type");
            String aaa = sc.next();
            System.out.println("Enter Price");
            int price = sc.nextInt();
            obj.addBook(isbn, tt, aa, aaa, price);
            System.out.println("Added successfully");
            }
            
            else  if (input == 5)
            {
            System.out.println("Enter Title");
            Scanner scan = new Scanner(System.in);
            String name="";
            name+=scan.nextLine();
            obj.removeBookbyTitle(name);
            System.out.println("removed successfully");
            }
            
            else if (input == 6) // edit
            {
            System.out.println("Enter Title of Book that you want to edit");
            Scanner scan = new Scanner(System.in);
            String tt="";
            tt+=scan.nextLine();
            System.out.println("what you want to change ? 1  for change title 2 for ISBN 3 for author 4 for price"  );
            int in = sc.nextInt();
            if (in == 1)
            {
              System.out.println("Enter new title");
             String name="";
              name+=scan.nextLine();
             obj.editBookTitle(tt, name);
          }
          else if (in == 2)  
          {
              System.out.println("Enter new ISBN");
             int isbn = sc.nextInt();
            
              obj.editBookISBN(tt, isbn);
          }
            else if (in == 3)  
             {
                 System.out.println("Enter new author name");
                 String t2 = sc.next();    
                 obj.editBookAuthor(tt, t2);
            }
         else if (in == 4)  
         {
             System.out.println("Enter new price");
          int no = sc.nextInt();
            obj.editBookPrice(tt, no);
            }
            
            }
           else if (input == 12) // view info
            {
               Student o = null;
               System.out.println("Enter roll number : ");
          int no = sc.nextInt();
        o = obj.Searchbyrollno(no);
        if (o != null)
                o.print();
            else
         System.out.println("Student not found");
            
            }
            else if (input == 8) // book details
            {
                         Student o = null;
               System.out.println("Enter roll number : ");
          int no = sc.nextInt();
        o = obj.Searchbyrollno(no);
      
 if (o != null)
                o.OnLoanBooks();
            else
         System.out.println("Not found");
            
            }
            else if (input == 14) // place a book on hold
            {
                         Student o = null;
               System.out.println("Enter roll number : ");
          int no = sc.nextInt();
        o = obj.Searchbyrollno(no);
      
                 System.out.println("Enter Book name ");   
                 String tt2 = sc.next();
            Book book = obj.SearchbyTitle(tt2);
            if (o != null)
            {
                if (book != null)
            o.PlaceonHold(book);
            else 
                    System.out.println("Not found");
            }
            else
                    System.out.println("Roll no not correct");
            
            }
           
          else if (input == 10) // edit 
            {
             System.out.println("Enter student roll no. ");
             int no = sc.nextInt();
             System.out.println("what do you wanna change ? 1  for change address 2 for change number");
             int in = sc.nextInt();
          if (in == 1)
          {
           System.out.println("Enter new address");
           String address = sc.next();
           obj.editPersonAddress(no, address);
          }
          else if (in == 2)
          {
          System.out.println("Enter new number");
          String nn = sc.next();
            obj.editPersonNumber(no,nn);
             }
            }
            else  if (input == 9) // make a loan
            {
        System.out.println("enter id ");
        int i= sc.nextInt();
        System.out.println("enter title"); // will search for book obj
        String t2 = sc.next();
        Book bb1 = obj.SearchbyTitle(t2);
        if (bb1.isStatus()) 
        {
            System.out.println("enter issue Date");
        String d = sc.next();
        System.out.println("enter student roll no "); // will search for student obj
        int r = sc.nextInt();
        Book bb11 = obj.SearchbyTitle(t2);
        Student ss = obj.Searchbyrollno(r);
        Loan l = new Loan(i,bb11,d,ss);         
        ss.addLoan(l);
        bb11.addLoan(l);
    String due = l.getDueDate();
    System.out.println("Duedate is " + due);
        }
        else
                System.out.println("Book is not avaiable"); 
            }
  
            else if (input == 7) // renew a book
            {
            System.out.println("Enter rollno");
            int rn = sc.nextInt();
            System.out.println("Enter Title");
            String tt1 = sc.next();
            Student s1 = obj.Searchbyrollno(rn);
            Loan l1 = s1.SearchLoanByTitle(tt1);
if (l1 !=null)     
{ l1.printloanDetails();

            System.out.println("Enter Number of days for renew book");
            int days = sc.nextInt();
            l1.renewBook(days);
}
else
        System.out.println("You didn't make this loan");
            
            }
            else if (input == 11) // returning a book
            {
            System.out.println("Enter rollno");
            int rn = sc.nextInt();
            System.out.println("Enter Title");
            String tt1 = sc.next();
            Student s1 = obj.Searchbyrollno(rn);
            Loan l1 = s1.SearchLoanByTitle(tt1);
           if (l1 != null)
       {   
           l1.printloanDetails();
       
            System.out.println("Enter Date of return ");
            String Date = sc.next();
            l1.ReturnBook(Date);
            int fine = l1.total_fine();
       System.out.println("fine is " + fine);
       }
       else 
           System.out.println("not found");
  }           
    
  else if (input == 8) // Loan details
  {
               System.out.println("Enter rollno");
                 int rn = sc.nextInt();
            System.out.println("Enter Title");
             String tt1 = sc.next();
Student s1 = obj.Searchbyrollno(rn);
Loan l1 = s1.SearchLoanByTitle(tt1);
if (l1 != null)
l1.printloanDetails();
else
        System.out.println("You didn't make a loan");
            
}
            
              System.out.println("For menu again press 1");
              System.out.println("For logout press any key ");
              int q = sc.nextInt();
        if (q == 1)
        {

        }
        else
        {
                ii =1000000001;
        //loop = false;
        }
        }
            }
        // ................................................ clerk ...................................................  // 
        }
  if (n == 3)
  {
           int flag = 0;
            for (int i=0 ;i < obj.getCp() && flag == 0;i++)
            {
            if (obj.getpbyindex(i) instanceof Clerk)    
            {
                
            Clerk o = (Clerk) obj.getpbyindex(i);
           if (o.getUid() == id && o.getPswd().equals(pswd))
           {
           flag =1;
           }
            }
            }
            if (flag == 1)
            {
             int ii=0;
            while(ii < 100)
            {
               System.out.println("1 for Search book by Title");
               System.out.println("2 for Search book by Author");            
               System.out.println("3 for Search book by Subject");               
               System.out.println("4 for renew a book");    
               System.out.println("5 for View details about Loan");  
               System.out.println("6 for Issue Book");          
               System.out.println("7 for Updating Borrower info"); 
               System.out.println("8 for Returning Book");  
               // student cases
                   System.out.println("9 for Viewing info");            
             System.out.println("10 for list of currently borrowed");            
             System.out.println("11 for placing a book on hold");  
               
       
             Book bbb =null;
             Book bbb1[] = null;
             int input= sc.nextInt();
           if (input == 1) // Search by title
            {
            System.out.println("Enter Title");
            String t = sc.next();
            bbb = obj.SearchbyTitle(t);
            if (bbb != null)
            bbb.printdetails();
           else
                    System.out.println("Not found");
           }
            else  if (input == 2) // Search by author
            {
            System.out.println("Enter Author");
            String a = sc.next();
           bbb1 = obj.SearchByAuthor(a);
            if (bbb1 != null)
            {
                for (int i=0 ;i < bbb1.length ; i++)
            {
            bbb1[i].printdetails();
            }
            }
            else
                    System.out.println("Not found");
            
            }
            else  if (input == 3) // Search by subject
            {
            System.out.println("Enter Subject");
           String t1 = sc.next();
            bbb1 = obj.SearchBySubject(t1);
            if (bbb1 != null)
            {
                for (int i=0 ;i < bbb1.length ; i++)
            {
            bbb1[i].printdetails();
            }
            }
            else
              System.out.println("Not found");
            
            }
                         
          else if (input == 7) // edit 
            {
             System.out.println("Enter student roll no. ");
             int no = sc.nextInt();
             System.out.println("what you wanna change ? 1  for change address 2 for change number");
             int in = sc.nextInt();
          if (in == 1)
          {
           System.out.println("Enter new address");
           String address = sc.next();
           obj.editPersonAddress(no, address);
          }
          else if (in == 2)
          {
          System.out.println("Enter new number");
          String nn = sc.next();
            obj.editPersonNumber(no,nn);
             }
            }
            else  if (input == 6) // make a loan
            {
        System.out.println("enter id ");
        int i= sc.nextInt();
        System.out.println("enter title"); // will search for book obj
        String t2 = sc.next();
        Book bb1 = obj.SearchbyTitle(t2);
        if (bb1.isStatus()) 
        {
            System.out.println("enter issue Date");
        String d = sc.next();
        System.out.println("enter student roll no "); // will search for student obj
        int r = sc.nextInt();
        Book bb11 = obj.SearchbyTitle(t2);
        Student ss = obj.Searchbyrollno(r);
        Loan l = new Loan(i,bb11,d,ss);         
        ss.addLoan(l);
        bb11.addLoan(l);
    String due = l.getDueDate();
    System.out.println("Duedate is " + due);
        }
        else
                System.out.println("Book is not avaiable"); 
            }
  
            else if (input == 4) // renew a book
            {
            System.out.println("Enter rollno");
            int rn = sc.nextInt();
            System.out.println("Enter Title");
            String tt1 = sc.next();
            Student s1 = obj.Searchbyrollno(rn);
            Loan l1 = s1.SearchLoanByTitle(tt1);
if (l1 !=null)     
{ l1.printloanDetails();

            System.out.println("Enter Number of days for renew book");
            int days = sc.nextInt();
            l1.renewBook(days);
}
else
        System.out.println("You didn't make this loan");
            
            }
            else if (input == 8) // returning a book
            {
            System.out.println("Enter rollno");
            int rn = sc.nextInt();
            System.out.println("Enter Title");
            String tt1 = sc.next();
            Student s1 = obj.Searchbyrollno(rn);
            Loan l1 = s1.SearchLoanByTitle(tt1);
           if (l1 != null)
       {   
           l1.printloanDetails();
       
            System.out.println("Enter Date of return ");
            String Date = sc.next();
            l1.ReturnBook(Date);
            int fine = l1.total_fine();
       System.out.println("fine is " + fine);
       }
       else 
           System.out.println("not found");
  }           
    
  else if (input == 5) // Loan details
  {
               System.out.println("Enter rollno");
                 int rn = sc.nextInt();
            System.out.println("Enter Title");
             String tt1 = sc.next();
Student s1 = obj.Searchbyrollno(rn);
Loan l1 = s1.SearchLoanByTitle(tt1);
if (l1 != null)
l1.printloanDetails();
else
        System.out.println("You didn't make a loan");
            
}
  
    // student use case
            else if (input == 9) // view info
            {
                Student o=null;
                System.out.println("Enter roll number : ");
                int r = sc.nextInt();
                o  = obj.Searchbyrollno(r);
 if (o != null)
                o.print();
            else
         System.out.println("Student not found");
            
            }
            else if (input == 10) // book details
            {
                                Student o=null;
                System.out.println("Enter roll number : ");
                int r = sc.nextInt();
                o  = obj.Searchbyrollno(r);
 if (o != null)
                o.OnLoanBooks();
            else
         System.out.println("Not found");
            
            }
            else if (input == 11) // place a book on hold
            {
                                Student o=null;
                System.out.println("Enter roll number : ");
                int r = sc.nextInt();
                o  = obj.Searchbyrollno(r);
                 System.out.println("Enter Book name ");   
                 String tt2 = sc.next();
            Book book = obj.SearchbyTitle(tt2);
            if (o != null)
            {
                if (book != null)
            o.PlaceonHold(book);
            else 
                    System.out.println("Not found");
            }
            else
                    System.out.println("Roll no not correct");
            
            }
    
    
             
              System.out.println("For menu again press 1");
              System.out.println("For logout press any key ");
              int q = sc.nextInt();
        if (q == 1)
        {

        }
        else
        {
                ii =1000000001;
        //loop = false;
        }
        }
  }
            }
 
    //Student
        if (n == 1)
        {
            
            Student o=null;
           
            int flag  =0;
            for (int i=0 ;i < obj.getCp() && flag == 0;i++)
            {
            if (obj.getpbyindex(i) instanceof Student)    
            {
                
            o = (Student) obj.getpbyindex(i);
           if ( o.getUid() == id && o.getPswd().equals(pswd))
           {
           flag =1;
           }
            }
            }
            if (flag == 0)
            {
            System.out.println("id didnt match");
            }
            else if (flag == 1)
            {
            int ii=0;
            while(ii < 100)
            {
             System.out.println("1 for Search book by Title");
             System.out.println("2 for Search book by Author");            
             System.out.println("3 for Search book by Subject");      
             System.out.println("4 for Viewing info");            
             System.out.println("5 for list of currently borrowed");            
             System.out.println("6 for placing a book on hold");            
                        
            // take input 
            int input = sc.nextInt();
            if (input == 1) // Search by title
            {
            System.out.println("Enter Title");
            String t = sc.next();
             Book bbbb = obj.SearchbyTitle(t);
             if (bbbb != null)
           bbbb.printdetails();
 else
                     System.out.println("Not found");
           
            }
            else  if (input == 2) // Search by author
            {
            System.out.println("Enter Author");
              String a = sc.next();
         
            Book b11[] = obj.SearchByAuthor(a);
           if (b11 != null)
           {
               for (int i=0 ;i < b11.length ; i++ )
            b11[i].printdetails();
            }
            else
                    System.out.println("Not found");
            }
            else  if (input == 3)
            {
            System.out.println("Enter Subject");
            String a = sc.next();
         
            Book b11[] =     obj.SearchBySubject(a);
            if (b11 != null)
            {
                for (int i=0 ;i < b11.length ; i++ )
            b11[i].printdetails();
            }
                else
                    System.out.println("Not found");
            
            }
            else if (input == 4) // view info
            {
 if (o != null)
                o.print();
            else
         System.out.println("Student not found");
            
            }
            else if (input == 5) // book details
            {
 if (o != null)
                o.OnLoanBooks();
            else
         System.out.println("Not found");
            
            }
            else if (input == 6) // place a book on hold
            {
                 System.out.println("Enter Book name ");   
                 String tt2 = sc.next();
            Book book = obj.SearchbyTitle(tt2);
            if (o != null)
            {
                if (book != null)
            o.PlaceonHold(book);
            else 
                    System.out.println("Not found");
            }
            else
                    System.out.println("Roll no not correct");
            
            }
           
              System.out.println("For menu again press 1");
              System.out.println("For logout press any key ");
              int q = sc.nextInt();
        if (q == 1)
        {

        }
        else
        {
                ii =1000000001;
        //loop = false;
        }
        }
            
            
            }
        }
        else if (n == 4)
        {
            int flag = 0;
            for (int i=0 ;i < obj.getCp() && flag == 0;i++)
            {
            if (obj.getpbyindex(i) instanceof Accounting_System)    
            {
                
            Accounting_System o = (Accounting_System) obj.getpbyindex(i);
           if ( o.getUid() == id && (o.getPswd()).equals(pswd))
           {
           flag =1;
           }
            }
            }
            if (flag == 1)
            { int ii=0;
            while(ii < 100)
            {        
                // id pswd matched
                System.out.println("1 for calculate fine");
                System.out.println("2 for logout");        
                int input= sc.nextInt();
           if (input == 1) // Search by title
            {
               System.out.println("Enter student roll number");
               int rl = sc.nextInt();
               Student ss = obj.Searchbyrollno(rl);
    if (ss != null)
    {               int ff = obj.total_fine_paid(rl);
           System.out.println("Fine is " + ff);
            }
           }
           else
           {
           System.out.println("Student not found");
           }
           System.out.println("For menu again press 1");
              System.out.println("For logout press any key ");
              int q = sc.nextInt();
        if (q == 1)
        {

        }
        else
        {
                ii =1000000001;
        //loop = false;
        }    
            }
            }
        }
    }
        
    }
}
    