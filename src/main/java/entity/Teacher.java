package entity;

import hannotation.Column;
import hannotation.Entity;
import hannotation.Id;


@Entity(tableName = "giangvien")
public class Teacher {

    @Id(autoIncreament = true)
    @Column(columnName = "khoaChinh", columnType = "int")
    private int id;
    @Column(columnName = "nameOfTeacher", columnType = "varchar(250)")
    private String nameOfTeacher;
    @Column(columnName = "emailOfTeacher", columnType = "varchar(250)")
    private String emailOfTeacher;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", nameOfTeacher='" + nameOfTeacher + '\'' +
                ", emailOfTeacher='" + emailOfTeacher + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public String getEmailOfTeacher() {
        return emailOfTeacher;
    }

    public void setEmailOfTeacher(String emailOfTeacher) {
        this.emailOfTeacher = emailOfTeacher;
    }
}
