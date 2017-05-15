package com.greenfox.Controller;

import com.greenfox.Logic.Logic;
import com.greenfox.Model.CalorieTable;
import com.greenfox.Model.Error;
import com.greenfox.Model.Food;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/15/17.
 */
@RestController
public class DraxController {
  Error e;

  Logic logic = new Logic();

  @ExceptionHandler(Exception.class)
  public String handleAllExceptions() {
    return "Error happend";
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Error exception(MissingServletRequestParameterException er) {
    e = new Error("I am Groot!");
    return e;
  }

  @GetMapping("/drax")
  public CalorieTable calorieTable() {
    return logic.getCalorieTable();
  }


  @GetMapping("/drax/add")
  public CalorieTable addFood(@RequestParam("name") String name, @RequestParam("amount") int amount, @RequestParam("calorie") int calorie) {
    logic.addFood(name, amount, calorie);
    return logic.getCalorieTable();
  }

  @GetMapping("/drax/delete")
  public CalorieTable deleteFood(@RequestParam("name") String name) {
    logic.deleteFood(name);
    return logic.getCalorieTable();
  }

  @GetMapping("/drax/amount")
  public CalorieTable amountOffood(@RequestParam("name") String name, @RequestParam("amount") int amount) {
    logic.changeAmount(name, amount);
    return logic.getCalorieTable();
  }

}

