package application.springmvc_hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String phoneNumber;
    private Integer flatNum;
    private Integer numCount;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(Integer flatNum) {
        this.flatNum = flatNum;
    }

    public Integer getNumCount() {
        return numCount;
    }

    public void setNumCount(Integer numCount) {
        this.numCount = numCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        if (flatNum != null ? !flatNum.equals(user.flatNum) : user.flatNum != null) return false;
        return numCount != null ? numCount.equals(user.numCount) : user.numCount == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + (flatNum != null ? flatNum.hashCode() : 0);
        result = 31 * result + (numCount != null ? numCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", flatNum=" + flatNum +
                ", numCount=" + numCount +
                '}';
    }
}
