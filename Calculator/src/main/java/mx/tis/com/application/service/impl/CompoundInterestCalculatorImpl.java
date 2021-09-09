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
* Nombre de archivo: CompoundInterestCalculatorImpl.java
* Autor: calmaraz
* Fecha de creación: 8 sep. 2021
*/
package mx.tis.com.application.service.impl;


import mx.tis.com.application.dto.InitialInvestmentDto;
import mx.tis.com.application.dto.InvestmentYieldDto;
import mx.tis.com.application.service.CompoundInterestCalculator;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class CompoundInterestCalculatorImpl.
 */
public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator{
  
  /**
   * Creates the revenue grid.
   *
   * @param initialInvestment the initial investment
   * @return the list
   */
  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment) {
    ArrayList<InvestmentYieldDto> investmentYieldArray=new ArrayList<>();

    for(int i=0; i<initialInvestment.getInvestmentYears(); i++) {
      InvestmentYieldDto investmentYieldDto=new InvestmentYieldDto();
      investmentYieldDto.setInvestmentYear(i+1);
      investmentYieldDto.setYearlyInput(initialInvestment.getYearlyInput());
      Double initialBalance=initialInvestment.getInitialInvestment();
      
      if(i>0) {
        investmentYieldDto.setYearlyInput(calculateYearlyInput(
            investmentYieldArray.get(i-1).getYearlyInput(),initialInvestment
            .getYearlyInputIncrement()));
        initialBalance=investmentYieldArray.get(i-1).getFinalBalance();
      }
      investmentYieldDto.setInitialInvestment(initialBalance);
      
      investmentYieldDto.setInvestmentYield(calculateInvestment(initialBalance,
          investmentYieldDto.getYearlyInput(),initialInvestment.getInvestmentYield()));
      
      investmentYieldDto.setFinalBalance(calculateFinalBalance(initialBalance, 
          investmentYieldDto.getYearlyInput(), investmentYieldDto.getInvestmentYield()));
      
      investmentYieldArray.add(i,investmentYieldDto);
    }
    return investmentYieldArray;
  } 
  
  /**
   * Calculate yearly input.
   *
   * @param yearlyInput the yearly input
   * @param yearlyInputIncrement the yearly input increment
   * @return the double
   */
  private Double calculateYearlyInput(Double yearlyInput, Integer yearlyInputIncrement) {
    return (yearlyInput * (1 + ((double)yearlyInputIncrement/100)));
  }
  
  /**
   * Calculate investment.
   *
   * @param initialBalance the initial balance
   * @param yearlyInput the yearly input
   * @param investmentYield the investment yield
   * @return the double
   */
  private Double calculateInvestment(Double initialBalance, Double yearlyInput, Float investmentYield) {
    return ((initialBalance+yearlyInput)*(investmentYield/100));
  }
  
  /**
   * Calculate final balance.
   *
   * @param initialBalance the initial balance
   * @param yearlyInput the yearly input
   * @param investmentYield the investment yield
   * @return the double
   */
  private Double calculateFinalBalance(Double initialBalance, Double yearlyInput, Double investmentYield) {
    return (initialBalance+yearlyInput+investmentYield);
  }

  /**
   * Validate input.
   *
   * @param initialInvestment the initial investment
   * @return true, if successful
   */
  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestment) {
    this.setDefaults(initialInvestment);
    
    return (initialInvestment.getInitialInvestment()<1000 || initialInvestment.getYearlyInput()<0 ||
        initialInvestment.getYearlyInputIncrement()<0 || initialInvestment.getInvestmentYield()<=0 ||
        initialInvestment.getInvestmentYears()<=0);
  }
  
  /**
   * Sets the defaults.
   *
   * @param initialInvestment the new defaults
   */
  private void setDefaults(InitialInvestmentDto initialInvestment) {
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput=yearlyInput==null ? 0.0: yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);
    
    Integer yearlyInputIncrement = initialInvestment.getYearlyInputIncrement();
    yearlyInputIncrement=yearlyInputIncrement==null ? 0: yearlyInputIncrement;
    initialInvestment.setYearlyInputIncrement(yearlyInputIncrement);
    
    Float investmentYield = initialInvestment.getInvestmentYield();
    investmentYield=investmentYield==null ? 0: investmentYield;
    initialInvestment.setInvestmentYield(investmentYield);
  }
  
}
