# code-up-micronaut

This is the starter application for the micronaut talk. 

## Installation Instructions

### Clone the git repository.

Navigate to the directory you would like to which you would like to clone the project. Run the following.

    git clone git@github.com:chantrybjss/code-up-micronaut.git
    
For those of you without git installed. If you visit [the branch on github](https://github.com/chantrybjss/code-up-micronaut) there is a green button that says Clone or Download. Click this button if you do not want to clone using the above command.
### Install Java 11

Amazon Corretto is a production-ready distribution of OpenJDK. Download and install from the AWS Documentation [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).

### Install IntelliJ

[Download](https://www.jetbrains.com/idea/download/#section=windows) IntelliJ Community Edition (or Professional if you have a license) and follow the instructions.

Upon installation, open IntelliJ, and run through the wizard to configure the environment. When asked to create or open a project, simply navigate to the project cloned above and select the folder.

Once the project is open, enable annotation processing. From the menu navigate to the following.

File -> Settings -> Build, Execution, Deployment -> Compiler

Then tick "Enable annotation processing". As explained in the [Micronaut Docs](https://docs.micronaut.io/latest/guide/index.html#ideSetup) this ensures that you can run the application and tests without the need for an external build tool like maven.

### Add Java 11 to IntelliJ

Navigate to File -> Project Structure and click New..., then JDK, then navigate to the installation directory for Amazon Corretto (or whichever JDK distribution you have installed).

Make sure all the Java 11 features are enabled for the project.

## Running the Project

Navigate to the Application class file by double tapping shift, typing Application, and selecting it from the dropdown. Then simply click the green arrow and watch the project build and run.

If you are successful you should see something like the following.

    18:33:41.339 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 1566ms. Server Running: http://localhost:8080
    
Congrats! You are all setup!