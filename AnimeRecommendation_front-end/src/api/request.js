import axios from 'axios'

export default{
    getSeasonAnime:function(season,year,callback){
        axios.get(`https://api.jikan.moe/v3/season/${season}/${year}`).then(function(response){
            callback(response)
        })
    }
}