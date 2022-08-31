@SingtelRegressionRun
Feature: Verify Todo List Feature - As a ToDo MVC user, I want to manage my todo list
	
	
@crateTodoList
Scenario: Verify as a user i should be able to create the todo list successfully
Given I navigate to singtel application
When I create the todays todo list "Need to send email for card approval"
Then I verify the created todo list "Need to send email for card approval" successfully
When I select all todo list into completed status
When I click the clear completed button
	
@VerifyTodoListCount
Scenario Outline: Verify as a user i should be able to view the created todo list count 
Given I navigate to singtel application           
When I create the todays todo list <actionItems>
Then I verify the created todo list <actionItems> successfully
Then I verify the todo list count <todoListCount> item left
When I select all todo list into completed status
When I click the clear completed button
	
Examples:
|actionItems                          |todoListCount|                  
|Need to send email for card approval |1            |

@VerifyButtons
Scenario Outline: Verify user able to view all the filter buttons after creating the todo list
When I create the todays todo list <actionItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
Then I verify the required buttons on the screen
 | All       |
 | Active    |
 | Completed |
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |todoListCount|filter|                  
|Need to send email for card approval |1            |All   |

@RemoveItems
Scenario Outline: Verify user able remove the task from the todo list
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <beforeRemovedCount> item left
When I remove the <actionItems> from the todo list
Then I verify the selected item removed successfully
And I verify the todo list count <afterRemovedCount> item left
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |beforeRemovedCount|aditionalItems      |afterRemovedCount|                  
|Need to send email for card approval |2                 |Nee to call hospital|1                |

@RemoveItemsInCompletedFilterTab
Scenario Outline: Verify user able remove the task from the completed list
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
When I mark todo list <actionItems> to completed status
When I mark todo list <aditionalItems> to completed status
When I click the <filter> filter
When I remove the <actionItems> from the todo list
Then I verify the selected item removed successfully
When I click the <Allfilter> filter
When I create the todays todo list <aditionalItems>
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems      |filter   |Allfilter|         
|Need to send email for card approval |Nee to call hospital|Completed|All      |

@VerifyCreateTodoItemInCompletedFilter
Scenario Outline: Verify user able create the todo item when user applied completed filter
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
When I mark todo list <actionItems> to completed status
When I click the <CompletedFilter> filter
When I create the todays todo list <newlyCreatedItems>
When I click the <allFilter> filter
Then I verify the created todo list <newlyCreatedItems> successfully
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems      |CompletedFilter |allFilter |newlyCreatedItems     |        
|Need to send email for card approval |Nee to call hospital|Completed       |All       |Visa appoinment today |

@CompletedTodoList
Scenario Outline: Verify user able to mark the selected todo list to completed status
When I create the todays todo list <actionItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <actionItems> to completed status
When I click the <filter> filter
Then I verify the completed todo list <actionItems> successfully
Then I click the clear completed button

Examples:
|actionItems                          |todoListCount|filter   |                  
|Need to send email for card approval |1            |Completed|

@CompletedAllTodoList
Scenario Outline: Verify user able to mark the all todo list to completed status
When I create the todays todo list <actionItems>
And I verify the todo list count <todoListCount> item left
When I select all todo list into completed status	
When I click the <filter> filter
Then I verify the completed todo list <actionItems> successfully
When I click the clear completed button

Examples:
|actionItems           |todoListCount|filter   |allFilter|                  
|Freshers Appoinment   |1            |Completed|All      | 

@VerifyCompletedFilter
Scenario Outline: Verify user able to see all completed todo list when applied completed filter
When I create the todays todo list <actionItems>
When I click the <allFilter> filter
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <actionItems> to completed status
When I click the <filter> filter
And I verify the todo list count <completedTodoListCount> item left
Then I verify the completed todo list <actionItems> successfully
When I click the <allFilter> filter
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems  |todoListCount|filter   |completedTodoListCount |allFilter|                
|Interview Call                       |Onboard Meeting |2            |Completed|1                      |All      |

@VerifyActiveFilter
Scenario Outline: Verify user able to see active todo list when applied active filter
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <aditionalItems> to completed status
When I click the <filter> filter
Then I verify the active filter todo list <actionItems> successfully
When I click the <allFilter> filter
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems  |todoListCount|filter |allFilter|                 
|Need to send email for card approval |Onboard Meeting |2            |Active |All      |

@VerifyAllFilter
Scenario Outline: Verify user able to see all todo list when applied all filter
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
Then I verify the created todo list <aditionalItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <actionItems> to completed status
When I click the <filter> filter
Then I verify the active todo list <aditionalItems> successfully
Then I verify strike through todo list <actionItems> successfully
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems      |todoListCount|filter   |                  
|Need to set Payrol meeting           |New Joiners Meeting |2            |All      |

@VerifyClearCompleted
Scenario Outline: Verify user able to clear the completed filter
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <actionItems> to completed status
When I click the <completedFilter> filter
When I click the clear completed button
Then I verify the selected item removed successfully
When I click the <allFilter> filter
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems     |todoListCount|filter         |completedFilter|allFilter|                  
|Need to send email for card approval |Scrum Call Meeting |2            |Clear completed|Completed      |All      |

@VerifyCompletedTodoListEdit
Scenario Outline: Verify user able to edit the existing completed todo list
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <actionItems> to completed status
When I click the <completedFilter> filter
And I verify the todo list count <completedTodoListCount> item left
When I edit the action item <actionItems> in todo list <EditedTodoItem>
Then I verify the edited todo list <EditedTodoItem> successfully
When I click the <allFilter> filter
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems     |todoListCount|EditedTodoItem         |completedFilter|completedTodoListCount|allFilter|                 
|Need to send email for card approval |Scrum Call Meeting |2            |Passport Meeting       |Completed      |1                     |All      |

@VerifyCompletedItemMovedToActive
Scenario Outline: Verify user able to move the Completed todo item to Active todo item
When I create the todays todo list <actionItems>
When I create the todays todo list <aditionalItems>
Then I verify the created todo list <actionItems> successfully
And I verify the todo list count <todoListCount> item left
When I mark todo list <actionItems> to completed status
When I click the <filter> filter
And I verify the todo list count <completedTodoListCount> item left
When I mark todo list <actionItems> back to active status
Then I verify the selected item removed successfully
When I click the <AllFilter> filter
When I select all todo list into completed status
When I click the clear completed button

Examples:
|actionItems                          |aditionalItems  |todoListCount|filter   |completedTodoListCount |AllFilter|               
|Need to send email for card approval |Onboard Meeting |2            |Completed|1                      |All      |
