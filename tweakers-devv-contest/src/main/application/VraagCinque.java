package main.application;
/**
 * In het oude Rome stond een sterk staaltje architectuur genaamd het 'Ominesium'. 
 * Op de gevel van het gebouw was met mozaïek aangegeven hoe oud het gebouw was in jaren.
 * Uiteraard gaven de oude Romeinen dit aan met Romeinse cijfers. Deze Romeinen waren erg bij 
 * de tijd en gebruikten de moderne notatie voor Romeinse cijfers: 49 = XLIX, 4 = IV.
 * Het gebouw is net na een stevige aardbeving voltooid, en het eerste mozaïek werd na een jaar aangebracht. 
 * Onze jaartelling begint bij 0, dus het eerste mozaïek werd geplaatst in het jaar 1.
 * Het aantal mozaïksteentjes benodigd voor een symbool is 250. Het jaartal IV kostte dus 500 steentjes om op de muur aan te brengen.
 * Om kleurverschil tegen te gaan werd bij elke plaatsing van een nieuw jaartal de complete mozaïek opnieuw geplaatst.
 * Het was een regio met veel seismische activiteit; om de 43 jaar werd de regio getroffen door een zware aardbeving 
 * waarbij 15% van de voorraad steentjes verloren ging, per aardbeving afgerond naar boven op gehele steentjes. 
 * De eerste beving sinds de voltooiing van het gebouw vond plaats na 43 jaar.
 * Aardbevingen vonden door een enorm toeval telkens plaats voordat het nieuwe mozaïek werd aangebracht.
 * Na de voltooiing van het 'Ominesium' (en dus ook ná de aardbeving in het jaar 0) was er nog een 
 * voorraad van 12.500.000 mozaïeksteentjes beschikbaar voor de jaarlijkse renovatie van het mozaïek.
 * In welk jaar was de voorraad steentjes niet meer voldoende om het nieuwe jaartal op het gebouw te plaatsen?
 * Antwoord in Romeinse notatie, dus bijvoorbeeld: DCCLXII
 */
public class VraagCinque {

	private static String I = ""; //1
	private static String V = ""; //5
	private static String X = ""; //10
	private static String L = ""; //50
	private static String C = ""; //100
	private static String D = ""; //500
	private static String M = ""; //1000

	private static int quantityStonesForSymbol = 250;

	private static int years = 1; //250 stones are used this first year

	private static int earthquakeInYears = 43;
	private static int lostQuantityStonesInPercentage = 15; //Every eathquake 15% of the remaining stones is lost

	private static int quantityStones = 12500000 - 250;

	public static void main(String[] args) {
		//Calculate how long the quantityStones will last in years
		while (quantityStones > 0) {
			StringBuilder reverseYears = new StringBuilder(Integer.toString(years));
			String year = reverseYears.reverse().toString();
			calculateYears(year);
		}
		
		System.out.println("Rom years: " + formatToRom(years) + "\n"
						+ "Normal Years past: " +years);
	}

	private static String formatToRom(int years) {
		   String riman[] = {"M","XM","CM","D","XD","CD","C","XC","L","XL","X","IX","V","IV","I"};
		    int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		    StringBuilder result = new StringBuilder();
		    int i = 0;
		    while (years > 0 || arab.length == (i - 1)) {
		        while ((years - arab[i]) >= 0) {
		        	years -= arab[i];
		            result.append(riman[i]);
		        }
		        i++;
		    }
		    return result.toString();
	}

	private static void calculateYears(String year){
		for(int i = 0; i < year.length(); i++){
			if(years == earthquakeInYears){
				earthquakeInYears = earthquakeInYears + earthquakeInYears;
				calculateYearsWithEarthQ(year);
				break;
			}
			years++;
			char [] c = year.toCharArray();
			char y = c[i];
			if(i == 0){
				//00000000#
				countYears(y);
				break;
			} else if (i == 1){
				//0000000#0
				countYears(y);
				break;
			} else if (i == 2){
				//000000#00
				countYears(y);
				break;
			} else if (i == 3){
				//00000#000
				countYears(y);
				break;
			} else if (i == 4){
				//0000#0000
				countYears(y);
				break;
			} else if (i == 5){
				//000#00000
				countYears(y);
				break;
			} else if (i == 6){
				//00#000000
				countYears(y);
				break;
			} else if (i == 7){
				//0#0000000
				countYears(y);
				break;
			} else if (i == 8){
				//#00000000
				countYears(y);
				break;
			} 
		}
	}
	
	private static void calculateYearsWithEarthQ(String year){
		for(int i = 0; i < year.length(); i++){
			//kleinste getal : totaal x 100 = Antwoord in %
			quantityStones = 15 / quantityStones * 100;
			char [] c = year.toCharArray();
			char y = c[i];
			if(i == 0){
				//00000000#
				countYears(y);
				break;
			} else if (i == 1){
				//0000000#0
				countYears(y);
				break;
			} else if (i == 2){
				//000000#00
				countYears(y);
				break;
			} else if (i == 3){
				//00000#000
				countYears(y);
				break;
			} else if (i == 4){
				//0000#0000
				countYears(y);
				break;
			} else if (i == 5){
				//000#00000
				countYears(y);
				break;
			} else if (i == 6){
				//00#000000
				countYears(y);
				break;
			} else if (i == 7){
				//0#0000000
				countYears(y);
				break;
			} else if (i == 8){
				//#00000000
				countYears(y);
				break;
			} 
		}
	}

	private static void countYears(char y){
		switch (y){
		case '0':
			//do nothing
			;
		case '1':
			quantityStones = quantityStones - 250;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 250;
				years--;
			}
			;
		case '2':
			quantityStones = quantityStones - 500;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 500;
				years--;
			}
			;
		case '3':
			quantityStones = quantityStones - 750;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 750;
				years--;
			}
			;
		case '4':
			quantityStones = quantityStones - 500;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 500;
				years--;
			}
			;
		case '5':
			quantityStones = quantityStones - 250;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 250;
				years--;
			}
			;
		case '6':
			quantityStones = quantityStones - 500;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 500;
				years--;
			}
			;
		case '7':
			quantityStones = quantityStones - 750;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 750;
				years--;
			}
			;
		case '8':
			quantityStones = quantityStones - 1000;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 1000;
				years--;
			}
			;
		case '9':
			quantityStones = quantityStones - 500;
			if((quantityStones < 0)){
				quantityStones = quantityStones + 500;
				years--;
			}
			;
		}
	}

}
