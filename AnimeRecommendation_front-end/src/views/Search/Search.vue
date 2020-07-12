<template>
  <v-app>
    <v-row>
      <v-col
        md="auto"
        v-for="(item, i) in this.$store.state.searchContent"
        :key="i"
      >
        <v-skeleton-loader
          class="mx-auto"
          width="300"
          height="392"
          type="text,image,list-item-two-line"
          md="auto"
          v-if="loading"
        ></v-skeleton-loader>

        <v-card
          max-width="300"
          height="392"
          class="mx-auto"
          v-else
         @click="routerTo('/detail',item.mal_id)"
        >
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title class="headline">{{
                item.title
              }}</v-list-item-title>
              <v-list-item-subtitle>{{ item.source }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-img contain :src="item.image_url" height="194"></v-img>

          <v-card-text class="cardTitle">{{ item.synopsis }}</v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      loading: false,
      animeData: [],
    };
  },
  methods: {
    routerTo(url, id) {
      this.$router.push(url);
      this.$store.commit("saveAnimeID", id);
    },
  },
};
</script>

<style scoped>
.v-card__text {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
}
</style>
