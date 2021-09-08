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
* Nombre de archivo: CompoundInterestCalculator.java
* Autor: calmaraz
* Fecha de creación: 7 sep. 2021
*/
package mx.tis.com.application.service;

import mx.tis.com.application.dto.InitialInvestmentDto;
import mx.tis.com.application.dto.InvestmentYieldDto;
import java.util.List;

/**
 * The Interface CompoundInterestCalculator.
 */
public interface CompoundInterestCalculator {
  
  /**
   * Creates the revenue grid.
   *
   * @param initialInvestment the initial investment
   * @return the list
   */
  List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment);

  /**
   * Validate input.
   *
   * @param initialInvestment the initial investment
   * @return true, if successful
   */
  boolean validateInput(InitialInvestmentDto initialInvestment);
}
