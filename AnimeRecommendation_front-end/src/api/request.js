import axios from 'axios'

export default{
    getSeasonAnime:function(season,year,callback){
        axios.get(`http://127.0.0.1:8081/api/anime/${season}/${year}`).then(function(response){
            callback(response)
        })
    },
    getAnimeDetail:function(id,callback){
        axios.get(`https://api.jikan.moe/v3/anime/${id}`).then(function(response){
            callback(response)
        })
    },
}