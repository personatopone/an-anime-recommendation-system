import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    anime_id:null
  },
  mutations: {
    saveAnimeID(state,id){
      state.anime_id = id;
    }
  },
  actions: {
  },
  modules: {
  }
})
