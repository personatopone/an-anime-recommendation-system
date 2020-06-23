<template>
  <v-app>
      <v-app-bar app clipped-left color="blue" dense>
      <v-icon class="mx-4" large>mdi-google-ads</v-icon>
      <v-toolbar-title class="mr-12 align-center">
        <span class="title">Anime Recommendation</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-row align="center" style="max-width: 650px">
        <v-text-field
          :append-icon-cb="() => {}"
          placeholder="Search..."
          single-line
          append-icon="mdi-magnify"
          color="white"
          hide-details
        ></v-text-field>
      </v-row>
    </v-app-bar>

    <v-main>
        <v-container  class="d-flex flex-row justify-start">
            <v-img
              src="https://cdn.myanimelist.net/images/anime/1141/102223.jpg"
              height="500"
              width="200"
              contain
              class="grey darken-4"
            ></v-img>
            <v-img
              src="https://picsum.photos/350/165?rando m"
              height="125"
              contain
              class="grey darken-4"    
            ></v-img>
        </v-container>
    </v-main>
  </v-app>
</template>
