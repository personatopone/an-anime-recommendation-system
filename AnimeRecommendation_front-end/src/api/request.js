import axios from 'axios'

export default{
    getSeasonAnime:function(season,year,callback){
        axios.get(`http://127.0.0.1:8081/api/anime/${season}/${year}`).then(function(response){
            callback(response)
        })
    }
}