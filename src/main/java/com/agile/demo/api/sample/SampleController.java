package com.agile.demo.api.sample;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/samples")
@AllArgsConstructor
public class SampleController {

    private SampleRepository sampleRepository;
    @GetMapping
    public ResponseEntity<?> gets(){
        List<SampleEntity> list = sampleRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
}
