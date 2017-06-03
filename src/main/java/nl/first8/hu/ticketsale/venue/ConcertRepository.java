package nl.first8.hu.ticketsale.venue;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import nl.first8.hu.ticketsale.artist.Genre;

@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ConcertDTO> findByArtistName(String name) {
        String jpql = "SELECT DISTINCT NEW nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate)  FROM Concert c WHERE c.artist.name LIKE :name";
        TypedQuery<ConcertDTO> query = entityManager.createQuery(jpql, ConcertDTO.class);
        query.setParameter("name", "%"+name+"%");
        return query.getResultList();
    }
 public List<ConcertDTO> findByLocation(String name) {
        String jpql = "SELECT DISTINCT NEW nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate)  FROM Concert c WHERE c.location.name LIKE :name";
        TypedQuery<ConcertDTO> query = entityManager.createQuery(jpql, ConcertDTO.class);
        query.setParameter("name", "%"+name+"%");
        return query.getResultList();
    }
  public List<ConcertDTO> findByGenre(String name) {
    try { 
      Genre genre = Genre.valueOf(name);
        String jpql = "SELECT DISTINCT NEW nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate)  FROM Concert c WHERE c.artist.genre = :name";
        TypedQuery<ConcertDTO> query = entityManager.createQuery(jpql, ConcertDTO.class);
        query.setParameter("name", genre);
        return query.getResultList();
    }catch (IllegalArgumentException ex){
          return new ArrayList<>();        }
    }
   public List<ConcertDTO> findByDate(String searchdate) {
       try{ 
       Date date = Date.valueOf(searchdate);
        String jpql = "SELECT DISTINCT NEW nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.concertDate > :date";
        TypedQuery<ConcertDTO> query = entityManager.createQuery(jpql, ConcertDTO.class);
        query.setParameter("date", date);
        return query.getResultList();
       } catch (IllegalArgumentException ex){
           ex.printStackTrace();
           return new ArrayList<>();
           
       }
    }
  


}
