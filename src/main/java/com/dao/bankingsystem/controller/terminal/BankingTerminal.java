package com.dao.bankingsystem.controller.terminal;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.bankingsystem.controller.terminal.ATMTerminalAPI;
import com.dao.bankingsystem.controller.terminal.AdminTerminalAPI;
import com.dao.bankingsystem.controller.terminal.CDMTerminalAPI;
import com.dao.bankingsystem.controller.terminal.TerminalContext;

public class BankingTerminal {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	protected boolean running = false;
	/*
	@Autowired
	protected AdminTerminalController adminTerminalController;
	
	@Autowired
	protected ATMTerminalController atmTerminalController;
	
	@Autowired
	protected CDMTerminalController cdmTerminalController;
	*/
	
	public void run() {
		logger.info("### BankingTerminalController.run ###");
		
		try (Scanner scanner = new Scanner(System.in)) {
			TerminalContext terminalContext = new TerminalContext(scanner);
			
			running = true;
			
			do {
				displayMainMenu();
				
				System.out.print("Main > Enter selected menu : ");
				String command = scanner.nextLine();
				
				switch(command) {
					case "1" -> executeAdminCommand(terminalContext);
					case "2" -> executeAtmCommand(terminalContext);
					case "3" -> executeCdmCommand(terminalContext);
					case "q" -> executeExitCommand(terminalContext);
					default -> System.out.println("Main > Incorrect command, please type again");
				}
			} while(running);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} 
	}
	
	protected void displayMainMenu() {
		System.out.println("\n---------- Banking Terminal ----------");
		System.out.println("---------- Select Menu ----------");
		System.out.println("'1' -> Admin");
		System.out.println("'2' -> ATM");
		System.out.println("'3' -> CDM");
		System.out.println("'q' -> Exit");
		System.out.println();
	}
	
	protected void executeAdminCommand(TerminalContext terminalContext) {
		logger.info("### BankingTerminalController.executeAdminCommand ###");
		//adminTerminalController.commandPrompt(terminalContext);
	}
	
	protected void executeAtmCommand(TerminalContext terminalContext) {
		logger.info("### BankingTerminalController.executeAtmCommand ###");
		//atmTerminalController.commandPrompt(terminalContext);
	}
	
	protected void executeCdmCommand(TerminalContext terminalContext) {
		logger.info("### BankingTerminalController.executeCdmCommand ###");
		//cdmTerminalController.commandPrompt(terminalContext);
	}
	
	protected void executeExitCommand(TerminalContext terminalContext) {
		logger.info("### BankingTerminalController.executeExitCommand ###");
		
		System.out.print("Main > Are you sure to exit terminal, type 'Y' to confirm or 'N' to cancel : ");
		String result = terminalContext.getScanner().nextLine();
		
		if (result.equalsIgnoreCase("Y")) {
			running = false;
			System.out.println("Exit From Main Terminal");
		}
	}
}
