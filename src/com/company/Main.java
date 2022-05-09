package com.company;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.lang.Boolean.FALSE;

public class Main {
	
	public static String getBetweenStrings(
			String text,
			String textFrom,
			String textTo) {
		
		String result = "";
		
		// Cut the beginning of the text to not occasionally meet a
		// 'textTo' value in it:
		result =
				text.substring(
						text.indexOf(textFrom) + textFrom.length(),
						text.length());
		
		// Cut the excessive ending of the text:
		result =
				result.substring(
						0,
						result.indexOf(textTo));
		
		return result;
	}
	
	public static String hexToBin(String hex) {
		hex = hex.replaceAll("0", "0000");
		hex = hex.replaceAll("1", "0001");
		hex = hex.replaceAll("2", "0010");
		hex = hex.replaceAll("3", "0011");
		hex = hex.replaceAll("4", "0100");
		hex = hex.replaceAll("5", "0101");
		hex = hex.replaceAll("6", "0110");
		hex = hex.replaceAll("7", "0111");
		hex = hex.replaceAll("8", "1000");
		hex = hex.replaceAll("9", "1001");
		hex = hex.replaceAll("A", "1010");
		hex = hex.replaceAll("B", "1011");
		hex = hex.replaceAll("C", "1100");
		hex = hex.replaceAll("D", "1101");
		hex = hex.replaceAll("E", "1110");
		hex = hex.replaceAll("F", "1111");
		return hex;
	}
	
	public static String addZeros(String x, int num) {
		while (x.length() < num)
			x = "0" + x;
		System.out.println(x);
		return x;
	}
	
	public static String removezeros(String opcode) {
		int x = Integer.parseInt(opcode, 16);
		String binary = Integer.toBinaryString(x);
		binary = addZeros(binary, 8);
		binary = binary.substring(0, binary.length() - 2);
		System.out.println(binary);
		return binary;
	}
	
	public static String binToHex(String hex) {
		hex = hex.replaceAll("0000", "0");
		hex = hex.replaceAll("0001", "1");
		hex = hex.replaceAll("0010", "2");
		hex = hex.replaceAll("0011", "3");
		hex = hex.replaceAll("0100", "4");
		hex = hex.replaceAll("0101", "5");
		hex = hex.replaceAll("0110", "6");
		hex = hex.replaceAll("0111", "7");
		hex = hex.replaceAll("1000", "8");
		hex = hex.replaceAll("1001", "9");
		hex = hex.replaceAll("1010", "A");
		hex = hex.replaceAll("1011", "B");
		hex = hex.replaceAll("1100", "C");
		hex = hex.replaceAll("1101", "D");
		hex = hex.replaceAll("1110", "E");
		hex = hex.replaceAll("1111", "F");
		return hex;
	}
	
	public static void main(String[] args) throws IOException {
		
		/*...........................................................ARRAY LISTS AND HASHTABLE..................................................................*/
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> variables = new ArrayList<String>();
		ArrayList<String> instructions2 = new ArrayList<String>();
		ArrayList<Integer> format = new ArrayList<Integer>();
		ArrayList<String> variables2 = new ArrayList<String>();
		ArrayList<String> LOCATIONS = new ArrayList<String>();
		ArrayList<String> opcode = new ArrayList<String>();
		ArrayList<String> variables3 = new ArrayList<String>();
		ArrayList<String> variables3VALUE = new ArrayList<String>();
		ArrayList<String> relocationLABEL = new ArrayList<String>();
		ArrayList<String> relocationINSTRUCTION = new ArrayList<String>();
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		ArrayList<String> a4 = new ArrayList<String>();
		ArrayList<String> b1 = new ArrayList<String>();
		ArrayList<String> b2 = new ArrayList<String>();
		ArrayList<String> b3 = new ArrayList<String>();
		ArrayList<String> b4 = new ArrayList<String>();
		ArrayList<String> c1 = new ArrayList<String>();
		ArrayList<String> c2 = new ArrayList<String>();
		ArrayList<String> c3 = new ArrayList<String>();
		ArrayList<String> c4 = new ArrayList<String>();
		ArrayList<String> mrecords = new ArrayList<String>();
		
		
		Hashtable<String, String> numbers = new Hashtable<String, String>();
		Set<String> keys = numbers.keySet();
		
		/*..................................................................FILES AND PRINTERS...................................................................*/
		
		File file1 = new File("/Users/saintadel/Documents/iCollections/uni courses/my whole work/pass onee/newinpit");
		Scanner sc1 = new Scanner(file1, "UTF-8");
		File file2 = new File("/Users/saintadel/Documents/iCollections/uni courses/my whole work/pass onee/instructionset");
		Scanner sc2 = new Scanner(file2, "UTF-8");
		File file3 = new File("/Users/saintadel/Documents/iCollections/uni courses/my whole work/pass onee/format2table");
		Scanner sc3 = new Scanner(file3, "UTF-8");
		FileWriter fileWriter = new FileWriter("/Users/saintadel/Documents/iCollections/uni courses/my whole work/pass onee/pass1.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		FileWriter fileWriter2 = new FileWriter("/Users/saintadel/Documents/iCollections/uni courses/my whole work/pass onee/symboltable.txt");
		PrintWriter printWriter2 = new PrintWriter(fileWriter2);
		FileWriter fileWriter3 = new FileWriter("/Users/saintadel/Documents/iCollections/uni courses/my whole work/pass onee/HTEtable.txt");
		PrintWriter printWriter3 = new PrintWriter(fileWriter3);
		/*................................................READING FROM FILES AND ADDING TO ARRAYLISTS............................................................*/
		
		int Counter = 0;
		/* READING FROM THE SOURCE CODE FILE*/
		while (sc1.hasNext()) {
			String Line1 = sc1.nextLine();
//               Line1.replace("  "," ");
			String[] Lines_after_splitting1 = Line1.split("\\t", 3);
			labels.add(Lines_after_splitting1[0]);
			instructions.add(Lines_after_splitting1[1]);
			variables.add(Lines_after_splitting1[2]);
			Counter++;
		}
		/* READING FROM THE INSTRUCTIONSET FILE*/
		while (sc2.hasNext()) {
			String Line2 = sc2.nextLine();
			String[] Lines_after_splitting2 = Line2.split(" ", 3);
			instructions2.add(Lines_after_splitting2[0]);
			format.add(Integer.parseInt(Lines_after_splitting2[1]));
			variables2.add(Lines_after_splitting2[2]);
		}
		
		while (sc3.hasNext()) {
			String Line3 = sc3.nextLine();
			String[] Lines_after_splitting3 = Line3.split(" ", 2);
			variables3.add(Lines_after_splitting3[0]);
			variables3VALUE.add(Lines_after_splitting3[1]);
			
		}
		/*.....................................................................PASS ONE..........................................................................*/
		
		
		/*Relocation*/
		int m = 0;
		
		for (int j = 0; j < Counter; j++) {
			if (variables.get(j).startsWith("=X") || variables.get(j).startsWith("=C")) {
				relocationINSTRUCTION.add(variables.get(j));
			}
		}
		
		int posLTORG = -1;
		for (int j = 0; j < Counter; j++) {
			if (instructions.get(j).equals("LTORG")) {
				posLTORG = instructions.indexOf(instructions.get(j));
			}
		}
		
		if (posLTORG != -1) {
			for (int j = posLTORG; j < Counter; j++) {
				if ((variables.get(j).startsWith("=X") || variables.get(j).startsWith("=C"))) {
					m++;
				}
			}
		}
		
		for (int j = 0; j < instructions.size(); j++) {
			if (instructions.get(j).equals("LTORG")) {
				for (int i = relocationINSTRUCTION.size() - m - 1; i >= 0; i--) {
					labels.add(j + 1, "*");
					instructions.add(j + 1, relocationINSTRUCTION.get(i));
					variables.add(j + 1, "%");
				}
			}
			if (instructions.get(j).equals("END")) {
				for (int i = relocationINSTRUCTION.size() - 1; i >= relocationINSTRUCTION.size() - m; i--) {
					labels.add(j + 1, "*");
					instructions.add(j + 1, relocationINSTRUCTION.get(i));
					variables.add(j + 1, "%");
				}
			}
		}
		
		
		String location = (variables.get(0));
		LOCATIONS.add(location);
		
		for (int j = 0; j < instructions.size(); j++) {
			if (instructions.get(j).equals("BASE")||instructions.get(j).equals("EXTEDF")||instructions.get(j).equals("EXTREF")) {
//				printWriter.write("....."+"\t"+labels.get(j)+"\t"+instructions.get(j)+"\t"+ variables.get(j)+"\n");
				LOCATIONS.add(j, "....");
//				LOCATIONS.set(j, "....");
			} else if (instructions.get(j).equals("RESB")) {
				location = Integer.toHexString(Integer.parseInt(location, 16) + Integer.parseInt(variables.get(j)));
				LOCATIONS.add(location);
			} else if (instructions.get(j).equals("RESW")) {
				location = Integer.toHexString(Integer.parseInt(location, 16) + 3 * Integer.parseInt(variables.get(j)));
				LOCATIONS.add(location);
			} else if (instructions.get(j).startsWith("+")) {
				location = Integer.toHexString(Integer.parseInt(location, 16) + 4);
				LOCATIONS.add(location);
			} else if (instructions.get(j).equals("START")) {
				String location2 = (variables.get(0));
				LOCATIONS.add(location2);
			} else if (instructions.get(j).equals("END")) {
				continue;
			} else if (instructions.get(j).equals("LTORG")) {
				LOCATIONS.add(j, "....");
			} else if (instructions.get(j).equals("BYTE")) {
				if (variables.get(j).startsWith("X")) {
					location = Integer.toHexString(Integer.parseInt(location, 16) + (variables.get(j).length() - 3) / 2);
					LOCATIONS.add(location);
				} else {
					location = Integer.toHexString(Integer.parseInt(location, 16) + (variables.get(j).length() - 3));
					LOCATIONS.add(location);
				}
			}
			
			/* LITERALS*/
			else if (instructions.get(j).startsWith("=")) {
				if (instructions.get(j).contains("X")) {
					location = Integer.toHexString(Integer.parseInt(location, 16) + (instructions.get(j).length() - 4) / 2);
					LOCATIONS.add(location);
				} else {
					location = Integer.toHexString(Integer.parseInt(location, 16) + (instructions.get(j).length() - 4));
					LOCATIONS.add(location);
				}
			}
			
			/* MYSTERY FROMAT 5*/
			else if (instructions.get(j).contains("&")) {
				location = Integer.toHexString(Integer.parseInt(location, 16) + 3);
				LOCATIONS.add(location);
			}
			
			/* MYSTERY FROMAT 6*/
			else if (instructions.get(j).contains("$")) {
				location = Integer.toHexString(Integer.parseInt(location, 16) + 4);
				LOCATIONS.add(location);
			} else if (instructions.get(j).equals("WORD")) {
				location = Integer.toHexString(Integer.parseInt(location, 16) + Integer.parseInt(variables.get(j), 16) * 3);
				LOCATIONS.add(location);
			}
			
			/* ALL FORMATS TILL 4*/
			else {
				int z;
				int pos = instructions2.indexOf(instructions.get(j));
				if (pos == -1)
					z = 1;
				else {
					location = Integer.toHexString(Integer.parseInt(location, 16) + format.get(pos));
					LOCATIONS.add(location);
				}
			}
		}
		/*.......................................................................................................................................................*/
		
		for (int q = 0; q < Counter; q++) {
			if (labels.get(q) != "") {
				int pos = labels.indexOf(labels.get(q));
				numbers.put(LOCATIONS.get(pos).toUpperCase(), labels.get(q));
			}
		}
		
		for (String w : keys) {
			printWriter2.write(w + " " + numbers.get(w) + "\n");
		}
		
		for (int x = 0; x < instructions.size(); x++) {
			printWriter.write(LOCATIONS.get(x).toUpperCase() + "\t" + labels.get(x) + "\t" + instructions.get(x) + "\t" + variables.get(x) + "\n");
		}
		printWriter.write("__________________________________________________________\n");
		/*.....................................................................PASS TWO..........................................................................*/
		
		String str = "0";
		int cccccc = 0;// counter for format 4 arraylists
		int dddddd = 0;// counter for format 3 arraylists
		int eeeeee = 0;
		int ffffff = 0;
		
		for (int j = 0; j < instructions.size(); j++) {
			
			int z;
			int pos = instructions2.indexOf(instructions.get(j));
			if (pos == -1) {
				if (instructions.get(j).equals("BYTE")) {
					if (variables.get(j).startsWith("X")) {
						String byteOPcode = getBetweenStrings(variables.get(j), "'", "'");
						int Size = byteOPcode.length();
						opcode.add(str.repeat(6 - Size).concat(byteOPcode).toUpperCase());
					} else {
						String byteOPcode = getBetweenStrings(variables.get(j), "'", "'");
						String CHEXA = "";
						for (int kk = 0; kk < byteOPcode.length(); kk++) {
							char letter = byteOPcode.charAt(kk);
							int ascii = (int) letter;
							CHEXA = CHEXA.concat(Integer.toHexString(ascii));
						}
						int Size = CHEXA.length();
						opcode.add(str.repeat(6 - Size).concat(CHEXA).toUpperCase());
					}
				} else if (instructions.get(j).equals("BASE")) {
					opcode.add("....");
				} else if (instructions.get(j).equals("START") || instructions.get(j).equals("END") || instructions.get(j).equals("LTORG")||instructions.get(j).equals("EXTEDF")
						||instructions.get(j).equals("EXTREF")
				) {
					opcode.add("....");
				}
				/* MYSTERY FROMAT 5*/
				else if (instructions.get(j).startsWith("&")) {
					
					int pos_FORMAT = instructions2.indexOf(instructions.get(j).substring(1));
					String opcodeee = variables2.get(pos_FORMAT);
					String binary = hexToBin(opcodeee.substring(0, 1));
					String operand = variables.get(j);
					String hexa = "";
					
					
					int disp, ta, pc;
					int pos_OF_a4_2 = labels.indexOf(variables.get(j));
					String TA = Integer.toHexString(Integer.parseInt(LOCATIONS.get(pos_OF_a4_2), 16));
					String PC = LOCATIONS.get(j + 1);
					ta = Integer.parseInt(TA, 16);
					pc = Integer.parseInt(PC, 16);
					disp = ta - pc;
					String DISP;
					
					if (disp >= -2048 && disp <= 2047) {
						if (disp % 2 == 0) {
							binary += "1";
						} else {
							binary += "0";
						}
						if (disp > 0) {
							binary += "0";
						} else {
							binary += "1";
						}
						if (operand.endsWith(",X")) {
							binary += "1";
						} else {
							binary += "0";
						}
						binary += "01";
						if (disp == 0) {
							binary += "1";
						} else {
							binary += "0";
						}
						int mm = Integer.parseInt(binary, 2);
						hexa = Integer.toHexString(m);
						hexa = addZeros(hexa, 3);
						DISP = Integer.toHexString(disp);
						DISP = addZeros(DISP, 3);
					} else {
						int posssss1 = instructions.indexOf("BASE");
						int posssss2 = labels.indexOf(variables.get(posssss1));
						int base = Integer.parseInt(LOCATIONS.get(posssss2), 16);
						disp = ta - base;
						
						if (disp % 2 == 0) {
							binary += "1";
						} else {
							binary += "0";
						}
						if (disp > 0) {
							binary += "0";
						} else {
							binary += "1";
						}
						if (operand.endsWith(",X")) {
							binary += "1";
						} else {
							binary += "0";
						}
						binary += "10";
						if (disp == 0) {
							binary += "1";
						} else {
							binary += "0";
						}
						int mm = Integer.parseInt(binary, 2);
						hexa = Integer.toHexString(m);
						hexa = addZeros(hexa, 3);
						DISP = Integer.toHexString(disp);
						DISP = addZeros(DISP, 3);
					}
					hexa = hexa + DISP;
					opcode.add(hexa);
					
				}
				/* MYSTERY FROMAT 6*/
				else if (instructions.get(j).contains("$")) {
					int pos_FORMAT = instructions2.indexOf(instructions.get(j).substring(1));
					String binary = removezeros(variables2.get(pos_FORMAT));
					String operand = variables.get(j);
					String hexa = "";
					
					if (instructions.get(j).startsWith("@")) {
						operand = instructions.get(j).substring(1);
						binary = binary + "10";
					} else if (instructions.get(j).startsWith("#")) {
						operand = instructions.get(j).substring(1);
						binary = binary + "01";
					} else {
						binary = binary + "11";
					}
					
					if (operand.endsWith(",X")) {
						binary += "1";
					} else {
						binary += "0";
					}
					String address = LOCATIONS.get(labels.indexOf(variables.get(j)));
					int add = Integer.parseInt(address, 16);
					if (add % 2 == 0) {
						binary += "0";
					} else {
						binary += "1";
					}
					if (add == 0) {
						binary += "0";
					} else {
						binary += "1";
					}
					int posssss1 = instructions.indexOf("BASE");
					int posssss2 = labels.indexOf(variables.get(posssss1));
					int base = Integer.parseInt(LOCATIONS.get(posssss2), 16);
					if (add == base) {
						binary += "0";
					} else {
						binary += "1";
					}
					
					System.out.println(binary);
					int mm = Integer.parseInt(binary, 2);
					hexa = Integer.toHexString(m);
					hexa = addZeros(hexa, 3);
					address = addZeros(address, 5);
					hexa = hexa + address;
					opcode.add(hexa);
				}
				
				//				/* LITERALS*/
				else if (instructions.get(j).startsWith("=")) {
					if (instructions.get(j).startsWith("=X")) {
						String byteOPcode = getBetweenStrings(instructions.get(j), "'", "'");
						int Size = byteOPcode.length();
						opcode.add(str.repeat(6 - Size).concat(byteOPcode).toUpperCase());
					} else {
						String byteOPcode = getBetweenStrings(instructions.get(j), "'", "'");
						String CHEXA = "";
						for (int kk = 0; kk < byteOPcode.length(); kk++) {
							char letter = byteOPcode.charAt(kk);
							int ascii = (int) letter;
							CHEXA = CHEXA.concat(Integer.toHexString(ascii));
						}
						int Size = CHEXA.length();
						opcode.add(str.repeat(6 - Size).concat(CHEXA).toUpperCase());
					}
				} else if (instructions.get(j).equals("RESB")) {
					opcode.add("....");
				} else if (instructions.get(j).equals("RESW")) {
					opcode.add("....");
				} else if (instructions.get(j).equals("WORD")) {
					int Size = Integer.toHexString(Integer.parseInt(variables.get(j))).length();
					opcode.add(str.repeat(6 - Size).concat(Integer.toHexString(Integer.parseInt(variables.get(j)))).toUpperCase());
				}
				
				/*FORMAT4*/
				else if (instructions.get(j).startsWith("+")) {
					int x = Integer.parseInt(LOCATIONS.get(instructions.indexOf(instructions.get(j))), 16);
					x++;
					String add = Integer.toHexString(x);
					int sizee = String.valueOf(add).length();
					add = str.repeat(sizee - 2) + add;
					mrecords.add("M" + add + "05");
					
					int pos_FORMAT = instructions2.indexOf(instructions.get(j).substring(1));
					String convo = variables2.get(pos_FORMAT);
					a1.add(hexToBin(convo.substring(0, 1)));
					if (variables.get(j).startsWith("#")) {
						a2.add(hexToBin(convo.substring(1)).substring(0, 2) + "01");
					} else if (variables.get(j).startsWith("@")) {
						a2.add(hexToBin(convo.substring(1)).substring(0, 2) + "10");
					} else {
						a2.add(hexToBin(convo.substring(1)).substring(0, 2) + "11");
					}
					if (variables.get(j).contains(",X")) {
						a3.add("1001");
						
						/*if variable contain ,X */
						
						int q = variables.get(j).length();
						
						int pos_OF_a4_1 = labels.indexOf(variables.get(j).substring(0, q - 2));
						if (pos_OF_a4_1 == -1) {
							if (variables.get(j).startsWith("@")) {
								pos_OF_a4_1 = labels.indexOf(variables.get(j).substring(1).substring(0, q - 3));
								int size = LOCATIONS.get(pos_OF_a4_1).length();
								a4.add(str.repeat(5 - size) + LOCATIONS.get(pos_OF_a4_1));
							} else {
								int size = variables.get(j).substring(1).substring(0, q - 2).length();
								a4.add(str.repeat(5 - size) + Integer.toHexString(Integer.parseInt(variables.get(j).substring(1).substring(0, q - 3))));
							}
						} else {
							int size = LOCATIONS.get(pos_OF_a4_1).length();
							a4.add(str.repeat(5 - size) + LOCATIONS.get(pos_OF_a4_1));
						}
						opcode.add(binToHex(a1.get(cccccc)).concat(binToHex(a2.get(cccccc))).concat(binToHex(a3.get(cccccc))).concat(a4.get(cccccc)).toUpperCase());
						cccccc++;
					} else {
						a3.add("0001");
						/*if variable doesn't contain ,X */
						int pos_OF_a4_1 = labels.indexOf(variables.get(j));
						if (pos_OF_a4_1 == -1) {
							if (variables.get(j).startsWith("@")) {
								pos_OF_a4_1 = labels.indexOf(variables.get(j).substring(1));
								int size = LOCATIONS.get(pos_OF_a4_1).length();
								a4.add(str.repeat(5 - size) + LOCATIONS.get(pos_OF_a4_1));
							} else {
								int size = variables.get(j).substring(1).length();
								a4.add(str.repeat(5 - size) + Integer.toHexString(Integer.parseInt(variables.get(j).substring(1))));
							}
						} else {
							int size = LOCATIONS.get(pos_OF_a4_1).length();
							a4.add(str.repeat(5 - size) + LOCATIONS.get(pos_OF_a4_1));
						}
						opcode.add(binToHex(a1.get(cccccc)).concat(binToHex(a2.get(cccccc))).concat(binToHex(a3.get(cccccc))).concat(a4.get(cccccc)).toUpperCase());
						cccccc++;
					}
				}
			} else {
				if (format.get(pos).equals(2)) {
					if (variables.get(j).contains(",")) {
						String[] comprBreak = variables.get(j).split(",", 2);
						int position1 = variables3.indexOf(comprBreak[0]);
						int position2 = variables3.indexOf(comprBreak[1]);
						opcode.add("00".concat(variables2.get(pos)).concat(variables3VALUE.get(position1)).concat(variables3VALUE.get(position2)).toUpperCase());
					} else {
						int pos2 = variables3.indexOf(variables.get(j));
						if (pos2 == -1)
							z = 1;
						else {
							opcode.add("000".concat(variables2.get(pos)).concat(variables3VALUE.get(pos2)).toUpperCase());
						}
					}
				} else if (format.get(pos).equals(1)) {
					opcode.add("0000".concat(variables2.get(pos)));
				} else if (format.get(pos).equals(4)) {
					int x = Integer.parseInt(LOCATIONS.get(instructions.indexOf(instructions.get(j))), 16);
					x++;
					String add = Integer.toHexString(x);
					int size = String.valueOf(add).length();
					add = str.repeat(size - 6) + add;
					mrecords.add("M" + add + "05");
				} else if (format.get(pos).equals(3)) {
					
					if (variables.get(j).contains(",X")) {
						int pos_FORMAT = instructions2.indexOf(instructions.get(j));
						String convo = variables2.get(pos_FORMAT);
						b1.add(hexToBin(convo.substring(0, 1)));
						if (variables.get(j).startsWith("#")) {
							b2.add(hexToBin(convo.substring(1)).substring(0, 2) + "01");
						} else if (variables.get(j).startsWith("@")) {
							b2.add(hexToBin(convo.substring(1)).substring(0, 2) + "10");
						} else {
							b2.add(hexToBin(convo.substring(1)).substring(0, 2) + "11");
						}
						int q = variables.get(j).length();
						int pos_OF_a4_2 = -1;
						
						String TA = "";
						int ta = 0;
						int disp = 0;
						
						if (variables.get(j).startsWith("=")) {
							for (int i = 0; i < relocationINSTRUCTION.size(); i++) {
								if (variables.get(j).equals(relocationINSTRUCTION.get(i))) {
									pos_OF_a4_2 = variables.indexOf(variables.get(j));
									TA = LOCATIONS.get(pos_OF_a4_2);
									break;
								}
							}
						} else if (variables.get(j).startsWith("@")) {
							int pos_OF_a4_1 = labels.indexOf(variables.get(j).substring(1).substring(0, q - 3));
							pos_OF_a4_2 = variables.indexOf(variables.get(j));
							TA = Integer.toHexString(Integer.parseInt(LOCATIONS.get(pos_OF_a4_1), 16));
						} else if (variables.get(j).startsWith("#")) {
							int size = Integer.toHexString(Integer.parseInt(variables.get(j).substring(1))).length();
							disp = Integer.parseInt(str.repeat(3 - size) + Integer.toHexString(Integer.parseInt(variables.get(j).substring(1))), 16);
							b3.add("1000");
						} else {
							pos_OF_a4_2 = variables.indexOf(variables.get(j));
							int pos_pos = labels.indexOf(variables.get(j).substring(0, q - 2));
							TA = Integer.toHexString(Integer.parseInt(LOCATIONS.get(pos_pos), 16));
						}
						ta = Integer.parseInt(TA, 16);
						int pc = Integer.parseInt(LOCATIONS.get(j + 1), 16);
						if (variables.get(j).startsWith("#")) {
							b4.add(Integer.toHexString(disp));
							
						} else {
							disp = ta - pc;
							int size = String.valueOf(disp).length();
							if (disp >= -2048 && disp <= 2047) {
								b3.add("1010");
								b4.add(str.repeat(3 - size) + Integer.toHexString(disp));
							} else {
								b3.add("1100");
								int posssss1 = instructions.indexOf("BASE");
								int posssss2 = labels.indexOf(variables.get(posssss1));
								int base = Integer.parseInt(LOCATIONS.get(posssss2), 16);
								disp = ta - base;
								size = String.valueOf(disp).length();
								if (size > 3) {
									b4.add(Integer.toHexString(disp).substring(size - 3));
								} else
									b4.add(str.repeat(3 - size) + Integer.toHexString(disp));
							}
						}
						opcode.add(binToHex(b1.get(dddddd)).concat(binToHex(b2.get(dddddd))).concat(binToHex(b3.get(dddddd))).concat(b4.get(dddddd)).toUpperCase());
						dddddd++;
					} else {
						int pos_FORMAT = instructions2.indexOf(instructions.get(j));
						String convo = variables2.get(pos_FORMAT);
						c1.add(hexToBin(convo.substring(0, 1)));
						if (variables.get(j).startsWith("#")) {
							c2.add(hexToBin(convo.substring(1)).substring(0, 2) + "01");
						} else if (variables.get(j).startsWith("@")) {
							c2.add(hexToBin(convo.substring(1)).substring(0, 2) + "10");
						} else {
							c2.add(hexToBin(convo.substring(1)).substring(0, 2) + "11");
						}
						int q = variables.get(j).length();
						int pos_OF_a4_2 = -1;
						
						String TA = "";
						int ta = 0;
						int disp = 0;
						
						if (variables.get(j).startsWith("=")) {
							pos_OF_a4_2 = variables.indexOf(variables.get(j));
							int posss = instructions.indexOf(variables.get(j));
							TA = LOCATIONS.get(posss);
							
							
						} else if (variables.get(j).startsWith("@")) {
							int pos_OF_a4_1 = labels.indexOf(variables.get(j).substring(1));
							pos_OF_a4_2 = variables.indexOf(variables.get(j));
							TA = Integer.toHexString(Integer.parseInt(LOCATIONS.get(pos_OF_a4_1), 16));
						} else if (variables.get(j).startsWith("#")) {
							int size = Integer.toHexString(Integer.parseInt(variables.get(j).substring(1))).length();
							disp = Integer.parseInt(str.repeat(3 - size) + Integer.toHexString(Integer.parseInt(variables.get(j).substring(1))), 16);
							c3.add("1000");
						} else {
							pos_OF_a4_2 = variables.indexOf(variables.get(j));
							int pos_pos = labels.indexOf(variables.get(j));
							TA = Integer.toHexString(Integer.parseInt(LOCATIONS.get(pos_pos), 16));
						}
						
						if (variables.get(j).startsWith("#")) {
							c4.add(Integer.toHexString(disp));
						} else {
							ta = Integer.parseInt(TA, 16);
							int pc =0;//Integer.parseInt(LOCATIONS.get(j + 1 ), 16);
							
								for(int i=j;i<LOCATIONS.size();i++){
									if(LOCATIONS.get(i+1).equals("....")){
										continue;
									}
									else {
										pc = Integer.parseInt(LOCATIONS.get(i +1), 16);
										break;
									}
								}
							
							disp = ta - pc;
							int size = String.valueOf(disp).length();
							if (disp >= -2048 && disp <= 2047) {
								c3.add("0010");
								c4.add(str.repeat(3 - size) + Integer.toHexString(disp));
							} else {
								c3.add("0100");
								int posssss1 = instructions.indexOf("BASE");
								int posssss2 = labels.indexOf(variables.get(posssss1));
								int base = Integer.parseInt(LOCATIONS.get(posssss2), 16);
								disp = ta - base;
								size = String.valueOf(disp).length();
								if (size > 3) {
									c4.add(Integer.toHexString(disp).substring(size - 3));
								} else
									c4.add(str.repeat(3 - size) + Integer.toHexString(disp));
								
								
							}
						}
						opcode.add(binToHex(c1.get(eeeeee)).concat(binToHex(c2.get(eeeeee))).concat(binToHex(c3.get(eeeeee))).concat(c4.get(eeeeee)).toUpperCase());
						eeeeee++;
					}
				}
			}
		}
		for (int x = 0; x < instructions.size(); x++) {
			printWriter.write(LOCATIONS.get(x).toUpperCase() + "\t" + labels.get(x) + "\t" + instructions.get(x) + "\t" + variables.get(x) + "\t" + opcode.get(x) + "\n");
		}
		String progname = labels.get(0);
		while (progname.length() < 6) {
			progname = progname + " ";
		}
		String st = variables.get(0);
		String en = LOCATIONS.get(instructions.size() - 1);
		int start = Integer.parseInt(st, 16);
		int end = Integer.parseInt(en, 16);
		int length = end - start;
		String programLength = Integer.toHexString(length);
		while (programLength.length() < 6) {
			programLength = "0" + programLength;
		}
		while (st.length() < 6) {
			st = "0" + st;
		}
		printWriter3.write("H" + progname + st + programLength);
		printWriter3.write(System.lineSeparator());
		
		for (int i = 1; i < instructions.size(); i++) {
			if(instructions.get(i).equals("EXTEDF")){
				String[] comprBreak = variables.get(i).split(",", 2);
				
				int position1 = labels.indexOf(comprBreak[0]);
				int position2 = labels.indexOf(comprBreak[1]);
				printWriter3.write("D" + comprBreak[0] + LOCATIONS.get(position1)+ comprBreak[1]+LOCATIONS.get(position2));
				printWriter3.write(System.lineSeparator());
				
			}
			if(instructions.get(i).equals("EXTREF")){
				String[] comprBreak = variables.get(i).split(",", 3);
				printWriter3.write("R" +comprBreak[0]+comprBreak[1]+comprBreak[2]);
				printWriter3.write(System.lineSeparator());
			}
	
		}
		
		
		String objectcode = "";
		String len = "";
		String add = "";
		for (int i = 1; i < instructions.size(); i++) {
			
			if (instructions.get(i).equalsIgnoreCase("BASE") || instructions.get(i).equalsIgnoreCase("LTORG") ||
					instructions.get(i).equalsIgnoreCase("RESW") || instructions.get(i).equalsIgnoreCase("RESB") ||
					instructions.get(i).equalsIgnoreCase("END"))
				continue;
			if (add.equals("") && !opcode.get(i).equals("")) {
				add = LOCATIONS.get(i);
			}
			while (add.length() < 6) {
				add = "0" + add;
			}
			if (objectcode.length() + opcode.get(i).length() <= 60
					&& opcode.get(i).length() > 0) {
				objectcode = objectcode + opcode.get(i);
			} else {
				if (objectcode.length() > 0) {
					len = Integer.toHexString(objectcode.length() / 2);
					if (len.length() < 2) {
						len = "0" + len;
					}
					printWriter3.write("T" + add + len + objectcode);
					printWriter3.write(System.lineSeparator());
					
				}
				add = "";
				objectcode = opcode.get(i);
				if (!objectcode.equals("")) {
					add = LOCATIONS.get(i);
				}
			}
		}
		if (objectcode.length() > 0) {
			len = Integer.toHexString(objectcode.length() / 2);
			if (len.length() < 2) {
				len = "0" + len;
			}
			printWriter3.write("T" + add + len + objectcode);
			printWriter3.write(System.lineSeparator());
			
		}
		for (int i = 0; i < mrecords.size(); i++) {
			printWriter3.write(mrecords.get(i));
			printWriter3.write(System.lineSeparator());
		}
		
		printWriter3.write("E" + st);
		
		printWriter.close();
		printWriter2.close();
		printWriter3.close();
		
	}
}