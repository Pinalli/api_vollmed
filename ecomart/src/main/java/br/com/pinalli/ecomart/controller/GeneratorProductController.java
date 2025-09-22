package br.com.pinalli.ecomart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generation-product")
public class GeneratorProductController {

    @GetMapping
 public String getGenerationProduct() {
  return "Generation Product";
 }
}
