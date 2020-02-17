Feature: Search Flights 
	This is to test all the functionality related to the search flights.

Background: 
	Given login to expedia.in website 
Scenario: User is able to click and search flights in expedia.in site 
	When click on flights tab 
	Then user should be able to get the options for searching flights 
	
Scenario: User is able to search flights for one way trip 
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
		|Hyderabad|Bangalore|
	And User provides departure date "30/02/2020"
	And User click submit 
	Then User should be able to navigate to search results page