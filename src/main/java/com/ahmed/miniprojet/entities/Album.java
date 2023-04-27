package com.ahmed.miniprojet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "album")
public class Album {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AlbumId;
	
	@NotNull
	@Size(min = 4, max = 35)
     private String AlbumName;
	
	@NotNull
    private String AlbumArtist;
	
	@NotNull
    private String AlbumDescription;
    
    @Min(value = 10)
  @Max(value = 1500)
  private Double AlbumPrice;
    
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date AlbumReleaseDate;
	
	
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long AlbumId;
//    @NotNull
//    @Size(min = 3, max = 35)
//    private String AlbumName;
//    @NotNull
//    private String AlbumArtist;
//    private String AlbumDescription;
//    @Min(value = 10)
//    @Max(value = 1500)
//    private Double AlbumPrice;
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @PastOrPresent
//    private Date AlbumReleaseDate;
    
    
    @ManyToOne
    @JoinColumn(name = "LabelId")
    private Label label;

    public Album(String albumName, String albumArtist, String albumDescription, Double albumPrice, Date albumReleaseDate, Label label) {
        AlbumName = albumName;
        AlbumArtist = albumArtist;
        AlbumDescription = albumDescription;
        AlbumPrice = albumPrice;
        AlbumReleaseDate = albumReleaseDate;
        this.label = label;
    }

    public Album() {
    }
}
