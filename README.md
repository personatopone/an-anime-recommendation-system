# -anime.sql
User should install MySQL program on local machine
https://www.youtube.com/watch?v=u96rVINbAUI
Using “root” as username and “123456” as password. Other settings are installed according to the default settings.


Also, user should install Navicat program.
https://www.navicat.com/en/download/navicat-for-mysql
Then create a connection. Use “root” as username and use “123456” as password. And user create a database named animedata in this connection. Right-click the “Table” to choose “New Table” button under animedata database, and design this table named anime as shown in the following figure. (Note that the first row is mal_id)

Name		Type		Length	 Decimals	Not null	 virtual   key  comment
mal_id		int			11		 0			√				  √
title			varchar		100		 0         √				  


After that, right-click the anime table, click "Execute SQL File" button, fill the anime.sql to the choosing box, and then click "start" to complete executing.




# -AnimeRecommendation_back-end
Use maven and SpringBoot
Import AnimeRecommendation_back-end to Intellij IDEA
In the Intellij program, click File -> Setting. In the setting, click "Plugins", find Lombok and install, then click apply. Then click the compiler in "Build, Execution, Deployment" in the setting, click "Annotation Processors" from compiler button. choose "Enable above annotation processing", then click apply and ok.



# animeRecommendation_front-end
First, download Visual Studio Code
https://code.visualstudio.com/
And node.js
https://nodejs.org/en/download/
Import animeRecommendation_front-end to Visual Studio Code
Click Terminal -> New Terminal. Enter the following corresponding commands in the command box

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

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
