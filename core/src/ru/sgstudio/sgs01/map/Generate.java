package ru.sgstudio.sgs01.map;

public class Generate {
	private static int z=5, y=15, x=10;
	private static int map[][][] = new int[z][y][x];
	private static boolean newMap = true;
	
	public Generate(){
		if(newMap){
			generateMap();
			newMap=!newMap;
		}
		for(int Z=0;Z<z;Z++){
			for(int Y=0;Y<y;Y++){
				System.out.print("Z"+Z+" - ");
				for(int X=0;X<x;X++){
					System.out.format("%4d", map[Z][Y][X]);
				}
				System.out.print('\n');
			}
			System.out.print('\n');
		}
	}
	
	public int[][][] getMap(){ return map; }
	
	private void generateMap(){
		for(int Z=0;Z<z;Z++){
			for(int Y=0;Y<y;Y++){
				for(int X=0;X<x;X++){
					if(Y>4) map[Z][Y][X] = Y-5;
					else map[Z][Y][X] = 0;
				}
			}
		}
	}
}