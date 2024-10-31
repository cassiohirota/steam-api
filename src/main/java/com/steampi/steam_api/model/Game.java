package com.steampi.steam_api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {

	public int id;
	public String name;
	public String desc;
	public List<Genre> genero;
	public String reqMin;
	public String reqRecommend;
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", desc=" + desc + ", genero=" + genero + ", reqMin=" + reqMin
				+ ", reqRecommend=" + reqRecommend + "]";
	}
	
	
	
	
	
}
