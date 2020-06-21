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
      <v-col md="auto" v-for="(a,i) in a " :key="i">
        <v-skeleton-loader class="mx-auto" width="368" height="362" type="card,text,card-heading" md="auto" v-if="loading"></v-skeleton-loader>
          <v-card class="mx-auto" max-width="344" v-else>
            <v-img src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg" height="200px"></v-img>

            <v-card-title>Top western road trips</v-card-title>

            <v-card-subtitle>1,000 miles of wonder</v-card-subtitle>

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
export default {
  data() {
    return {
      yearValue: null,
      seasonValue: null,
      year: [2015, 2016, 2017, 2018, 2019, 2020],
      season: ["Spring", "Summer", "fall", "winter"],
      loading:true,
      a: [1, 2, 3, 4, 5]
    };
  },
  methods: {
    requestSeasonAnime() {
      console.log(this.yearValue + this.seasonValue);
      this.loading=!this.loading
    }
  }
};
</script>