# Qhala-Android-Test
This app consumes The Movie DB Api to fetch and display a list of popular movies, The uses MVVM clean architecture.
<br>


Minimum API level supported: 21
<br>
Build System: [Gradle](https://gradle.org/)

### Prerequisite
To run the project you should have the following tools
* Android Studio 4.0 or above
* Internet connection

### Architecture
The app is build with MVVM clean architeture with multimodules taking into coondieration seperation for easier testing.

### Screenshots
#### Movie List
<img src="/art/list_light.png" width="260">&emsp;<img src="/art/list_dark.png" width="260">

#### Movie Details
<img src="/art/detail_light.png" width="260">&emsp;<img src="/art/detail_dark.png" width="260">

### Libraries
* Retrofit - A Type-safe HTTP client for android and java which simplfies consuming RESTful APIs.
* Gson - Converts JSON to Java/Kotlin objects.
* OkHttp-logging-interceptor - Makes it easy to log OkHttp network traffic
* Glide - Image loader libraru for android
* Dagger Hilt - Used for Dependency Injection
* Room - Persistence library making it easier to work with SQLite database
* Data Binding - Jetpack library allowing to bind UI components to data sources
* ViewModel - Designed to store and manage UI data in a lifecycler aware fashion.

### Unit Tests
Unit test tests Dao, ViewModels and Repository
<img src="/art/dao.png" >&emsp;
<br>
<img src="/art/dao_local.png" >&emsp;
<br>
<img src="/art/details_test.png" >&emsp;

### License
```text
MIT License

Copyright (c) 2021 Daniel Waiguru

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

