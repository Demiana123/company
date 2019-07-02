//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Objects;
//
//class company
//{
//    private String name;
//    //employee[][] employees;
//    employee[] employees;
//    public company(String name)
//    {
//        this.name=name;
//        employees = new employee[100];
//    }
//    public void insertemployees(employee[] emp)
//    {
////        for(int i=0;i<emp.length;i++)
////        {
////            for(int j=0;i<emp[i].length;j++)
////            {
////                employees[i][j]=emp[i][j];
////            }
////
////        }
//        for(int i=0;i<emp.length;i++)
//        {
//            employees[i]=emp[i];
//        }
//    }
//}
//abstract class employee
//{
//    protected final int id;
//    protected String name;
//    protected int salary;
//    protected String department;
//    public employee()
//    {
//        this(0,"",0,"");
//    }
//    public  employee(int id,String name,int salary,String department)
//    {
//        this.id=id;
//        this.name=name;
//        this.salary=salary;
//        this.department=department;
//    }
//    public abstract employee get_Employee_info();
//}
//class part_time extends employee
//{
//    private int work_hours;
//
//    public part_time(int id,String name,int salary,String department,int work_hours)
//    {
//        super(id,name,salary,department);
//        this.work_hours=work_hours;
//    }
//
//    @Override
//    public employee get_Employee_info() {
//
//        return this;
//    }
//}
//class full_time extends employee
//{
//    private int insurance_no;
//
//    public full_time(int id,String name,int salary,String department,int insurance_no)
//    {
//        super(id,name,salary,department);
//        this.insurance_no=insurance_no;
//    }
//
//    @Override
//    public employee get_Employee_info() {
//        return this;
//    }
//}
//public class HcHome {
//
//    static employee global ;
//    static company c ;
//    static employee[] emp ;
//    static int count=0;
//    public static void main(String[] args) {
//
//        JFrame company = new JFrame("Company");
//        company.setLayout(new FlowLayout());
//        JLabel companyname = new JLabel("Company Name");
//        JTextField nameofcompany = new JTextField(10);
//        JLabel Employees_count = new JLabel("Employees_count");
//        JTextField countofemployees = new JTextField(10);
//        JButton add = new JButton("Add Employee");
//        JTable table = new JTable(new DefaultTableModel(new Object[]{"ID", "Name","Department","Salary","Kind of employees"},0));
//        DefaultTableModel model=(DefaultTableModel) table.getModel();
//        model.addRow(new Object[]{"ID", "Name","Department","Salary","Kind of employees"});
//        table.setEnabled(false);
//        company.setSize(500, 500);
//        company.setVisible(true);
//        company.add(companyname);
//        company.add(nameofcompany);
//        company.add(Employees_count);
//        company.add(countofemployees);
//        company.add(add);
//        company.add(table);
//        c = new company(companyname.getText());
//
//        company.setDefaultCloseOperation(company.EXIT_ON_CLOSE);
//        add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (nameofcompany.getText().isEmpty() || countofemployees.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(company, "Please fill all the data", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                else {
//                    emp = new employee[Integer.valueOf(countofemployees.getText())];
//
//                    if (Integer.valueOf(table.getRowCount() - 1) == Integer.valueOf(countofemployees.getText())) {
//
//                        JOptionPane.showMessageDialog(company, "you already inserted 2 employees", "Error", JOptionPane.WARNING_MESSAGE);
//                    } else {
//                        company.setVisible(false);
//                        JFrame employee = new JFrame("Employee");
//                        employee.setLayout(new FlowLayout());
//                        employee.setSize(500, 500);
//                        String[] options = {"Choose kind of employee", "full time", "part time"};
//                        JComboBox kindofemployee = new JComboBox(options);
//                        kindofemployee.setSelectedIndex(0);
//                        kindofemployee.setBounds(50, 50, 50, 50);
//                        JLabel id = new JLabel("ID");
//                        JTextField idtxt = new JTextField(10);
//                        JLabel name = new JLabel("Name");
//                        JTextField nametxt = new JTextField(10);
//                        JLabel department = new JLabel("Department");
//                        JTextField departmenttxt = new JTextField(10);
//                        JLabel salary = new JLabel("Salary");
//                        JTextField salarytxt = new JTextField(10);
//                        JButton add2 = new JButton("Add");
//                        employee.add(kindofemployee);
//                        employee.add(id);
//                        employee.add(idtxt);
//                        employee.add(name);
//                        employee.add(nametxt);
//                        employee.add(department);
//                        employee.add(departmenttxt);
//                        employee.add(salary);
//                        employee.add(salarytxt);
//                        JLabel insurance_no = new JLabel("Insurance_no");
//                        JTextField insurancetxt = new JTextField(10);
//                        employee.add(insurance_no, BorderLayout.WEST);
//                        employee.add(insurancetxt);
//                        insurance_no.setVisible(false);
//                        insurancetxt.setVisible(false);
//                        JLabel workHourslbl = new JLabel("Work_Hours");
//                        JTextField workHrsText = new JTextField(10);
//                        employee.add(workHourslbl, BorderLayout.WEST);
//                        employee.add(workHrsText);
//                        workHourslbl.setVisible(false);
//                        workHrsText.setVisible(false);
//                        kindofemployee.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                if (kindofemployee.getSelectedItem() == "full time") {
//                                    insurance_no.setVisible(true);
//                                    insurancetxt.setVisible(true);
//                                    workHourslbl.setVisible(false);
//                                    workHrsText.setVisible(false);
//                                } else if (kindofemployee.getSelectedItem() == "part time") {
//                                    insurance_no.setVisible(false);
//                                    insurancetxt.setVisible(false);
//                                    workHourslbl.setVisible(true);
//                                    workHrsText.setVisible(true);
//                                } else {
//                                    JOptionPane.showMessageDialog(employee, "This is not an option");
//                                }
//                            }
//                        });
//                        employee.add(add2);
//                        employee.setVisible(true);
//                        employee.setDefaultCloseOperation(employee.EXIT_ON_CLOSE);
//                        kindofemployee.setBounds(100, 100, 200, 50);
//                        add2.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                if (idtxt.getText().isEmpty() || nametxt.getText().isEmpty() || departmenttxt.getText().isEmpty() || salarytxt.getText().isEmpty()||kindofemployee.getItemCount()==0) {
//                                    JOptionPane.showMessageDialog(employee, "Please fill all the data", "Error", JOptionPane.ERROR_MESSAGE);
//                                }
//                                else{
//                                    int id = Integer.valueOf(idtxt.getText());
//                                    String name = nametxt.getText();
//                                    String department = departmenttxt.getText();
//                                    int salary = Integer.valueOf(salarytxt.getText());
//                                    if (kindofemployee.getSelectedItem() == "part time") {
//                                        int workhours = Integer.valueOf(workHrsText.getText());
//                                        global = new part_time(id, name, salary, department, workhours);
//                                        emp[table.getRowCount() - 1] = global;
//                                        DefaultTableModel model = (DefaultTableModel) table.getModel();
//                                        model.addRow(new Object[]{global.id, global.name, global.department, global.salary, kindofemployee.getSelectedItem()});
//                                    } else if (kindofemployee.getSelectedItem() == "full time") {
//                                        int insurancenumber = Integer.valueOf(insurancetxt.getText());
//                                        global = new full_time(id, name, salary, department, insurancenumber);
//                                        emp[table.getRowCount() - 1] = global;
//
//                                        DefaultTableModel model = (DefaultTableModel) table.getModel();
//                                        model.addRow(new Object[]{global.id, global.name, global.department, global.salary, kindofemployee.getSelectedItem()});
//                                    }
//                                    employee.setVisible(false);
//                                    company.setVisible(true);
//                                    company company1 = new company(nameofcompany.getText());
//                                    employee array[] = new employee[Integer.valueOf(countofemployees.getText())];
//                                    while (count < Integer.valueOf(countofemployees.getText())) {
////                            employee[][] emps = new employee[Integer.valueOf(countofemployees.getText())][5];
////                            employee arr[]={id,name,department,salarytxt.getText(),kindofemployee.getSelectedItem().toString()};
////                            for (int i = 0; i < Integer.valueOf(countofemployees.getText()); i++) {
////
////                                    arr[0]=""+id;
////                                    arr[1]=name;
////                                    arr[0]=department;
////                                    arr[0]=""+salary;
////                                    arr[0]=""+kindofemployee.getSelectedItem();
////                                    emps[i]=arr;
////                            }
////                            Objects data[][]=new Object[Integer.valueOf(countofemployees.getText())][5];
////                            //employee[] arr=new employee[Integer.valueOf(countofemployees.getText())];
////                            Object[]arr2={global.id,global.name,global.department,global.salary,kindofemployee.getSelectedItem()};
////                            for(int i=0;i<Integer.valueOf(countofemployees.getText());i++)
////                            {
////
////                                data[i]=arr2;
////                            }
//
//                                        array[count] = global;
//                                        count++;
//                                    }
//                                    if (count == Integer.valueOf(countofemployees.getText())) {
//                                        company1.insertemployees(array);
//                                    }
//                                }
//                            }
//
//                        });
//                    }
//                }
//            }
//        });
//    }
//
//}