package account;

import Person.Person;
import java.util.Objects;

public class Account {
    private long id;
    private String password;
    private Position position;
    private Person person;

    public Account(long Id, String Password, Position position, Person person) {
        this.id = id;
        this.password = password;
        this.position = position;
        this.person = person;
    }
    
    public Account(Account account){
        this.id=account.id;
        this.password=account.password;
        this.person=account.person;
    }
 
    public boolean equals(Object obj) {
        
    }
    
}
