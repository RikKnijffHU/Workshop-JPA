package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/concert")
@Transactional
public class ConcertResource {

    private final ConcertService service;

    @Autowired
    public ConcertResource(ConcertService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ConcertDTO>> searchConcerts(@RequestParam("search") final String search) {
        try {
            List<ConcertDTO> concerts = service.searchConcert(search);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
