package org.programarteduele.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="user_role")
public class Role {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="user_type", nullable=false, length=70)
	private String name;
	@Column(name="role", nullable=true, length=70)	
	private String description;

}
