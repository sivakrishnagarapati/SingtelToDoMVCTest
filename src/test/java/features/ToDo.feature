@TodoFeature
Feature: In order to remember the things I want to do, as a ToDo MVC user, I want to manage my todo list

Background: 
Given Browser is launched and todos web URL is entered

@AddTasks
Scenario Outline: 1 To validate user is able to add the tasks to the list and able to validate number items added and same are showing under All and Active filters
When user enters all the tasks "<listoftasks>" in the text box and hit enter one after the other
Then All the tasks "<listoftasks>" should be added as list under All tab 
And user validates numbers tasks "<numberoftasks>" added to the list
And user clicks on Active tab and ensure all the tasks "<listoftasks>" are showing
And user clicks on Completed tab and ensure no tasks are showing

Examples:
|listoftasks																												  | numberoftasks |
|Checking emails,Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email| 5 items left  |

@CompleteTasks
Scenario Outline: 2 To validate user is able to make the tasks as completed and tasks left under All filter should be updated accordingly and Completed tasks should be moved to Completed filter and shouldnot display under Active tab 
When user enters all the tasks "<listoftasks>" in the text box and hit enter one after the other
And user clicks on check box for "<todoitemtocomplete>" task in order to complete it
Then user validates "<todoitemtocomplete>" task turned to completed and number of tasks left should become "<numberoftasksleft>" under All tab
And user clicks on Active tab and ensure all the tasks "<itemsleft>" should be displaying except "<todoitemtocomplete>" task  
And user clicks on Completed tab and ensure "<todoitemtocomplete>" task is displaying

Examples:
|listoftasks																												  | numberoftasksleft | todoitemtocomplete | itemsleft 																									   |
|Checking emails,Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email| 4 items left  	  | Checking emails    | Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email |

@InCompleteTasks
Scenario Outline: 3 To validate user is able to make the tasks as incompleted and tasks left under All filter should be updated accordingly and tasks under Completed tab should be removed and all tasks which are not completed should be displayed under Active tab 
When user enters all the tasks "<listoftasks>" in the text box and hit enter one after the other
And user clicks on check box for "<todoitemtocomplete>" task in order to complete it
Then user validates "<todoitemtocomplete>" task turned to completed and number of tasks left should become "<numberoftasksleft>" under All tab
And user clicks on check box for "<todoitemtocomplete>" task in order to incomplete it
And user validates numbers tasks "<numberoftasks>" added to the list
And user clicks on Active tab and ensure all the tasks "<listoftasks>" are showing  
And user clicks on Completed tab and ensure no tasks are showing

Examples:
|listoftasks																												  | numberoftasksleft | todoitemtocomplete | numberoftasks |
|Checking emails,Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email| 4 items left  	  | Checking emails    | 5 items left  | 

@ClearCompleteTasks
Scenario Outline: 4 To validate user is able to clear the completed tasks and same shouldnot be displayed under Completed tab 
When user enters all the tasks "<listoftasks>" in the text box and hit enter one after the other
And user clicks on check box for "<todoitemtocomplete>" task in order to complete it
And user clicks on Clear completed option
Then user clicks on Completed tab and ensure no tasks are showing

Examples:
|listoftasks																												  | todoitemtocomplete |
|Checking emails,Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email| Checking emails    |

@CompleteAllTasks
Scenario Outline: 5 To validate user is able to make all the tasks as completed and incompleted and tasks left under All filter should be updated accordingly 
When user enters all the tasks "<listoftasks>" in the text box and hit enter one after the other
And user clicks on select all check box in order to complete all the tasks
Then user validates "<listoftasks>" tasks turned to completed and number of tasks left should become "<numberoftasksleft>" under All tab
And user clicks on Completed tab and ensure "<listoftasks>" tasks are displaying
And user clicks on All tab and select all check box in order to incomplete all the tasks
And user validates numbers tasks "<numberoftasks>" added to the list
And user clicks on Active tab and ensure all the tasks "<listoftasks>" are showing  
And user clicks on Completed tab and ensure no tasks are showing

Examples:
|listoftasks																												  | numberoftasksleft | numberoftasks |
|Checking emails,Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email| 0 items left  	  | 5 items left  | 

@RemoveTasks
Scenario Outline: 6 To validate user is able to remove all the tasks by clicking on the cross mark
When user enters all the tasks "<listoftasks>" in the text box and hit enter one after the other
And user validates numbers tasks "<numberoftasks>" added to the list
And user clicks on cross mark beside each task
Then All the tasks should be removed under All tab


Examples:
|listoftasks																												  | numberoftasks |
|Checking emails,Attending morning meetings,Focusing on priority tasks,Attending afternoon meetings,Sending daily status email| 5 items left  |