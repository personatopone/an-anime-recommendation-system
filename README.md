# -How to Run
You need to follow the steps below to run this system smoothly：
1. Follow "Database" section to create a database, and import sql files from database folder.
2. Follow "AnimeRecommendation_back-end" to complete IDEA's environment configuration. After that, run "AnimeRecommendationApplication.java" to run the webpage backend. The purpose of running the webpage backend is to complete the interaction between the webpage frontend and the database. So don't terminate IDEA from running or close IDEA, but minimize IDEA and start the next operation.
3. Follow "AnimeRecommendation_front-end" to open this webpage. Then you can do whatever you like.

# -Database
User should install MySQL program on local machine
https://www.youtube.com/watch?v=u96rVINbAUI
Using “root” as username and “123456” as password. Other settings are installed according to the default settings.


Also, user should install Navicat Premium program.
https://www.navicat.com/en/download/navicat-premium
Then create a connection. Use “root” as username and use “123456” as password. And user create a database named animedata in this connection. After that, right-click the "Table" , click "Execute SQL File" button, fill the one of the four files (anime.sql, comment.sql, genre.sql, song.sql. They are all in database folder) to the choosing box, and then click "start" to complete executing. Then you can check data via double-click anime table. Repeat this step until you have successfully imported all four files.



# -AnimeRecommendation_back-end
Use maven and SpringBoot

Import "AnimeRecommendation_back-end" folder to Intellij IDEA

### Using Lombok
There is a link https://projectlombok.org/setup/intellij to show you how we do it.
In the Intellij program, click File -> Setting. In the setting, click "Plugins", find Lombok and install, then click apply. Then click the compiler in "Build, Execution, Deployment" in the setting, click "Annotation Processors" from compiler button. choose "Enable above annotation processing", then click apply and ok.



# -AnimeRecommendation_front-end
First, download Visual Studio Code 
https://code.visualstudio.com/
And node.js
https://nodejs.org/en/download/
And install them two.

Import "animeRecommendation_front-end" folder to Visual Studio Code

Click Terminal -> New Terminal. Enter the following corresponding commands in the command box

In order to open the webpage, you should first enter the "npm install" command and press Enter, and then enter the "npm run serve" command and press Enter. Then you can open the webpage. If you want to open the webpage later, because the npm environment is already installed, you only need to enter the "npm run serve" command.

### If you want to run the animation recommendation website successfully. Only input the first command(npm install) and the second command(npm run serve).

## Project setup
```
npm install(only first need)
```

### Compiles and hot-reloads for development
```
npm run serve
```

When you enter this command, you can see this right output. Under this picture, You can click the URL behind the "local" to see the animation recommendation webpage.


![image](https://github.com/bsu-cs222-summer20-dll/an-anime-recommendation-system/blob/master/InstructionPicture/picture3.png?raw=true)


If you want to exit this command and want to input other command, you can press "Ctrl + C" twice. Then you can input new command.


### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
