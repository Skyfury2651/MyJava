package entity;

import hannotation.Column;
import hannotation.Entity;
import hannotation.Id;
import hannotation.Validate;

import java.sql.Date;

@Entity(tableName = "account")
public class Account {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id(autoIncreament = true)
    @Column(columnName = "id", columnType = "int")
    private int id;

    @Column(columnName = "salt", columnType = "varchar(200)")
    private String salt;

    @Column(columnName = "password", columnType = "varchar(200)")
    private String hashPassword;

    @Column(columnName = "fullName", columnType = "varchar(200)")
    @Validate(required = true, requiredMessage = "Full name is required")
    private String fullName;

    @Column(columnName = "email", columnType = "varchar(200)")
    @Validate(requiredMessage = "Email can't be null", isEmail = true, required = true)
    private String email;

    @Column(columnName = "createdAt", columnType = "date")
    private Date createdAt;

    @Column(columnName = "updatedAt", columnType = "date")
    private Date updatedAt;

    @Column(columnName = "deletedAt", columnType = "date")
    private Date deletedAt;

    @Column(columnName = "status", columnType = "int(20)")
    private boolean status;
}
