import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    anime_id:0,
    searchContent:null
  },
  mutations: {
    saveAnimeID(state,id){
      state.anime_id = id;
    },
    setSearchContent(state,content){
      state.searchContent=content;
    }
  },
  actions: {
  },
  modules: {
  }
})
