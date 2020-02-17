$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/searchflights.feature");
formatter.feature({
  "name": "Search Flights",
  "description": "\tThis is to test all the functionality related to the search flights.",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login to expedia.in website",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.login_to_expedia_in_website()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User is able to click and search flights in expedia.in site",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "click on flights tab",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.click_on_flights_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user shou ld be able to get the options for searching flights",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.user_should_be_able_to_get_the_options_for_searching_flights()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login to expedia.in website",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.login_to_expedia_in_website()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User is able to search flights for one way trip",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "click on flights tab",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.click_on_flights_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select oneway trip checkbox",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.select_oneway_trip_checkbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides Orgin and Destination cities",
  "rows": [
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.user_provides_Orgin_and_Destination_cities(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides departure date \"30/02/2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.user_provides_departure_date(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click submit",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.user_click_submit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to navigate to search results page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinition.SearchFlights.user_should_be_able_to_navigate_to_search_results_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});