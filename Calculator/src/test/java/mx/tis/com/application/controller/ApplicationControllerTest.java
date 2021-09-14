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
* Nombre de archivo: ApplicationControllerTest.java
* Autor: calmaraz
* Fecha de creación: 9 sep. 2021
*/
package mx.tis.com.application.controller;

import mx.tis.com.application.dto.InitialInvestmentDto;
import mx.tis.com.application.dto.InvestmentYieldDto;
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.application.service.impl.CompoundInterestCalculatorImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

/**
 * The Class ApplicationControllerTest.
 */
public class ApplicationControllerTest {
  
  /** The initial investment. */
  private InitialInvestmentDto initialInvestment;
  
  /** The calculator. */
  private CompoundInterestCalculator calculator;
  
  /** The controller. */
  private ApplicationController controller;

  /**
   * Creates the values before to test.
   */
  @Before
  public void createValuesBeforeToTest() {
    this.calculator = new CompoundInterestCalculatorImpl();
    this.controller = new ApplicationController(this.calculator);
    this.initialInvestment = new InitialInvestmentDto();

    this.initialInvestment.setInitialInvestment(5000.00);
    this.initialInvestment.setYearlyInput(3000.00);
    this.initialInvestment.setYearlyInputIncrement(1);
    this.initialInvestment.setInvestmentYears(5);
    this.initialInvestment.setInvestmentYield(21f);
  }

  /**
   * Should generate table yield.
   */
  @Test
  public void shouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield = controller.createTableYield(
        "application/json",initialInvestment);
    
    assertEquals(5, tableYield.size());
    InvestmentYieldDto firstYear = tableYield.get(0);
    assertEquals(Double.valueOf(5000.00), firstYear.getInitialInvestment());
    assertEquals(Double.valueOf(3000.00), firstYear.getYearlyInput());
    assertEquals(Double.valueOf(1680.00), firstYear.getInvestmentYield());
    assertEquals(Double.valueOf(9680.00), firstYear.getFinalBalance());
    InvestmentYieldDto secondYear = tableYield.get(1);
    assertEquals(Double.valueOf(9680.00), secondYear.getInitialInvestment());
    assertEquals(Double.valueOf(3030.00), secondYear.getYearlyInput());
    assertEquals(Double.valueOf(2670.00), secondYear.getInvestmentYield());
    assertEquals(Double.valueOf(15380.00), secondYear.getFinalBalance());
    InvestmentYieldDto fifthYear = tableYield.get(4);
    assertEquals(Double.valueOf(30738.00), fifthYear.getInitialInvestment());
    assertEquals(Double.valueOf(3122.00), fifthYear.getYearlyInput());
    assertEquals(Double.valueOf(7111.00), fifthYear.getInvestmentYield());
    assertEquals(Double.valueOf(40970.00), fifthYear.getFinalBalance());
  }
}
