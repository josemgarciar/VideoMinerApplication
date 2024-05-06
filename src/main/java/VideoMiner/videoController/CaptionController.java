package VideoMiner.videoController;

import VideoMiner.model.Channel;
import VideoMiner.repository.CaptionRepository;
import VideoMiner.model.Caption;
import java.util.*;

import exception.CaptionNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="VideoMiner caption", description = "Captions operations")
@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;

    @Operation(summary = "Find all captions", description = "Find all captions in the database", tags = { "Captions", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Captions from the database",
                    content = {@Content(schema = @Schema(implementation = Caption.class),
                            mediaType = "application/json")
                    })
    })
    @GetMapping
    public List<Caption> getCaptions() { return captionRepository.findAll(); }

    @Operation(summary = "Find a caption by id", description = "Find a caption by id in VideoMiner", tags = { "Captions", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Caption from VideoMiner by its ID",
                    content = {@Content(schema = @Schema(implementation = Caption.class),
                            mediaType = "application/json")
                    }),

            @ApiResponse(responseCode = "404", description = "Caption not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @GetMapping("/{id}")
    public Caption getCaptionById(@PathVariable String id) throws CaptionNotFoundException {
        Optional<Caption> foundCaption = captionRepository.findAll().stream().filter(c -> c.getId().equals(id)).findFirst();

        if (foundCaption.isEmpty()) {
            throw new CaptionNotFoundException();
        }

        return foundCaption.get();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caption create(@Valid @RequestBody Caption caption) {
        captionRepository.save(caption);
        return caption;
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
