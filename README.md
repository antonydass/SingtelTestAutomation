# SingtelTestAutomation
Configuration Setup:
1.Eclipse Oxygen 
2.Once All setup is done. Verify the setup is done properly by running the below comment in cmd;
For Java : java -version 
For Maven : mvn -version 
3.Import the project as a maven project.
4.Project Name - > right click -> Maven -> Update Project
5. maven clean and install if any issue occured while maven update project 	
6. Go to test_runner->RunTest.java->right click -> run as -> junit
7. cmd run - > open cmd -> go to project location 
mvn verify -Dcucumber.options="--tags @SingtelRegressionRun" -Dbrowser="chrome"