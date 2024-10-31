package com.steampi.steam_api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne // Mapeamento de muitos jogos para um gênero
	@JoinColumn(name = "generoId", referencedColumnName = "id", nullable = false) // Coluna de referência
	private GenreEntity genero;

	public String reqMin;

	public String reqRecommend;

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

	public GenreEntity getGenero() {
		return genero;
	}

	public void setGenero(GenreEntity genero) {
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
