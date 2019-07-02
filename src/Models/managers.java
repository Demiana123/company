package Models;


public class managers {
    private int manager_id;
    private String manager_firstname;
    private String manager_lastname;
    private String manager_birthdate;
    private String manager_hiredate;
    private int department_id;

    //constructor
    public managers(int manager_id,String manager_firstname,String manager_lastname,String manager_birthdate,String manager_hiredate,int department_id) {
        this.manager_id=manager_id;
        this.manager_firstname=manager_firstname;
        this.manager_lastname=manager_lastname;
        this.manager_birthdate=manager_birthdate;
        this.manager_hiredate=manager_hiredate;
        this.department_id=department_id;
    }

    //getters and setters
    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_firstname() {
        return manager_firstname;
    }

    public void setManager_firstname(String manager_firstname) {
        this.manager_firstname = manager_firstname;
    }

    public String getManager_lastname() {
        return manager_lastname;
    }

    public void setManager_lastname(String manager_lastname) {
        this.manager_lastname = manager_lastname;
    }

    public String getManager_birthdate() {
        return manager_birthdate;
    }

    public void setManager_birthdate(String manager_birthdate) {
        this.manager_birthdate = manager_birthdate;
    }

    public String getManager_hiredate() {
        return manager_hiredate;
    }

    public void setManager_hiredate(String manager_hiredate) {
        this.manager_hiredate = manager_hiredate;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
