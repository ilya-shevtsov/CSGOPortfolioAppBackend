# CSGO Case Portfolio Tracker Backend

This is the backend I've created for the app CSGO Case Portfolio Tracker. This is where I collect data, analyze it and out put it to the app. 

I used Kotlin Ktor for the creation of the server and Kotlin Exposed to create and with with databases. 

## The server has following calls (Or how its called):
- /getCase - to sent the data for the "Case Overview" screen

- /getAnalyticalDetails - to sent the data for the "Case Analytics Overview"

- /getPreferredCurrency - to sent the preferredCurrency for the "Start Screen"

- /getPortfolioData - to sent the PortfolioData that contais the cases that you have added to the portfolio

- /postPreferredCurrency - get the preferred currency from the app

- /postAddedCase - get the case you added to the portfolio

## In creating of this sever I've used:
- Ktor

- Kotlin Exposed

- Koltin Couroutines

- Kotlin Serialization

- My own Serializer

- Clean Architecture

- REST API
