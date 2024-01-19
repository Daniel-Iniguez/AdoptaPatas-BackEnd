package org.programarteduele.app.entity;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="user")
public class User {
	@Id //Indica que el atributo será la clave primaria de la entidad
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Indica como se generan automaticamente las llaves primarias.
	private Long id;
	@Column(name="first_name", nullable=false, length=65)
	private String firstName; //Los tipo String son como VARCHAR en MySQL
	@Column(name="last_name", nullable=false, length=65)
	private String lastName;
	@Column(name="username", nullable=false, length=50, unique=true)
	private String username;
	@Column(name="age", nullable=false)
	private int age;
	@Column(name="email", nullable=false, length=100, unique=true)
	private String email;
	@Column(name="phone", nullable=false, length=16)
	private String phone;
	@Column(name="password_hash", nullable=false, length=45)
	private String password;
	@Column(name="registered_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime registrationDate;
	@Column(name="updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@Column(name="city", nullable=false, length=45)
	private String city;
	@Column(name="state", nullable=false, length=45)
	private String state;
	@Column(name="profile_picture", length=255)
	private String porfilePicture;
	@Column(name="bio")
	private String bio;
	@Column(name="activo")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="user_role", nullable=false)
	@JsonIgnoreProperties("description")
	private Role role;
	
	// Creación de la tabla follower a partir de @JoinTable con @JoinColumn para atribuir
	// nombres a las columnas 
		
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = { @JoinColumn(name = "following_id") }, inverseJoinColumns = {
			@JoinColumn(name = "followers_id") })
	private Set<User> following;

	@ManyToMany(mappedBy = "following", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<User> followers;
	
	// Un usuario puede publicar muchas mascotas
	// Relacion Bidireccional con "pet"
	@OneToMany(mappedBy = "user")
	private Set<Pet> pets;
	
	// Un usuario puede realizar varias solicitudes de adopción
	// Relacion Bidireccional con "adoption_inqiry"
	@OneToMany(mappedBy = "user")
	private Set<AdoptionInquiry> adoptionInquiries;
	
	// Un usuario puede tener muchas publicaciones
	// Relacion Bidireccional con "post"
	// -Properties annotated with @JsonProperty(access = Access.WRITE_ONLY)
	// will not be included while serializing (Java object to JSON in this case) the object
	// that contains them.
	@OneToMany(mappedBy="user")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Post> posts;
	
	// Un usuario puede realizar muchos comentarios
	// Relacion Bidireccional con "comment"
	@OneToMany(mappedBy = "user")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Comment> postComments;

	// Un usuario puede dar like a muchas publicaciones
	// Relacion Bidireccional con "post_likes"
	@OneToMany(mappedBy = "user")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<PostLike> postLikes;
	
	// Un usuario puede dar like a muchos comentarios
	// Relacion Bidireccional con "comment_likes"
	@OneToMany(mappedBy = "user")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<CommentLike> commentLikes;
	
	// Un usuario puede tener muchas notificaciones
	// Relacion Bidireccional con "notifications"
	@OneToMany(mappedBy = "user")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Notification> notification;
	
	
}

