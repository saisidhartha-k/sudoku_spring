package com.sudoku.game.controller;

import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sudoku.game.model.SudokuGenerator;

@Controller
public class SudokuController {

    @GetMapping("/input")
    public String showInputForm(Model model) {
        SudokuGenerator generator = new SudokuGenerator();
        model.addAttribute("generator", generator);
        return "input"; 
    }

    @PostMapping("/input")
    public String generatePuzzle(SudokuGenerator generator, Model model) {
        int[][] puzzle = generator.generatePuzzle();
        model.addAttribute("puzzle", puzzle);
        return "generated"; 
    }

    @GetMapping("/input/board")
    public String showBoard()
    {
        return "generated";
    }
}
