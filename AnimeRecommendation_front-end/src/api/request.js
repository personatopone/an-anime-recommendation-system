import axios from 'axios'

export default{
    getSeasonAnime:function(season,year,callback){
        axios.get(`http://127.0.0.1:8081/api/anime/${season}/${year}`).then(function(response){
            callback(response)
        })
    },
    getAnimeDetail:function(id,callback){
        axios.get(`http://127.0.0.1:8081/api/anime/get/${id}`).then(function(response){
            callback(response)
        })
    },
    saveComment:function(username,time,comment_content,mal_id,callback){
        axios.get(`http://127.0.0.1:8081/api/comment/save/${username}/${time}/${comment_content}/${mal_id}`).then(function(response){
            callback(response)
        })
    },
    getComment:function(mal_id,callback){
        axios.get(`http://127.0.0.1:8081/api/comment/get/${mal_id}`).then(function(response){
            callback(response)
            console.log(mal_id+"adssad");
        })
    },
    getRanking:function(callback){
        axios.get(`http://127.0.0.1:8081/api/anime/ranking`).then(function(response){
            callback(response)
        })
    }
}