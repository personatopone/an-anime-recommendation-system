<template>
  <v-app>
    <v-row justify="center">
      <v-col cols="2">
        <v-select v-model="yearValue" :items="year" label="Year" solo></v-select>
      </v-col>
      <v-col cols="2">
        <v-select v-model="seasonValue" :items="season" label="Season" solo></v-select>
      </v-col>

      <v-col cols="2">
        <div class="my-2">
          <v-btn small color="primary" @click="requestSeasonAnime">GO</v-btn>
        </div>
      </v-col>
    </v-row>

    <v-row>
      <v-col md="auto" v-for="(item,i) in animeData " :key="i">
        <v-skeleton-loader
          class="mx-auto"
          width="200"
          height="360"
          type="card,text,card-heading"
          md="auto"
          v-if="loading"
        ></v-skeleton-loader>
        <v-card class="mx-auto" width="270" height="360" v-else>
          <v-img :src="item.image_url" height="200px" contain></v-img>

          <v-card-title class="cardTitle">{{item.title}}</v-card-title>

          <v-card-subtitle>{{item.source}}</v-card-subtitle>

          <v-card-actions>
            <v-btn text>Share</v-btn>

            <v-btn color="purple" text>Explore</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>
import request from "../../api/request.js";
export default {
  data() {
    return {
      yearValue: 2020,
      seasonValue: "spring",
      year: [2015, 2016, 2017, 2018, 2019, 2020],
      season: ["spring", "summer", "fall", "winter"],
      loading: true,
      animeData: [
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
      ]
    };
  },
  methods: {
    requestSeasonAnime() {
      var _this = this;
      _this.loading = true;
      request.getSeasonAnime(this.yearValue, this.seasonValue, function(
        response
      ) {
        console.log(response);
        _this.animeData = response.data.anime;
        _this.loading = false;
      });
    }
  },
  mounted: function() {
    var _this = this;
    request.getSeasonAnime(this.yearValue, this.seasonValue, function(
      response
    ) {
      _this.animeData = response.data.anime;
      console.log(_this.animeData);
      _this.loading = false;
    });
  }
};
</script>

<style  scoped>
.cardTitle {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
</style>


