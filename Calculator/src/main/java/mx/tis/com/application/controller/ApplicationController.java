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
import java.util.List;

/**
 * The Class ApplicationController.
 */
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
     * @param initialInvestment the initial investment
     * @return the list
     */
    public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestment){
      if (calculator.validateInput(initialInvestment)) {
        throw new CalculatorInputException("No es posible procesar su solicitud con los datos proporcionados");
      }
      return calculator.createRevenueGrid(initialInvestment);
    }
}
