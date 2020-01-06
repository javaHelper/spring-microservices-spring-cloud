package com.prateek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROOM")
public class Room {
	@Id
	@Column(name = "ROOM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ROOM_NUMBER")
	private String roomNumber;
	@Column(name = "BED_INFO")
	private String bedInfo;
}