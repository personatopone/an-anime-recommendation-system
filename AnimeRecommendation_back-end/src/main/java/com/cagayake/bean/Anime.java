package com.cagayake.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Anime {
    int mal_id;
    String title;
    String image_url;
    String type;
    String source;
    String synopsis;
    String season_year;
    String season_name;
}
