/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: ApplicationController.java
* Autor: calmaraz
* Fecha de creación: 8 sep. 2021
*/
package mx.tis.com.application.controller;

import mx.tis.com.application.dto.InitialInvestmentDto;
import mx.tis.com.application.dto.InvestmentYieldDto;
import mx.tis.com.application.service.CompoundInterestCalculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * The Class ApplicationController.
 */
@RestController
public class ApplicationController {
	
    /** The calculator. */
    private CompoundInterestCalculator calculator;
    
    /**
     * Instantiates a new application controller.
     *
     * @param calculator the calculator
     */
    public ApplicationController(CompoundInterestCalculator calculator) {
      this.calculator=calculator;
    }
    
    /**
     * Creates the table yield.
     *
     * @param contentType the content type
     * @param initialInvestment the initial investment
     * @return the list
     */
    @PostMapping(value="/api/v1/investors/calculators/ci")
    public List<InvestmentYieldDto> createTableYield(
        @RequestHeader(value="Content-Type",required=false) String contentType,
        @RequestBody InitialInvestmentDto initialInvestment){
     
      if (calculator.validateInput(initialInvestment)) {
        throw new CalculatorInputException("No es posible procesar su solicitud con los datos proporcionados");
      }
      return calculator.createRevenueGrid(initialInvestment);
    }
}
