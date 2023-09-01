package com.test.sudoku.demo;

import org.springframework.data.repository.CrudRepository;


public interface SudokuRepository extends CrudRepository<Sudoku, String> {
	Sudoku findByUniqueLink(String uniqueLink);
}
