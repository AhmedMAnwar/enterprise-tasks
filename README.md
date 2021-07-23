# musala-soft-tasks

_________________

- Project content
_________________

 -> Below "src/test/java" path, you can find the following class presenting test cases
	- Careers test cases
	- Company test cases
	- Contact us form test cases
	- Display position job info test cases

 -> Below "src/test/resources", path you can  find the following files sharing some data content test  
    cases needs
	- config.properties : contains all website URLs to be verified
	- dummyfile : only for testing CV field in a application form test case
	- regression.xml : is presenting the whole test suites running on different browsers
	  simultaneously

-> Below "src/main/java"
  - There are three main packages for running this project
	- Drivers : presenting both Firefox, and chrome drivers.
	- Elements : sharing the whole pages accessing web elements
	- Properties : through that you are able to load the file containing the browser URLs
	-------------------------------------------------------------------------
	-------------------------------------------------------------------------
_________________

Pre-configuration
_________________

Install the following tools:

1- Eclipse IDE
2- JDK 8
3- Install maven , and TestNg plugins
4- Install chrome, and Firefox browser

	-------------------------------------------------------------------------
	-------------------------------------------------------------------------
_________________

Running script
_________________

-> Go to java/test/resources - > select regression.xml file, then right click on it, then select 
   "Rub as TestNG Suite"

	-------------------------------------------------------------------------
	-------------------------------------------------------------------------
_________________

Reports:
_________________

- Go to report -> you will find two file reports