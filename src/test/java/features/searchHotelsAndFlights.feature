Feature: Search Flights with Hotels 
	This is to test all the functionality related to the search Hotels

Background: 
	Given login to expedia.in website
	
@SMOKE
Scenario: User is able to click on FlightAndHotelsTab
	When Click on Flights and Hotels tab.
	Then User should be able to get the options for searching flights and hotels.

@SMOKE
Scenario: Verify if user is able to search for flights and hotels
	When Click on Flights and Hotels tab.
	Given User enters origin and destination city in package tab
			|New Delhi|Chennai|
	And User enters departing and returning date in package tab
		|20/05/2020|06/06/2020|
	When User clicks on search button in package search tab
	Then User should be able to navigate to search results page with flights and hotels
	
@FULLRUN
Scenario: Verify that user is able to searhc for direct flights in package tab
	When Click on Flights and Hotels tab.
	Given User enters origin and destination city in package tab
			|New Delhi|Chennai|
	And User enters departing and returning date in package tab
		|20/05/2020|06/06/2020|
	And User selects direct flights option
	When User clicks on search button in package search tab
	Then User should be able to navigate to search results page with flights and hotels
	


	
	
	

