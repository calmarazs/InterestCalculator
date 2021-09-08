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
import mx.tis.com.application.service.impl.CompoundInterestCalculatorImpl;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The Class ApplicationController.
 */
public class ApplicationController {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	  InitialInvestmentDto initialInvestmentDto=new InitialInvestmentDto();
	  CompoundInterestCalculatorImpl compoundInterestCalculatorImpl=new CompoundInterestCalculatorImpl();
	  
	  System.out.println("Inversión inicial: ");
      Scanner initialInvestmentScanner = new Scanner(System.in);
      Double initialInvestment = Double.valueOf(initialInvestmentScanner.nextLine());
      
      System.out.println("Aportación anual: ");
      Scanner yearlyInputScanner = new Scanner(System.in);
      Double yearlyInput = Double.valueOf(yearlyInputScanner.nextLine());
      
      System.out.println("Incremento anual: ");
      Scanner yearlyInputIncrementScanner = new Scanner(System.in);
      Integer yearlyInputIncrement = Integer.valueOf(yearlyInputIncrementScanner.nextLine());
      
      System.out.println("Años de inversión: ");
      Scanner investmentYearsScanner = new Scanner(System.in);
      Integer investmentYears = Integer.valueOf(investmentYearsScanner.nextLine());
      
      System.out.println("Rendimiento: ");
      Scanner investmentYieldScanner = new Scanner(System.in);
      Float investmentYield = Float.valueOf(investmentYieldScanner.nextLine());
      
      initialInvestmentDto.setInitialInvestment(initialInvestment);
      initialInvestmentDto.setYearlyInput(yearlyInput);
      initialInvestmentDto.setYearlyInputIncrement(yearlyInputIncrement);
      initialInvestmentDto.setInvestmentYears(investmentYears);
      initialInvestmentDto.setInvestmentYield(investmentYield);
      
      if (compoundInterestCalculatorImpl.validateInput(initialInvestmentDto)) {
        System.out.println("No es posible procesar su solicitud con los datos proporcionados");
      } else {
        
        List<InvestmentYieldDto> investmentYieldArray =
            compoundInterestCalculatorImpl.createRevenueGrid(initialInvestmentDto);
        for (int i = 0; i < investmentYieldArray.size(); i++) {
          System.out.println("\nAño: " + investmentYieldArray.get(i).getInvestmentYear() + "\n"
              + "Aportacion: " + Math.ceil(investmentYieldArray.get(i).getYearlyInput()) + "\n"
              + "Rendimiento: " + Math.ceil(investmentYieldArray.get(i).getInvestmentYield()) + "\n"
              + "Saldo final: " + Math.ceil(investmentYieldArray.get(i).getFinalBalance()));
        }
      }
      
      
	}
}
