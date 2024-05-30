This project repository contains 3 interfaces. The first 2 are concept web interfaces and my last, an Android application is more complex.

The first interface is finance_tracker, which is a simple React project that contains package files, src, public and documentation files. The src contains the main files for the project, with public just containing boilerplate for launching the project.

My second interface project_planning has the same folder structure. The src however does not contain any pages folder due to it being a single page application.

To run these React projects, you need to have npm installed. This is installed by downloading Node.js. The installer for this can be found at:
https://nodejs.org/en/download
Once npm is installed, clone the Gitlab repository to your local device using git clone link. 
Then after opening your terminal or an appropriate substitute cd inside the directory of the project you want to access. 
Here the command npm i will need to be run to install any required libraries.
The command npm start will then launch the website.

The third interface is cooking_companion and its directory looks a lot different due to it being a Jetpack Compose and Kotlin project. The src files are located in app/src/main. There are pages and components inside there, similar to the finance_tracker.

The running of this application is a bit more complicated. 

You will need to install the ide Android Studio Code at the link:
https://developer.android.com/
Once this has been installed, open the ide and navigate to file -> open and then open the directory cooking_companion. This will install all libraries that may have been deleted or were not installed on your computer.
From here you will need to connect an Android device or install an emulator. This can be done by navigating to device manager on the right navbar (highlighted option on the right image).
Then click the add device button and follow the intsturctions on screen to install a device of your choice.
Once this is done, you can click start at the top on the App configuration which will start your emulator, install the application and open it.
