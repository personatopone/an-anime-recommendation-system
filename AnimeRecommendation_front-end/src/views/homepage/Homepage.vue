<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app clipped>
      <v-list dense>
        <v-list-item link>
          <v-list-item-icon>
            <v-icon>mdi-alpha-s-box</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title @click="routerTo('/homepage')"
              >Season Anime</v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>

        <v-list-item link>
          <v-list-item-icon>
            <v-icon>mdi-chevron-triple-up</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title @click="routerTo('/homepage/ranking')"
              >Ranking</v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app clipped-left color="blue" dense>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-icon class="mx-4" large>mdi-google-ads</v-icon>
      <v-toolbar-title class="mr-12 align-center">
        <span class="title">Anime Recommendation</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>

      <v-row align="center" style="max-width: 650px">
        <v-col cols="3">
          <v-select
            :items="items"
            label="search type"
            class="search"
            v-model="searchType"
          ></v-select>
        </v-col>

        <v-col cols="9">
          <v-text-field
            v-on:keyup.enter="search"
            :append-icon-cb="() => {}"
            placeholder="Press enter to search"
            single-line
            append-icon="mdi-magnify"
            color="white"
            hide-details
            v-model="searchContent"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-app-bar>

    <v-main>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import request from "../../api/request.js";
export default {
  props: {
    source: String,
  },
  data: () => ({
    drawer: true,
    searchContent: "",
    items: ["Title", "Genre"],
    searchType: "",
  }),

  methods: {
    routerTo(url) {
      this.$router.push(url);
    },
    search() {
      var _this = this;
      if (this.searchType == "Title") {
        request.search(0, this.searchContent, function(response) {
         _this.$store.commit("setSearchContent", response.data.data);
        });
        this.$router.push("/homepage/search");
      } else if (this.searchType == "Genre") {
        request.search(1, this.searchContent, function(response) {
         _this.$store.commit("setSearchContent", response.data.data);
        });
        this.$router.push("/homepage/search");
      } else if (this.searchType == "") {
        alert("Please select a search type");
      }
    },
  },
  components: {},
  created() {
    this.$vuetify.theme.dark = false;
  },
};
</script>

<style scoped>
.search {
  position: relative;
  top: 11px;
}
</style>
