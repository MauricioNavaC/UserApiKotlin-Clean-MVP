# UserApiKotlin-Clean-MVP

[![N|Solid](https://i.blogs.es/df41c1/kotlin_800x320/1366_2000.png)](https://kotlinlang.org/)

# Random User API Consumption
Application to consume random user endpoint.
It works by rendering a user fetched from the api. The app has the feature to explore other users.

# Arquitecture

## Data
 - This is the layer with the concrete implementations for repositories.
 - Current implementations use in-memory storage.
 - As all repositories implement contract clases (Dependency inversion), those repository implementations could be easily replaced with others with different data sources like Room, Realm, etc...

## Domain
The inner-most layer is domain, with all the business logic. 
- Use cases live here

## UI
This layer contains all the presentation logic. Here is where the android stuff lives in. Activities, Fragments, etc...
- MVP pattern is used.
- The presenter will send the data through callbacks to the activities, the activities will present this in the view.

# Library Stack
* Dagger2: For dependency Injection
* RXJava2: To keep data synchronized
* Retrofit/OkHttp/Gson: For service consumption
* Glide: For image loading

# Obstacles
- Lack of practice with some technologies such as Dagger2 and RXJava2
- Keep the architechture as clean as possible
- UserApi sometimes send me the "post code" field in int and others in String. This scenario makes the deserialization fails.

# Solutions
- Reading documentation and working examples online
- Reading about Clean Architecture online
- Choose not to add the field to the model since this wouldn't be used

# Working Example GIF
![](https://media.giphy.com/media/fqt956HTU5T2nVlcza/giphy.gif)