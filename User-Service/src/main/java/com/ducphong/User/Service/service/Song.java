package com.ducphong.User.Service.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private Integer songId;
    private String songTitle;
    private String artistName;
    private String genre;
    private Integer duration;
    private String filePath;
}
