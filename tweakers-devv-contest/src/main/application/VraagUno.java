package main.application;

/**
 * Sommige positieve getallen n hebben de eigenschap dat de som [ n + reverse(n) ] 
 * volledig bestaat uit oneven nummers. Bijvoorbeeld, 36 + 63 = 99 en 409 + 904 = 1313.
 * Deze getallen noemen we omkeerbaar; dus 36, 63, 409, en 904 zijn omkeerbaar. Voorlopende nullen in n or reverse(n) zijn niet toegestaan.
 * Er zijn 120 omkeerbare getallen onder 1000.
 * Hoeveel omkeerbare getallen zijn er onder 100 miljoen (108)?
 * Voorbeeldnotatie antwoord (schrijfwijze als positief integer): 15000
 */
public class VraagUno {


	public static void main(String[] args) {
		int answer = 0;
		for (int i = 0; i < 100000000; i++) {
			String reverse = "" + i;
			StringBuilder stringOfInt = new StringBuilder(reverse);
			reverse = stringOfInt.reverse().toString();
			if(!reverse.startsWith("0")){
				int result = i + Integer.parseInt(reverse);

				String res = Integer.toString(result);
				if(res.contains("0") ||res.contains("2") ||res.contains("4") ||res.contains("6") ||res.contains("8")){

				} else {
					answer++;
					//System.out.println("Normal: "+ i + " Reverse: " + reverse + " Result: "+ result);
				}
			}
		}
		System.out.println(answer);
		//Answer is: 608720
	}
}
