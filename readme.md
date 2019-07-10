Java 
Banuprakash C

VISA University
CO-Founder: Lucida Technologies Pvt. Ltd
Full Stack Architect
-----------------------------------------

	OOP -- Object Oriented Programming

	Programming to real world

	--> Objects communcate with each other by sending a message. What messages an object can accept is exposed thro its interface.
	To send the message we need to know what it does rather than how it works [ abstraction]

	We should follow SOLID design principles while building objects

		S ==> Single Reponsibility
		O ==> open Close principle
		L ==> Liskov Substitution Principle
		I ==> Interface segregation
		D ==> Dependency Injection

	Object: What is an Object?
		Object contains state, which is mutated and accessed by sending message
	We need to have a template for creating objects [ Blue Print]
	
		--> class
		--> function
			function Person() {

			}

			var p = new Person();
		---> Type
==================================================================

	What is Java?
		Java is a technology, it provides a platform and APIs for 
		executing bytecode.

		What is bytecode?
			
			portable machine independent set of instructions generated using compiler

			Java prog lang ---> javac ---> Bytecode
			Kotlin prog lang --> Kotlin compiler ===> Bytecode
			Groovy prog lang ==> Groovy Compiler --> Bytecode
===================================================================

	JDK ==> Java Development Kit
	Account.java
	public class Account			


	https://jb101-6080.cloudlab.jnaapti.io/vnc.html
	to
	https://jb127-6080.cloudlab.jnaapti.io/vnc.html


	 jb101%%^ [ SHIFT 5 5 6]
	 ==============================================

	 Logically grouping of objects/classes:
	 	1) entity/ domain / model	
	 		==> to represent a business data
	 			Example: Customer, Product, Order, Invoice

	 	2) DAO [ Data Access Objects]
	 	3) Business 
	 	4) Service
	 	5) Utility
	 	6) UI
	 	7) DTO / VO

	 In Java we create packages to logically group classes/object
	 packages --> folders

	 Comments
	 	a) single line
	 		int name ; // name of employee

	 	b) multi line
	 		/*
	 			sort logic
	 			to sort entities
	 		*/
	 	c) API comments [ JavaDoc]
	 		/**


	 		*/

	 	single line and "multi line" comments are for developers
	 	who have an access to source code

	 	JavaDoc comments are for API users [ Developer ]



	 	a) Slow
	 	b) Disconnect
	 	c) After REconnect: Ghost text
	 	d) Few VMs have Caps lock [ jb123]
	 	e) CTRL key not working [ jb113 ]
===============================================================

	new ==> to create objects on heap
	GC ==> Garbage collector is responsible for releasing resources
			It's a Low Priority Thread belonging to System Group

	GC 
		==> Short GC
		==> Full GC


		String s1 = "Hello"; // puts object on String pool

		String s2 = new String("Hello"); 

		String s3 = new String("Hello");

		s2 == s3 [ false ]

		String s4 = "Hello";

		s1 == s4 [ true ]
================================================
	Constructors
		==> invoked when object is created
		==> Sort of special methods
		==> Same name as that of class
		==> No explict return type


		public class Account {

			Account() {

			}

			Account(double amt) {

			}
		}

		Account a = new Account(5000);
		Account b = new Account();

		Compiler creates a default constructor if no constructors are written


		============

		public class Time {
			// 
		}



		public class TimeClient {
			public static void main(String[] args) {
				Time t1 = new Time(4,30);
				Time t2 = new Time(3,45);

				Time t3 = Time.addTime(t1, t2) ;

				s.o.p(t3.getHours() + " : " + t3.getMin()); // 8 : 15


				Time t4 = t1.addTim(t2);
				s.o.p(t4.getHours() + " : " + t4.getMin()); // 8 : 15
			}
		}

		============

			Terminal
			# cd /opt/eclipse
			# ./eclipse &
		===========================

		Unit Testing
			We write unit tests for every compilation units [class in Java, file in C]

			For Every class we write a Unit testing class

			AAA ==> Assemble Action Assert

			JUnit and TestNG are Unit Testing frameworks used by Java developers
==================================================================
	Relationship between Objects:
		a) Generalization and Specialization
		b) Realization
		c) Association
		d) Uses A

		Tools used by Java Developers:
			a) Checkstyle
				i) Naming Conventions
					=> CamelCase
						for class , variables and methods
						class AccountClient {

						}
						getmetea() {}
						getMeTea() {

						}
					=> SNAKE CASE for constants
						final int MAX_AGE = 100;
					=> Spine case [ not supported by JAva]
						used generally in XML based
							first-name
				2) Comments
				3) Spacing	
			b) PMD / FindBugs ==> Coding Stds
				1) Empty conditional statment/ catch block
					try {
						//code
					} catch(SQLException) {

					}

					if(condition){

					} else {
						//code
					}
				 2) Dead Code
				 3) Copy & Paste Code
			c) JUNit
			d) Clover/ CodeCoverage/ jacoco
				How much of your code has been tested?

			e) Maven	
				==> Project management tool
					==> Management of depedencies
					==> Setting up development goals [ steps]
					==> Brings in uniformity to all IDEs

			f) GIT/ BitBucket
			g) Jenkins
				CI ==> Continuos Integration Tool
			i ) SonarQube

		https://www.youtube.com/watch?v=hXkzfLaps8s

		Generalization and Specialization [ Inheritance]
		done using "extends" keyword in java

		class Product { 						new Mobile(); // PA MA
			Product() {
				"PA" 							new Mobile(24,"4G"); // PA MB
			}

			Product(int id) {
				"PB"
			}
		}

		class Mobile extends Product {
			Mobile() {
				"MA"
			}
			Mobile(int id, String connect) {
				"MB"
			}
		}
======================
	class Product { 						 	new Mobile(); // PA MA
			Product() {
				"PA" 							new Mobile(24,"4G"); // PB MB
			}

			Product(int id) {
				this();
				"PB"
			}
		}

		class Mobile extends Product {
			Mobile() {
				super();
				"MA"
			}
			Mobile(int id, String connect) {
				super(id);
				"MB"
			}
		}
==========

class Product { 						 	new Mobile(); // Compilation ERROR

			Product(int id) {
				"PB"
			}
		}

		class Mobile extends Product {
			Mobile() {
				"MA"
			}
			Mobile(int id, String connect) {
				super(id);
				"MB"
			}
		}
=============================================================================
	class Product {					Mobile m = new Mobile();
		doThat() {  						m.doThat(); // MDA
			"PDA"							m.doThis(); // MDT
		}							Product p = new Mobile(); // UPCASTING
	}								p.doThat(); // MDA
									p.doThis(); // ERROR

	class Mobile extends Product {
		doThat() {
			"MDA"
		}
		doThis() {
			"MDT"
		}
	}
	========

	abstract class 
		==> can't instantiate [ can't create object]
		==> need not have abstract methods
		==> If one of the method is abstract, then class should be abstract
	=====
	Rules of Override:
		==> Method name and arguments should be same
		==> Return type can be same or sub-type
		==> visbility can be same or enhanced
============================
	a) Java doesn't support multiple inheritance
	b) Object class is the root of all classes
==============================================================

	Realization Relationship
	------------------------
		A Component/Object will realize the behaviour specifed by other
		to communicate.

		This is done using interface

			No state and implementation:
			interface interfaceName {
				abstract methods
				constants
			}

			Example:
			interface EmployeeDao {
				void addEmployee(Employee e);
				Employee getEmployee(int id);
			}

			Why should be program to an interface?
				a) DESIGN
				b) IMPLEMENTATION
				c) TESTING
				d) INTEGRATION
				e) LOOSE COUPLING
				f) OCP

		public class Test {
			public static void main(String[] args) {
				String str = "com.visa.prj.dao.MobileDaoMongoImpl";
				// loads the class 
				Class.forName(str);

				// creating objects

				Class.forName(str).newInstance(); 
			}
		}
		============

		class PlantFactory {

			public static Plants[] getPlants(String season) {
				if(season.equals("SUMMER")) {
					//
				} else {

				}
			}
		}

		Client:
				Plants[] plants = PlantFactory.getPlants("SUMMER");
=====================================================================
	interface Swim {					Fight f = new Hero();
		void swim();					f.fight();
	}									Dance d = (Dance) f; 
										d.dance();
	interface Dance {
		void dance();
	}

	interface Fight {
		void fight();
	}

	class Actor implements Dance {
		public void dance() {//code}
	}

	class Hero extends Actor implements Swim, Fight {
		swim..
		fight...
	}
====================================================
	
	Generics:

	class Rectangle <T> { 				class Rectangle {
		T width;								Object width;
		T breadth; 								Object breadth;
		//code
	}									}

	Rectangle<Integer> r1 = new Rectangle<>(4,5);
	Rectangle<Double> r2 = new Rectangle<>(1.4,4.5);
	Rectangle<String> r3 = new Rectangle<>("Hello", "World");

	class Rectangle <T extends Number> {  		class Rectangle {
														Number width;
	}			

	git config -l
	git config --global user.name <name>
	git config --global user.email <email>



======================================

https://github.com/BanuPrakash/visa_week1.git

	Version Control		

	git config -l
	git config --global user.name BanuPrakash
	git config --global user.email banu@lucidatechnologies.com

	create a file ".gitignore"

	==> initialize a local repository
	git init

	==> add files to staging area

	git add .

	git status

	git push https://github.com/BanuPrakash/visa_week1.git master
=====================================================================

	Day 3:
	------

	interface Flyable {
		void fly();
	}

	class Bird implements Flyable {
		//state
		// behaviour
		public void fly() {
			// code
		}
	}

	Flyable f = new Bird();

	// Anonymous class
	Flyable f = new Flyable() {
		public void fly() {
			Jump from 4th floor!!!
		}
	}
			


	======

	Java Collection Framework
		==> Data Containers
		Array is a data container
			--> Can't grow or shrink
			--> Needs Contiguos memory
			--> adding / removing from arbitrary position is not efficient

	JCF
		--> interfaces
		--> implementation classes
		--> Utility / Algorithm classes [ sort(), max(), binarySearch()]
		These collections are interoperable 


		interface List extends Collection {

		}

		==========

		List 									Set

	a) supports duplicate elements 				unique
	b) supports index based operation			doesn't
			get(pos)
			add(elem,pos)
			remove(pos)	
	c) maintains insertion Order 					won't
	d) re-order 									can't



	List list = new ArrayList();
	List list = new LinkedList();
	list.add("a");
	list.add(new Employee());
	list.add(new Date());

	String s = (String) list.get(0);

	List<String> list = new ArrayList<String>(); // java 5 and 6
	List<String> list = new ArrayList<>(); // java > 7

	https://shrib.com/#banu

	===========

	Functional style of Programming and (High Order Functions):


	High Order Functions are functions:
		a) which accept other functions as arguments
		b) which return a function
		--> treat function as first class member ( primitive, objects)

	Functional style of Programming
		=> Not tightly coupled to state of object
		=> Does not mutate the input
	OOP 
		==> methods are tightly coupled to state of object

	Commonly used High Order Functions:
		Intermediary:
		a) map
		b) filter
	
		d) limit
		e) skip
		f) flatMap
		g) merge
		Terminal operations:
		d) sort
		c) reduce
		g) forEach
		i) collect















