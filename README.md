# SingtelTestAutomation

Configuration Setup:

Eclipse Oxygen 

Once All setup is done. Verify the setup is done properly by running the below comment in cmd;
For Java : java -version 
For Maven : mvn -version 

Import the project as a maven project.

Project Name - > right click -> Maven -> Update Project
maven clean and install if any issue occured while maven update project 	

Go to test_runner->RunTest.java->right click -> run as -> junit
cmd run - > open cmd -> go to project location 

mvn verify -Dcucumber.options="--tags @SingtelRegressionRun" -Dbrowser="chrome"
