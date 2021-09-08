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
* Nombre de archivo: InitialInvestmentDto.java
* Autor: calmaraz
* Fecha de creación: 7 sep. 2021
*/
package mx.tis.com.application.dto;

/**
 * The Class InitialInvestmentDto.
 */
public class InitialInvestmentDto {
  
  /** The initial investment. */
  private Double initialInvestment;
  
  /** The yearly input. */
  private Double yearlyInput;
  
  /** The yearly input increment. */
  private Integer yearlyInputIncrement;
  
  /** The investment yield. */
  private Float investmentYield;
  
  /** The investment years. */
  private Integer investmentYears;

  /**
   * Gets the initial investment.
   *
   * @return the initial investment
   */
  public Double getInitialInvestment() {
    return initialInvestment;
  }

  /**
   * Sets the initial investment.
   *
   * @param initialInvestment the new initial investment
   */
  public void setInitialInvestment(Double initialInvestment) {
    this.initialInvestment = initialInvestment;
  }

  /**
   * Gets the yearly input.
   *
   * @return the yearly input
   */
  public Double getYearlyInput() {
    return yearlyInput;
  }

  /**
   * Sets the yearly input.
   *
   * @param yearlyInput the new yearly input
   */
  public void setYearlyInput(Double yearlyInput) {
    this.yearlyInput = yearlyInput;
  }

  /**
   * Gets the yearly input increment.
   *
   * @return the yearly input increment
   */
  public Integer getYearlyInputIncrement() {
    return yearlyInputIncrement;
  }

  /**
   * Sets the yearly input increment.
   *
   * @param yearlyInputIncrement the new yearly input increment
   */
  public void setYearlyInputIncrement(Integer yearlyInputIncrement) {
    this.yearlyInputIncrement = yearlyInputIncrement;
  }

  /**
   * Gets the investment yield.
   *
   * @return the investment yield
   */
  public Float getInvestmentYield() {
    return investmentYield;
  }

  /**
   * Sets the investment yield.
   *
   * @param investmentYield the new investment yield
   */
  public void setInvestmentYield(Float investmentYield) {
    this.investmentYield = investmentYield;
  }

  /**
   * Gets the investment years.
   *
   * @return the investment years
   */
  public Integer getInvestmentYears() {
    return investmentYears;
  }

  /**
   * Sets the investment years.
   *
   * @param investmentYears the new investment years
   */
  public void setInvestmentYears(Integer investmentYears) {
    this.investmentYears = investmentYears;
  }


}
