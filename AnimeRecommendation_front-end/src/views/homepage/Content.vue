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
          width="300"
          height="392"
          type="text,image,list-item-two-line"
          md="auto"
          v-if="loading"
        ></v-skeleton-loader>

        <v-card max-width="300" height="392" class="mx-auto" v-else @click="displayDetail">
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title class="headline">{{item.title}}</v-list-item-title>
              <v-list-item-subtitle>{{item.source}}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-img contain :src="item.image_url" height="194"></v-img>

          <v-card-text class="cardTitle">{{item.synopsis}}</v-card-text>
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
      animeData: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
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
    },
    displayDetail(){
      this.$router.push("/detail")
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
.v-card__text {
display: -webkit-box;
-webkit-box-orient: vertical;
-webkit-line-clamp: 2;
overflow: hidden;

}
</style>


