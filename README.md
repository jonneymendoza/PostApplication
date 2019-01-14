# PostApplication
Simple application to demonstrate fetching some data and displaying them.

## Tools used:
*  Kotlin
*  Koin
*  Coroutines
*  ROOM DB
*  Retrofit
*  Android Architecture components(LiveData, ViewModel)

## Approached used:
 The project was architect using Clean Architecture and i mainly focused on the overall architecture for this app instead of the UI. A good base of code architecture makes implementing features, UI's and testing easier in the long term.
 
 The App First fetches all the data from the 3 api calls and after fetching them. adds it all to a Database storage so that its simple to query the data based on the requirements specified for this project(ie show a post details with who posted it and how many comments there is)
 
 On a production level app, i would suggestion that the Api was pagenated as at present it will send the client all the posts from the single GET Post API.
 
 The handling of us finding out wwhich username posted the Post item and also how many comments made could also be dealt in the Server side as well making it easier for clients to obtain that information and focus on user experience in the app

