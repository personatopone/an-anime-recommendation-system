# -anime.sql, comment.sql, genre.sql, song.sql
User should install MySQL program on local machine
https://www.youtube.com/watch?v=u96rVINbAUI
Using “root” as username and “123456” as password. Other settings are installed according to the default settings.


Also, user should install Navicat program.
https://www.navicat.com/en/download/navicat-for-mysql
Then create a connection. Use “root” as username and use “123456” as password. And user create a database named animedata in this connection. After that, right-click the "Table" , click "Execute SQL File" button, fill the one of the four files(anime.sql, comment.sql, genre.sql, song.sql) to the choosing box, and then click "start" to complete executing. Then you can check data via double-click anime table. Repeat this step until you have successfully imported all four files.



# -AnimeRecommendation_back-end
Use maven and SpringBoot

Import "AnimeRecommendation_back-end" folder to Intellij IDEA

### Using Lombok
There is a link https://projectlombok.org/setup/intellij to show you how we do it.
In the Intellij program, click File -> Setting. In the setting, click "Plugins", find Lombok and install, then click apply. Then click the compiler in "Build, Execution, Deployment" in the setting, click "Annotation Processors" from compiler button. choose "Enable above annotation processing", then click apply and ok.



# -animeRecommendation_front-end
First, download Visual Studio Code
https://code.visualstudio.com/
And node.js
https://nodejs.org/en/download/

Import "animeRecommendation_front-end" folder to Visual Studio Code

Click Terminal -> New Terminal. Enter the following corresponding commands in the command box

## Project setup
```
npm install(only first need)
```

### Compiles and hot-reloads for development
```
npm run serve
```

When you enter this command, you can see this right output. Under this picture, You can click the URL behind the "local" to see the animation recommendation webpage.
![image](https://github.com/bsu-cs222-summer20-dll/an-anime-recommendation-system/blob/master/output1.png)


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
