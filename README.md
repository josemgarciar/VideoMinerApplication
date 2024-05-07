# VideoMiner Application

VideoMiner is a robust Java application that leverages the power of Spring Boot and Maven to interact with video data from Vimeo and YouTube. 
It uses the Vimeo and YouTube APIs to fetch and process video data, including details about channels, videos, comments, and captions. 
The application uses Spring's RestTemplate to make HTTP requests to the APIs and process the responses. It also includes a model layer that represents the data structures returned by the APIs, which are then transformed into a format suitable for further processing or storage.
In essence, VideoMiner is a comprehensive tool for mining and processing video data from popular platforms, providing a solid foundation for any project that requires interaction with such data.The application is designed to convert API responses into a more manageable format, storing them in custom data models for further use. This includes details such as video descriptions, release times, and associated comments.

## Contents Table

1. [Installation](#Instalation)
2. [Use](#Use)
3. [Contribution](#Contribution)

## Installation
Here are the instructions to install and run the project:
* **Prerequisites:** Make sure you have Java and Maven installed on your system.
* **Clone the Repository:** Clone the repository to your local machine using the command git clone <repository-url>. Replace <repository-url> with the URL of this GitHub repository.
* **Navigate to the project Directory:** Use the command cd <project-name> to navigate into the project directory. Replace <project-name> with the name of the project.
* **Build the project:** Run the command mvn clean install to build the project and install any necessary dependencies.
* **Run the application:** Run the command mvn spring-boot:run to start the application.
*Note: The application uses tokens to access Vimeo and YouTube APIs. Make sure to replace the placeholders in VimeoController.java and YoutubeController.java with your actual tokens.*


## Use



## Contribution
### José Manuel García Rosa
email: josgarros@alum.us.es  
gitHub profile: https://github.com/josemgarciar  

### Julian Romero Parejo
email: julrompar@alum.us.es  
gitHub profile: https://github.com/julrompar

### Fernando Triguero Caballo
email: fertricab@alum.us.es  
gitHub profile: https://github.com/FernandoTC18  

