# Explore
Explore is a mobile application build on that allow the user to explore a list of countries and their details as provide by [Countries REST API](https://restcountries.com/v3.1/all).
This project is a solution to stage 3 mobile track of HNGi9 internship.

## Design
Figma design for the project is available at [UI Design](https://www.figma.com/file/v9AXj4VZNnx26fTthrPbhX/Explore?node-id=0%3A1).

# Tech Stack
- Minimum SDK level 21
- Kotlin based, Coroutines + Flow for asynchronous 
- Jetpack
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Manage UI-related data holder and lifecycle aware.
  - [Compose](https://developer.android.com/jetpack/compose): Defining declarative UI purely in kotlin
- [Hilt](https://dagger.dev/hilt/) : for depency injection
- [Retrofit & OkHttp](https://github.com/square/retrofit) : Construct the REST APIs and downloading network data
- [GSON](https://github.com/google/gson): Serializing json data
- [Coin](https://coil-kt.github.io/coil/svgs/) : Loading images from network

# Architecture
The application has 2 screens,HomeScreen and CountryDetail screen. The setup uses MVVM architectural guildelines and divide the project into 3 layers and each layer ensure unidirectional event/data flow.
- Ui layer
- Domain Layer
- Data Layer
# Challenges
- the modelling of data structures from the json was a major challenge. After consoltation from different preople, i resoted to slimming the json to simple field that i needed
- Transforming the data to be displayed in a group.

# Appetize.io
The app ist hosted at appetize and can be acessed through [appetize.io](https://appetize.io/app/q26jbta3ekfxbu675sanym6sta?device=pixel4&osVersion=11.0&scale=75)
