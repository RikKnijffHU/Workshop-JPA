package nl.first8.hu.ticketsale.venue;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConcertService {

    private final ConcertRepository concertRepository;
 
   @Autowired
   public ConcertService(ConcertRepository concertRepository){
       this.concertRepository = concertRepository;
    }

     public List<ConcertDTO> searchConcert(String search){
        List<ConcertDTO> result = new ArrayList<>();
        result.addAll(concertRepository.findByGenre(search));
        result.addAll(concertRepository.findByArtistName(search));
        result.addAll(concertRepository.findByLocation(search));
        result.addAll(concertRepository.findByDate(search));
        return result;
    }

}
