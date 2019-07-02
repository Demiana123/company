import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.JavaBean;
import java.sql.*;
import java.util.ArrayList;

public class hello {
    public static void main(String[] args)
    {
        JFrame f=new JFrame("company");
        f.setLayout(new FlowLayout());
        f.add(new JLabel("Emolyee Id:"));
        JTextField id=new JTextField(10);
        f.add(id);
        f.add(new JLabel("Emolyee birthdate:"));
        JTextField birthday=new JTextField(10);
        f.add(birthday);
        f.add(new JLabel("Emolyee firstName:"));
        JTextField firstname=new JTextField(10);
        f.add(firstname);
        f.add(new JLabel("Emolyee lastName:"));
        JTextField lastname=new JTextField(10);
        f.add(lastname);
        f.add(new JLabel("Emolyee hiredate:"));
        JTextField hiredate=new JTextField(10);
        f.add(hiredate);
        f.add(new JLabel("Emolyee's department Id:"));
        JTextField deptId=new JTextField(10);
        f.add(deptId);
        JButton insert=new JButton("Insert");
        JButton update =new JButton("Update");
        JButton delete =new JButton("Delete");
        JButton displayAll =new JButton("Display All");
        JButton search =new JButton("Search");
        f.add(insert);
        f.add(update);
        f.add(delete);
        f.add(displayAll);
        f.add(search);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
        f.setSize(500,500);
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String username="ahmed";
        String password="12345";
        String url="jdbc:sqlserver://localhost;database=company";
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName(driver);
                    Connection con= DriverManager.getConnection(url,username,password);
                    String sql="SET IDENTITY_INSERT employees ON "+"insert into employees"+"(emp_no,birth_date,first_name,last_name,hire_date,dept_no)"+
                            "values(?,?,?,?,?,?)" +"SET IDENTITY_INSERT employees OFF";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1,id.getText());
                    pst.setString(2,birthday.getText());
                    pst.setString(3,firstname.getText());
                    pst.setString(4,lastname.getText());
                    pst.setString(5,hiredate.getText());
                    pst.setString(6,deptId.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(f,"inserted successfully");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(f,ex.getMessage());
                    System.out.println(ex.getMessage());
                }
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName(driver);
                    Connection con= DriverManager.getConnection(url,username,password);
                    String sql="update employees set birth_date=?,first_name=?,last_name=?,hire_date=?,dept_no=? where emp_no=?";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1,birthday.getText());
                    pst.setString(2,firstname.getText());
                    pst.setString(3,lastname.getText());
                    pst.setString(4,hiredate.getText());
                    pst.setString(5,deptId.getText());
                    pst.setString(6,id.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(f,"updated successfully");
                }
                catch(Exception ex)
                {

                    JOptionPane.showMessageDialog(f,ex.getMessage());
                    System.out.println(ex.getMessage());
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName(driver);
                    Connection con= DriverManager.getConnection(url,username,password);
                    String sql="delete from employees  where emp_no=?";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1,id.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(f,"deleted successfully");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(f,ex.getMessage());
                    System.out.println(ex.getMessage());
                }
            }
        });
        displayAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show_employee("");
            }

        });
    search.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //showuser
            JFrame f2=new JFrame("searching");
            f2.setLayout(new FlowLayout());
            f2.setSize(500,200);
            JLabel lbl1=new JLabel("Enter FirstName");
            JTextField searchkey=new JTextField(10);
            JButton okay=new JButton("Okay");
            f2.add(lbl1);
            f2.add(searchkey);
            f2.add(okay);
            f2.setVisible(true);

        //
            okay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    show_employee(searchkey.getText());
                }
            });
        }
    });
    }
    public static ArrayList<employee> userList(String x)
    {

        ArrayList<employee> usersList=new ArrayList<employee>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=company", "ahmed", "12345");
            String query1 = " ";
            //check if x is empty so display all
            if(x=="") {
                query1 = "SELECT * FROM employees";
            }
                // if x is not empty so we need to update our query
            else {
                query1 = "SELECT * FROM employees where first_name like '%"+x+"%'";
            }
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery(query1);
            employee employee;
            while(rs.next())
            {
                employee = new employee(rs.getInt("emp_no"),rs.getString("first_name"),
                        rs.getString("last_name"),rs.getString("birth_date"),rs.getString("hire_date"),rs.getInt("dept_no"));
                usersList.add(employee);
                System.out.println(employee);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        return usersList;
    }
    public static void show_employee(String x)
    {
        JFrame f1=new JFrame("Displaying data");
        JTable table = new JTable(new DefaultTableModel(new Object[]{"ID", "FirstName","LastName","BirthDate","HireDate","DepartmentId"},0));
        DefaultTableModel model1=(DefaultTableModel) table.getModel();
        model1.addRow(new Object[]{"ID", "FirstName","LastName","BirthDate","HireDate","DepartmentId"});
        table.setEnabled(false);
        f1.setSize(500, 500);
        f1.setVisible(true);
        f1.add(table);
        ArrayList<employee> List=userList(x);
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        Object[] row=new Object[6];
        for(int i=0;i<List.size();i++)
        {
            row[0]=List.get(i).getEmployee_id();
            row[3]=List.get(i).getBirth_date();
            row[1]=List.get(i).getEmployee_firstname();
            row[2]=List.get(i).getEmployee_lastname();
            row[4]=List.get(i).getHire_date();
            row[5]=List.get(i).getDepartment_id();
            model.addRow(row);
        }
    }
}