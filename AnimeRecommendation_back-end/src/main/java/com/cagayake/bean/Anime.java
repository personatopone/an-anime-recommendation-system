package com.cagayake.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Anime {
   private int mal_id;
   private String title;
   private String image_url;
   private  String type;
   private String source;
   private String synopsis;
   private String season_year;
   private String season_name;
   private String title_japanese;
   private String score;
   private int click_conut;
}
