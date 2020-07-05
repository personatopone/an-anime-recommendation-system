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
            <div>opening themes:{{op[1]}}</div>
            <div>ending themes:{{ed[1]}}</div>
          </v-card-text>

          <v-card-actions>
            <v-btn color="deep-purple lighten-2" text @click="reserve">Reserve</v-btn>
          </v-card-actions>
        </v-card>
        <v-divider></v-divider>

        <v-text-field label="name" placeholder="name" solo v-model="username"></v-text-field>
        <v-textarea clearable clear-icon="cancel" label="comment:" v-model="comment_content"></v-textarea>
        <div class="d-flex flex-row-reverse myDvider">
          <v-btn color="primary" @click="saveComment">submit</v-btn>
        </div>

        <v-timeline :align-top="true" :dense="true">
          <v-timeline-item v-for="(item,i) in comment" :key="i" right=true hide-dot=true>
            <v-card class="elevation-2" max-height="100px">
              <v-card-title class="headline">{{item.username}} time：{{item.time}}</v-card-title>
              <v-card-text>{{item.comment}}</v-card-text>
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
      loading: false,
      comment_content: "",
      username: "",
      comment: [],
      op:[],
      ed:[]
    };
  },
  methods: {
    reserve() {
      var _this = this;
     
      request.getAnimeDetail(this.$store.state.anime_id, function(response) {
        _this.animeDetail = response.data.data.anime; 
        _this.op = response.data.data.op;
        _this.ed = response.data.data.ed;
      });
    },
    saveComment() {
      var _this = this;
      var myDate = new Date();
      request.saveComment(
        this.username,
        myDate.toString(),
        this.comment_content,
        this.$store.state.anime_id,
        function(response) {
          console.log(response);
          _this.comment.push({
            "username": _this.username,
            "time":myDate.toString() ,
            "comment": _this.comment_content
          })
         
        }
      );
    }
  },
  mounted: function() {
    var _this = this;
     
      request.getAnimeDetail(this.$store.state.anime_id, function(response) {
        _this.animeDetail = response.data.data.anime; 
        _this.op = response.data.data.op;
        _this.ed = response.data.data.ed;

        console.log(response)
      });

    request.getComment(this.$store.state.anime_id, function(response) {
      _this.comment = response.data.data;
      console(response);
    });
  }
};
</script>

<style  scoped>
.myDvider {
  margin-bottom: 20px;
}
</style>
