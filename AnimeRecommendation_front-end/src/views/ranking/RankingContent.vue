<template>
  <v-app>
 <v-list >
      <v-subheader>RANKING</v-subheader>
      <v-list-item-group v-model="item" color="primary">
        <v-list-item
          v-for="(item, i) in animes"
          :key="i"
          @click="routerTo('/detail',item.mal_id)"
        >
          <v-list-item-icon>
           <v-img contain :src=item.image_url height="100"></v-img>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title v-text="item.title"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
   

  </v-app>
</template>

<script>
import request from "../../api/request.js";
  export default {
    data: () => ({
      item: 1,
      animes: [],
    }),

    methods:{

    routerTo(url,id) {
      this.$router.push(url);
        this.$store.commit("saveAnimeID",id);
    }
  },
    mounted:function(){
        var _this = this;
        request.getRanking(function(response){
            _this.animes = response.data.data;
        })
    }
  }
</script>