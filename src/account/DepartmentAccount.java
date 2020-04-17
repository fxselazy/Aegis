package account;

import person.Person;

public class DepartmentAccount extends Account {

    public DepartmentAccount(long Id, String password, Person person, Position position) {
        super(Id, password, person, position);
    }

   
}
