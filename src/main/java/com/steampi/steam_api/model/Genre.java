package com.steampi.steam_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@AllArgsConstructor
@ToString
public class Genre {

	public String code;
	public String name;
	@Override
	public String toString() {
		return "Genre [code=" + code + ", name=" + name + "]";
	}
	
	
}
