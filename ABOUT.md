This application represents simple online hotels reservation web site , built using Java Language and maven.

The web site consumes this url “https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel”
that returns a JSON result containing hotels information and offers.

The process followed for building this application :-

- Designing home page that represents list of hotels booking and contains search filters from this data.
- Creating wrapper object that represents the data objects returned from the JSON result.
- Return this data in a readable manner for the end user in the home page.
- Writing test cases for the code using Junit.

What learned from this exercise is how to create a website from scratch and taking in consideration making my code readable, maintainable, documented, and tested
in a way to get best performance and in the same time attractive and simple user experience in addition to deploy the application to Heroku and Travis CI.