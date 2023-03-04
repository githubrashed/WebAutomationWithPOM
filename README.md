# Step by Step Guideline related Web Automation using like below:
1. TestNG Framework, Design pattern: POM with Page Factory
2. Application Login using separate respective Page Class, respective Test Class
3. Multiple Test Case Writing by integrating Multiple Web Page
4. Run Test Case using TestNG XML file
5. Coming soon....
* Data Driven Testing
* Multi Browser Support
* Use properties file
* Extend Report
* Taking Screenshot

Documentation link:
-------------------
https://docs.google.com/document/d/1cYhqcmjiKEE3SRUA68BT7-iX6busB6o8eKqDmSCrvZo/edit
-------------------
What is a Page Object Model(POM)?

Organizing the page elements.
Maintaining or managing all the page objects in proper way on different files
Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements.
design pattern, popularly used in test automation that creates Object Repository for web UI elements.
Under this model, for each web page in the application, there should be a corresponding Page Class. This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

In the Page Object Model, Object is nothing but an element.

Object Repository: Collection of all objects.

Web Element: button, input field, drop down list.

Why Page Object Model?

Starting an UI Automation in Selenium, we just need to find elements, perform operations on it.
As we know, we all try to find out elements and fill values for those elements.

driver.findsElement(By.name(“name”).sendkeys();

This is a small script. Script maintenance looks easy. But with time the test suite will grow. As you add more and more lines to your code, things become tough.

The chief problem with script maintenance is that if 10 different scripts are using the same page element, with any change in that element, you need to change all 10 scripts. This is time consuming and error prone.

A better approach to script maintenance is to create a separate class file which would find web elements, fill them or verify them. This class can be reused in all the scripts using that element. In future, if there is a change in the web element, we need to make the change in just 1 class file and not 10 different scripts.

This approach is called Page Object Model in Selenium. It helps make the code more readable, maintainable, and reusable.

@FindBy(name = "username") WebElement userNameEl;

Advantages of using POM

- Easy Maintenance
- Code Reusability
- reduces code duplication
- Readability and Reliability of Scripts

POM Structure >= will discuss in session

Implementing POM with Demo Project

For today’s class:
Application Login with Valid UserName, Password
Assertion after Login

What is a Page Factory in Selenium?

Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns.
Used for initialization of Page objects or to instantiate the Page object itself. It is also used to initialize Page class elements without using “FindElement/s.”
What is initElements() in Selenium?
initElements is a static method in Page Factory class
We use initElements method to initialize web elements
What is @FindBy in Selenium?

An annotation used in Page Factory to locate and declare web elements using different locators.

With the help of class PageFactory in Selenium, we use annotations @FindBy to find WebElement.
We use initElements method to initialize web elements located by @FindBy annotation.

@FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.

TestNG XML file in TestNG Configuration
---------------------------------------
TestNG XML plugin install from Marketplace - File >> Settings >> plugin >> Marketplace >> search 'Create TestNG XML' & install

In TestNG, you can define multiple test cases in a single class whereas, in Java, you can define only one test in a single class in the main() method. In Java, if you want to create one more test, then you need to create another java file and define the test in the main() method.

Instead of creating test cases in different classes, we recommend you to use TestNG framework that allows you to create multiple test cases in a single class.

You can create multiple test cases with the help of @Test annotation

Note: You can trigger all the test cases from a single file known as xml file. Xml file is the heart of TestNG framework.

How to create a xml file
------------------------
In xml file, suite is at the higher hierarchy in TestNG. Inside the , we have to define the test name folder. This test name folder is the name of the folder. For example, In a loan company, there are three different types of modules such as personal loan, home loan and car loan, and each module contain its own test cases. All these test cases are defined in the test name folder.

<suite> - The suite tag can be given any name and denotes the test suite name.
<test> - The test tag can be given any name and indicates your test sets.
<classes> - This is the combination of your package name and test case name and cannot write anything else.

Note: that there is no package name in the above-written code. It is because TestNG.java is inside the default package. For example, if the package name is ABC, then this would be written as ABC.TestNG.

<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd"&gt;  
<suite name="loan_department">  
  <test name="Personal_loan">  
    <classes>  
      <class name="day1.module1"/>  
      <class name="day1.module2"/>  
    </classes>  
  </test>
</suite> 

How to Run the TestNG Suite?

<packages>
<package name="io.devqa.tests.ui"/>
</packages>

<class name="packagename.classname"/>  

runtestngsuite.png

Exclude/Include test cases

TestNG provides the feature of enabling and disabling the test cases.

In TestNG, test cases can be disabled in two ways:
You can disable the test case in a @Test annotation.
You can disable the test case in the XML file.
@Test(enabled=false)

In testng.xml file:

 <class name="day1.test">  
 <methods>  
 <include name="test3"/>  
 </methods>  
 </class>       

 <exclude name = "MobileLoginCarLoan"/>  

Note: Suppose we have multiple test cases and you want to include only one or two test cases, in such situation, we use <include> tag. If we use the <exclude> tag, then it becomes very tedious to exclude all the test cases.

TestNG Annotation

TestNG Annotation is a piece of code which is inserted inside a program or business logic used to control the flow of execution of test methods.

An annotation is a tag that provides information about the method, class, and suite. It helps to define the execution approach of your test cases and the different features associated with it.

Below are the major annotations used:

@Test– This is the root of TestNG test cases. In order to use TestNG, all methods should be annotated with this annotation.

Below is an example:

@Test
public void setupTestNG()
{
System.out.println(“this is a test annotation method”)
}

Hierarchy of the TestNG Annotations:

TestNG Annotations
@BeforeSuite
@BeforeTest
@BeforeClass
@BeforeMethod
@Test
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite

Benefits of using TestNG Annotations:
------------------------------------
1. TestNG Annotations made the life of testers very easy. Based on your requirements, you can access the test methods, i.e., it has no predefined pattern or format.
2. we can pass the additional parameters to TestNG annotations.
3. In the case of TestNG annotations, you do not need to extend any test classes.
4. TestNG Annotations are strongly typed, i.e., errors are detected at the compile time.
5. No main() dependency

TestNG Annotation Attributes
----------------------------
While writing the test cases in the TestNG, you need to mention the @Test annotation before the test method.
@Test(attribute="value")  
public void testcase2()  
{    System.out.println("This is testcase2");

}

Some of the common attributes are described below:
-----------------------------------
description
timeOut
priority
dependsOnMethods
enabled
groups