package com.raj;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;

public class newaction extends ActionSupport {

    private String name, mail, company;
    private Integer num, id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String execute() {
        property p = new property();
        try {
            Connection cn = p.connection();
            Statement stmt = cn.createStatement();

            int r = stmt.executeUpdate("insert into details (number,name,mail,company) values(" + num + ",'" + name + "','" + mail + "','" + company + "')");
            ResultSet rs = stmt.executeQuery("select * from details");
            System.out.println("Created...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("name:" + name + "\nnum:" + num + "\nmail:" + mail + "\ncompany:" + company);
        return "success";
    }

    public String display() {
        property p = new property();
        try {
            Connection cn = p.connection();
            Statement stmt = cn.createStatement();

//            ResultSet r = stmt.executeQuery("SELECT COUNT(id) FROM details");
//            r.next();
//            System.out.println("result set r: " + r.getInt(1));
            ResultSet rs = stmt.executeQuery("select * from details where id = 1");
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                num = rs.getInt(3);
                mail = rs.getString(4);
                company = rs.getString(5);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }

    public String edit() {
        property p = new property();
        try {
            Connection cn = p.connection();
            Statement stmt = cn.createStatement();

            int i = stmt.executeUpdate("update details SET name = '"+name+"', number= "+num+", mail= '"+mail+"', company= '"+company+"' WHERE id ="+id+";");
            if(i ==1)
                return "success";
            else
                return "error";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String delete()
    {
        property p = new property();
        try {
            Connection cn = p.connection();
            Statement stmt = cn.createStatement();

            int i = stmt.executeUpdate("delete from details where id=+"+id+";");
            if(i==0)
                return "error";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
