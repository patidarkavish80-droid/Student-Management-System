import java.util.ArrayList;
import java.util.Scanner;

class student{
    String name ;
    int rollno;
    double marks;
    student(String name ,int rollno,double marks){
        this.name=name;
        this.rollno=rollno;
        this.marks=marks;
    }void Display(){
        System.out.println();
        System.out.println("ROLL NO : "+rollno);
        System.out.println("NAME : "+name);
        System.out.println("MARKS : "+marks);

    }
    void grade() {
        if (marks >= 90) {
            System.out.println("GRADE : " + 'A');
        } else if (marks >= 75) {
            System.out.println("GRADE : " + 'B');
        } else if (marks >= 60) {
            System.out.println("GRADE : " + 'C');
        } else {
            System.out.println("GRADE : " + 'D');
        }
        if (marks >= 40) {
            System.out.println("Status : PASS");
        } else {
            System.out.println("Status : FAIL");
        }
        System.out.println();
    }
}
class Main {
    static ArrayList<student> num = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.println();
        System.out.print("ENTER ROLL NUMBER : ");
        int Roll_num = sc.nextInt();
        sc.nextLine();
        for(int i =0;i< num.size();i++){
            if(num.get(i).rollno==Roll_num){
                System.out.println("Student with this roll no already exist");
                return;
            }
        }

        System.out.print("ENTER NAME : ");
        String name = sc.nextLine();
        System.out.print("ENTER MARKS : ");
        int marks = sc.nextInt();
        if (marks <= 100 && marks >= 0) {
            student s = new student(name, Roll_num, marks);
            num.add(s);
            System.out.println("Student added successfully");
        }else {
            System.out.println("Invalid marks");
        }
    }

    static void search_student() {
        System.out.println();
        System.out.print("ENTER ROLL NO : ");
        int rollno = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).rollno == rollno) {
                System.out.println("NAME : " + num.get(i).name);
                System.out.println("MARKS : " + num.get(i).marks);
                num.get(i).grade();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }

    static void Display_student() {
        for (int i = 0; i < num.size(); i++) {
            num.get(i).Display();
            num.get(i).grade();
        }
    }

    static void Delete_student() {
        System.out.print("ENTER ROLL NUM : ");
        int Roll_num = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).rollno == Roll_num) {
                num.remove(i);
                System.out.println("Delete successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found");
        }
    }

    static void Update_student() {
        System.out.print("ENTER ROLL NUM : ");
        int Roll_num = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).rollno == Roll_num) {
                System.out.print("ENTER NEW MARKS : ");
                int marks = sc.nextInt();
                num.get(i).marks = marks;
                System.out.println("Marks Update Successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found");
        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("==================== STUDENT MANAGEMENT SYSTEM =====================");
            System.out.println("1.ADD STUDENT");
            System.out.println("2.DISPLAY STUDENT");
            System.out.println("3.SEARCH STUDENT");
            System.out.println("4.UPDATE STUDENT");
            System.out.println("5.DELETE STUDENT");
            System.out.println("6.EXIT");
            System.out.println();
            System.out.print("ENTER CHOICE : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2 :
                        Display_student();
                        break;
                case 3:
                    search_student();
                    break;
                case 4:
                    Update_student();
                    break;
                case 5:
                    Delete_student();
                    break;
                case 6:
                    System.out.println(" THANK YOU ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");


            }

        }
    }
}