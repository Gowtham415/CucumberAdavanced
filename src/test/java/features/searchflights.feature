Feature: Search Flights 
	This is to test all the functionality related to the search flights.

Background: 
	Given login to expedia.in website 
	
@SMOKE @FULLRUN 
Scenario: User is able to click and search flights in expedia.in site 
	When click on flights tab 
	Then user should be able to get the options for searching flights 
	
@SMOKE @FULLRUN 
Scenario: User is able to search flights for one way trip 
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
		|Hyderabad|Bangalore|
	And User provides departure date "30/03/2020" 
	And User click submit 
	Then User should be able to navigate to search results page 
	
@SMOKE @FULLRUN 
Scenario Outline: User is able to search flights for round trip 
	Given click on flights tab 
	When User provides Origin "<origin>" and Destination "<destination>" cities for round trip 
	And User provides departure date "30/03/2020" and return date "04/04/2020" for round trip 
	And User click submit 
	Then User should be able to navigate to search results page 
	
	Examples: 
		|origin|destination|
		|Hyderabad|Bangalore|
		|New Delhi|Bangalore|
		|Chennai|Mumbai|
		
@FULLRUN 
Scenario: user is able to search flights for adults with children for one way trip 
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Bangalore|
	And User provides departure date "30/04/2020" 
	And User selects multiple adults with children 
	And User click submit 
	Then User should be able to navigate to search results page

@FULLRUN 
Scenario: user is able to search for a business class ticket for oneway trip in Air India
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Bangalore|
	And User provides departure date "30/04/2020"
	And User sets the preferred Airline as "Air India"
	And User sets preferred class as "Business"
	And User click submit
	Then User should be able to navigate to search results page 
	
