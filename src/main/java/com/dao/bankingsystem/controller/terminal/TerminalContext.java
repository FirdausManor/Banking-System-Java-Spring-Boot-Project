package com.dao.bankingsystem.controller.terminal;

import java.util.Scanner;

public class TerminalContext {
	protected Scanner scanner;
	
	public TerminalContext(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Scanner getScanner() {
		return scanner;
	}
}
