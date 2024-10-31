package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDTO {
    private int id;
    private String name;
    private String desc;
    
    @JsonProperty("genero")
    private List<GenreDTO> genre; // Note que "genero" é mapeado para "genre"
    
    private String reqMin;
    private String reqRecommend;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<GenreDTO> getGenre() {
        return genre;
    }

    public void setGenre(List<GenreDTO> genre) {
        this.genre = genre;
    }

    public String getReqMin() {
        return reqMin;
    }

    public void setReqMin(String reqMin) {
        this.reqMin = reqMin;
    }

    public String getReqRecommend() {
        return reqRecommend;
    }

    public void setReqRecommend(String reqRecommend) {
        this.reqRecommend = reqRecommend;
    }
}