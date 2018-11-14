
Q. ResultSet.TYPE_SCROLL_INSENSITIVE means ? 


 
 1). ResultSet is insensitive to scrolling 

 2). Resultset is sensitive to scrolling, but insensitive to updates, i.e. not updateable 

 3). ResultSet is sensitive to scrolling, but insensitive to changes made by others 

 4). Depends on the type of data source, and the type and version of the driver you use with 
this data source 
 
Solution :
option  [3] is correct 

Q. Select the  false statements regarding type 4 driver: 


 
 1). Type 4 driver is "native protocol, pure java" driver 

 2). Type 4 drivers are 100% Java compatible 

 3). Type 4 drivers uses Socket class to connect to the database 

 4). Extra software is required at client side or server side. 
 
Solution :
option  [4] is correct 

Q. Consider the following code and predict the output. Consider the table is empty:

 String sql = "SELECT * FROM  ShowDetails";
   ShowBean showBean = null;
   List<ShowBean> shows = new ArrayList<ShowBean>();
   Statement statement = con.createStatement();
    rs = statement.executeQuery(sql);
    while (rs.next()) {
     showBean = new ShowBean();
     showBean.setShowId(rs.getString("ShowId"));
     showBean.setShowName(rs.getString("ShowName"));
     showBean.setLocation(rs.getString("Location"));
     showBean.setShowDate(rs.getDate("ShowDate").toString());
     showBean.setAvSeats(rs.getInt("AvSeats"));
     showBean.setPriceTicket(rs.getFloat("PriceTicket"));
     shows.add(showBean);

    } 


 
 1). ArrayList contains all the records from the table 

 2). ArrayList contains only the first record from the table 

 3). ArrayList contains only the last record from the table 

 4). Shows ArrayList is empty  
 
Solution :
option  [4] is correct 

Q. Consider the following code and predict the output :

 String sql = "UPDATE ShowDetails SET AvSeats=? WHERE ShowId=?";
   preStatement = con.prepareStatement(sql);
   preStatement.setInt(1, 5);
   preStatement.setString(2, "S102");
   preStatement.executeQuery(); 
 

 
 1). Compilation error as executeQuery is used to execute a DML statement 

 2). Runtime error as executeQuery is used to execute a DML statement 

 3). No error. Table gets updated 

 4). No error but table does not get updated  
 
Solution :
option  [3] is correct 

Q. Select the true statements about JDBC transactions: 


 
 1). A transaction is a set of successfully executed statements in the database 

 2). A transaction is finished when commit() or rollback() is called on the Connection object 

 3). JDBC Connection is in auto-commit mode, which it is by default, every SQL statement is 
committed to the database upon its completion. 

 4). A transaction is a set of actions to be carried out as a single, atomic action 
 
Solution :
option  [3,4] are correct 

Q. Consider the following code and guess the output:

 String sql="SELECT request_id FROM cab_request";
 Statement stmt = con.createStatement();
 ResultSet rSet = stmt.executeQuery(sql);
   
    rSet.next();
    rSet.getString(1);
     rSet.getString(1);
    System.out.println(rSet.getString(1)); 


 
 1). Compilation error as rs.getString(1) is written more than once 

 2). No error. 1st row, 1st column value is printed once 

 3). No error. 1st row, 1st column value is printed thrice 

 4). SQLException as the same column value is being read more than once 
 
Solution :
option  [2] is correct 

Q. Consider the following stored procedure and identify the JDBC interfaces 
 which can be used to call this stored procedure.

 CREATE OR REPLACE PROCEDURE addNumbers(num1 NUMBER ,num2 NUMBER) AS
 BEGIN
 DBMS_OUTPUT.PUT_LINE(num1+num2);
 END;
 / 


 
 1). Statement 

 2). PreparedStatement 

 3). CallableStatement 

 4). ResultSet 
 
Solution :
option  [1,2,3] are correct 

Q. Consider the following code and choose the right java code to call this procedure:

 CREATE OR REPLACE PROCEDURE updateSeats(show VARCHAR2,numOfSeats NUMBER,status OUT VARCHAR2) AS
 BEGIN
 UPDATE ShowDetails SET AvSeats=numOfSeats WHERE ShowId=show;
 IF SQL%FOUND  THEN 
 status:='true';
 ELSE
 status:='false';
 END IF;
 END;
 / 
 

 
 1). CallableStatement cst = 
 conn.prepareCall
 ("{call updateSeats(?,?,?)}");
 cst.setString(1, "S101");
 cst.setInt(2,30);
 cst.registerOutParameter(3, Types.VARCHAR);
 cst.execute();
 String seatsUpdated = cst.getString(3);
 System.out.println("Seats updated :" + seatsUpdated); 

 2). Statement cst = 
 conn.prepareStatement
 ("{call updateSeats(?,?,?)}");
 cst.setString(1, "S101");
 cst.setInt(2,30);
 cst.registerOutParameter(3, Types.VARCHAR);
 cst.execute();
 String seatsUpdated = cst.getString(3);
 System.out.println("Seats updated :" + seatsUpdated); 

 3). Statement cst = 
 conn.createStatement
 ("{call updateSeats(?,?,?)}");
 cst.setString(1, "S101");
 cst.setInt(2,30);
 cst.execute();
 String seatsUpdated = cst.getString(3);
 System.out.println("Seats updated :" + seatsUpdated); 

 4). PreparedStatement cst = 
 conn.prepareStatement
 ("{call updateSeats(?,?,?)}");
 cst.setString(1, "S101");
 cst.setInt(2,30);
 cst.execute();
 String seatsUpdated = cst.getString(3);
 System.out.println("Seats updated :" + seatsUpdated); 
 
Solution :
option  [1] is correct 

Q. Consider the following code and predict the output.
 Assume emp table exists in the database with 5 employee records

 CREATE OR REPLACE PROCEDURE fetchDetails(dno dept.deptno%type) AS

 ROW EMP%ROWTYPE;
 BEGIN

 SELECT * INTO ROW FROM EMP WHERE  deptno =dno;
 DBMS_OUTPUT.PUT_LINE(ROW.EMPNO || ROW.ENAME ||ROW.DEPTNO);
 END;
 / 
 

 
 1). No error at both compilation and execution time.  

 2). Error: exact fetch returns more than requested number of rows is displayed during procedure 
compilation time  

 3). Error: exact fetch returns more than requested number of rows is displayed during procedure call 

 4). Procedure is executed and displays correct output 
 
Solution :
option  [3] is correct 

Q. Which of the given options is most appropriate for line 3 ? 
 Assume sequence exists in the database
 ......
 String sql="SELECT empseq.nextval FROM dual";
   Statement stmt = con.createStatement();
   ResultSet rSet = stmt.executeQuery(sql);
   //line 3
   return rSet.getInt(1); 
 

 
 1). while(rSet.next() 

 2). if(rSet.next()) 

 3). for(rSet.next()) 

 4). No statement is required 
 
Solution :
option  [2] is correct 

Q. SQL> desc cab_request
  Name                                      Null?    Type
  ----------------------------------------- -------- ------------
 REQUEST_ID                                         NUMBER

 What would the following code give as output ?
 String sql="SELECT request_id FROM cab_request";
 Statement stmt = con.createStatement();
 ResultSet rSet = stmt.executeQuery(sql);
 rSet.next();
 System.out.println(rSet.getString(1));

 Assume rows exist in the table: 
 

 
 1). Compilation error as datatype of column is number and java code has specified string  

 2). SQLException gets thrown as Oracle cannot convert number into string 

 3). No error. Column value is displayed 

 4). NumberFormatException get thrown 
 
Solution :
option  [3] is correct 

Q. Which of the following are true about execute method of Statement/PreparedStatement? 
 

 
 1). It is used to execute DDLcommands 

 2). It is used to execute DMLcommands 

 3). The return type of this method is boolean 

 4). The return type of this method is int 
 
Solution :
option  [1,3] are correct 

Q. Consider the following code and predict the output:
 Assume table contains 5 records

 public List<ShowBean> showAllMovies() throws BookingException{
   List<ShowBean> shows = new ArrayList<ShowBean>();
   String sql = "SELECT * FROM  ShowDetails";
   ShowBean showBean = null;
    Statement statement = con.createStatement();
   ResultSet rSet = statement.executeQuery(sql);
 rSet.next();
    while (rSet.next()) {
     showBean = new ShowBean();
     showBean.setShowId(rSet.getString("ShowId"));
 showBean.setShowName(rSet.getString("ShowName"));
 shows.add(showBean);
 }} 


 
 1). The arraylist contains all the records of the showdetails table 

 2). The arraylist contains all the records of the showdetails table except the last record 

 3). The arraylist contains all the records of the showdetails table except the first record 

 4). ArrayList is empty  
 
Solution :
option  [3] is correct

Q. Consider the following code and predict the output:
 Assume table contains 5 records

 public List<ShowBean> showAllMovies() throws BookingException{
   List<ShowBean> shows = new ArrayList<ShowBean>();
   String sql = "SELECT * FROM  ShowDetails";
   ShowBean showBean = null;
    Statement statement = con.createStatement();
   ResultSet rSet = statement.executeQuery(sql);
 rSet.next();
    while (rSet.next()) {
     showBean = new ShowBean();
     showBean.setShowId(rSet.getString("ShowId"));
 showBean.setShowName(rSet.getString("ShowName"));
 shows.add(showBean);
 }} 


 
 1). The arraylist contains all the records of the showdetails table 

 2). The arraylist contains all the records of the showdetails table except the last record 

 3). The arraylist contains all the records of the showdetails table except the first record 

 4). ArrayList is empty  
 
Solution :
option  [3] is correct 


Q. Refer to the below code and predict the output:

 String query="SELECT customer_name, request_status,cab_number,address_of_pickup,date_of_request FROM cab_request WHERE request_id=?";
   try{
    PreparedStatement pstmt= con.prepareStatement(query);
    pstmt.setInt(1, requestId);
    ResultSet result=pstmt.executeQuery(query);
  if(result.next())
    {
     System.out.println("Name of The Customer: "+result.getString(1));
 }}
 catch(SQLException se){
 System.out.println(se.getMessage());
 } 
 

 
 1). No error  

 2). Compilation error. Not all variables bound 

 3). Runtime error. Not all variables bound 

 4). None of the above 
 
Solution :
option  [3] is correct 


Q. Consider the following code and answer the true statements:

 String query="SELECT customer_name, request_status,cab_number,address_of_pickup,date_of_request FROM cab_request WHERE request_id=?";
 PreparedStatement pstmt= con.prepareStatement(query); 
 

 
 1). Method is called on the interface Connection  

 2). Method is called on the implementation class which is a child of the interface Connection 

 3). This implementation class name need not be known to us. It is a part of the jar file provided 
by the java language  

 4). This implementation class name need not be known to us. It is a part of the jar file provided 
by the database vendor 

 5). The implementation class name needs to be known because it has to be mentioned in the java code 
 
Solution :
option  [2,4] are correct


Q. Select the true statements from the following: 
 

 
 1). The classes which implement the interfaces in java.sql package are in rt.jar file, 
which you get along with jdk installation 

 2). The classes which implement the interfaces in java.sql package are in the jar file 
which the database vendor provides 

 3). Classes in ojdbc.jar file have been creaetd by the datbaase driver developer 

 4). Classes in ojdbc.jar file have been creaetd by the developers of Java 
 
Solution :
option  [2,3] are correct 


Q. JDBC functionality offered by java.sql package depicts which of the following features? 


 
 1). Polymorphism 

 2). Programming to interface 

 3). Inheritance 

 4). Vendor independence 

 5). All of the above 
 
Solution :
option  [5] is correct 


Q. Which of the following lines in JDBC 4.0 are optional? 


 
 1). Instantiating the database driver class 

 2). Registering / Loading the driver with DriverManager 

 3). Establishing connection using DriverManager 

 4). Providing the location of database driver jar file 
 
Solution :
option  [1,2] are correct


Q. Consider the following stored procedure and identify the JDBC interfaces which can be used 
 to call this stored procedure.

 CREATE OR REPLACE FUNCTION addNumbers(num1 NUMBER ,num2 NUMBER) RETURN NUMBER AS
 BEGIN
 RETURN (num1+num2);
 END;
 / 
 

 
 1). Statement 

 2). PreparedStatement 

 3). CallableStatement 

 4). ResultSet 
 
Solution :
option  [3] is correct 


Q. If we do:

 ArrayList lst = new ArrayList();

 What is the initial capacity of the ArrayList lst ? 


 
 1). 10 

 2). 8 

 3). 15 

 4). 12 
 
Solution :
option  [1] is correct 


Q. Refer the code below:

 import java.util.ArrayList;
  import java.util.List;
  public class Test{ 
        public static void main(String args[]) {
         List<Integer> list = new ArrayList<Integer>(); 
     list.add(0, 59);
     int total = list.get(0);
     System.out.println(total);  
      }
 } 
 

 
 1). Gives output : 0  

 2). Will not compile 

 3). Gives output : 59 

 4). Runtime Exception 
 
Solution :
option  [3] is correct 


Q. Which statements creates an ArrayList of Strings with an initial capacity of 20? 
 (Choose all that apply) 
 

 
 1). ArrayList<String> names = new ArrayList<>( ); 

 2). ArrayList<String> names = new ArrayList<>(20); 

 3). ArrayList<String> names = new ArrayList<String>( ); 

 4). ArrayList<String> names = new ArrayList<String>(20); 
 
Solution :
option  [2,4] are correct 


Q. Given: 

 1. public static Collection get() { 
 2.          Collection sorted = new LinkedList(); 
 3.          sorted.add("B"); sorted.add("C"); sorted.add("A"); 
 4.          return sorted; 
 5. } 
 6. public static void main(String[] args) { 
 7.           Collection list = get();
 7.          for (Object obj: list) { 
 8.                    System.out.print(obj + ", "); 
 9.          } 
 10. } 

 What is the result? 


 
 1). A, B, C 

 2). B, C, A 

 3). Compilation fails.  

 4). The code runs with no output.  
 
Solution :
option  [2] is correct 


Q. Refer the given code :

 public class Test {
 public static void main(String... args) {

 Set s = new TreeSet();
  s.add("7");
  s.add(9);
  Iterator itr = s.iterator();
  while (itr.hasNext())
  System.out.print(itr.next() + " ");
 }
 } 
 

 
 1). Compile error 

 2). Runtime Exception 

 3). 7 9 

 4). None of the above 
 
Solution :
option  [2] is correct 


Q. Given the code fragment:

 public static vodi main(String args[]){
 ArrayList<String> list= new ArrayList<>();
 list.add("SE");
 list.add("EE");
 list.add("ME");
 list.add("SE");
 list.add("EE");

 list.remove("SE");
 System.out.println("Values are : "+ list);
 } 
 

 
 1). [ SE,EE,ME,EE] 

 2). [ EE ME SE EE ] 

 3). [ SE SE EE, EE] 

 4). [EE ME EE] 
 
Solution :
option  [2] is correct 


Q. What, inserted at line 39, will sort the keys in the props HashMap?

 34. HashMap props = new HashMap(); 
 35. props.put("key45", "some value"); 
 36. props.put("key12", "some other value"); 
 37. props.put("key39", "yet another value"); 
 38. Set s = props.keySet(); 
 39. // insert code here 
 

 
 1). Arrays.sort(s);  

 2). s = new TreeSet(s);  

 3). Collections.sort(s);  

 4). s = new SortedSet(s); 
 
Solution :
option  [2] is correct 



Q. Identify 2 benefits of using ArrayList over array in Software Development. 
 

 
 1). reduces memory footprint 

 2). implements Collection API 

 3). is multithread safe 

 4). dynamically resizes based on the number of elements in the list 
 
Solution :
option  [1,4] are correct 


Q. What is the result?

 1. import java.util.*;
 2.
 3. public class LetterASort{
 4. public static void main(String[] args) {
 5. ArrayList<String> strings = new ArrayList<String>();
 6. strings.add("aAaA");
 7. strings.add("AaA");
 8. strings.add("aAa");
 9. strings.add("AAaa");
 10. Collections.sort(strings);
 11. for (String s : strings) { System.out.print(s + " "); }
 12. }
 13. } 
 

 
 1). Compilation fails. 

 2). aAaA aAa AAaa AaA 

 3). AAaa AaA aAa aAaA 

 4). AaA AAaa aAaA aAa 

 5). aAa AaA aAaA Aaaa 
 
Solution :
option  [3] is correct 



Q. Given the code fragment:

 1. ArrayList<Integer> list = new ArrayList<>(1);
 2. list.add(1001);
 3. list.add(1002);
 4. System.out.println(list.get(list.size()));

 What is the result? 


 
 1). Compilation fails due to an error on line 1. 

 2). An exception is thrown at run time due to error on line 3 

 3). An exception is thrown at run time due to error on line 4 

 4). 1002 
 
Solution :
option  [3] is correct 



Q. What is the output for the below code?

 import java.util.Iterator;
 import java.util.TreeSet;
 public class Test {
 public static void main(String... args) {

 TreeSet s1 = new TreeSet();
 s1.add("one");
 s1.add("two");
 s1.add("three");
 s1.add("one");
  Iterator it = s1.iterator();
  while (it.hasNext() ) {
  System.out.print( it.next() + " " );
  }
 }
 } 


 
 1). one three two 

 2). Runtime Exception 

 3). one three two one 

 4). one two three 
 
Solution :
option  [1] is correct 



Q. Given: 

 1. public static Collection get() { 
 2.          Collection sorted = new LinkedList(); 
 3.          sorted.add("B"); sorted.add("C"); sorted.add("A"); 
 4.          return sorted; 
 5. } 
 6. public static void main(String[] args) { 
 7.          for (Object obj: get()) { 
 8.                    System.out.print(obj + ", "); 
 9.          } 
 10. } 

 What is the result? 
 

 
 1). A,B,C 

 2). B,C,A 

 3). Compilation Fails 

 4). The code runs without output 

 5). Exception thrown 
 
Solution :
option  [2] is correct 



Q.  Which of the following are true statements? 
 

 
 1). The Iterator interface declares only three methods: hasNext, next and remove. 

 2). The ListIterator interface extends both the List and Iterator interfaces. 

 3). The ListIterator interface provides forward and backward iteration capabilities. 

 4). The ListIterator interface provides the ability to modify the List during iteration. 

 5). The ListIterator interface provides the ability to determine its position in the List. 
 
Solution :
option  [1,3,4,5] are correct 



Q. Given the following code:

 package test;
 import java.util.ArrayList;
 public class Roller {
 public static void main(String[] args) {
 ArrayList<String> collector = new ArrayList<String>( );
 collector.add("Study");
 collector.add(Integer.toOctalString(Integer.MAX_VALUE));
 ArrayList<String> names = new ArrayList<>( );
 names.addAll(collector);
 names.add("Study");
 names.add(null);
 System.out.println(names.size( ));
 }
 }

 What is printed on the console? 
 

 
 1). 0 

 2). 2 

 3). 3 

 4). 4 
 
Solution :
option  [4] is correct 


Q. Given a pre-generics implementation of a method:

 11. public static int sum(List list) { 
 12. int sum = 0; 
 13. for ( Iterator iter = list.iterator(); iter.hasNext(); ) { 
 14. int i = ((Integer)iter.next()).intValue(); 
 15. sum += i; 
 16. } 
 17. return sum; 
 18. } 

 Which three changes must be made to the method sum to use generics? (Choose three.) 


 
 1). Remove line 14.  

 2). Replace line 13 with "for (int i : intList) {".  

 3). Replace line 13 with "for (Iterator iter : intList) {".  

 4). Replace the method declaration with "sum(List<int> intList)".  

 5). Replace the method declaration with "sum(List<Integer> intList)" 
 
Solution :
option  [1,2,5] are correct 


Q. Whats is the output?

 import java.util.ArrayList;
 import java.util.List;
 public class Test {     
       public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("English");
            list.add("Hindi");
            list.add("Kannada");
            list.add("Marathi");
            list.add("Tamil");
            list.add("Telugu");
            list.add(2,"Oriya");
            System.out.print(list.get(4));
            list.remove(3);
            System.out.print(list.get(4));
       }
 } 
 

 
 1). TamilTelugu 

 2). KannadaMarathi 

 3). MarathiTamil 

 4). Exception at runtime 
 
Solution :
option  [3] is correct 



Q.  Given:

 public class Concert {
 static class PowerOutage extends Exception {}
 static class Thunderstorm extends Exception {}
 public static void main(String[] args) {
 try {
 new Concert().listen();
 System.out.println("a");
 } catch(PowerOutage | Thunderstorm e) {
 e = new PowerOutage();
 System.out.println("b");
 } finally { System.out.println("c"); }
 }
 public void listen() throws PowerOutage, Thunderstorm{ }
 }

 What will this code print? 


 
 1). a 

 2). ab 

 3). ac 

 4). abc 

 5). compilation error 
 
Solution :
option  [5] is correct 


Q. View the Exhibit.
 public class Hat {
 public int ID =0;
 public String name = "hat";
 public String size = "One Size Fit All";
 public String color="";
 public String getName() { return name; }
 public void setName(String name) {
 this.name = name;
 }
 }
 Given
 public class TestHat {
 public static void main(String[] args) {
 Hat blackCowboyHat = new Hat();
 }
 }

 Which statement sets the name of the Hat instance? 


 
 1). blackCowboyHat.setName = "Cowboy Hat"; 

 2). setName("Cowboy Hat"); 

 3). Hat.setName("Cowboy Hat"); 

 4). blackCowboyHat.setName("Cowboy Hat"); 
 
Solution :
option  [4] is correct 



Q. View the Exhibit.
 public class Hat {
 public int ID =0;
 public String name = "hat";
 public String size = "One Size Fit All";
 public String color="";
 public String getName() { return name; }
 public void setName(String name) {
 this.name = name;
 }
 }
 Given
 public class TestHat {
 public static void main(String[] args) {
 Hat blackCowboyHat = new Hat();
 }
 }

 Which statement sets the name of the Hat instance? 
 

 
 1). blackCowboyHat.setName = "Cowboy Hat"; 

 2). setName("Cowboy Hat"); 

 3). Hat.setName("Cowboy Hat"); 

 4). blackCowboyHat.setName("Cowboy Hat"); 
 
Solution :
option  [4] is correct 



Q. Which line of code marks the earliest point that an object referenced by intObj becomes 
 a candidate for garbage collection?

 11. public void genNumbers() {
 12. ArrayList numbers = new ArrayList();
 13. for (int i=0; i<10; i++) {
 14. int value = i * ((int) Math.random());
 15. Integer intObj = new Integer(value);
 16. numbers.add(intObj);
 17. }
 18. System.out.println(numbers);
 19. } 
 

 
 1). Line 16 

 2). Line 17 

 3). Line 18 

 4). Line 19 

 5). The object is NOT a candidate for garbage collection. 
 
Solution :
option  [4] is correct 	



Q. Which code, inserted at line 4, guarantees that this program will output [1, 2]?

 1. import java.util.*;
 2. public class Example {
 3. public static void main(String[] args) {
 4. // insert code here
 5. set.add(new Integer(2));
 6. set.add(new Integer(1));
 7. System.out.println(set);
 8. }
 9. } 


 
 1). Set set = new TreeSet(); 

 2). Set set = new HashSet(); 

 3). Set set = new SortedSet(); 

 4). List set = new SortedList(); 

 5). Set set = new LinkedHashSet(); 
 
Solution :
option  [1] is correct 