package account;

import Person.Person;

public class DepartmentAccount extends Account{
    
    public DepartmentAccount(long Id, String Password, Position position, Person person) {
        super(Id, Password, position, person);
    }
    
     public DepartmentAccount(Account account) {
        super(account);
    }
}
