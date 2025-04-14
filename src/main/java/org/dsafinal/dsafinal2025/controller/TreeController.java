package org.dsafinal.dsafinal2025.controller;

import org.dsafinal.dsafinal2025.model.BinarySearchTreeResult;
import org.dsafinal.dsafinal2025.repository.BinarySearchTreeRepository;
import org.dsafinal.dsafinal2025.service.BinarySearchTreeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class TreeController {

    @Autowired
    private BinarySearchTreeService bstService;

    @Autowired
    private BinarySearchTreeRepository treeRepo;

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "redirect:/dashboard";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> processNumbers(@RequestParam("numbers") String numbers) {
        try {
            List<Integer> numList = Stream.of(numbers.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Map<String, Object> treeMap = bstService.processNumbers(numList);
            ObjectMapper mapper = new ObjectMapper();
            String treeJson = mapper.writeValueAsString(treeMap);
            BinarySearchTreeResult result = new BinarySearchTreeResult();
            result.setInputNumbers(numbers);
            result.setTreeJson(treeJson);
            treeRepo.save(result);
            return ResponseEntity.ok(treeMap);
        } catch (NumberFormatException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<BinarySearchTreeResult> results = treeRepo.findAll();
        model.addAttribute("results", results);
        return "dashboard";
    }
}

