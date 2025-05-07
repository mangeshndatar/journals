package net.engeeringdigest.journalApp.controller;

import net.engeeringdigest.journalApp.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
@CrossOrigin(origins = "http://localhost:4200")
public class JournalController {

    private Map<Long,JournalEntity> journalEntry = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getEntries(){
        return new ArrayList<JournalEntity>(journalEntry.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntity newEntry){
            journalEntry.put(newEntry.getId(),newEntry);
            return true;
    }

    @GetMapping("/id/{id}")
    public JournalEntity getById(@PathVariable Long id){
        return journalEntry.get(id);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteById(@PathVariable Long id){
        journalEntry.remove(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntity updateById(@PathVariable Long id, @RequestBody JournalEntity entry){
        return journalEntry.put(id,entry);
    }
}
