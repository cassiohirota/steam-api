package com.steampi.steam_api.entity;

import java.util.ArrayList;
import java.util.List;

import dto.GenreDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GameEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
	private Integer id;

	public Integer codGame;

	public String name;

	public String descricao;

	@OneToMany // Mapeamento de muitos jogos para um gênero
	@JoinColumn(name = "generoId", referencedColumnName = "id", nullable = false) // Coluna de referência
	private List<GenreEntity> genero;

	public String reqMin;

	public String reqRecommend;

	public GameEntity() {
    }

	
	public GameEntity(Integer codGame, String name, String descricao, List<GenreDTO> genero, String reqMin,
			String reqRecommend) {
		super();
		this.codGame = codGame;
		this.name = name;
		this.descricao = descricao;
		this.reqMin = reqMin;
		this.reqRecommend = reqRecommend;
		convertDtoToEntity(genero);
	}

	private void convertDtoToEntity(List<GenreDTO> generoDto) {
		if (generoDto != null) {
	        generoDto.forEach(gen -> this.getGenero().add(new GenreEntity(gen.getName())));
	    } else {
	        this.genero = new ArrayList<>();
	    }
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodGame() {
		return codGame;
	}

	public void setCodGame(Integer codGame) {
		this.codGame = codGame;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<GenreEntity> getGenero() {
		if(this.genero == null) {
			this.genero = new ArrayList<GenreEntity>();
		}
		return genero;
	}

	public void setGenero(List<GenreEntity> genero) {
		this.genero = genero;
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
