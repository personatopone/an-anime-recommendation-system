package com.cagayake.dataSave.JsonBean;


import com.cagayake.bean.Genre;
import com.cagayake.bean.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDetailJson {
   private String title_japanese;
   private String score;
   private List<Genre>genres;
   private String[] opening_themes;
   private String[] ending_themes;

}
