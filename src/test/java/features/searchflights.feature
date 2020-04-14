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
	And User provides departure date "30/04/2020" 
	And User click submit 
	Then User should be able to navigate to search results page 
	
@SMOKE @FULLRUN 
Scenario Outline: User is able to search flights for round trip 
	Given click on flights tab 
	When User provides Origin "<origin>" and Destination "<destination>" cities for round trip 
	And User provides departure date "30/04/2020" and return date "04/05/2020" for round trip 
	And User click submit 
	Then User should be able to navigate to search results page 
	
	Examples: 
		|origin|destination|
		|Hyderabad|Bangalore|
		|New Delhi|Bangalore|
		
@FULLRUN 
Scenario: user is able to search flights for adults with children for one way trip 
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Bangalore|
	And User provides departure date "04/05/2020" 
	And User selects multiple adults with children 
	And User click submit 
	Then User should be able to navigate to search results page

@FULLRUN 
Scenario: user is able to search for a business class ticket for oneway trip in Air India
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Bangalore|
	And User provides departure date "04/05/2020"
	And User sets the preferred Airline as "Air India"
	And User sets preferred class as "Business"
	And User click submit
	Then User should be able to navigate to search results page 

@FULLRUN
Scenario: Verify if user is able to search for business class flight for roundtrip in a specific air liner
	Given click on flights tab
	When User provides Origin "Hyderabad" and Destination "New Delhi" cities for round trip
	And User provides departure date "30/04/2020" and return date "04/05/2020" for round trip
	And User sets the preferred Airline as "Air India"
	And User sets preferred class as "Business"
	And User click submit
	Then User should be able to navigate to search results page

@FULLRUN
Scenario: Verify if the user is able to search for one-way flight with adults, children and infants.
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Bangalore|
	And User provides departure date "04/05/2020"
	And User select adults "2" , children "2" and infants "2"
	And User click submit 
	Then User should be able to navigate to search results page

@FULLRUN
Scenario: Verify if the user is able to searhc for round trip flight with adults, children and infants.
	Given click on flights tab
	When User provides Origin "Hyderabad" and Destination "New Delhi" cities for round trip
	And User provides departure date "30/04/2020" and return date "04/05/2020" for round trip
	And User select adults "2" , children "2" and infants "2"
	And User click submit 
	Then User should be able to navigate to search results page

@FULLRUN
Scenario: Verify if error message is received if more than six members are selected in searching a flight for one way trip
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Bangalore|
	And User provides departure date "04/05/2020"
	And User select adults "3" , children "3" and infants "2"
	And User click submit 
	Then Error message saying more than six members are not allowed should be displayed
	
@FULLRUN
Scenario: Verify if error message is received if more than six members are selected in searching a flight for round trip
	Given click on flights tab
	When User provides Origin "Hyderabad" and Destination "New Delhi" cities for round trip
	And User provides departure date "30/04/2020" and return date "04/05/2020" for round trip
	And User select adults "3" , children "3" and infants "2"
	And User click submit 
	Then Error message saying more than six members are not allowed should be displayed
	
@TESTRUN
Scenario: Verify if user is able to select hotels while searching for one-way flights
	Given click on flights tab 
	And select oneway trip checkbox 
	When user provides Orgin and Destination cities 
			|Hyderabad|Kolkata|
	And User provides departure date "04/05/2020"
	And User selects the hotels option with checkin "04/05/2020" and checkout date "05/05/2020"
	And User click submit 
	Then User should be able to navigate to search results page with flights and hotels

@SMOKE @FULLRUN
Scenario: Verify if user is able to select hotels while searching for round trip flights
	Given click on flights tab
	When User provides Origin "Hyderabad" and Destination "New Delhi" cities for round trip
	And User provides departure date "30/04/2020" and return date "04/05/2020" for round trip
	And User selects the hotels option with checkin "01/05/2020" and checkout date "04/05/2020"
	And User click submit
	Then User should be able to navigate to search results page with flights and hotels
	

	

