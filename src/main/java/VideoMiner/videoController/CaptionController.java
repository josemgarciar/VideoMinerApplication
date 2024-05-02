package VideoMiner.videoController;

import VideoMiner.repository.CaptionRepository;
import VideoMiner.model.Caption;
import java.util.*;

import exception.CaptionNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("https://localhost:8080/videominer/captions")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;

    @GetMapping
    public List<Caption> getAll() { return captionRepository.findAll(); }

    @GetMapping("/{id}")
    public Caption getCaptionById(@PathVariable Long id) throws CaptionNotFoundException {
        Optional<Caption> foundCaption = captionRepository.findById(id);

        if (foundCaption.isEmpty()) {
            throw new CaptionNotFoundException();
        }

        return foundCaption.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caption create(@Valid @RequestBody Caption caption) {
        Caption newCaption = captionRepository.save(new Caption(caption));

        return newCaption;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @Valid @RequestBody Caption caption) throws CaptionNotFoundException {
        Optional<Caption> foundCaption = captionRepository.findById(id);

        if (foundCaption.isEmpty()){
            throw new CaptionNotFoundException();
        } else {
            Caption c = foundCaption.get();
            c.setLanguage(caption.getLanguage());
            c.setName(caption.getName());
            captionRepository.save(c);
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws CaptionNotFoundException {
        Optional<Caption> captionToBeDeleted = captionRepository.findById(id);

        if (captionToBeDeleted.isEmpty()) {
            throw new CaptionNotFoundException();
        } else {
            Caption c = captionToBeDeleted.get();
            captionRepository.delete(c);
        }

    }








}
