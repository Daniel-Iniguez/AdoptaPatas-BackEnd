package org.programarteduele.app.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="notification_type")
public class NotificationType {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long typeId;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "redirect_url")
	    private String redirectUrl;

}
