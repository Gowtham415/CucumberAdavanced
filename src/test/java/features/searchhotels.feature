Feature: Search Hotels 
	This is to test all the functionality related to the search Hotels

Background: 
	Given login to expedia.in website
	
@SMOKE @FULLRUN 
Scenario: User is able to search for Hotels
	Given Click on Hotels tab
	When User provides city to be searched for hotels
		|Hyderabad|Bangalore|
	And User provides checkin date "29/04/2020" in to hotel 
	And User provides checkout date "05/05/2020" from the hotel
	And User click on search hotel button
	Then User should be able to navigate to search results page for hotels
	
@FULLRUN 
Scenario: User is able to search for Hotels with flights
	Given Click on Hotels tab
	When User provides city to be searched for hotels
		|Hyderabad|
	And User provides checkin date "29/04/2020" in to hotel 
	And User provides checkout date "05/05/2020" from the hotel
	And User provide flights data for hotel search
		|Bangalore| 
	And User click on search hotel button
	Then User should be able to navigate to search results page for hotels

@FULLRUN
Scenario: Verify if user is able to search for flights with multiple adults
	Given Click on Hotels tab
	When User provides city to be searched for hotels
		|Hyderabad|
	And User provides checkin date "29/04/2020" in to hotel 
	And User provides checkout date "05/05/2020" from the hotel
	And User selects multiple adults
	And User click on search hotel button
	Then User should be able to navigate to search results page for hotels
	
@FULLRUN
Scenario: Verify if user is able to search for flights with multiple adults and multiple children
	Given Click on Hotels tab
	When User provides city to be searched for hotels
		|Hyderabad|
	And User provides checkin date "29/04/2020" in to hotel 
	And User provides checkout date "05/05/2020" from the hotel
	And User selects multiple adults and multiple children
	And User click on search hotel button
	Then User should be able to navigate to search results page for hotels
	
@FULLRUN
Scenario: verify if user is able to search for multiple rooms in hotels tab
	Given Click on Hotels tab
	When User provides city to be searched for hotels
		|Hyderabad|
	And User provides checkin date "29/04/2020" in to hotel 
	And User provides checkout date "05/05/2020" from the hotel
	And User selects multiple rooms for multiple people
	And User click on search hotel button
	Then User should be able to navigate to search results page for hotels
	
	
	
	