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
public class Person {
    protected int pid;
    protected String name;
    protected String address;
protected int uid;
    protected String pswd;

    public Person(int pid, String name, String address, int uid, String pswd) {
        this.pid = pid;
        this.name = name;
        this.address = address;
        this.uid = uid;
        this.pswd = pswd;
    }

    public Person() {
    }
   
    
}
