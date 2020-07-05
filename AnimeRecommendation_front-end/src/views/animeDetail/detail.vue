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
      <v-container>
        <v-card :loading="loading" class="mx-auto my-12" max-width="700">
          <v-img height="400" :src="animeDetail.image_url" contain></v-img>

          <v-card-title>{{animeDetail.title}}</v-card-title>

          <v-card-text>
            <div class="my-4 subtitle-1">janpanese:{{animeDetail.title_japanese}}</div>

            <div>{{animeDetail.synopsis}}</div>
          </v-card-text>

          <v-divider class="mx-4"></v-divider>

          <v-card-title>music</v-card-title>

          <v-card-text>
            <div>opening themes:{{animeDetail.opening_themes}}</div>
            <div>ending themes:{{animeDetail.ending_themes}}</div>
          </v-card-text>

          <v-card-actions>
            <v-btn color="deep-purple lighten-2" text @click="reserve">Reserve</v-btn>
          </v-card-actions>
        </v-card>
        <v-divider></v-divider>

        <v-textarea clearable clear-icon="cancel" label="comment:"></v-textarea>
        <div  class="d-flex flex-row-reverse myDvider">
           <v-btn color="primary">commit</v-btn>
        </div>
         
        <v-timeline :align-top="true" :dense="true">
          <v-timeline-item v-for="n in 3" :key="n" right="true" hide-dot="true">
            <v-card class="elevation-2" max-height="100px">
              <v-card-title class="headline">Lorem ipsum</v-card-title>
              <v-card-text>Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae.</v-card-text>
            </v-card>
          </v-timeline-item>
        </v-timeline>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import request from "../../api/request.js";
export default {
  data() {
    return {
      animeDetail: [],
      loading: false
    };
  },
  methods: {
    reserve() {
      var _this = this;
      request.getAnimeDetail(this.$store.state.anime_id, function(response) {
        _this.animeDetail = response.data;
      });
    }
  },
  mounted: function() {
    var _this = this;
    request.getAnimeDetail(this.$store.state.anime_id, function(response) {
      _this.animeDetail = response.data;
    });
  }
};
</script>

<style  scoped>


.myDvider{
  margin-bottom: 20px;
}
</style>
