package com.example.controller;

import com.example.domain.Stuff;
import com.example.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/stuff")
@RestController
public class StuffController {
    private StuffService stuffService;

    @Autowired
    public StuffController(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Page<Stuff>> findAll(Pageable pageable) {
        Page<Stuff> stuffPage = stuffService.findAll(pageable);
        return new ResponseEntity<Page<Stuff>>(stuffPage, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Stuff> findOne(@PathVariable("id") Integer id) {
        Stuff stuff = stuffService.findOne(id);
        return new ResponseEntity<Stuff>(stuff, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        stuffService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Stuff> create(@RequestBody Stuff stuff) {
        Stuff stuffSaved = stuffService.create(stuff);
        return new ResponseEntity<Stuff>(stuffSaved, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Stuff> update(@RequestBody Stuff stuff, @PathVariable("id") Integer id) {
        stuff.setId(id);
        Stuff stuffSaved = stuffService.update(stuff);
        return new ResponseEntity<Stuff>(stuffSaved, HttpStatus.OK);
    }

}
