#Alejandro Iglesias Expósito.
#email : alexsanko@gmail.com

#Build and Dependency Management Tool
In my case, I use:
➢ Maven Version 3.5.2
➢ JAVA jdk version 1.8.0_162

#Setup Machine
Let’s set up the machine to have all the required components in place. 
➢ IntelliJ IDEA 2017.3.4 (Community Edition)
Build #IC-173.4548.28, built on January 30, 2018
JRE: 1.8.0_152-release-1024-b11 x86_64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Mac OS X 10.13.3


#1.	Run the test from console

By console
You just need to run a single command from inside the project directory from
terminal. 

mvn clean install -pl web_test -Ddevice.name=<name>

Where <name>: 
if “NO DEVICE” -> will run by default with Chrome.
if “iPad” -> will run as iPad in Chrome.

Example: 
mvn clean install -pl web_test -Ddevice.name=iPad

Some parameters: "device.name" -> Select the device iPad, iPad Pro. By default will be NO DEVICE, so we will launch browser google chrome.
"browser.name" -> Select the browser, by default we will launch google chrome.
"browser.height" -> by default 900.
"browser.width" -> by default 1400.

#2.	Report Test
You just need to go inside your project directory. 
web_test/target/cucumber-html-reports





#About Test BBC challenge

In this project, we have 3 modules:
-	Java_selenium_framework: In this module we manage the browsers using the plugin “bonigarcia”, here, we have the page factory elements and we can extend it to other methods or modules.
-	Java_support_framework: This module contains properties related to this project, some utils and here we have an abstract that contain different asserts and checkers if element is present. 
-	Web_test: This is the module that contain the different scenarios.
o	I have used a enum class for submenu from sport section as page object.
o	I have created a “bussinesSteps” related to cases steps, for example doLogin() or accessToMenu will be more easy to manage. 
o	I have used in .feature data table, in this case I have used the business rules as templates and a table of specific values ​​is executed on this template, which helps reduce the number of scenarios. 


#Additional notes:

-	When I launch device.name with “Nexus 5” for example I have an error because some elements are not in the page. This is because the name element change or the elements are not present when is a mobile, for this reason I launch with tablets, so I have to create another flow for this cases when I will launch with a mobile. Personally, I prefer create another module related to mobile/tablets and not mixed with web because (in theory) the flow change or user experience and this form the flow web and mobile/tablet is more clear by separate. 
-	The report not is generated when is launched by IDE.
-	I have used only firefox and Chrome, but we can include in SeleniumDriverUtils others browser as ie, opera, edge…
