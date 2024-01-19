package org.programarteduele.app.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="adoption_inquiry")
public class AdoptionInquiry {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne // Muchos aplicaciones pueden ser hechas por un usuario
	@JoinColumn(name = "inquiry_user_id")
	private User user;
	
	@ManyToOne //Muchas aplicaciones pueden contener una mascota
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	@Column(name="status", nullable=false, length=45)
	private String status;
	
	@Column(name="date_started", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStarted;

}
