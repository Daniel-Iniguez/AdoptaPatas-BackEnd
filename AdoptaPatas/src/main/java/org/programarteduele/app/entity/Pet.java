package org.programarteduele.app.entity;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="pet")
public class Pet {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name", nullable=false, length=30)
	private String name;
	@Column(name="size", nullable=false, length=30)
	private String size;
	@Column(name="age", nullable=false, length=25)
	private String age;
	@Column(name="sex", nullable=false, length=20)
	private String sex;
	@Column(name="breed", nullable=false, length=30)
	private String breed;
	@Column(name="color", nullable=false, length=30)
	private String color;
	@Column(name="characteristics", columnDefinition="TINYTEXT")
	private String characteristics;
	@Column(name="description", columnDefinition="TEXT", nullable=false)
	private String description;
	@Column(name="pet_image", nullable=false, length=255)
	private String petImage;
	@Column(name="health_condition", columnDefinition="TINYTEXT", nullable=false)
	private String healthCondition;
	@Column(name="date_added", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;
	
	
	@ManyToOne
	@JoinColumn(name="pet_user_id",referencedColumnName = "id", nullable=false )
	@JsonIgnoreProperties()
	private User user;
	
	@ManyToOne
	@JoinColumn(name="pet_type_id",referencedColumnName = "id", nullable=false )
	@JsonIgnoreProperties()
	private PetType petType;
	
	@OneToMany(mappedBy = "pet")
    public Set<AdoptionInquiry> adoptionInquiry;
	
	

}
