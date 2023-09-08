
@tag
Feature: To Test the HomePage

	
	 Scenario: User launch home page of an DSALgo Project
    Given  The User opens DS Algo portal link
    When The User clicks the "Get Started" button
    Then The User should be redirected to homeage
    
  Scenario Outline: User is clicking Data Structures
  
  Given : The User is in HomePage
  When The user Chooses "<options>" without login
 	Then the user will get the "<errormessage>"
 	
 	 Examples:
 | options        | errormessage  |
 | Arrays      | You are not logged in  |
 | Linked List | You are not logged in  |
 | Stack    | You are not logged in     |
 | Queue    | You are not logged in     |
 | Tree    | You are not logged in      |
 | Graph    | You are not logged in     |   