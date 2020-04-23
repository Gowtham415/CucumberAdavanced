Feature: Search Flights with Hotels 
	This is to test all the functionality related to the search Hotels

Background: 
	Given login to expedia.in website
	
@TESTRUN
Scenario: User is able to click on FlightAndHotelsTab
	When Click on Flights and Hotels tab.
	Then User should be able to get the options for searching flights and hotels.

