package com.cagayake.dataSave.JsonBean;

import com.cagayake.bean.Anime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonJsonList{
   private String season_name;
   private String season_year;
   private List<Anime> anime;

}
