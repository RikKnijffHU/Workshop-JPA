/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.first8.hu.ticketsale.venue;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import nl.first8.hu.ticketsale.artist.Genre;

/**
 *
 * @author Rik_k
 */
@Data

public class ConcertDTO {
     private long id;
    private String locationName;
    private String artistName;
    private Genre artistGenre;
    private String concertDate;
    
 public ConcertDTO(Long id,String locationName, String artistName, Genre genre, Date concertDate){
 this.id = id;
 this.locationName = locationName;
 this.artistName = artistName;
 this.artistGenre = genre;
 this.concertDate = concertDate.toString();
 }
}
