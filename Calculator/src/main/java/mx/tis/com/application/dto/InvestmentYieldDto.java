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
* Nombre de archivo: InvestmentYieldDto.java
* Autor: calmaraz
* Fecha de creación: 7 sep. 2021
*/
package mx.tis.com.application.dto;

import lombok.Data;

/**
 * The Class InvestmentYieldDto.
 */

/**
 * Instantiates a new investment yield dto.
 */
@Data
public class InvestmentYieldDto {
  
  /** The investment year. */
  private Integer investmentYear;
  
  /** The yearly input. */
  private Double yearlyInput;
  
  /** The investment yield. */
  private Double investmentYield;
  
  /** The final balance. */
  private Double finalBalance;
  
  
}
