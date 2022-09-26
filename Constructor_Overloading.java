public class Constructor_Overloading {
    // parameter declared
    String subject;
    int mark;
    // creating different constructors with same name and different parameters
    Constructor_Overloading(String Subject,int Mark){
        subject = Subject;
        mark = Mark;
    }
    Constructor_Overloading(String Subject){
        subject = Subject;
        mark = 00;
    }
    Constructor_Overloading(){
        subject = null;
        mark = 00;
    }

    public static void main(String[] args) {
        //here we are creating objects of all constructors
        Constructor_Overloading Constructor1 = new Constructor_Overloading("Mathematics", 80);
        System.out.println("Subject is "+Constructor1.subject + "   Mark is " + Constructor1.mark);
        Constructor_Overloading Constructor2 = new Constructor_Overloading("Mathematics");
        System.out.println("Subject is "+Constructor2.subject + "   Mark is " + Constructor2.mark);
        Constructor_Overloading Constructor3 = new Constructor_Overloading();
        System.out.println("Subject is "+Constructor3.subject + "   Mark is " + Constructor3.mark);
    }

}
