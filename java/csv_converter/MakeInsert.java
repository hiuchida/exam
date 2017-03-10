package csv_converter;

public class MakeInsert {
	public static void main(String[] args) {
		long st = 1488294000-2592000+10;
		while (st <= 1488294000) {
			System.out.print("INSERT INTO history_uint VALUES ");
			boolean bFirst = true;
			for (int i=0; i<6*60; i++) {
				int id = 44140;
				while (id <= 44189) {
					if (bFirst) bFirst = false;
					else System.out.print(",");
					System.out.print("("+id+","+st+",1,0)");
					id++;
				}
				st += 10;
			}
			System.out.println(";");
		}
    }
	/*
	public static void main(String[] args) {
		int id = 44090+1;
		while (id <= 44139) {
			long st = 1488294000-2592000+10;
			while (st <= 1488294000) {
				System.out.println("INSERT INTO history_uint VALUES ("+id+","+st+",0,0);");
				st += 10;
			}
			id++;
		}
    }
    */
}
