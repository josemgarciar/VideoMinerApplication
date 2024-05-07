package VideoMiner.videoController;

import VideoMiner.model.Channel;
import VideoMiner.repository.CaptionRepository;
import VideoMiner.model.Caption;
import java.util.*;

import exception.CaptionNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="Captions", description = "Captions operations")
@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;

    @Operation(summary = "Find all captions", description = "Retrieve all captions from VideoMiner", tags = { "Captions", "Get Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Captions from the database",
                    content = {@Content(schema = @Schema(implementation = Caption.class),
                            mediaType = "application/json")
                    })
    })
    @GetMapping
    public List<Caption> getCaptions(@Parameter(description = "Name of the caption. Used to search channels by its name.") @RequestParam(required = false) String name,
                                     @Parameter(description = "If present, determines the order of the response according to the parameter received.")@RequestParam(required = false) String order, // + o -
                                     @Parameter(description = "Number of the response page. By default, VideoMiner will show the first page.")@RequestParam(defaultValue = "0") int page,
                                     @Parameter(description = "Size of the response page. By default, VideoMiner will show 5 captions per page.")@RequestParam(defaultValue = "5") int size) {

        Pageable paging;

        if (order != null) {
            if (order.startsWith("-"))
                paging = PageRequest.of(page, size, Sort.by(order.substring(1)).descending());
            else
                paging = PageRequest.of(page, size, Sort.by(order).ascending());
        } else {
            paging = PageRequest.of(page, size);
        }

        Page<Caption> pageCaptions;

        if(name == null) {
            pageCaptions = captionRepository.findAll(paging);
        } else {
            pageCaptions = captionRepository.findByName(name, paging);
        }
        return pageCaptions.getContent();

    }

    @Operation(summary = "Find a caption by id", description = "Find a caption by id in VideoMiner", tags = { "Captions", "Get operations"})
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
    public Caption getCaptionById(@Parameter(description = "ID of the caption to be searched") @PathVariable String id) throws CaptionNotFoundException {
        Optional<Caption> foundCaption = captionRepository.findAll().stream().filter(c -> c.getId().equals(id)).findFirst();

        if (foundCaption.isEmpty()) {
            throw new CaptionNotFoundException();
        }

        return foundCaption.get();
    }

    @Operation(summary = "Create a caption", description = "Post a caption to the database", tags = { "Captions", "Post Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Caption posted in the database",
                    content = {@Content(schema = @Schema(implementation = Caption.class),
                            mediaType = "application/json")
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caption create(@Parameter(description = "Caption to be posted in the database")@Valid @RequestBody Caption caption) {
        captionRepository.save(caption);
        return caption;
    }

    @Operation(summary = "Update a caption", description = "Update caption information given the caption ID.", tags = { "Captions", "Put Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Caption updated",
                    content = {@Content(schema = @Schema())
                    }),

            @ApiResponse(responseCode = "404", description = "Caption not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Parameter(description = "ID of the caption to be updated")@PathVariable Long id,
                       @Parameter(description = "Caption object with the updated information")@Valid @RequestBody Caption caption) throws CaptionNotFoundException {
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

    @Operation(summary = "Delete a caption", description = "Delete a caption from the database given the caption ID", tags = { "Captions", "Delete Operations"})
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Caption deleted",
                    content = {@Content(schema = @Schema())
                    }),
            @ApiResponse(responseCode = "404", description = "Caption not found",
                    content = {@Content(schema = @Schema())
                    })
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Parameter(description = "ID of the caption to be deleted")@PathVariable Long id) throws CaptionNotFoundException {
        Optional<Caption> captionToBeDeleted = captionRepository.findById(id);

        if (captionToBeDeleted.isEmpty()) {
            throw new CaptionNotFoundException();
        } else {
            Caption c = captionToBeDeleted.get();
            captionRepository.delete(c);
        }

    }








}
