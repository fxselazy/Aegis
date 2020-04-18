package account;

import java.util.Objects;
import person.Person;

public class Account {

    private long Id;
    private String password;
    private Person person;
    private Position position;

    public Account(long Id, String password, Person person, Position position) {
        this.Id = Id;
        this.password = password;
        this.person = person;
        this.position = position;
    }

//    public Account(Account account) {
//        super(account);
//    }

    public long getId() {
        return Id;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public Position getPosition() {
        return position;
    }
  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (this.position != other.position) {
            return false;
        }
        return true;
    }

}
