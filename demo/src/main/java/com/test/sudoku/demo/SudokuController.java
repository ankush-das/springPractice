package com.test.sudoku.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
public class SudokuController {

    @Autowired
    private SudokuRepository sudokuRepository;

    @GetMapping("/sudoku")
    public String showSudokuForm() {
        return "sudokuForm";
    }

    @PostMapping("/solve")
    public String solveSudoku(@RequestParam("inputValues") String inputValues, Model model) {
        
        Sudoku sudoku = new Sudoku();
        String uniqueLink = generateUniqueLink();
        sudoku.setUniqueLink(uniqueLink);
        sudoku.setInputValues(inputValues);
        sudokuRepository.save(sudoku);

        model.addAttribute("uniqueLink", uniqueLink);
        return "sudokuForm";
    }

    private String generateUniqueLink() {
        return UUID.randomUUID().toString();
    }
    
    @GetMapping("/puzzle/{uniqueLink}")
    public String showSudokuPuzzle(@PathVariable String uniqueLink, Model model) {
        Sudoku sudoku = sudokuRepository.findByUniqueLink(uniqueLink);
        if (sudoku != null) {
            model.addAttribute("sudoku", sudoku);
            return "sudokuPuzzle";
        } else {
            // Handle invalid or not found link
            return "invalidLink";
        }
    }
}


